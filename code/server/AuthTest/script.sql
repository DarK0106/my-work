-- AuthTest -> script.sql

create table tblUser (
    id varchar2(30) primary key, -- 아이디(PK)
    pw varchar2(30) not null, -- 암호
    name varchar2(30) not null, -- 이름
    grade number(1) not null -- 등급(일반(1), 관리자(2))
);

select * from tblUser;

delete table where tblUser;

insert into tblUser