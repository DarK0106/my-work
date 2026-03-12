--

-- 주소록 테이블
create table tblAddress (
    seq number PRIMARY KEY,
    name varchar2(30) NOT NULL,
    age number(3) NOT NULL CHECK ( age BETWEEN 0 and 120),
    gender char(1) NOT NULL CHECK ( gender in('m', 'f') ),
    tel varchar2(15) NOT NULL ,
    address varchar2(300) NOT NULL ,
    regdate date DEFAULT SYSDATE NOT NULL
);
create SEQUENCE  seqAddress;

-- CRUD SQL
-- 1. 검증
-- 2. JDBC > 프로그램 작업을 위해서 미리 작성
INSERT INTO tblAddress (seq, name, age, gender, tel, address, regdate)
    VALUES (seqAddress.nextval, '메시', 20, 'm', '010-1234-5678', '서울시 강남구 대치동', DEFAULT);

SELECT *
FROM tblAddress;

update tblAddress set address = '서울시 강남구 대치동' where seq=1;

commit;

delete from tblAddress where seq = 1;

select * from tabs;
select * from tblAddress2;
