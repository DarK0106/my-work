-- 컴퓨토 TRIGGER

CREATE OR REPLACE TRIGGER trgComputerDateStatus
AFTER INSERT OR UPDATE ON PERSONAL_COMPUTER
FOR EACH ROW
DECLARE
    v_studentStatus VARCHAR2(20);
BEGIN
    -- 1. 학생 상태 조회
    SELECT studentStatus INTO v_studentStatus
    FROM STUDENT
    WHERE studentSeq = :NEW.studentSeq;

    -- 현재(2026년)가 배정 시작일과 종료일 사이에 있는지 확인
    IF v_studentStatus = '수강중'
       AND SYSDATE BETWEEN :NEW.personalComputerAllocationDate AND :NEW.personalComputerEndDate THEN

        UPDATE COMPUTER
        SET UsedCompuTer = '사용중'
        WHERE computerSeq = :NEW.computerSeq;

    ELSE
        UPDATE COMPUTER
        SET UsedCompuTer = '미사용'
        WHERE computerSeq = :NEW.computerSeq;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        UPDATE COMPUTER
        SET UsedCompuTer = '미사용'
        WHERE computerSeq = :NEW.computerSeq;
END;
/

-- 업데이트로 데이터 변경
UPDATE PERSONAL_COMPUTER SET personalComputerAllocationDate = '2026-01-02' WHERE STUDENTSEQ = 100;
update PERSONAL_COMPUTER set personalComputerEndDate = '2026-02-01' where STUDENTSEQ = 100;

-- 정보 확인 개인 컴퓨터
select * from PERSONAL_COMPUTER;

-- 정보 확인 컴퓨터
select * from COMPUTER;

