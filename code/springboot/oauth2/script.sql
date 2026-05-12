-- oauth2 -> script.sql
create table tblUser (

  seq number primary key , -- 다양한 OAuth2 프로바이더를 사용한다면 별도의 PK를 둔다
  username varchar2(100) unique not null, -- 내부 아이디
  name varchar2(50) not null, -- 사용자 이름
  email varchar2(100) unique not null,
  role varchar2(50) not null, -- ROLE_MEMBER
  provider varchar2(50) not null, -- 프로바이더(구글, 네이버, 카카오 등)
  providerid varchar2(100) -- 각 OAuth2 프로바이더에서 발급하는 고유 사용자 ID
);

create sequence seqUser;

drop table tblUser cascade constraints;

commit ;