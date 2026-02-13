-- test_score 테이블에 insert 나 update 될 때
-- 점수가 0 미만이거나 100 초과면 에러를 발생시키는
-- 시험 점수 유효성 검사 트리거

CREATE OR REPLACE TRIGGER TRG_CHECK_VALID_SCORE
BEFORE INSERT OR UPDATE ON TEST_SCORE
FOR EACH ROW
BEGIN
    -- 들어오는 점수(:NEW.testGradeScore)가 0보다 작거나 100보다 크면 에러 발생
    IF :NEW.testGradeScore < 0 OR :NEW.testGradeScore > 100 THEN
        RAISE_APPLICATION_ERROR(-20001, '시험 점수는 0점 이상 100점 이하이어야 합니다.');
    END IF;
END;
/

-- 1. 실패 케이스 (100점 초과) -> 에러 발생해야 함!
/*
INSERT INTO TEST_SCORE (testGradeSeq, testGradeScore, testGradeParticipated, testSeq, studentSeq)
VALUES (TEST_SCORE_SEQ.NEXTVAL, 150, '참여', 1, 1);
*/
-- 결과: ORA-20001: 시험 점수는 0점 이상 100점 이하이어야 합니다.


-- 2. 실패 케이스 (음수) -> 에러 발생해야 함!
/*
INSERT INTO TEST_SCORE (testGradeSeq, testGradeScore, testGradeParticipated, testSeq, studentSeq)
VALUES (TEST_SCORE_SEQ.NEXTVAL, -10, '참여', 1, 1);
*/
-- 결과: ORA-20001: 시험 점수는 0점 이상 100점 이하이어야 합니다.