-- ex32_trigger.sql

/*

    트리거, Trigger
    - 선언 -> 호출(사용): X(메서드, 함수 등)
    - 선언 -> 감시(대기) 상태 -> 이벤트 발생 -> 호출(사용): 0

    - 트리거 선언(누구(테이블)를 감시(insert/update/delete)해라! + 명령)
        -> 계속 감시하다가 언젠가는 이런 일(insert/update/delete)이 발생하는데 그걸 event라고함
        -> 그때 트리거 자동실행
        
    - 트리거 호출
        - 개발자가 하지 않음, 오라클 시스템이 실행
        
    트리거 구문
    create or replace trigger 트리거명
        before|after
        insert|update|delete
        on 테이블명
        [for each row]
    declare
        선언부;
    begin
         구현부;
    end;

    for each row 유무
    
    1. 유
        - 행(Record) 단위 트리거
        - 그 사건이 어떤 레코드에 적용됐는지가 중요한 경우
    
    2. 무 
        - 문장(Query) 단위 트리거
        - Table level Trigger
        - 테이블에서 발생한 사건 그 자체가 중요한 경우
        - 사건이 어디서 일어났는지는 관심없음
*/

-- tblInsa -> 직원 삭제(퇴사)
-- 월요일엔 퇴사가 불가능한 규칙이 있음

drop table tblBonus;
delete from tblInsa where num = '1001';
rollback;

create or replace trigger trgInsa
    before
    delete
    on tblInsa
declare

begin

    dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss') || '트리거가 실행되었습니다.');
    
    -- 월요일 퇴사 불가능
    if to_char(sysdate, 'dy') = '월' then
    
    -- 만약에 월요일이다? 강제로 에러를 발생시킨다
    -- throw new Exception() // 예외 던지기
    
    -- -20000 ~ 29999
    raise_application_error(-20001, '월요일에는 퇴사가 불가능합니다');
    
    end if;

end trgInsa;
/

select * from tblInsa;

-- 트리거 상태
select trigger_name, status from user_triggers;

-- 트리거 중지
alter trigger trgInsa disable;

-- 트리거 시작
alter trigger trgInsa enable;

-- 로그를 남기는 트리거
-- tblDiary -> 트리거를 걸어놔서 감시하다가 이벤트가 발생하면 기록을 남기자
select * from tblDiary;

create table tblLogDiary
(
    seq number primary key, -- PK
    vmessage varchar2(500) not null, -- 메시지
    regdate date default sysdate not null -- 발생 시각

);

create sequence seqLogDiary;

-- tblDiary에 무슨 일이 생기면 그 생겼다는 사실을 로그 테이블에 기록하는 트리거를 만들어보자
create or replace trigger trgDiary
    after
    insert or update or delete -- 여러가지 경우의 사건(다이어리에 삽입/수정/삭제가 발생했을 때)
    on tblDiary
declare
    vmessage tblLogdiary.vmessage%type;
begin
    dbms_output.put_line('tblDiary 호출됨');
    if inserting then
        dbms_output.put_line('tblDiary 호출됨 - insert');
        vmessage := '새로운 항목이 추가되었습니다';
    elsif updating then
        dbms_output.put_line('tblDiary 호출됨 - update');
        vmessage := '기존 항목이 수정되었습니다.';
    elsif deleting then
        dbms_output.put_line('tblDiary 호출됨 - delete');
        vmessage := '기존 항목이 삭제되었습니다';
    end if;
    
    insert into tblLogDiary values (seqlogdiary.nextval, vmessage, default);
    
end trgDiary;
/

-- 사건들 발생
-- select에는 트리거가 걸리지 않는다
-- 데이터를 조작하는 행위에만 트리거를 걸 수 있다
insert into tblDiary values(11, '배불러요.', '추움', sysdate);
update tblDiary set subject = '너무 배불러요' where seq = 11;
delete from tblDiary where seq = 9;

select * from tblDiary;

-- 로그가 기록되었음
select * from tblLogDiary;

-- for each row 가 있어야만 쓸 수 있는 :old.seq
-- for each row 가 반복문 돌듯이 계속 돌아다니면서
-- 뭐가 달라졌는지 감시한다?
-- :old, :new -> 의사 레코드, 상관변수
-- for each row 가 없으면 사고가 터진건 알 수 있지만 어디에서 터졌는지는 모른다
create or replace trigger trgDiary
    after -- 사건이 발생한 후 로그 기록
    delete
    on tblDiary
    -- ORA-04082: 테이블 레벨 트리거에서 NEW 혹은 OLD 참조는 허용되지 않습니다
    for each row
