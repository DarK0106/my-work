-- ex29_relationship.sql

/*
    1. 기본키
        a. 단일키
        b. 복합키
        
    2. 관계
        a. 비식별 관계
        b. 식별 관계

*/

select * from tabs;

drop table tblUser;

-- 부모가 자식을 바라보는 시점으로써의 표현 -> 식별 vs 비식별
-- 자식 테이블에서 FK가 PK의 역할을 하면 식별관계라고 한다.
-- 자식 테이블에서 FK가 일반 컬럼이면 비식별관계라고 한다.

-- 식별관계가 만들어지기 위한 조건
-- 1. 1:1 관계에서 만들어짐(근데 1:1 관계가 잘 안만들어짐)
-- 2. 복합키를 만들어야 한다

-- 회원 테이블과 게시판 테이블의 관계
-- 단일키(PK)를 가지며, 1:N 에서 비식별관계를 만들었음


-- 회원 테이블과 회원 세부 정보 테이블의 관계
-- 단일키(PK)를 가지며, 1:1 에서 식별관계를 만들었음

-- 비식별관계?
/*
   홍길동(회원) - 길동이가 쓴 글 A
                - 길동이가 쓴 글 B
                - 길동이가 쓴 글 C
*/

-- 식별관계?



create table tblUser

(
    seq number primary key,
    id varchar2(30) not null,
    pw varchar2(30) not null,
    name varchar2(30) not null

);

-- 이 사람들이 글을 쓴다 -> 게시판 테이블을 만들자
create table tblBoard
(
     seq number primary key,
     subject varchar2(1000) not null,
     content varchar2(4000) not null,
     regdate date default sysdate not null,
     user_seq number not null references tblUser(seq)

);

-- 유저 세부 정보
create table tblUserDetails
(
    seq number,
    tel varchar2(15) not null,
    email varchar2(50) not null,
    address varchar2(200) not null,

    constraint tbluserdetails_seq_pk primary key(seq),
    constraint tbluserdetails_seq_fk foreign key(seq) references tblUser(seq)
);

-- N:N 관계가 발견되면 중간에 테이블을 생성해서
-- 학생-수강신청-과목 이렇게
-- 1:N N:1 관계로 바꾼다

-- 학생, 과목, 수강
-- 복합키는 뭘까?
create table tblStudent
(
    seq number primary key,
    name varchar2(30) not null

);

-- 과목 정보
create table tblSubject
(
    seq number primary key,
    name varchar2(100) not null
);

create table tblRegistration
(
    student_seq number not null,
    subject_seq number not null,
    score number not null,
    
    constraint tblregistration_pk primary key(student_seq, subject_seq),
    constraint tblregistration_fk1 foreign key(student_seq)
                                        references tblStudent(seq),
    constraint tblregistration_fk2 foreign key(subject_seq)
                                        references tblStudent(seq)
);

select * from tblStudent;


insert into tblStudent values (1, '홍길동');
insert into tblStudent values (2, '강아지');
insert into tblStudent values (3, '고양이');

insert into tblSubject values (1, '자바');
insert into tblSubject values (2, '오라클');
insert into tblSubject values (3, '스프링');

insert into tblRegistration values ( 1, 1, 0);
insert into tblRegistration values ( 1, 2, 0);
insert into tblRegistration values ( 1, 3, 0);
insert into tblRegistration values ( 2, 1, 0);
insert into tblRegistration values ( 2, 2, 0);
insert into tblRegistration values ( 3, 2, 0);
insert into tblRegistration values ( 3, 3, 0);

-- 홍길동 + 자바 -> 점수?
-- 홍길동 + 어떤 과목?
-- 자바 + 어떤 학생?

-- 홍길동(seq) + 자바(seq) -> 점수(tblRegistration)?
select seq from tblStudent where name = '홍길동'; --1
select seq from tblSubject where name = '자바';

-- 길동이의 자바 점수
select * from registration
    where student_seq = (select seq from tblStudent where name = '홍길동')
        and subject_seq = (select seq from tblSubject where name = '자바');
        
select * from tblStudent st
    inner join tblRegistration r
        on st.seq = r.student_seq
            inner join tblSubject sj
                on sj.seq = r.subject_seq
                    where st.name = '홍길동' and sj.name = '자바';
                    
-- 홍길동 + 어떤 과목?
select sj.name from tblStudent st
    inner join tblRegistration r
        on st.seq = r.student_seq
            inner join tblSubject sj
                on sj.seq = r.subject_seq
                    where st.name = '홍길동';
                    
select * from tblSubject
    where seq in (select subject_seq from tblRegistration
                    where student_seq = (select seq from tblStudent
                                            where name = '홍길동'));
                                            
-- 자바 과목은 어떤 학생이 수강하고 있을까?
select st.name from tblStudent st
    inner join tblRegistration r
        on st.seq = r.student_seq
            inner join tblSubject sj
                on sj.seq = r.subject_seq
                    where sj.name = '자바';
                    
-- 보충 수업 테이블
create table tblExtra
(
    seq number primary key,
    regdate date,
    student_seq number, -- references tblRegistration(student_seq)
    subject_seq number, -- references tblRegistration(subject_seq)

    constraint tblextra_fk foreign key(student_seq, subject_seq)
        references tblRegistration(student_seq, subject_seq)
);

insert into tblExtra values (1, sysdate, 1, 1);
insert into tblExtra values(2, sysdate + 1, 1, 2);

-- 길동이가 어떤 과목에 대한 보충 수업을 듣는지 알고 싶대요
-- 보충 수업을 듣는 날짜?
select sj.name, e.regdate from tblStudent st
    inner join tblRegistration r
        on st.seq = r.student_seq
            inner join tblSubject sj
                on sj.seq = r.subject_seq
                    inner join tblExtra e
                        on r.student_seq = e.student_seq
                            and r.subject_seq = e.subject_seq
                                where st.name = '홍길동';
                                
select * from employees;