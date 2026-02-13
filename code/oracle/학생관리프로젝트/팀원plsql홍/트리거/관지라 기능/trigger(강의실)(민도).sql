-- LECTURE TRIGGER
-- 작성자: 김민도
-- 목적: LECTURE 테이블의 lectureCapacity(정수) 컬럼을 통해 강의실에 들어올 수 있는 학생수를 트리거로 관리한다.
-- 비고:
--      1.count(*)(view에서 조회용도)를 쓰는 트리거 방식은 동시성 문제가 있음
--          > 트리거에 많은 동시 접속이 많은 환경이 예상된다면 LECTURE 테이블에 current_count같은 컬럼을 두고 관리하는 것이 좋다고 한다.
--
--      2. LECTURE - REGISTERED_COURSE - STUDENT 구조로 LECTURE와 STUDENT 테이블이 이어져있지 않은데,
--            일반적으로 한 학생은 여러 과목을 들을 수 있고, 한 강의실에서도 시간대별로 여러 수업이 열리기 때문에,
--            만약 STUDENT에 lectureSeq를 직접 넣으면, 그 학생은 오직 한 강의실에만 소속될 수 있는 구조가 되기 쉽다.
--            현재 우리 프로젝트는 학생이 강의실을 변경하는 일이 없지만, 이 상황에도 데이터 무결성을 유지하는데 LECTURE - REGISTERED_COURSE - STUDENT 구조가 좋다.
--            학생 테이블에 강의실 번호를 직접 넣으면, 실수로 같은 수업을 듣는 학생들인데 서로 다른 강의실 번호가 입력되는 데이터 불일치 현상이 발생할 수 있기 때문이다.

CREATE OR REPLACE TRIGGER trg_check_student_limit
BEFORE INSERT ON STUDENT
FOR EACH ROW
DECLARE
    v_cap NUMBER;
    v_cur NUMBER;
BEGIN
    -- 뷰에서 현재 인원과 정원을 바로 가져옴
    SELECT lectureCapacity, currentCount
    INTO v_cap, v_cur
    FROM VIEW_COURSE_CAPACITY
    WHERE registeredCourseSeq = :NEW.registeredCourseSeq;

    -- 비교 후 에러 처리
    IF v_cur >= v_cap THEN --v_cur이 현재 인원수 이므로 참이되면 에러를 발생시킴
        RAISE_APPLICATION_ERROR(-20001, '강의실 정원(' || v_cap || '명)이 꽉 찼습니다!');
        --호출되면 해당 SQL문은 즉시 중단(Rollback)됨 / 여러 행을 한 번에 넣는경우 전체 작업이 취소되고 이전 상태로 돌아감
        --이후 java에서 try-catch로 잡아서 처리하게됨
    END IF;
END;



-- VIEW
-- 이렇게 view로 트리거의 from절을 관리하는 경우, 나중에 유지보수가 용이하고 트리거가 직관적으로 보이는 장점이 있음
CREATE OR REPLACE VIEW VIEW_COURSE_CAPACITY
AS
SELECT
    RC.registeredCourseSeq,
    L.lectureSeq,
    L.lectureCapacity,
    (SELECT COUNT(*) FROM STUDENT S WHERE S.registeredCourseSeq = RC.registeredCourseSeq) AS currentCount
FROM REGISTERED_COURSE RC
JOIN LECTURE L ON RC.lectureSeq = L.lectureSeq;



-- VIEW와 TRIGGER 생성 후 아래 코드를 실행하면 실행되지 않는다
insert into STUDENT (studentSeq, studentStatus, registeredCourseSeq, usersSeq) values (1, '수강완료', 1, 302);