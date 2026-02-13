-- ex34_transaction.sql

/*
    트랜잭션, Transaction
    - 데이터를 조작하는 업무들의 시간적 단위
    - 1개 이상의 DML을 묶어 놓은 단위
    ex) 은행에서 계좌와 관련된 업무?
    국민은행 선릉역점에 계좌가 있는데 거기에 돈이 20억 있다
    내가 부산에 잇는 카페를 매입하려고 부산을 갔는데
    땅주인이 현금 아니면 안받겠다함
    그래서 국민은행 해운대점에서 20억을 인출해야 하는 상황임
    내 계좌에 20억 있는지 해운대점이 선릉역점에 물어봄
    선릉역점이 있다고함
    해운대점이 20억 뽑아줌
    난 카페 건물 사러 감
    해운대점에서 우리가 20억 뽑아줫다고 선릉역에 알려줘야함
    선릉역에서 우리도 잔액 0으로 해놨어 라고 해운대점에 알려줌
    (*실제 은행 업무랑은 하나도 안 맞는데 그냥 그렇다고 가정)
    돌발상황) 선릉역점에 잔액 0원으로 바꾸라고 연락하려던 시점에 벼락으로 정전발생함
    0원으로 바꾸라고 하는걸 잊어버림
    난 20억이 더 생김 ;;
    만약 벼락 맞으면 은행원이 나한테 달려와서 20억 뺏어서 없었던일로 해야함
    없었던일로 하는게 난이도가 훨씬 쉬움
    
    한가지 목적을 달성하기 위해 짜잘한 업무를 모아놓은 그룹들을 트랜잭션이라고 한다?
    
    트랜잭션 명령어(DCL -> TCL)
    1. commit
    
    2. rollback
    
    3. savepoint
*/

create table tblTrans
as
select name, buseo, jikwi from tblInsa where city = '서울';

select * from tblTrans;

-- 우리가 하는 행동(SQL - insert, update, delete 이 3가지만 기억한다?) -> 반드시 시간순으로 기억(*중요)
-- 이전에 썼던 코드 다시 쓰지 말고 자바마냥 위에서 아래로 순서대로 하는 느낌으로 ??
-- 트랜잭션 시작 -> 종료 -> 또 다른 트랜잭션 시작 -> 종료 -> 또 다른 트랜잭션 시작 ...
-- 일단 가상으로 해놨다가 10번까지 다 하고 여지껏 한거가 문제가 없으면 
-- 진짜 한걸로 해주세요 라는 명령어가 있다 이게 커밋이다
-- 롤백은 가상으로 하다가 사고나면 가상으로 했으니까 없던일로 해주세요가 가능한것

select * from tblTrans;

-- 실제로 지워지는게 아닌 임시로 지워짐
-- 휴지통 느낌?
delete from tblTrans where name = '김말숙';

select * from tblTrans;

-- 김말숙 되살리기
rollback; -- 현재 트랜잭션에서 발생한 모든 쿼리를 없었던 일로 해라

select * from tblTrans;

-- 이전까지의 작업을 책임지고 승인하겠다(이전 작업은 되돌리지 않겠다(신중하게 해야함))
commit; -- 내눈엔 아까부터 이미 말숙이가 사라졌지만 
-- 아까는 임시로 사라진거고 지금은 진짜로 사라짐, 복구도 못함

-- 트랜잭션은 롤백이라는 기회를 준다는 것에 의의가 있다

-- 트랜잭션은 하나만 존재

-- SQL 디벨로퍼 키면 트랜잭션 시작함

select * from tblTrans; -- 20명, select는 트랜잭션이 신경안씀

insert into tblTrans values ('강아지', '개발부', '사원');

update tblTrans set jikwi = '이사' where name = '홍길동';

delete from tblTrans where name = '한석봉';

-- 트랜잭션 단위로 처리(일부 SQL만 따로 처리 불가능)
select * from tblTrans; -- 현재 세션에만 반영
rollback;

select * from tblTrans; -- 현재 세션에만 반영

