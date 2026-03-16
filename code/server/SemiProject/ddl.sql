-- SemiProject -> ddl.sql

drop table TBLUSER;

-- 회원 테이블
create table tblUser (
    id varchar2(50) primary key,  -- 아이디(PK)
    pw varchar2(50) not null, -- 비밀번호
    name varchar2(50) not null, -- 이름
    email varchar2(50) not null, -- 이메일
    lv number(1) not null, -- 회원등급(1: 일반회원 2: 관리자)
    pic varchar2(100) default 'pic.png' not null, -- 프로필 사진, 없으면 기본 프로필 사진
    intro varchar2(500) not null, -- 자기소개
    regdate date default sysdate not null, -- 가입날짜
    ing number(1) default 1 not null -- 활동유무(1: 활동 0: 탈퇴)
);

commit;

select * from tblUser;