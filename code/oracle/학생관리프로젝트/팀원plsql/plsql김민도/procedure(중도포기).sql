-- procedure 중도포기
-- 목적: 출석률이 80% 이하가 되면 중도포기처리
-- 작성자: 김민도

CREATE OR REPLACE PROCEDURE proc_handle_course_drop (
    p_student_seq IN NUMBER
)
IS
    v_rg_startDate    DATE;
    v_rg_endDate      DATE;
    v_total_days      NUMBER := 0;
    v_final_absence   NUMBER := 0;
    v_attendance_rate NUMBER := 0;
    v_student_name    VARCHAR2(100);
BEGIN
    -- 1. 학생 이름과 등록된 과정 시작일, 종료일 조회
    SELECT RC.registeredCourseStartDate, RC.registeredCourseEndDate, U.usersName
    INTO v_rg_startDate, v_rg_endDate ,v_student_name
    FROM STUDENT S
    JOIN REGISTERED_COURSE RC ON S.registeredCourseSeq = RC.registeredCourseSeq
    JOIN USERS U ON S.usersSeq = U.usersSeq
    WHERE S.studentSeq = p_student_seq;

    SELECT COUNT(*) INTO v_total_days
    FROM (
        -- 시작일(startDate)부터 종료일(endDate)까지 날짜를 한 줄씩 생성
        SELECT v_rg_startDate + LEVEL - 1 AS dt
        FROM DUAL
        CONNECT BY LEVEL <= (v_rg_endDate - v_rg_startDate + 1)
        )
        WHERE TO_CHAR(dt, 'D') NOT IN ('1', '7'); -- 1:일요일, 7:토요일 제외

    -- 2. ★미리 만든 함수 사용★ (코드 매우 깔끔!)
    v_final_absence := func_calculate_absence(p_student_seq);

    -- 3. 출석률 계산
    IF v_total_days > 0 THEN
        v_attendance_rate := ((v_total_days - v_final_absence) / v_total_days) * 100;
    ELSE
        v_attendance_rate := 0;
    END IF;

    -- 4. 80% 미만 시 상태 업데이트
    IF v_attendance_rate <= 80 THEN
        UPDATE STUDENT
        SET studentStatus = '중도포기'
        WHERE studentSeq = p_student_seq;

        DBMS_OUTPUT.PUT_LINE('[처리] ' || v_student_name || ' 학생 출석률 ' || ROUND(v_attendance_rate, 1) || '%로 중도포기 확정.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('[처리] ' || v_student_name || ' 학생 출석률 ' || ROUND(v_attendance_rate, 1) || ' / ' ||'출석률 80% 이상');
    END IF;
END;
/

DECLARE
    num1 number := 1;
begin
    LOOP
        proc_handle_course_drop(num1);
        num1 := num1 + 1;
        if num1 > 80 then
            exit;
        end if;
    END LOOP;
end;
/


select * from Student s
    inner join ATTENDANCE a on a.STUDENTSEQ = s.STUDENTSEQ
where s.STUDENTSEQ = 1;
