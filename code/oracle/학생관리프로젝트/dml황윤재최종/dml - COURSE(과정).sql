-- dml - COURSE.sql
-- 과정 / COURSE
-- 작성자: 황윤재

-- 1~5번 (6개월 과정 위주)
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'Java 기반 풀스택 개발자 양성 과정', '6개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'Spring Boot & React 실무 프로젝트 과정', '6개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '전자정부 프레임워크 기반 공공 SI 개발자 과정', '6개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '클라우드(AWS) 기반 MSA 융합 개발자 양성', '6개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '차세대 보안 관제 및 정보보호 전문가 과정', '6개월');

-- 6~10번 (5.5개월 과정 위주)
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'Python 활용 빅데이터 분석 및 시각화 과정', '5.5개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'AI 인공지능 서비스 기획 및 개발자 과정', '5.5개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'Node.js 백엔드 서버 개발자 실무 과정', '5.5개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'Vue.js 프론트엔드 전문 개발자 양성 과정', '5.5개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '스마트 팩토리 SW 개발 전문가 과정', '5.5개월');

-- 11~15번 (7개월 과정 위주 - 좀 더 심화된 느낌)
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'IoT(사물인터넷) 융합 임베디드 SW 개발자 과정', '7개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '금융 IT 핀테크 서비스 개발자 양성 과정', '7개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '블록체인 기반 응용 소프트웨어 개발자 과정', '7개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '자율주행 데이터 처리 및 AI 모델링 과정', '7개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '메타버스 및 XR 실감형 콘텐츠 제작 과정', '7개월');

-- 16~20번 (다양한 기간 섞기)
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'C# .NET 스마트 윈도우 프로그래밍 과정', '5.5개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '코틀린(Kotlin) 기반 안드로이드 앱 개발 과정', '6개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '유니티(Unity) 게임 클라이언트 개발자 양성', '6개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, '데브옵스(DevOps) 및 CI/CD 인프라 구축 전문가', '5.5개월');
INSERT INTO COURSE (courseSeq, courseName, coursePeriod) VALUES (COURSE_SEQ.NEXTVAL, 'SAP ABAP 엔터프라이즈 솔루션 개발 과정', '7개월');

-- [필수] 작업 저장
COMMIT;

select * from course;