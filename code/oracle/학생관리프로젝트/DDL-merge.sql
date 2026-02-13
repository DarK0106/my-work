-- depth 1
-- 권한 / authority
DROP SEQUENCE AUTHORITY_SEQ;
CREATE SEQUENCE AUTHORITY_SEQ;
DROP TABLE AUTHORITY;
CREATE TABLE AUTHORITY(
    authoritySeq number,
    authorityName varchar2(20) not null,

    CONSTRAINT authority_pk primary key(authoritySeq),
    CONSTRAINT authority_seq_limit CHECK (authoritySeq IN (1, 2, 3, 4))
);

-- 과목 / subject
DROP SEQUENCE SUBJECT_SEQ;
CREATE SEQUENCE SUBJECT_SEQ;
DROP TABLE SUBJECT;
CREATE TABLE SUBJECT(
    subjectSeq number,
    subjectTitle varchar2(50) not null,
    subjectType varchar2(20) not null,

    CONSTRAINT subject_pk primary key(subjectSeq),
    CONSTRAINT subject_uq_title unique(subjectTitle),
    CONSTRAINT subject_type_limit CHECK ( subjectType in ('공통', '개별'))
);

-- 교사 / INSTRUCTOR
DROP SEQUENCE INSTRUCTOR_SEQ;
CREATE SEQUENCE INSTRUCTOR_SEQ;
DROP TABLE INSTRUCTOR;
CREATE TABLE INSTRUCTOR(
    instructorSeq number,
    instructorName varchar2(20) not null,
    instructorSSN varchar2(14) not null,
    instructorTel varchar2(30),

    CONSTRAINT instructor_pk PRIMARY KEY (instructorSeq),
    CONSTRAINT instructor_uq UNIQUE (instructorssn),
    CONSTRAINT instructor_ssn_ck CHECK (REGEXP_LIKE(instructorSSN, '^[0-9]{6}-[0-9]{7}$')),
    CONSTRAINT instructor_tel_ck CHECK (REGEXP_LIKE(instructorTel, '^[0-9]{3}-[0-9]{4}-[0-9]{4}$'))
);



-- 근태종류
drop sequence  ATTENDANCE_TYPE_SEQ;
create sequence ATTENDANCE_TYPE_SEQ;
drop table ATTENDANCE_TYPE;
create table ATTENDANCE_TYPE(
    attendanceTypeSeq number,
    attendanceTypeState varchar2(20) not null,

    constraint attendanceTypeSeq_pk primary key (attendanceTypeSeq),
    constraint attendanceTypeSeq_limit check (attendanceTypeSeq in (1, 2, 3, 4, 5, 6)),
    constraint attendance_type_uq UNIQUE (attendanceTypeState)
);



-- 과정 / course
DROP SEQUENCE COURSE_SEQ;
CREATE SEQUENCE COURSE_SEQ;
DROP TABLE COURSE;
CREATE TABLE COURSE
(
      courseSeq number, -- 과정번호
      courseName varchar2(100) not null, -- 과정명
      coursePeriod varchar2(20) not null, -- 과정기간

      -- 제약조건
      CONSTRAINT course_pk primary key(courseSeq),
      CONSTRAINT ck_course_period CHECK (coursePeriod in ('5.5개월', '6개월', '7개월') )

);

-- 강의실
DROP SEQUENCE lecture_SEQ;
CREATE SEQUENCE lecture_SEQ;
drop table LECTURE;
CREATE TABLE LECTURE(
    lectureSeq number,
    lectureCapacity number not null ,

     CONSTRAINT check_lecture_rules CHECK (
        (lectureSeq BETWEEN 1 AND 3 AND lectureCapacity = 30) -- 1~3이면 30명 고정
        OR
        (lectureSeq BETWEEN 4 AND 6 AND lectureCapacity = 26) -- 4~6이면 26명 고정
     ),
    constraint lecture_pk primary key(lectureSeq)

);


--컴퓨터 상태
DROP SEQUENCE computer_Status_SEQ;
CREATE SEQUENCE computer_Status_SEQ;
DROP TABLE COMPUTER_STATUS;
create table COMPUTER_STATUS(
    computerStatusSeq number,
    computerStatusState varchar2(20) unique not null,

    constraint computer_status_pk primary key(computerStatusSeq)
);


