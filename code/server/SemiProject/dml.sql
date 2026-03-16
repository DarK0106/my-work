-- SemiProject -> dml.sql

-- 계정
-- 일반 계정 1명
insert into tblUser(id, pw, name, email, lv, pic, intro, regdate, ing)
    values ('hong', '1111', '홍길동', 'hong@gmail.com', 1, default, '반갑습니다.', default, default);

-- 관리자 계정 1명
insert into tblUser(id, pw, name, email, lv, pic, intro, regdate, ing)
    values ('tiger', '1111', '호랑이', 'tiger@gmail.com', 2, default, '관리자입니다.', default, default);

commit;

select * from TBLUSER;