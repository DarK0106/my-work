create table tblMemo (
    seq number primary key, -- 메모번호(PK)
    name varchar2(30) not null, -- 작성자
    pw varchar2(30) not null, -- 암호
    memo varchar2(2000) not null, -- 메모
    regdate date default sysdate not null -- 작성일
);
create sequence seqMemo;

-- 메모 쓰기
insert into tblMemo (seq, name, pw, memo, regdate) VALUES (seqMemo.nextval, '홍길동', '1111', '메모 내용입니다.', default);

-- 메모 목록 보기
select * from tblMemo order by seq desc;


-- 메모 작성자인지 확인하기 -> 암호 확인
select count(*) as cnt from tblMemo where seq = 1 and pw = '1111';

delete from tblMemo;

-- 메모 수정하기
update tblMemo set memo = '수정합니다.' where seq = 1;

-- 메모 삭제하기
delete from tblMemo where seq = 1;

commit;