-- depth 2
-- 강의 가능 과목 / TEACHABLE_SUBJECT
DROP SEQUENCE TEACHABLE_SUBJECT_SEQ;
CREATE SEQUENCE TEACHABLE_SUBJECT_SEQ;
DROP TABLE TEACHABLE_SUBJECT;
CREATE TABLE TEACHABLE_SUBJECT(
    teachableSubjectSeq number,
    subjectSeq number not null,
    instructorSeq number not null,

    CONSTRAINT pk_teachableSubject PRIMARY KEY (teachablesubjectseq),
    CONSTRAINT fk_teachable_subject FOREIGN KEY (subjectSeq) REFERENCES SUBJECT(subjectSeq),
    CONSTRAINT fk_teachable_instructor FOREIGN KEY (instructorSeq) REFERENCES  instructor(instructorSeq)
);

-- 커리큘럼 / CURRICULUM
DROP SEQUENCE CURRICULUM_SEQ;
CREATE SEQUENCE CURRICULUM_SEQ;
DROP TABLE CURRICULUM;
CREATE TABLE CURRICULUM(
    curriculumSeq number,
    curriculumPeriod varchar2(10) not null,
    courseSeq number not null,
    subjectSeq number not null,

    CONSTRAINT pk_curriculum PRIMARY KEY (curriculumSeq),
    CONSTRAINT fk_curriculum_course FOREIGN KEY (courseSeq) REFERENCES COURSE(courseSeq),
    CONSTRAINT fk_curriculum_subject FOREIGN KEY (subjectSeq) references SUBJECT(subjectSeq)
);

-- 등록된 과정 --depth 2
DROP SEQUENCE REGISTERED_COURSE_SEQ;
create sequence REGISTERED_COURSE_SEQ;
drop table REGISTERED_COURSE;
create table REGISTERED_COURSE(
    registeredCourseSeq number,
    registeredCourseStatus varchar2(20) not null,
    registeredCourseStartDate date,
    registeredCourseEndDate date,
    courseSeq number not null,
    lectureSeq number not null,

    constraint registeredCourseSeq_pk primary key (registeredCourseSeq),
    constraint registeredCourse_courseSeq_fk foreign key (courseSeq) references course(courseSeq),
    constraint registeredCourse_lectureSeq_fk foreign key (lectureSeq) references lecture(lectureSeq)
);
-- Function-based Unique Index를 사용하여 강의중일때만 lectureSeq의 유일성 검증
/*
    CREATE UNIQUE INDEX idx_lecture_status_unique
    ON REGISTERED_COURSE (
    CASE
        WHEN registeredCourseStatus = '강의중'
        THEN lectureSeq
        ELSE NULL
    END
);
*/

-- 사물함 --depth 2
drop sequence LOCKER_SEQ;
create sequence LOCKER_SEQ;
drop table LOCKER;
create table LOCKER(
    lockerSeq number,
    lockerUseStatus varchar2(20) not null,
    lectureSeq number not null,

    constraint lockerSeq_pk primary key (lockerSeq),
    constraint locker_lectureSeq_fk foreign key (lectureSeq) references lecture(lectureSeq)
);



-- 학원교사 / affiliated_instructor
DROP SEQUENCE AFFILIATED_INSTRUCTOR_SEQ;
CREATE SEQUENCE AFFILIATED_INSTRUCTOR_SEQ;
DROP TABLE AFFILIATED_INSTRUCTOR;
CREATE TABLE AFFILIATED_INSTRUCTOR
(
    affiliatedInstructorSeq number, -- 학원 교사 번호
    affiliatedInstructorState varchar2(20) not null, -- 상태
    affiliatedInstructorSalary number, -- 월급
    affiliatedInstructorID varchar2(20) not null, -- 아이디
    affiliatedInstructorPW varchar2(20) not null, -- 비밀번호

    -- 외래키
    instructorSeq number not null, -- 교사 번호
    authoritySeq number default 2, -- 권한 번호

    -- 제약 조건
    CONSTRAINT affiliatedInstructor_pk primary key (affiliatedInstructorSeq),
    CONSTRAINT affiliatedInstructor_fk_teacher FOREIGN KEY (instructorSeq) REFERENCES INSTRUCTOR(instructorSeq),
    CONSTRAINT affiliatedInstructor_fk_auth FOREIGN KEY (authoritySeq) REFERENCES AUTHORITY(authoritySeq),
    CONSTRAINT affiliatedInstructor_uk unique (affiliatedInstructorID)

);

