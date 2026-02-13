--자바 기초' 과목 시험에서 80점 이상의 점수를 기록한 학생들의 이름과 과정명을 조회하시오.

select us.usersName AS 학생이름
     , co.courseName as 과정이름
     , ts.testGradeScore as 시험점수 from TEST_SCORE ts
    join TEST t on ts.testSeq = t.testSeq
    join OPENED_SUBJECT os on t.openedSubjectSeq = os.openedSubjectSeq
    join REGISTERED_COURSE rc on rc.registeredCourseSeq = os.registeredCourseSeq
    join COURSE co on rc.courseSeq = co.courseSeq
    join SUBJECT su on su.subjectSeq = os.subjectSeq
    join STUDENT st on st.studentSeq = ts.studentseq
    join USERS us on us.usersSeq = st.usersSeq
        where su.SUBJECTTITLE = '자바 기초' and ts.testGradeScore >= 80;

--취업에는 성공했으나('취업성공'), 아직 '취업 성공 수당'을 받지 못한 학생의 이름을 찾으시오.

select us.usersName AS 학생이름 from STUDENT st
    join USERS us on us.usersSeq = st.usersSeq
    join EMPLOYMENT_STATUS es on es.STUDENTSEQ = st.STUDENTSEQ
    join EMPLOYMENT_SUCCESS_ALLOWANCE esa on esa.STUDENTSEQ = st.STUDENTSEQ
        where esa.employmentSuccessAllowanceState = '미지급' and es.employmentStatusState = '취업성공';

--전체 출결 기록 중 '조퇴' 횟수가 가장 많은 학생의 이름과 결석 횟수를 구하시오.

select us.usersName AS 학생이름
    ,count(*) AS 조퇴횟수 from STUDENT st
    join USERS us on us.usersSeq = st.usersSeq
    join ATTENDANCE at on at.STUDENTSEQ = st.STUDENTSEQ
    join ATTENDANCE_TYPE att on att.ATTENDANCETYPESEQ = at.ATTENDANCETYPESEQ
    where att.ATTENDANCETYPESTATE = '조퇴'
    Group By us.usersName
    order by 조퇴횟수 DESC
    FETCH FIRST 1 ROWS ONLY;



