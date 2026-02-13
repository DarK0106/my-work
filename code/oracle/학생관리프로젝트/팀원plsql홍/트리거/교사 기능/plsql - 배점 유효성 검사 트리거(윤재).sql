-- 배점 유효성 검사 트리거
-- 배점의 총합은 정확히 100이어야 함

-- 배점 유효성 검사 트리거
CREATE OR REPLACE TRIGGER TRG_CHECK_POINT_SUM
BEFORE INSERT OR UPDATE ON POINT_VALUE
FOR EACH ROW
DECLARE
    v_total_sum NUMBER;
BEGIN
    -- 1. 입력되는 세 가지 배점의 합계를 계산
    v_total_sum := :NEW.pointValueAttendance
                 + :NEW.pointValueWrittenTest
                 + :NEW.pointValuePracticalTest;

    -- 2. 배점의 합계가 '정확히 100'이 아니면 에러 발생
    IF v_total_sum != 100 THEN
        RAISE_APPLICATION_ERROR(-20002,
            '배점 비율의 총합은 정확히 100이어야 합니다. (현재 입력된 합계: ' || v_total_sum || '점)');
    END IF;
END;
/

-- 합계: 50 + 50 + 10 = 110 (실패 -> 트리거 에러 발생)
/*
INSERT INTO POINT_VALUE (pointValueSeq, pointValueAttendance, pointValueWrittenTest, pointValuePracticalTest, openedSubjectSeq)
VALUES (POINT_VALUE_SEQ.NEXTVAL, 50, 50, 10, 78);
*/

