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

