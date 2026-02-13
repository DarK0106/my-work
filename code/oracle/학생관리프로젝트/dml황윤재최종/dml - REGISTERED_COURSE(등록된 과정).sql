-- dml - REGISTERED_COURSE_REVISED.sql
-- 등록된 과정 데이터 12개 (종료 3 + 진행중 6 + 예정 3)
-- 기준일: 2026-02-06 (금) / 작성자: 황윤재

-- =============================================
-- 1. [종료] 2024년 데이터 (3개)
-- 이미 기간이 다 지났으므로 '종료' 상태
-- =============================================

-- 1-1. (종료) Java 풀스택 / 6개월(180일) / 2024년 상반기
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '종료',
    TO_DATE('2024-01-02', 'YYYY-MM-DD'),
    TO_DATE('2024-01-02', 'YYYY-MM-DD') + 180, -- 2024-06-30 종료
    1,  -- Java 과정
    1   -- 1강의실 (옛날에 씀)
);

-- 1-2. (종료) Python 빅데이터 / 5.5개월(165일) / 2024년 중반기
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '종료',
    TO_DATE('2024-03-04', 'YYYY-MM-DD'),
    TO_DATE('2024-03-04', 'YYYY-MM-DD') + 165, -- 2024-08-15 종료
    6,  -- Python 과정
    2   -- 2강의실
);

-- 1-3. (종료) AI 서비스 / 7개월(210일) / 2024년 하반기
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '종료',
    TO_DATE('2024-05-01', 'YYYY-MM-DD'),
    TO_DATE('2024-05-01', 'YYYY-MM-DD') + 210, -- 2024-11-26 종료
    7,  -- AI 과정
    3   -- 3강의실
);


-- =============================================
-- 2. [진행중] 2026년 2월 6일 현재 수업 중 (6개)
-- 시작일 + 기간이 오늘 날짜를 포함하도록 설정
-- =============================================

-- 2-1. (진행중) Spring Boot / 6개월(180일) / 작년 9월 개강 -> 올해 3월 수료
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행중',
    TO_DATE('2025-09-01', 'YYYY-MM-DD'),
    TO_DATE('2025-09-01', 'YYYY-MM-DD') + 180, -- 2026-02-28 종료 예정 (수료 임박!)
    2,  -- Spring 과정
    1   -- 1강의실 (2024년에 썼던 곳 다시 사용)
);

-- 2-2. (진행중) 클라우드 MSA / 6개월(180일) / 작년 10월 개강 -> 올해 4월 수료
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행중',
    TO_DATE('2025-10-20', 'YYYY-MM-DD'),
    TO_DATE('2025-10-20', 'YYYY-MM-DD') + 180, -- 2026-04-18 종료 예정
    4,  -- 클라우드 과정
    2   -- 2강의실
);

-- 2-3. (진행중) IoT 융합 / 7개월(210일) / 작년 8월 개강 -> 올해 3월 수료
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행중',
    TO_DATE('2025-08-04', 'YYYY-MM-DD'),
    TO_DATE('2025-08-04', 'YYYY-MM-DD') + 210, -- 2026-03-02 종료 예정
    11, -- IoT 과정
    4   -- 4강의실
);

-- 2-4. (진행중) Java 풀스택 (2기) / 6개월(180일) / 작년 12월 개강 -> 올해 6월 수료
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행중',
    TO_DATE('2025-12-29', 'YYYY-MM-DD'),
    TO_DATE('2025-12-29', 'YYYY-MM-DD') + 180, -- 2026-06-27 종료 예정
    1,  -- Java 과정
    3   -- 3강의실
);

-- 2-5. (진행중) 핀테크 / 7개월(210일) / 올해 1월 개강 -> 올해 8월 수료
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행중',
    TO_DATE('2026-01-05', 'YYYY-MM-DD'),
    TO_DATE('2026-01-05', 'YYYY-MM-DD') + 210, -- 2026-08-03 종료 예정 (개강 초기)
    12, -- 핀테크 과정
    5   -- 5강의실
);

-- 2-6. (진행중) 보안 전문가 / 6개월(180일) / 올해 1월 말 개강 -> 올해 7월 수료
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행중',
    TO_DATE('2026-01-26', 'YYYY-MM-DD'),
    TO_DATE('2026-01-26', 'YYYY-MM-DD') + 180, -- 2026-07-25 종료 예정 (따끈따끈한 새 과정)
    5,  -- 보안 과정
    6   -- 6강의실
);


-- =============================================
-- 3. [진행예정] 2027년 데이터 (3개)
-- 미래 날짜
-- =============================================

-- 3-1. (예정) Java 풀스택 (3기) / 2027년 1월 개강
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행예정',
    TO_DATE('2027-01-04', 'YYYY-MM-DD'),
    TO_DATE('2027-01-04', 'YYYY-MM-DD') + 180,
    1,  -- Java 과정
    1   -- 1강의실 (내년에 다시 씀)
);

-- 3-2. (예정) Python 빅데이터 (2기) / 2027년 3월 개강
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행예정',
    TO_DATE('2027-03-02', 'YYYY-MM-DD'),
    TO_DATE('2027-03-02', 'YYYY-MM-DD') + 165,
    6,  -- Python 과정
    2   -- 2강의실
);

-- 3-3. (예정) AI 서비스 (2기) / 2027년 5월 개강
INSERT INTO REGISTERED_COURSE (
    registeredCourseSeq, registeredCourseStatus, registeredCourseStartDate, registeredCourseEndDate, courseSeq, lectureSeq
) VALUES (
    REGISTERED_COURSE_SEQ.NEXTVAL,
    '진행예정',
    TO_DATE('2027-05-03', 'YYYY-MM-DD'),
    TO_DATE('2027-05-03', 'YYYY-MM-DD') + 210,
    7,  -- AI 과정
    3   -- 3강의실
);

-- [필수] 저장
COMMIT;
