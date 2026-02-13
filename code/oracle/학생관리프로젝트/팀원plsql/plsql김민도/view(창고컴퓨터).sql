-- view 창고컴퓨터
-- 목적: 창고에 컴퓨터가 몇대 보관중인지 보여준다
-- 작성자: 김민도

create or replace view vw_storage_computer
as
select
    C.COMPUTERSEQ as 컴퓨터번호,
    CS.COMPUTERSTATUSSTATE as 컴퓨터상태,
    C.USEDCOMPUTER as 사용여부
from COMPUTER C
    join COMPUTER_STATUS CS
        on C.computerStatusSeq = CS.computerStatusSeq
where C.USEDCOMPUTER = '미사용';

select * from vw_storage_computer;