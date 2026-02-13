--ex33_index.sql

/*
    인덱스, index
    - 검색을 빠른 속도로 하기 위해 사용하는 도구
    
    데이터베이스의 데이터 검색 방식
    - 어떤 데이터를 검색 -> 테이블의 첫번째 레코드에서부터 끝까지 차례대로 검색 -> table full scan 이라고 함
    - full scan? 딱봐도 엄청 느려보임
    - 검색을 위한 특정 컬럼(예: name)을 먼저 정함 -> 이 컬럼을 별도의 테이블 비슷한걸로 복사를 함(진짜 테이블이 아님)
    - 그런 다음 그걸 정렬, 정렬한걸 index라고 부름
    - 엄용수가 몇번에 있네요 라는 정보까지 저장해둔다(이게 ROWID)
    - index 도 양날의 검이다, 잘못 걸면 큰일남

*/

select * from tblinsa where name = '엄용수';

select * from tblAddressbook;

create table tblIndex
as
select * from tblAddressBook; -- 이렇게 복사해서 만든 테이블은 제약사항까지 복사되진 않는다

select count(*) from tblIndex;

insert into tblIndex select * from tblIndex; -- 데이터를 늘리기 위해 작성

-- 시간 확인
set timing on;

-- 인덱스 없이 겁색
-- 컨트롤 엔터 말고 F5를 누르자
-- 약 3초 후반대 정도의 시간 소요
select count(*) from tblIndex where name = '최민기';

-- 인덱스 생성: 경과 시간: 00:00:26.319
-- 이걸 단일 인덱스라고 함
create index idxName
    on tblIndex(name); -- tblIndex 테이블의 name 컬럼에 index를 걸겠다
    
-- 인덱스를 사용해서 검색 경과 시간: 00:00:00.002
-- 엄청 빨라짐
-- 힌트(Hint) <- 오라클한테 이렇게 해 라고 보조 명령을 하는 것
select /*+ index(tblIndex idxName) */
    count(*) from tblIndex where name = '최민기';
    
-- 홈타운에 대한 인덱스 만들기
create index idxHometown on tblIndex(hometown);

-- 경과 시간: 00:00:01.563
select /*+ index(tblIndex idxHometown) */
    count(*) from tblIndex where hometown = '서울';
    
-- 경과 시간: 00:00:24.378
select /*+ index(tblIndex idxHometown) */
    count(*) from tblIndex where hometown = '서울' and job = '학생';

-- 찾을 조건이랑 똑같이 인덱스를 만들어야 함
-- 이걸 복합 인덱스 라고 함
create index idxHometownJob on tblIndex(hometown, job);

-- 새로 만든 복합 인덱스로 바꿔서 찾아보자 / 경과 시간: 00:00:00.059
select /*+ index(tblIndex idxHometownJob) */
    count(*) from tblIndex where hometown = '서울' and job = '학생';

-- 인덱스를 걸지 않아도 자동으로 걸리는 경우 <- 기본 검색 속도가 빠름
-- 1. PK
-- 2. Unique
-- 왜? 검색 조건에 걸릴 확률이 높기 때문에 인덱스가 자동으로 걸림
-- 밑의 경우에는 데이터가 너무 적어서 거의 차이 안 남
select * from tblInsa where num = 1010;      -- PK        -- 경과 시간: 00:00:00.008
select * from tblInsa where name = '최민기'; -- 일반 컬럼 -- 경과 시간: 00:00:00.004

select * from tblAddressBook where seq = 1900; -- 얘는 인덱스가 걸려있음 -- 경과 시간: 00:00:00.008
select * from tblAddressBook where name = '박신영'; -- 인덱스가 걸려있지 않음 -- 경과 시간: 00:00:00.010
-- 데이터가 적어서 별로 차이 안 나는듯

drop index idxName; -- 객체기 때문에 금방 지워져서 부담 가질 필요는 없음


/*
    인덱스를 사용해야 하는 상황
    1. 테이블에 레코드가 많을 때
    2. where 절에서 사용하는 횟수가 많은 컬럼에 적용(*중요)
    3. 인덱스 손익분기점 -> 검색 결과가 원본 테이블의 10~15% 이하인 경우
    
    인덱스를 사용하지 말아야 하는 상황
    1. 테이블에 레코드가 적을 때(풀 스캔과 차이 거의 없음)
    2. 인덱스 손익분기점 -> 검색 결과가 원본 테이블의 15% 이상인 경우
    3. 우리가 인덱스를 걸 테이블이 새로운 레코드가 삽입이 되거나 기존 레코드가 수정, 삭제가 빈번할 경우
    절대 인덱스를 사용하지 말아야 함

    프로젝트 마지막에 부하가 걸리는 검색 작업을 선별해서 인덱스 생성해서 시간차 테스트를 해보자 
*/

select * from tblAddressBook where rownum <= 10;

-- 이렇게 인덱스를 만들면 아무 의미가 없음, 데이터 찾으면서 데이터 가공을 하기 때문
create index idxEmail on tblIndex(email);

-- 내가 쓰려는 최종 가공 형태의 데이터로 인덱스를 만들어야함 경과 시간: 00:00:16.677
-- 이걸 함수 기반 인덱스(가공)이라고함
create index idxEmail on tblIndex(substr(email, instr(email, '@')));

-- 경과 시간: 00:00:08.557 -> 경과 시간: 00:00:00.139 매우 빨라짐
select /*+ index(tblIndex idxEmail) */
    count(*) from tblIndex where substr(email, instr(email, '@')) = '@naver.com';
    
select substr(email, instr(email, '@')) from tblAddressBook where rownum <= 10;