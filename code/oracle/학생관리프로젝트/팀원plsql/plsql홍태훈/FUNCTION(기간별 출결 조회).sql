-- 년, 월, 일별 출결 현황 조회
CREATE OR REPLACE FUNCTION fnGetAttendanceList (
    p_date IN VARCHAR2
) RETURN SYS_REFCURSOR
IS
    v_cursor SYS_REFCURSOR; -- 빨대
BEGIN
    OPEN v_cursor FOR
        SELECT
            학생이름,
            과정명,
            TO_CHAR(출석일, 'YYYY-MM-DD') AS 날짜,
            근태종류,
            출석률
        FROM VW_STUDENT_ATTENDANCE_STATUS
        WHERE TO_CHAR(출석일, 'YYYY-MM-DD') LIKE p_date || '%'
        ORDER BY 출석일 DESC, 학생이름;

    -- 함수라 반환
    RETURN v_cursor;
END;
/

--실행 코드
SELECT fnGetAttendanceList('2026-02') FROM DUAL;