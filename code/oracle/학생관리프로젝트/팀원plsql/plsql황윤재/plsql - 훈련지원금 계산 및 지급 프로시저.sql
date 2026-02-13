-- 출석률에 따른 훈련수당 계산기
-- 년, 월을 입력받으면 전체 수강생을 돌면서 출석을 확인하고,
-- 돈을 계산해서 TRAINING_ALLOWANCE 테이블에 데이터를 작성.

-- 훈련지원금 계산 및 지급 프로시저
CREATE OR REPLACE PROCEDURE PROC_GIVE_TRAINING_ALLOWANCE (
    p_year IN NUMBER,
    p_month IN NUMBER
)
IS
    v_target_date DATE; -- 계산 기준 월 (1일)
    v_month_end DATE;   -- 계산 기준 월 (말일)

    -- 대상자 선정 커서
    CURSOR cur_student IS
        SELECT s.studentSeq, s.studentStatus
        FROM STUDENT s
        JOIN REGISTERED_COURSE rc ON s.registeredCourseSeq = rc.registeredCourseSeq
        WHERE s.studentStatus IN ('수강중', '수강종료') -- 1. 수강대기생(X) 제외, 수료생(O) 포함
          -- 2. 기간 교차 체크 (이번 달에 수업이 있었던 사람만)
          AND rc.registeredCourseStartDate <= v_month_end
          AND rc.registeredCourseEndDate >= v_target_date;

    v_absent_count NUMBER;
    v_allowance NUMBER;
    v_dup_count NUMBER;

    v_base_pay CONSTANT NUMBER := 300000;
    v_deduction CONSTANT NUMBER := 10000;

BEGIN
    -- 날짜 세팅
    v_target_date := TO_DATE(p_year || '-' || p_month || '-01', 'YYYY-MM-DD');
    v_month_end := LAST_DAY(v_target_date);

    FOR rec IN cur_student LOOP

        -- 1. [중복 방지] 이미 이번 달 명단에 있는지 확인
        SELECT COUNT(*)
        INTO v_dup_count
        FROM TRAINING_ALLOWANCE
        WHERE studentSeq = rec.studentSeq
          AND TO_CHAR(trainingAllowanceApplyDate, 'YYYY-MM') = TO_CHAR(v_target_date, 'YYYY-MM');

        -- 2. 명단에 없을 때만 계산 시작
        IF v_dup_count = 0 THEN

            -- A. 결석 횟수 조회 (이번 달 내역만)
            SELECT COUNT(*)
            INTO v_absent_count
            FROM ATTENDANCE a
            JOIN ATTENDANCE_TYPE atType ON a.attendanceTypeSeq = atType.attendanceTypeSeq
            WHERE a.studentSeq = rec.studentSeq
              AND a.attendanceDate BETWEEN v_target_date AND v_month_end
              AND atType.attendanceTypeState = '결석';

            -- B. 금액 계산
            v_allowance := v_base_pay - (v_absent_count * v_deduction);
            IF v_allowance < 0 THEN v_allowance := 0; END IF;

            -- C. 데이터 입력
            INSERT INTO TRAINING_ALLOWANCE (
                trainingAllowanceSeq, trainingAllowanceAmount, trainingAllowanceApplyDate,
                trainingAllowancePayDate, trainingAllowanceState, studentSeq
            ) VALUES (
                TRAINING_ALLOWANCE_SEQ.NEXTVAL, v_allowance, SYSDATE,
                NULL, '지급예정', rec.studentSeq
            );

        END IF;

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(p_year || '년 ' || p_month || '월 지급 작업 완료.');
END;
/