-- 유저에서 수강생으로 insert 되면  4번권한 주기
CREATE OR REPLACE TRIGGER trg_student_insert_update_user_state
AFTER INSERT OR UPDATE ON student
FOR EACH ROW
WHEN (NEW.studentStatus = '수강중')
BEGIN
    UPDATE users
    SET authoritySeq = 4
    WHERE usersseq = :NEW.usersseq;
END;
/
insert into STUDENT (studentSeq, studentStatus, registeredCourseSeq, usersSeq) values (student_seq.nextval, '수강중', 9, 301);

-- 수강생이 수강종료상태가 되면 유저권하이 3번으로
CREATE OR REPLACE TRIGGER trg_student_update_users_state_endcourse
AFTER UPDATE ON STUDENT
FOR EACH ROW
WHEN (new.STUDENTSTATUS = '수강종료')
BEGIN
    UPDATE USERS
    SET AUTHORITYSEQ = 3
    where USERSSEQ = :NEW.usersseq;
END;
/
update student set STUDENTSTATUS = '수강종료' where STUDENTSEQ = 301;
update student set STUDENTSTATUS = '수강중' where STUDENTSEQ = 301;
commit;
select * from users u
    inner join student s on u.USERSSEQ = s.USERSSEQ where s.USERSSEQ = 301;

-- 뷰
-- 모든 학생(유저)의 정보를 출력하는 뷰 관리자가 목록보는 뷰임

CREATE OR REPLACE VIEW vw_user_course_info AS
SELECT DISTINCT
    u.usersseq,
    u.usersname as 학생이름,
    u.usersID as 학생아이디,
    u.userstel,
    st.studentseq,
    st.studentstatus,
    rc.registeredcourseseq,
    c.courseseq,
    c.coursename,
    i.INSTRUCTORNAME as 담당교사
FROM users u
    LEFT JOIN student st ON u.USERSSEQ = st.USERSSEQ
    LEFT JOIN REGISTERED_COURSE rc ON st.REGISTEREDCOURSESEQ = rc.REGISTEREDCOURSESEQ
    LEFT JOIN course c ON rc.COURSESEQ = c.COURSESEQ
    INNER JOIN COURSE_INSTRUCTOR ci ON rc.REGISTEREDCOURSESEQ = ci.REGISTEREDCOURSESEQ
    INNER JOIN AFFILIATED_INSTRUCTOR ai ON ai.AFFILIATEDINSTRUCTORSEQ = ci.AFFILIATEDINSTRUCTORSEQ
    INNER JOIN INSTRUCTOR i ON i.INSTRUCTORSEQ = ai.INSTRUCTORSEQ;

-- 관리자가 모든 정보를 봄
select * from vw_user_course_info;
-- 특정교사가 자신들의 학생들의 정보를 봄
select * from vw_user_course_info
         where 담당교사 = '허이면';
-- 특정 교육생이 자신의 정보만 봄;
select * from vw_user_course_info
        where 학생아이디 = 'ebe0m9';



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



SELECT view_name
FROM USER_VIEWS
ORDER BY view_name;

SELECT trigger_name, table_name, status
FROM USER_TRIGGERS
ORDER BY trigger_name;