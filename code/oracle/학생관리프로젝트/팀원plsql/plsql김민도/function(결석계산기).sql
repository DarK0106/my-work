 -- function 결석일 계산기
 -- 목적: 지각, 외출, 조퇴 3회시 결석 1회로 산정하여 총 결석일 수를 조회한다.
 -- 작성자: 김민도

CREATE OR REPLACE FUNCTION func_calculate_absence (
    p_student_seq IN NUMBER
) RETURN NUMBER
IS
    v_pure_absence  NUMBER := 0;
    v_other_bad_cnt NUMBER := 0;
    v_final_absence NUMBER := 0;
BEGIN
    -- 근태 데이터 집계
    SELECT
        COUNT(DECODE(AT.attendanceTypeState, '결석', 1)),
        COUNT(CASE WHEN AT.attendanceTypeState IN ('지각', '조퇴', '외출') THEN 1 END)
    INTO v_pure_absence, v_other_bad_cnt
    FROM ATTENDANCE A
    JOIN ATTENDANCE_TYPE AT ON A.attendanceTypeSeq = AT.attendanceTypeSeq
    WHERE A.studentSeq = p_student_seq;

    -- 3회당 1회 로직 적용
    v_final_absence := v_pure_absence + TRUNC(v_other_bad_cnt / 3);

    RETURN v_final_absence;
END;
/

-- 확인용
SELECT
    '학생번호: ' || 50 AS 정보,
    func_calculate_absence(50) AS "최종 계산된 결석일"
FROM DUAL;