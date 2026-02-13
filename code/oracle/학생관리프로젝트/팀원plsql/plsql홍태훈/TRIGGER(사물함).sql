CREATE OR REPLACE TRIGGER trgLockerDateStatus
AFTER INSERT OR UPDATE ON PERSONAL_LOCKER
FOR EACH ROW
DECLARE
    v_studentStatus VARCHAR2(20);
BEGIN
    -- 1. 배정받는 학생의 현재 수강 상태를 확인
    SELECT studentStatus INTO v_studentStatus
    FROM STUDENT
    WHERE studentSeq = :NEW.studentSeq;

    -- 2. 조건 체크: 학생이 '수강중'이고 + 오늘이 배정 기간(시작일~종료일) 내에 있는지 확인
    IF v_studentStatus = '수강중'
       AND SYSDATE BETWEEN :NEW.personalLockerAllocationDate AND :NEW.personalLockerEndDate THEN

        -- 조건을 만족하면 사물함 상태를 '사용중'으로 변경
        UPDATE LOCKER
        SET lockerUseStatus = '사용중'
        WHERE lockerSeq = :NEW.lockerSeq;

    ELSE
        -- 학생이 수강생이 아니거나, 배정 기간이 아직 아니거나 이미 끝났다면 '미사용'
        UPDATE LOCKER
        SET lockerUseStatus = '미사용'
        WHERE lockerSeq = :NEW.lockerSeq;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- 학생 정보가 없을 경우 미사용 처리
        UPDATE LOCKER
        SET lockerUseStatus = '미사용'
        WHERE lockerSeq = :NEW.lockerSeq;
END;

-- 업데이트로 데이터 변경
update PERSONAL_LOCKER set personalLockerAllocationDate = '2026-01-01' where STUDENTSEQ = 100;
update PERSONAL_LOCKER set PERSONALLOCKERENDDATE = '2026-02-28' where STUDENTSEQ = 100;

-- 정보 확인 개인 사물함
select * from PERSONAL_LOCKER;

-- 정보 확인 사물함
select * from LOCKER;

