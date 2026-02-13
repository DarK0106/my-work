select * from AFFILIATED_INSTRUCTOR;

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
  CONSTRAINT course_pk primary key(courseSeq)

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
    authoritySeq number, -- 권한 번호

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
    adminID varchar2(255) not null, -- ID
    adminPW varchar2(20) not null, -- PW

    -- 외래키
    authoritySeq number not null,

    -- 제약조건
    CONSTRAINT admin_pk primary key (adminSeq),
    CONSTRAINT admin_fk_authority FOREIGN KEY (authoritySeq) REFERENCES AUTHORITY(authoritySeq),
    CONSTRAINT admin_uk unique (adminID)

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

-- 답변 / answer
DROP SEQUENCE ANSWER_SEQ;
CREATE SEQUENCE ANSWER_SEQ;
DROP TABLE ANSWER;

CREATE TABLE ANSWER
(
    answerSeq number, -- 답변 번호
    answerTitle varchar2(100) not null, -- 답변 제목
    answerContent varchar2(4000), -- 답변 내용

    -- 외래키
    questionSeq number not null, -- 질문 번호
    affiliatedInstructorSeq number not null, -- 학원 교사 번호

    -- 제약조건
    CONSTRAINT answer_pk primary key (answerSeq),
    CONSTRAINT answer_fk_question foreign key (questionSeq) references QUESTION(questionSeq),
    CONSTRAINT answer_fk_instructor foreign key (affiliatedInstructorSeq) references AFFILIATED_INSTRUCTOR(affiliatedInstructorSeq)
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
    studentSeq number, -- 수강생 번호
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
    CONSTRAINT lecture_review_fk_student foreign key (lectureReviewSeq) references STUDENT(studentSeq)

);
