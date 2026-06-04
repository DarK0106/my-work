ALTER SESSION SET CONTAINER = XEPDB1;

CREATE USER springboot IDENTIFIED BY java1234;

GRANT CONNECT, CREATE TABLE, CREATE SEQUENCE, CREATE VIEW, CREATE PROCEDURE, CREATE TRIGGER TO springboot;
ALTER USER springboot DEFAULT TABLESPACE users QUOTA UNLIMITED ON users TEMPORARY TABLESPACE temp;

ALTER SESSION SET CURRENT_SCHEMA = springboot;


create table tblAddress (
    seq number primary key,
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null,
    gender char(1) not null
);

create sequence seqAddress;

insert into tblAddress (seq, name, age, address, gender)
values (seqAddress.nextval, '홍길동', 20, '서울시 강남구 대치동', 'm');
insert into tblAddress (seq, name, age, address, gender)
values (seqAddress.nextval, '강아지', 3, '서울시 강남구 역삼동', 'm');
insert into tblAddress (seq, name, age, address, gender)
values (seqAddress.nextval, '고양이', 2, '서울시 강동구 천호동', 'f');
insert into tblAddress (seq, name, age, address, gender)
values (seqAddress.nextval, '병아리', 1, '서울시 강동구 둔촌동', 'm');
insert into tblAddress (seq, name, age, address, gender)
values (seqAddress.nextval, '거북이', 100, '서울시 강동구 길동', 'm');

commit;