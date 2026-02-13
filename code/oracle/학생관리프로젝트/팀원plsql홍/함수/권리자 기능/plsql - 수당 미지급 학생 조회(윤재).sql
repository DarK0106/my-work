-- 강의를 수료한 수강생 중 취업에 성공했고,
-- 강의 수료일에서 6개월이 지났지만 취업 성공 수당이
-- 지급되지 않은 수강생의 목록을 보는 함수

create or replace function FN_FIND_UNPAID_GRADUATES
(
    p_studentSeq IN NUMBER
) return varchar2

is
    v_count number;

    v_result varchar2(1) := 'N';
begin
    select count(*)
    into v_count
    from student s

    join REGISTERED_COURSE rc on s.REGISTEREDCOURSESEQ = rc.REGISTEREDCOURSESEQ
    join EMPLOYMENT_STATUS es on s.STUDENTSEQ = es.STUDENTSEQ
    left join EMPLOYMENT_SUCCESS_ALLOWANCE esa on s.STUDENTSEQ = esa.STUDENTSEQ

    where s.STUDENTSEQ = p_studentSeq
        and s.STUDENTSTATUS = '수강완료' -- 수료생
        and es.EMPLOYMENTSTATUSSTATE = '취업성공' -- 수료생 중에서 취업성공
        and rc.REGISTEREDCOURSEENDDATE <= add_months(sysdate, -6)
        and (esa.employmentSuccessAllowanceState IS NULL OR esa.employmentSuccessAllowanceState != '지급완료');
    
    IF v_count > 0 THEN
        v_result := 'Y'; -- 이 학생은 대상자다(Y)
    ELSE
        v_result := 'N'; -- 이 학생은 대상자가 아니다(N)
    END IF;

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