declare

begin
    dbms_output.put_line('레코드가 삭제되었습니다.');
end trgDiary;
/

select * from tblMen;

create or replace trigger trgMen -- 25세(과거)에서 26세(미래)로 나이를 수정하겠다
-- 트리거에서는 과거와 미래 둘 다 접근할 수 있음
    before
    -- update -- :old, :new 모두 참조 가능
    -- insert -- :new 만 참조 가능
    delete -- :old 만 참조 가능
    on tblMen
    for each row -- 이걸 붙이겠다는 얘기는 :old, :new를 사용하겠다는 뜻
declare

begin
    dbms_output.put_line('---------------');
    dbms_output.put_line('수정 전 나이: ' || :old.age); --:old -> 수정 전 레코드
    dbms_output.put_line('수정 전 나이: ' || :new.age); --:new -> 수정 후 레코드
    -- 똑같은 사람임, 과거 시점과 미래 시점이 존재하는 것
    dbms_output.put_line('전 여친: ' || :old.couple);
    dbms_output.put_line('현 여친: ' || :new.couple);
    dbms_output.put_line('---------------');
end trgMen;
/

update tblMen set age = age + 1 where name = '홍길동';
update tblMen set couple = '홍현희' where name = '홍길동'; -- 전여친 장도연, 현여친 홍현희

insert into tblMen values ('강아지', 3, 30, 10, null);

delete from tblMen where name = '홍길동';

-- 회원 테이블, 게시판 테이블
-- 포인트 정책
-- 1. 글을 작성하면 기존의 포인트에서 100점 추가
-- 2. 글을 삭제하면 기존의 포인트에서 50점 삭감

drop table tblUser; -- 이걸 부모로 알고 있는 자식 테이블을 찾아야 drop 가능
DROP TABLE tblUser CASCADE CONSTRAINTS;
SELECT fk.owner, fk.constraint_name , fk.table_name 
        FROM all_constraints fk, all_constraints pk 
        WHERE fk.r_constraint_name = pk.constraint_name 
                   AND fk.constraint_type = 'R' 
                   AND pk.table_name = UPPER('tblUser')
        ORDER BY fk.table_name;

create table tblUser
(
    id varchar2(30) primary key,
    point number not null

);

create table tblBoardTwo
(
    seq number not null,
    subject varchar2(2000) not null,
    id varchar2(30) not null references tblUser(id)

);

insert into tblUser values ('hong', 1000); -- 회원가입 할 때 1000포인트 지급

-- 1. 글을 쓴다
-- 2. 100포인트를 지급한다
-- 1-1. 글을 삭제한다
-- 2-1. 50포인트를 차감한다

-- Case 1. 모든 제어를 우리가 직접 할 때
-- 1.1 글쓰기
-- 단점: 실수로 까먹어서 포인트 증감 업무 누락의 가능성 존재
insert into tblBoardTwo values (1, '안녕하세요.', 'hong');


-- 1.2 포인트 누적
update tblUser set point = point + 100 where id = 'hong';

-- 1.3 글 삭제
delete from tblBoardTwo where seq = 1;

-- 1.4 포인트 차감
update tblUser set point = point - 50 where id = 'hong';

select * from tblBoardTwo;
select * from tblUser;

-- Case 2. 트리거 사용
create or replace trigger trgBoard
    after
    insert or delete
    on tblBoardTwo
    for each row
begin
    if inserting then -- 글쓰기
        update tblUser set point = point + 100 where id = :new.id;
    elsif deleting then
    -- 삭제된 글의 모든 정보를 가져온다
    -- old 를 사용
        update tblUser set point = point - 50 where id = :old.id; -- 글 삭제한 사람의 아이디인 :old.id
    
    end if;
    
end trgBoard;
/

select * from tblUser;

-- 개발자들 간에 트리거 방식의 장단점 견해 차이가 있음
-- 1. 장점: 본 업무에 집중할 수 있는 환경을 만들어 준다(게시판 업무 집중 가능, 포인트 업무 신경 끌 수 있음)
-- 2. 단점 의견: 본 업무 이외의 사건을 알 수가 없다.(포인트 증감이 발생하는지 알 수 없다. 물론 로그를 보면 알수는 있지만
-- 직관적으로 눈에 보이지 않는다는 의견)
insert into tblBoardTwo values (2, '난 홍길동이다.', 'hong'); -- 100 포인트 증가 확인

delete from tblBoardTwo where seq = 2; -- 50 포인트 차감 확인