-- 관리자 / admin
DROP SEQUENCE ADMIN_SEQ;
CREATE SEQUENCE ADMIN_SEQ;
DROP TABLE ADMIN;
CREATE TABLE ADMIN
(
    adminSeq number, -- 관리자 번호
    adminName varchar2(20) not null, -- 관리자명
    adminID varchar2(20) not null, -- ID
    adminPW varchar2(20) not null, -- PW

    -- 외래키
    authoritySeq number default 1,

    -- 제약조건
    CONSTRAINT admin_pk primary key (adminSeq),
    CONSTRAINT admin_fk_authority FOREIGN KEY (authoritySeq) REFERENCES AUTHORITY(authoritySeq),
    CONSTRAINT admin_uq unique (adminID)

);

--유저
DROP SEQUENCE USERS_SEQ;
CREATE SEQUENCE USERS_SEQ;
DROP TABLE users;
CREATE TABLE USERS(
    usersSeq number not null ,
    usersName VARCHAR2(50) not null ,
    usersAddress varchar2(150) not null ,
    usersSSN varchar2(14) unique not null ,
    usersTel varchar2(30) not null ,
    usersID varchar2(20) unique not null ,
    usersPW varchar2(20) not null, --트리거 필요!!!!!!!!!!!!!
    authoritySeq number default 3 ,

    constraint users_pk primary key(usersSeq),
    constraint users_auth_fk foreign key (authoritySeq) REFERENCES AUTHORITY(authoritySeq),
    CONSTRAINT users_ssn_ck CHECK (REGEXP_LIKE(usersSSN, '^[0-9]{6}-[0-9]{7}$'))
);


--컴퓨터
DROP SEQUENCE COMPUTER_SEQ;
CREATE SEQUENCE COMPUTER_SEQ;
drop TABLE COMPUTER;
CREATE TABLE COMPUTER(
    computerSeq number,
    computerStatusSeq number not null ,
    lectureSeq number,

    constraint computer_pk primary key(computerSeq),
    constraint computer_status_fk foreign key (computerStatusSeq) references COMPUTER_STATUS(computerStatusSeq),
    constraint computer_lecture_fk foreign key (lectureSeq) references LECTURE(lectureSeq)
);


-- depth 3
-- 수강생 / student
DROP SEQUENCE STUDENT_SEQ;
CREATE SEQUENCE STUDENT_SEQ;
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    studentSeq number,
    studentStatus varchar2(20) not null,
    registeredCourseSeq number not null,
    usersSeq number not null,

    CONSTRAINT pk_student PRIMARY KEY (studentSeq),
    CONSTRAINT fk_student_registerd_course FOREIGN KEY (registeredCourseSeq) REFERENCES REGISTERED_COURSE(registeredCourseSeq),
    CONSTRAINT fk_student_users FOREIGN KEY (usersSeq) REFERENCES USERS (usersSeq)
);

-- 개설과목 --depth 3
DROP SEQUENCE OPENED_SUBJECT_SEQ;
create sequence OPENED_SUBJECT_SEQ;
drop table OPENED_SUBJECT;
create table OPENED_SUBJECT(
    openedSubjectSeq number,
    openedSubjectStartDate date,
    openedSubjectEndDate date,
    registeredCourseSeq number not null,
    subjectSeq number,

    constraint openedSubjectSeq_pk primary key (openedSubjectSeq),
    constraint openedSubject_registeredCourseSeq_fk foreign key (registeredCourseSeq) references REGISTERED_COURSE(registeredCourseSeq),
    constraint openedSubjectSeq_subjectSeq_fk foreign key (subjectSeq) references SUBJECT(subjectSeq)
);



-- 질문 / question
DROP SEQUENCE QUESTION_SEQ;
CREATE SEQUENCE QUESTION_SEQ;
DROP TABLE QUESTION;

