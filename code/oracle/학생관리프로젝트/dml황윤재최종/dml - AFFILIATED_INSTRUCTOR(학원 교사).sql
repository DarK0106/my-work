-- dml - AFFILIATED_INSTRUCTOR.sql
-- 학원 교사 / AFFILIATED_INSTRUCTOR
-- 작성자: 황윤재
-- 학원 교사의 초기 비밀번호인 주민번호는 교사 테이블의 주민번호에서 뒷자리만 가져옴


-- 1. (교사 1번) 강의중 / 아이디: eng1001 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (
    affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary,
    affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq
)
SELECT
    AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL,
    '강의중',
    3200000,
    'eng1001',
    SUBSTR(instructorSSN, 8),
    instructorSeq,
    2 -- (권한번호: 교사)
FROM INSTRUCTOR WHERE instructorSeq = 1;

-- 2. (교사 2번) 대기중 / 아이디: kor2020 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '대기중', 2800000, 'kor2020', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 2;

-- 3. (교사 3번) 강의중 / 아이디: mat3303 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '강의중', 3500000, 'mat3303', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 3;

-- 4. (교사 4번) 강의중 / 아이디: jav1104 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '강의중', 3100000, 'jav1104', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 4;

-- 5. (교사 5번) 대기중 / 아이디: pyt5050 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '대기중', 2900000, 'pyt5050', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 5;

-- 6. (교사 6번) 강의중 / 아이디: dbx6006 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '강의중', 3300000, 'dbx6006', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 6;

-- 7. (교사 7번) 대기중 / 아이디: aws7070 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '대기중', 2700000, 'aws7070', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 7;

-- 8. (교사 8번) 강의중 / 아이디: cpp8808 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '강의중', 4000000, 'cpp8808', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 8;

-- 9. (교사 9번) 강의중 / 아이디: sec9909 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '강의중', 3600000, 'sec9909', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 9;

-- 10. (교사 10번) 대기중 / 아이디: linux10 / 비번: 주민뒷자리
INSERT INTO AFFILIATED_INSTRUCTOR (affiliatedInstructorSeq, affiliatedInstructorState, affiliatedInstructorSalary, affiliatedInstructorID, affiliatedInstructorPW, instructorSeq, authoritySeq)
SELECT AFFILIATED_INSTRUCTOR_SEQ.NEXTVAL, '대기중', 2600000, 'linux10', SUBSTR(instructorSSN, 8), instructorSeq, 2
FROM INSTRUCTOR WHERE instructorSeq = 10;

-- [필수] 저장
COMMIT;

