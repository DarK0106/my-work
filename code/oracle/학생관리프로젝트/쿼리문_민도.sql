    -- sql 쿼리문
-- 작성자: 김민도

-- 1. 모든 '수강생(STUDENT)'의 이름, 전화번호, 그리고 현재 수강 중인 '과정명(Course Title)'을 출력하시오. (중도탈락 학생 제외)
select
    U.usersName,
    U.usersTel,
    C.CourseName
from STUDENT S
    join REGISTERED_COURSE RC
        on S.registeredCourseSeq = RC.registeredCourseSeq
    join USERS U
        on U.usersSeq = S.usersSeq
    join COURSE C
        on C.CourseSeq = RC.CourseSeq
where s.STUDENTSTATUS = '수강중';


-- 2. '제1강의실'에서 진행 중이거나 진행 예정인 모든 과정의 과정명, 시작일, 종료일을 출력하시오.
select
    C.CourseName as 과정명,
    RC.registeredCourseStartDate as 시작일,
    RC.registeredCourseEndDate as 종료일
from COURSE C
    join REGISTERED_COURSE RC
        on RC.CourseSeq = C.CourseSeq
    join LECTURE L
        on L.lectureSeq = RC.lectureSeq
where L.lectureSeq = 1 and rc.REGISTEREDCOURSESTATUS in ('진행중', '진행예정');

-- 3. 'JAVA' 과목을 강의할 수 있는('강의가능과목'에 등록된) 모든 교사의 이름과 전화번호를 출력하시오. > 과목명 '자바 기초'
select
    i.INSTRUCTORNAME as 교사이름,
    i.INSTRUCTORTEL as 교사전화번호
from INSTRUCTOR I
    join TEACHABLE_SUBJECT TSU
        on I.instructorSeq = TSU.instructorSeq
    join SUBJECT SU
        on SU.subjectSeq = TSU.subjectSeq
where tsu.subjectseq = (select subjectseq from subject where SUBJECTTITLE= '자바 기초');

-- 4. '제1강의실'에 있는 사물함 중, 현재 배정된 사물함의 번호와 그 사물함을 쓰는 학생의 이름을 출력하시오.
select
    PL.personalLockerSeq as 사물함번호,
    U.usersName as 학생이름,
    case
        when l.LOCKERUSESTATUS = '사용' then '사용중'
        else
            '배정은 받았으나 미사용'
    end as 사용여부
from USERS U
    join STUDENT S
        on U.usersSeq = S.usersSeq
    join PERSONAL_LOCKER PL
        on PL.studentSeq = S.studentSeq
    join LOCKER L
        on L.lockerSeq = PL.lockerSeq
    join LECTURE LEC
        on LEC.lectureSeq = L.lectureSeq
where LEC.lectureSeq = 1;


-- 5. 70번 수강생이 치른 모든 시험의 과목명, 점수를 출력하시오
select
    SU.subjectTitle as 시험이름,
    TS.testGradeParticipated as 참여여부,
    TS.testGradeScore as 점수
from STUDENT S
    join TEST_SCORE TS
        on S.studentSeq = TS.studentSeq
    join TEST T
        on T.testSeq = TS.testSeq
    join OPENED_SUBJECT OSU
        on OSU.openedSubjectSeq = T.openedSubjectSeq
    join SUBJECT SU
        on SU.subjectSeq = OSU.subjectSeq
where S.studentSeq = 70 and ts.TESTGRADEPARTICIPATED = '참여';


-- 6. 'Java 풀스택 과정(1기)' 수강생 중, 'SQL 활용' 과목 시험 점수가 가장 높은 학생의 이름과 점수를 출력하시오. > 과정명: Java 기반 풀스택 개발자 양성 과정
select
    U.usersName,
    TS.testGradeScore
from STUDENT S
    join REGISTERED_COURSE RC
        on S.registeredCourseSeq = RC.registeredCourseSeq
    join TEST_SCORE TS
        on TS.studentSeq = S.studentSeq
    join OPENED_SUBJECT OSU
        on OSU.registeredCourseSeq = RC.registeredCourseSeq
    join SUBJECT SU
        on SU.subjectSeq = OSU.subjectSeq
    join COURSE C
        on C.CourseSeq = RC.CourseSeq
    join USERS U
        on U.usersSeq = S.usersSeq
