-- 강의를 수료한 수강생 중 취업에 성공했고,
-- 강의 수료일에서 6개월이 지났지만 취업 성공 수당이
-- 지급되지 않은 수강생의 목록을 보는 함수

-- 취업 성공 수당 미지급 학생 조회 함수
create or replace function FN_FIND_UNPAID_GRADUATES
(
    p_studentSeq IN NUMBER
) return varchar2

is
    v_count number;

    -- (이미 받은 사람, 취업 못한 사람, 아직 6개월 안 지난 사람)
    v_result varchar2(1) := 'N';
begin
    -- 조건 검사
    select count(*)
    into v_count
    from student s

    -- 수강생(student)과 등록된 과정(registered_course) join
    join REGISTERED_COURSE rc on s.REGISTEREDCOURSESEQ = rc.REGISTEREDCOURSESEQ

    -- 수강생(student)과 취업상태(employment_status) join
    join EMPLOYMENT_STATUS es on s.STUDENTSEQ = es.STUDENTSEQ

    -- 수강생(student)과 취업 성공 수당(employment_status) left join
    -- 수당을 신청하지 않은 수강생을 찾을 수 있도록 left join
    left join EMPLOYMENT_SUCCESS_ALLOWANCE esa on s.STUDENTSEQ = esa.STUDENTSEQ

    -- s.STUDENTSEQ: FROM STUDENT s에서 가져온 실제 데이터들
    -- p_studentSeq: 사용자가 함수를 실행할 때 FN_FIND... (70) 하고 던져준 숫자 70
    where s.STUDENTSEQ = p_studentSeq
        and s.STUDENTSTATUS = '수강완료' -- 수료생
        and es.EMPLOYMENTSTATUSSTATE = '취업성공' -- 수료생 중에서 취업성공

        -- 수료생 중에서 취업성공하고 6개월 경과
        and rc.REGISTEREDCOURSEENDDATE <= add_months(sysdate, -6)

        -- 수료생 중에서 취업성공하고 6개월 경과됐는데 수당 미지급
        and (esa.employmentSuccessAllowanceState IS NULL OR esa.employmentSuccessAllowanceState != '지급완료');
    
    -- v_count가 0보다 크다면? (조건에 맞는 데이터가 1건이라도 발견되었다면?)
    IF v_count > 0 THEN
        v_result := 'Y'; -- 이 학생은 대상자다(Y)
    ELSE
        v_result := 'N'; -- 이 학생은 대상자가 아니다(N)
    END IF;

    -- 최종 결과('Y' 또는 'N')를 함수 밖으로 던져줌
    RETURN v_result;


end;
/

-- 함수 사용 예시
SELECT
    u.usersName AS 학생이름,
    u.usersTel AS 전화번호,
    c.courseName AS 과정명,
    es.employmentStatusDate AS 취업일
FROM STUDENT s
JOIN USERS u ON s.usersSeq = u.usersSeq
JOIN REGISTERED_COURSE rc ON s.registeredCourseSeq = rc.registeredCourseSeq
JOIN COURSE c ON rc.courseSeq = c.courseSeq
JOIN EMPLOYMENT_STATUS es ON s.studentSeq = es.studentSeq
WHERE FN_IS_ALLOWANCE_TARGET(s.studentSeq) = 'Y'; -- 함수 호출