CREATE TABLE QUESTION
(
   questionSeq number, -- 질문 번호
   questionTitle varchar2(100) not null, -- 질문 제목
   questionContent varchar2(4000) not null, -- 질문 내용

   -- 외래키
   usersSeq number not null, -- 유저 번호

  -- 제약조건
  CONSTRAINT question_pk primary key (questionSeq),
  CONSTRAINT question_fk_users FOREIGN KEY (usersSeq) REFERENCES USERS(usersSeq)

);

-- 자주 묻는 질문 / FAQ
DROP SEQUENCE FAQ_SEQ;
CREATE SEQUENCE FAQ_SEQ;
DROP TABLE FAQ;

CREATE TABLE FAQ
(
    faqSeq number, -- 자주 묻는 질문 번호
    faqTitle varchar2(100) not null, -- 제목
    faqContent varchar2(4000) not null, -- 내용

    -- 외래키
    adminSeq number not null, -- 관리자 번호

    -- 제약조건
    CONSTRAINT faq_pk primary key (faqSeq),
    CONSTRAINT faq_fk_admin foreign key (adminSeq) references ADMIN(adminSeq)

);

-- 등록교사
DROP SEQUENCE course_Instructor_SEQ;
CREATE SEQUENCE course_Instructor_SEQ;

drop TABLE COURSE_INSTRUCTOR;
CREATE TABLE COURSE_INSTRUCTOR(
    courseInstructorSeq number,
    courseInstructorStartDate Date,
    courseInstructorEndDate Date,
    affiliatedInstructorSeq number not null ,
    registeredCourseSeq number not null ,

    constraint coures_pk primary key (courseInstructorSeq),
    constraint coures_affil_fk foreign key (affiliatedInstructorSeq) REFERENCES AFFILIATED_INSTRUCTOR(affiliatedInstructorSeq),
    constraint coures_regist_fk foreign key (registeredCourseSeq) REFERENCES REGISTERED_COURSE(registeredCourseSeq)
);


-- depth 4
-- 훈련지원금 / TRAINING_ALLOWANCE
DROP SEQUENCE TRAINING_ALLOWANCE_SEQ;
CREATE SEQUENCE TRAINING_ALLOWANCE_SEQ;
DROP TABLE TRAINING_ALLOWANCE;
CREATE TABLE TRAINING_ALLOWANCE(
    trainingAllowanceSeq number,
    trainingAllowanceAmount number not null,
    trainingAllowanceApplyDate date not null,
    trainingAllowancePayDate date,
    trainingAllowanceState varchar2(15) not null,
    studentSeq number not null,

    CONSTRAINT pk_training_allowance PRIMARY KEY(trainingAllowanceSeq),
    CONSTRAINT fk_training_allowance_student FOREIGN KEY (studentSeq) REFERENCES STUDENT(studentSeq)
);


-- 취업상태 / EMPLOYMENT_STATUS
DROP SEQUENCE EMPLOYMENT_STATUS_SEQ;
CREATE SEQUENCE EMPLOYMENT_STATUS_SEQ;
DROP TABLE EMPLOYMENT_STATUS;
CREATE TABLE EMPLOYMENT_STATUS(
    employmentStatusSeq number,
    employmentStatusState varchar2(15) NOT NULL,
    employmentStatusDate date,
    employmentStatusPossible date GENERATED ALWAYS AS (employmentStatusDate + 180),
    studentSeq number not null,

    CONSTRAINT pk_employment_status PRIMARY KEY (employmentStatusSeq),
    CONSTRAINT fk_employment_status_student FOREIGN KEY (studentSeq) REFERENCES student(studentSeq)
);


-- 취업 성공 수당 / EMPLOYMENT_SUCCESS_ALLOWANCE
DROP SEQUENCE EMPLOYMENT_SUCCESS_ALLOWANCE_SEQ;
CREATE SEQUENCE EMPLOYMENT_SUCCESS_ALLOWANCE_SEQ;
DROP TABLE EMPLOYMENT_SUCCESS_ALLOWANCE;
CREATE TABLE EMPLOYMENT_SUCCESS_ALLOWANCE(
    employmentSuccessAllowanceSeq number,
    employmentSuccessAllowanceAmount number default 0 not null,
    employmentSuccessAllowancePayment date,
    employmentSuccessAllowanceState varchar2(15) not null,
    employmentSuccessAllowanceApplication date not null,
    studentSeq number not null,

    CONSTRAINT pk_employment_success PRIMARY KEY (employmentSuccessAllowanceSeq),
    CONSTRAINT fk_employment_success_student FOREIGN KEY (studentSeq) REFERENCES STUDENT(studentSeq)
);