where C.CourseName = 'Java 기반 풀스택 개발자 양성 과정' and SU.subjectTitle = 'SQL 활용'
    and TS.testGradeScore = (select max(TS.testGradeScore)
                                from STUDENT S
                                join REGISTERED_COURSE RC
                                    on S.registeredCourseSeq = RC.registeredCourseSeq
                                join TEST_SCORE TS
                                    on TS.studentSeq = S.studentSeq
                                join OPENED_SUBJECT OSU
                                    on OSU.registeredCourseSeq = RC.registeredCourseSeq
                                join SUBJECT SU
                                    on SU.subjectSeq = OSU.subjectSeq
                                join COURSE C
                                    on C.CourseSeq = RC.CourseSeq
                                where C.CourseName = 'Java 기반 풀스택 개발자 양성 과정' and SU.subjectTitle = 'SQL 활용');



-- 7. 50번 수강생의 전체 출결 기록 중 '지각'과 '조퇴' 횟수를 각각 카운트하여 출력하시오.
select
    COUNT(DECODE(AT.attendanceTypeState, '지각', 1)) AS "지각 횟수",
    COUNT(DECODE(AT.attendanceTypeState, '조퇴', 1)) AS "조퇴 횟수"
from STUDENT S
    join ATTENDANCE A
        on S.studentSeq = A.studentSeq
    join ATTENDANCE_TYPE AT
        on AT.attendanceTypeSeq = A.attendanceTypeSeq
where S.studentSeq = 50;



-- 8. 7번 시험(test_seq = 7)을 응시한 수강생 중, 점수가 60점 미만인 학생들의 과정명, 과목명, 학생 이름, 점수를 출력하시오.
select
    C.CourseName as 과정명,
    S.subjectTitle as 과목명,
    U.usersName as 학생이름,
    TS.testGradeScore as 점수
from subject s
    inner join OPENED_SUBJECT os on s.SUBJECTSEQ = os.SUBJECTSEQ
    inner join TEST t on os.OPENEDSUBJECTSEQ = t.OPENEDSUBJECTSEQ
    inner join TEST_SCORE ts on t.TESTSEQ = ts.TESTSEQ
    inner join student st on st.STUDENTSEQ = ts.STUDENTSEQ
    inner join REGISTERED_COURSE rc on rc.REGISTEREDCOURSESEQ = st.REGISTEREDCOURSESEQ
    inner join COURSE c on c.COURSESEQ = rc.COURSESEQ
    inner join users u on u.USERSSEQ = st.USERSSEQ
where T.testSeq = 7 and TS.testGradeScore < 60;



-- 9. 학원 교사 4번(affiliatedInstructorSeq = 1)이 현재 강의 중인 과정명과 배정된 강의실 호수를 출력하시오.
select
    C.CourseName as 과정명,
    L.lectureSeq as 배정된강의실호수
from AFFILIATED_INSTRUCTOR AI
    join COURSE_INSTRUCTOR CI
        on AI.affiliatedInstructorSeq = CI.affiliatedInstructorSeq
    join REGISTERED_COURSE RC
        on RC.registeredCourseSeq = CI.registeredCourseSeq
    join LECTURE L
        on L.lectureSeq = RC.lectureSeq
    join COURSE C
        on C.CourseSeq = RC.CourseSeq
where AI.affiliatedInstructorSeq = 4 and RC.registeredCourseStatus = '진행중';

-- 10. 교사 평가(Teacher_Rating) 평균 점수가 9.0점 이상인 교사의 이름을 중복 없이 출력하시오.

select i.INSTRUCTORNAME as 교사이름 from COURSE_INSTRUCTOR CI
    join TEACHER_RATING TR
        on CI.courseInstructorSeq = TR.courseInstructorSeq
    join AFFILIATED_INSTRUCTOR AI
        on AI.affiliatedInstructorSeq = CI.affiliatedInstructorSeq
    join INSTRUCTOR I
        on I.instructorSeq = AI.instructorSeq
group by i.INSTRUCTORNAME
having round(avg(tr.TEACHERRATINGSCORE),1) >= 9.0;

-- 11. 강의 평가(Lecture_Review) 내용에 '친절'이라는 단어가 포함된 리뷰의 작성자 이름, 별점, 내용을 가져오시오.
select
    U.usersName as 작성자이름,
    TR.teacherRatingScore as 별점,
    TR.teacherRatingComment as 평가내용
from TEACHER_RATING TR
    join STUDENT S
        on S.studentSeq = TR.studentSeq
    join USERS U
        on U.usersSeq = S.usersSeq
where TR.teacherRatingComment like '%친절%';

-- 12. 각 교사별로 강의 가능한 과목이 몇 개인지 교사 이름과 과목 수를 출력하시오.
select
    I.instructorName as 교사이름,
    count(TSU.subjectSeq) as 강의과목수
from INSTRUCTOR I
    join TEACHABLE_SUBJECT TSU
        on TSU.instructorSeq = I.instructorSeq
    join SUBJECT SU
        on SU.subjectSeq = TSU.subjectSeq
group by I.instructorName;