/*
    (*중요)트랜잭션이 언제 시작해서 언제 끝나는지가 중요
    둘 다 같은 얘기임, 현재 트랜잭션 끝나자마자 새로운 트랜잭션이 시작되기 때문
    
    - 새로운 트랜잭션이 시작하는 경우
    1. 클라이언트가 접속한 직후
    
    
    
    - 현재 트랜잭션이 끝나는 경우
    1. 클라이언트가 접속 종료
        a. 정상적으로 종료
            - 현재 트랜잭션이 모두 완료가 되었다면 아무 일도 안 일어남
            - 현재 트랜잭션이 반영이 안 되어있다면 종료하기 전에 커밋할지 롤백할지 물어본다
        
        
        b. 비정상적으로 종료
            - rollback
            
    2. commit 실행 직후
    
    3. rollback 실행 직후   
    
    4. DDL 실행 직전 -> 자동 commit
        - create, alter, drop
        - DML(insert, update, delete) -> DDL 작업 이후에 주로 하는 행동
    
    



*/

commit;

insert into tblTrans values ('강아지', '개발부', '사원');

-- 돌발상황) 정전이 일어나서 컴퓨터가 꺼짐

select * from tblTrans;

update tblTrans set jikwi = '이사' where name = '홍길동';

-- 옆사람이 시퀀스 객체 생성 요청

create sequence seqAAA; -- 이걸 하는 순간 자동으로 commit 실행됨

rollback;

select * from tblTrans;

delete tblTrans where name = '한석봉';

commit;


savepoint a;

update tblTrans set jikwi = '사장' where name = '홍길동';

savepoint b;

/*
    오라클 서버
    - 팀원 A가 SQL 디벨로퍼를 써서 HR 계정으로 접속했다
    - 팀원 B가 DBeaver로 HR 계정으로 접속했다
    - 팀원 C가 DataGrip 으로 HR 계정으로 접속했다
    - 팀 작업 하려면 같은 계정으로 접속해야함
    
    팀 작업 시 트랜잭션 & 툴 특성(Auto Commit 기능이 있다)
    
    팀 작업
    1. 각자 DB를 사용하고 나중에 합치기
    2. 하나의 DB를 사용하고 실시간으로 같이 사용하는 방법 <- 추천
    
    팀원 5명 -> 그중 1명의 PC를 오라클 서버로 선정
    (이번 프로젝트에는 강의실에 남는 PC를 사용)
    1. 프로젝트용 계정을 새로 만들자
    2. 방화벽 오픈(오라클이 사용하는 포트를 개방) <- 오라클 서버 컴퓨터만 하면 됨
    - 다른 컴퓨터가 내 컴퓨터에 접속해야함
    
    집에 갔다
    (정책상 이 학원 나가면 학원에 있는 PC에 접속 안됨)
    1. 오늘 했던걸 바리바리 싸들고 간다 <- 권장
    2. 1번이 너무 귀찮다? 외부 오라클을 사용해야함
        a. 클라우드 서비스 -> AWS(유료), OracleCloud(무료 - 팀 작업 할 때 살짝 버벅임) 사용
        b. 누군가의 집의 PC를 하루종일 켜놓고 그걸 오라클 서버로 사용 <- 공유기에 포트포워딩 설정 해야함



*/

insert into tblTrans values ('병아리', '개발부', '사원');
commit;

select * from tblTrans;

-- 프로젝트용 계정 만들기(12c 이후부터 계정명 앞에 C## 을 붙이도록 되어있음)
-- 관리자만 가능 ORA-01031: 권한이 불충분합니다
-- C## 붙이기 싫은데 그러면 설정을 바꿔야함
alter session set "_ORACLE_SCRIPT"=true;

show user;

create user hyzProject identified by java1234;

grant connect, resource, dba to hyzProject; -- DCL 명령어 중 하나인 grant
alter user hyzProject default tablespace users;

-- '교육센터 운영 프로그램'을 만들어주십시오. <- 실제로는 DB 구축까지만
-- 관련된 데이터는 가상으로 만들어야함