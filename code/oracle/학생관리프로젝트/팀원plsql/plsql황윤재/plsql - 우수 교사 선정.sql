-- 교사 평가의 평균 점수가 9점 이상인
-- 교사를 우수 교사로 선정하는 함수

-- 우수 교사 선정 함수
CREATE OR REPLACE FUNCTION FN_CHECK_EXCELLENT_TEACHER (
    p_instructorSeq IN NUMBER
) RETURN VARCHAR2
IS
    v_avg_score NUMBER := 0;      -- 평균 점수를 담을 변수
    v_result VARCHAR2(20);        -- 결과 문자열 ('우수 교사' 등)
BEGIN
    -- 1. 해당 교사의 평가 점수 평균 계산
    SELECT AVG(tr.teacherRatingScore)
    INTO v_avg_score
    FROM TEACHER_RATING tr
    INNER JOIN COURSE_INSTRUCTOR ci ON tr.courseInstructorSeq = ci.courseInstructorSeq
    INNER JOIN AFFILIATED_INSTRUCTOR ai ON ci.affiliatedInstructorSeq = ai.affiliatedInstructorSeq
    WHERE ai.instructorSeq = p_instructorSeq;

    -- 2. 점수가 없으면(NULL) 0점으로 처리
    v_avg_score := NVL(v_avg_score, 0);

    -- 3. 판별 과정 (9점 이상이면 우수)
    IF v_avg_score >= 9 THEN
        v_result := '우수 교사';
    ELSE
        v_result := '일반 교사';
    END IF;

    RETURN v_result;
END;
/

-- 함수 사용 예시
SELECT
    i.instructorName AS 교사명,
    i.instructorTel AS 연락처,
    -- 여기서 함수를 호출해서 상태를 출력
    FN_CHECK_EXCELLENT_TEACHER(i.instructorSeq) AS 교사등급
FROM INSTRUCTOR i
WHERE FN_CHECK_EXCELLENT_TEACHER(i.instructorSeq) = '우수 교사';

commit;

select * from test_score;