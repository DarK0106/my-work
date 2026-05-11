create table member (
    username varchar2(50) primary key , -- 아이디(PK)
    password varchar2(100) not null , -- 암호
    age number(3) not null , -- 나이
    email varchar2(50) not null , -- 이메일
    role varchar2(50) not null -- ROLE_MEMBER, ROLE_ADMIN

);

commit ;

select *
from member;