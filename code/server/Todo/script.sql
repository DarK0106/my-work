-- Todo -> script.sql

create TABLE tblTodo (
    seq number primary key, -- 번호(PK)
    todo varchar2(100) not null, -- 할일
    state char(1) default 'n' not null, -- 완료(y), 미완료(n)
    regdate date default sysdate not null -- 등록일
    );

create sequence seqTodo;

insert into tblTodo(seq, todo, state, regdate)
    values (seqTodo.nextval, '컴퓨터 포맷하기', default, default);
insert into tblTodo(seq, todo, state, regdate)
    values (seqTodo.nextval, '강아지 산책시키기', default, default);
insert into tblTodo(seq, todo, state, regdate)
    values (seqTodo.nextval, '고양이 목욕하기', default, default);

update tblTodo set state = 'y' where seq in (2,3);

commit;

select *
from tblTodo;