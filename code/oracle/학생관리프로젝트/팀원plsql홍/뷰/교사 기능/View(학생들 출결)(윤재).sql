-- 뷰

CREATE OR REPLACE VIEW VW_STUDENT_ATTENDANCE_STATUS AS
SELECT
    u.usersName AS 학생이름,
    s.studentSeq AS 수강생번호,
    c.courseName AS 과정명,   -- ★ 추가된 부분: 어떤 과정인지 출력
    a.attendanceDate AS 출석일,
    at.attendanceTypeState AS 근태종류,

    -- [출석률 계산: AVG 함수 사용으로 오류 해결]
    ROUND(
        AVG(CASE WHEN at.attendanceTypeState != '결석' THEN 1 ELSE 0 END)
        OVER (PARTITION BY s.studentSeq) * 100
    , 2) || '%' AS 출석률

FROM STUDENT s
JOIN USERS u ON s.usersSeq = u.usersSeq
JOIN REGISTERED_COURSE rc ON s.registeredCourseSeq = rc.registeredCourseSeq
JOIN COURSE c ON rc.courseSeq = c.courseSeq       -- ★ 추가된 조인: 과정 테이블 연결
JOIN ATTENDANCE a ON s.studentSeq = a.studentSeq
JOIN ATTENDANCE_TYPE at ON a.attendanceTypeSeq = at.attendanceTypeSeq
WHERE s.studentStatus IN ('수강중', '수강종료');

-- 확인

SELECT * FROM VW_STUDENT_ATTENDANCE_STATUS
WHERE 수강생번호 = 93
ORDER BY 출석일 DESC;

