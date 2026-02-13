
-- 학생 성적
CREATE OR REPLACE VIEW vw_student_score AS
SELECT
    st.studentseq,
    st.usersseq,
    u.USERSNAME,
    t.testseq,
    sub.SUBJECTTITLE,
    os.openedsubjectseq,
    t.TESTTYPE,
    ts.TESTGRADESCORE,
    ts.TESTGRADEPARTICIPATED
FROM student st
    INNER JOIN REGISTERED_COURSE rc ON st.REGISTEREDCOURSESEQ = rc.REGISTEREDCOURSESEQ
    INNER JOIN OPENED_SUBJECT os ON rc.REGISTEREDCOURSESEQ = os.REGISTEREDCOURSESEQ
    INNER JOIN subject sub ON os.SUBJECTSEQ = sub.SUBJECTSEQ
    INNER JOIN test t ON os.OPENEDSUBJECTSEQ = t.OPENEDSUBJECTSEQ
    INNER JOIN test_score ts ON t.TESTSEQ = ts.TESTSEQ AND st.STUDENTSEQ = ts.STUDENTSEQ
    inner join users u on u.USERSSEQ = st.USERSSEQ;

-- 특정 과목의 특정 인원의 '평균' 계산기
-- 특정 수강생의 번호로 찾으면 됨
select studentseq as 학생번호,usersname as 학생이름,avg(TESTGRADESCORE) as 평균 from vw_student_score where studentseq = 62 GROUP BY studentseq,usersname;

-- 시험 순위 매기기
select studentseq as 학생번호,usersname as 학생이름,avg(TESTGRADESCORE) as 평균 from vw_student_score where openedsubjectseq = 2 GROUP BY studentseq,usersname
order by 평균 desc;

