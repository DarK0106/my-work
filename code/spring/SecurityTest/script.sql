-- SecurityTest -> script.sql

-- 스프링 시큐리티에서 제공하는 테이블

create table users (
	username varchar2(50) not null primary key, --아이디
	password varchar2(50) not null, --암호
	enabled char(1) default '1' --활동/미활동
);

create table authorities (
	username varchar2(50) not null, --아이디(FK)
	authority varchar2(50) not null, --권한(ROLE_XXX)
	constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);


insert into users (username, password) values ('dog', '1111');
insert into users (username, password) values ('cat', '1111');
insert into users (username, password) values ('tiger', '1111');

insert into authorities (username, authority) values ('dog', 'ROLE_MEMBER'); --일반 유저
insert into authorities (username, authority) values ('cat', 'ROLE_MEMBER'); --일반 유저
insert into authorities (username, authority) values ('tiger', 'ROLE_ADMIN'); --관리자
insert into authorities (username, authority) values ('tiger', 'ROLE_MEMBER'); --일반 유저

commit;

select * from users;
select * from authorities;

-- 12.2

create table member (
    memberid varchar2(50) primary key,      --아이디(username)
    memberpw varchar2(100) not null,        --암호(password)
    membername varchar2(50) not null,       --이름(추가)
    email varchar2(100) not null,           --이메일(추가)
    gender char(1) not null,                --성별(추가)
    enabled char(1) default '1',            --활동 유무(enabled)
    regdate date default sysdate not null   --회원 가입 날짜(추가)
);

create table member_auth (
    memberid varchar2(50) not null,     --아이디(FK)
    auth varchar2(50) not null,         --권한(ROLE_XXX)
    constraint fk_member_auth foreign key(memberid) references member(memberid)
);

commit;

select * from member;

drop table member;

insert into member_auth values ('dog', 'ROLE_MEMBER'); --일반 유저
insert into member_auth values ('cat', 'ROLE_MEMBER'); --일반 유저
insert into member_auth values ('tiger', 'ROLE_ADMIN'); --관리자
insert into member_auth values ('tiger', 'ROLE_MEMBER'); --일반 유저

select * from member_auth;