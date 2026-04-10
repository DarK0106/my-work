-- spring
select * from tabs;

create table tblAddress(
    seq number PRIMARY KEY ,
    name varchar2(30) NOT NULL ,
    age number(3) NOT NULL ,
    address varchar2(300) NOT NULL ,
    gender char(1) NOT NULL
);
create SEQUENCE seqAddress;

insert into TBLADDRESS (seq, name, age, address, gender) VALUES (seqAddress.nextval,'홍길동', 20, '서울시 강남구 대치동', 'm');
insert into TBLADDRESS (seq, name, age, address, gender) VALUES (seqAddress.nextval,'강아지', 3, '서울시 강남구 역삼동', 'm');
insert into TBLADDRESS (seq, name, age, address, gender) VALUES (seqAddress.nextval,'고양이', 2, '서울시 강동구 천호동', 'f');
insert into TBLADDRESS (seq, name, age, address, gender) VALUES (seqAddress.nextval,'병아리', 1, '서울시 강동구 둔촌동', 'm');
insert into TBLADDRESS (seq, name, age, address, gender) VALUES (seqAddress.nextval,'거북이', 100, '서울시 강동구 길동', 'm');
insert into TBLADDRESS (seq, name, age, address, gender) VALUES (seqAddress.nextval,'남궁준식', 124, '포르투갈', 'm');

select * from tblAddress;

commit;

insert into TBLADDRESS (seq, name, age, address, gender) VALUES (seqAddress.nextval,'닭', 20, '서울시 강남구 대치동', 'm');

-- 방금 추가한 회원의 seq를 어떻게 알지?
select max(seq) from tblAddress;

-- 방금 회원가입한 닭에게 멤버십 포인트 1000 제공
insert into TBLPOINT (seq, POINT, ASEQ)
values (SEQPOINT.nextval, 4000, (select max(seq) from tblAddress));

create table tblProject (
    seq number primary key,
    name varchar2(100) not null ,
    location varchar2(100) not null ,
    num number not null references TBLINSA(NUM)
);

-- 프로젝트를 진행할 부서인 홍보부
select * from TBLINSA where BUSEO = '홍보부';

-- 프로젝트 맞는 사람이 총 3명, 프로젝트 2개씩 맞고 있는 직원 2명, 1개 담당하는 직원 1명
insert into tblProject values (1, '해외 수출', '서울', 1012);
insert into tblProject values (2, 'TV 광고', '부산', 1037);
insert into tblProject values (3, '고객 홍보', '인천', 1012);
insert into tblProject values (4, '자재 매입', '강릉', 1008);
insert into tblProject values (5, '재고 확보', '대구', 1008);

select
    a.NUM, a.NAME, a.BUSEO, a.JIKWI, a.BASICPAY as salary,
    p.seq, p.NAME as pname, p.location, p.num as inum
from TBLINSA a
    left outer join tblProject p
        on a.NUM = p.NUM;

select * from tblProject;

create table tblUser (
    id varchar2(30) primary key ,
    pw varchar2(30) not null ,
    name varchar2(30) not null
);

insert into tblUser values ('hong', '1111', '홍길동');
insert into tblUser values ('dog', '1111', '강아지');
insert into tblUser values ('cat', '1111', '고양이');

commit ;

select * from tblAddress;

select a.* from (select * from tblAddress order by seq desc) a
            where rownum <= 5;

select * from
             (select a.*, ROWNUM as rnum from (select * from tblAddress order by seq desc ) a)
where rnum between 11 and 15;