-- 시험 --depth 4
DROP SEQUENCE TEST_SEQ;
create sequence TEST_SEQ;
drop table TEST;
create table TEST(
    testSeq number,
    testType varchar2(10) not null,
    testExecuted varchar2(10) not null,
    openedSubjectSeq number not null,

    constraint testSeq_pk primary key (testSeq),
    constraint test_openedSubjectSeq_fk foreign key (openedSubjectSeq) references OPENED_SUBJECT(openedSubjectSeq),
    CONSTRAINT ck_test_type CHECK ( testType in('필기', '실기') )
);


-- 교재 --depth 4
drop SEQUENCE BOOK_SEQ;
create sequence BOOK_SEQ;
drop table BOOK;
create table BOOK(
    bookSeq number,
    bookName varchar2(100) not null,
    bookPublisher varchar2(50) not null,
    openedSubjectSeq number not null,

    constraint bookSeq_pk primary key (bookSeq),
    constraint book_openedSubjectSeq_fk foreign key (openedSubjectSeq) references OPENED_SUBJECT(openedSubjectSeq)
);


-- 배점 --depth 4
DROP SEQUENCE POINT_VALUE_SEQ;
create sequence POINT_VALUE_SEQ;
drop table POINT_VALUE;
create table POINT_VALUE(
    pointValueSeq number,
    pointValueAttendance number not null,
    pointValueWrittenTest number not null,
    pointValuePracticalTest number not null,
    openedSubjectSeq number not null,

    constraint pointValueSeq_pk primary key (pointValueSeq),
    constraint point_value_openedSubjectSeq_fk foreign key (openedSubjectSeq)
        references OPENED_SUBJECT(openedSubjectSeq),
    CONSTRAINT uq_point_value_opened_subject UNIQUE (openedSubjectSeq)
);

-- 배점 테이블
CREATE TABLE point_value (
    pointValueSeq           NUMBER,
    pointValueAttendance    NUMBER NOT NULL,
    pointValueWrittenTest   NUMBER NOT NULL,
    pointValuePracticalTest NUMBER NOT NULL,
    openedSubjectSeq        NUMBER NOT NULL,
    CONSTRAINT pointValueSeq_pk PRIMARY KEY ( pointvalueseq ),
    CONSTRAINT point_value_openedSubjectSeq_fk FOREIGN KEY ( openedsubjectseq )
        REFERENCES opened_subject ( openedsubjectseq ),
    CONSTRAINT uq_point_value_opened_subject UNIQUE ( openedsubjectseq ),
    CONSTRAINT chk_attendance_min CHECK ( pointvalueattendance >= 20 ),
    CONSTRAINT chk_point_total_100 CHECK
    ( pointvalueattendance + pointvaluewrittentest + pointvaluepracticaltest = 100 )
);


-- 답변 / answer
DROP SEQUENCE ANSWER_SEQ;
CREATE SEQUENCE ANSWER_SEQ;
DROP TABLE ANSWER;
CREATE TABLE ANSWER
(
    answerSeq number, -- 답변 번호
    answerTitle varchar2(100) not null, -- 답변 제목
    answerContent varchar2(4000) not null, -- 답변 내용

    -- 외래키
    questionSeq number not null, -- 질문 번호
    affiliatedInstructorSeq number not null, -- 학원 교사 번호

    -- 제약조건
    CONSTRAINT answer_pk primary key (answerSeq),
    CONSTRAINT answer_fk_question foreign key (questionSeq) references QUESTION(questionSeq),
    CONSTRAINT answer_fk_affiliated FOREIGN KEY (affiliatedInstructorSeq) REFERENCES AFFILIATED_INSTRUCTOR(affiliatedInstructorSeq)
);

