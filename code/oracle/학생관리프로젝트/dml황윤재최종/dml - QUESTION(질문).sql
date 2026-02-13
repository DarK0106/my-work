-- dml - QUESTION.sql
-- 질문 / QUESTION
-- 작성자: 황윤재

-- 1. 자바 기초
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '자바 설치가 안 됩니다.', '오라클 사이트에서 자바 다운로드하려는데 버전이 너무 많아요. 뭘 받아야 하나요?', 1);

-- 2. 이클립스 관련
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '이클립스 실행 오류 질문', '이클립스를 켰는데 로딩창에서 안 넘어가요. 재설치해야 하나요?', 2);

-- 3. 변수 질문
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, 'int랑 long 차이가 뭔가요?', '숫자 넣을 때 그냥 다 long 쓰면 안 되나요? 메모리 차이인가요?', 3);

-- 4. for문 질문
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '구구단 찍는데 무한루프 돌아요', 'for문 조건식을 어떻게 줘야 할지 모르겠습니다. 코드 좀 봐주세요.', 4);

-- 5. SQL 접속
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '오라클 접속이 안 됩니다.', '리스너 오류라고 뜨는데 서비스 다시 시작해도 안 돼요. 도와주세요.', 5);

-- 6. SQL 문법
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, 'SELECT * FROM 의 의미', '별표(*)가 모든 컬럼을 다 가져온다는 뜻이 맞나요?', 6);

-- 7. 테이블 생성
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, 'Primary Key는 꼭 있어야 하나요?', '기본키 안 만들고 테이블 만들면 나중에 문제가 생기나요?', 7);

-- 8. 데이터 조작
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, 'DELETE랑 DROP 차이점', '둘 다 삭제하는 것 같은데 정확히 뭐가 다른 건가요?', 8);

-- 9. HTML 이미지
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '홈페이지에 이미지가 엑박으로 떠요', 'img 태그 경로를 제대로 쓴 것 같은데 이미지가 안 나옵니다.', 9);

-- 10. CSS 컬러
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '배경색 바꾸는 법 질문', 'div 태그 배경색을 빨간색으로 하고 싶은데 style 속성을 어떻게 쓰나요?', 10);

-- 11. 깃허브
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, 'git push가 안 됩니다.', '권한 오류(403)가 뜨는데 토큰 문제인가요?', 1);

-- 12. 팀 프로젝트
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '팀원끼리 코드 합칠 때 충돌나요', 'Merge Conflict 났는데 이거 어떻게 해결하나요? 빨간 줄이 너무 많아요.', 2);

-- 13. 수업 시간
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '내일 수업 몇 시 시작인가요?', '내일 특강 있다고 들었는데 9시 등원 맞나요?', 3);

-- 14. 지각 처리
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '오늘 몸이 안 좋아서 늦을 것 같아요', '병원 들렀다 가려고 하는데 지각 처리 되나요? 진단서 내면 되나요?', 4);

-- 15. 교재 문의
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '스프링 교재 언제 받나요?', '다음 달 수업인 스프링 교재는 학원에서 나눠주는 건가요?', 5);

-- 16. 파이썬
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '파이썬 print 한글 깨짐', '콘솔창에서 한글 출력하면 이상한 문자로 나옵니다.', 6);

-- 17. 알고리즘
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '코딩 테스트 준비 어떻게 하나요?', '백준이나 프로그래머스 어떤 거 먼저 푸는 게 좋을까요?', 7);

-- 18. 진로 상담
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '백엔드 개발자 취업 문의', '포트폴리오에 어떤 프로젝트를 넣는 게 유리한가요?', 8);

-- 19. 정보처리기사
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '정처기 실기 시험 일정', '이번 회차 실기 접수 기간 아시는 분 계신가요?', 9);

-- 20. 기타
INSERT INTO QUESTION (questionSeq, questionTitle, questionContent, usersSeq)
VALUES (QUESTION_SEQ.NEXTVAL, '학원 와이파이 비번 뭔가요?', '데이터가 다 떨어져서요. 와이파이 비밀번호 알려주세요.', 10);

-- [필수] 저장
COMMIT;