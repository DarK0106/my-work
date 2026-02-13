-- PROCEDURE 컴퓨터 사용 여부

CREATE OR REPLACE PROCEDURE proComputerStatus (
    p_used_status IN VARCHAR2,
    p_used_status2 IN varchar2
)
IS
BEGIN
    -- 188대의 컴퓨터 상태를 일괄 업데이트
    UPDATE COMPUTER
    SET     UsedComputer = p_used_status
    WHERE   computerSeq BETWEEN 1 AND 168;

    update computer
    set UsedComputer = p_used_status2
    where computerSeq between 169 and 188;
END;

-- 실행문
CALL proComputerStatus('사용중', '미사용');