-- 교사 평가 / teacher_rating
DROP SEQUENCE TEACHER_RATING_SEQ;
CREATE SEQUENCE TEACHER_RATING_SEQ;
DROP TABLE TEACHER_RATING;
CREATE TABLE TEACHER_RATING
(
    teacherRatingSeq number, -- 교사 평가 번호
    teacherRatingScore number not null, -- 점수
    teacherRatingComment varchar2(4000), -- 내용

    -- 외래키
    studentSeq number not null, -- 수강생 번호
    courseInstructorSeq number not null, -- 등록 교사 번호

    -- 제약조건
    CONSTRAINT teacher_rating_pk primary key (teacherRatingSeq),
    CONSTRAINT teacher_rating_fk_student foreign key (studentSeq) references STUDENT(studentSeq),
    CONSTRAINT teacher_rating_fk_course_instructor foreign key (courseInstructorSeq) references COURSE_INSTRUCTOR(courseInstructorSeq)

);

-- 강의 평가 / lecture_review
DROP SEQUENCE LECTURE_REVIEW_SEQ;
CREATE SEQUENCE LECTURE_REVIEW_SEQ;
DROP TABLE LECTURE_REVIEW;

CREATE TABLE LECTURE_REVIEW
(
    lectureReviewSeq number, -- 강의 평가 번호
    lectureReviewScore number not null, -- 점수
    lectureReviewContent varchar2(4000), -- 내용

    -- 외래키
    studentSeq number not null, -- 수강생 번호

    -- 제약조건
    CONSTRAINT lecture_review_pk primary key (lectureReviewSeq),
    CONSTRAINT lecture_review_fk_student foreign key (studentSeq) references STUDENT(studentSeq)
);


-- depth 4
-- 근태
DROP SEQUENCE attendance_SEQ;
CREATE SEQUENCE attendance_SEQ;
DROP TABLE ATTENDANCE;
CREATE TABLE ATTENDANCE(
    attendanceSeq NUMBER,
    attendanceDate DATE not null ,
    attendanceCheckIn DATE,
    attendanceCheckOut DATE,
    studentSeq NUMBER not null ,
    attendanceTypeSeq NUMBER not null ,

    CONSTRAINT attend_pk primary key (attendanceSeq),
    constraint attend_student_fk foreign key (studentSeq) references STUDENT (studentSeq),
    constraint attend_Type_fk foreign key (attendanceTypeSeq) references ATTENDANCE_TYPE (attendanceTypeSeq)
);

-- 사물함 개인배정
DROP SEQUENCE personal_Locker_SEQ;
CREATE SEQUENCE personal_Locker_SEQ;
drop table PERSONAL_LOCKER;

CREATE TABLE PERSONAL_LOCKER(
    personalLockerSeq NUMBER,
    personalLockerAllocationDate DATE not null,
    personalLockerEndDate DATE,
    studentSeq NUMBER not null,
    lockerSeq NUMBER not null ,

    constraint personallocker_pk primary key (personalLockerSeq),
    constraint person_student_fk foreign key (studentSeq) references STUDENT(studentSeq),
    constraint person_locker_fk foreign key (lockerSeq) references LOCKER (lockerSeq)
);

-- 컴퓨터 개인배정
DROP SEQUENCE personal_Computer_SEQ;
CREATE SEQUENCE personal_Computer_SEQ;
drop table PERSONAL_COMPUTER;
CREATE TABLE PERSONAL_COMPUTER(
    personalComputerSeq NUMBER,
    personalComputerAllocationDate DATE not null,
    personalComputerEndDate DATE,
    studentSeq NUMBER not null,
    computerSeq NUMBER not null,


    constraint personalcomputer_pk primary key (personalComputerSeq),
    constraint personalcomputer_com_fk foreign key (computerSeq) REFERENCES COMPUTER(computerSeq),
    constraint personalcomputer_student_fk foreign key (studentSeq) REFERENCES STUDENT(studentSeq)
);

-- depth 5
-- 시험성적
DROP SEQUENCE test_score_SEQ;
CREATE SEQUENCE test_score_SEQ;
drop TABLE TEST_SCORE;
CREATE TABLE TEST_SCORE(
    testGradeSeq NUMBER,
    testGradeScore NUMBER,
    testGradeParticipated VARCHAR2(20) not null ,
    testSeq NUMBER not null ,
    studentSeq NUMBER not null ,

    constraint testscore_pk primary key (testGradeSeq),
    constraint testscore_test_fk foreign key (testSeq) references TEST(testseq),
    constraint testscore_student_fk foreign key (studentSeq) references STUDENT(studentSeq)
);