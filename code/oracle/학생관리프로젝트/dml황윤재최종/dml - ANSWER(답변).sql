-- dml - ANSWER.sql
-- 답변 / ANSWER (질문 1~20번에 대한 1:1 답변)
-- 작성자: 황윤재

select * from answer;

-- 1. 자바 설치 (질문: 버전이 너무 많아요)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 자바 버전 가이드입니다.', '안녕하세요. 현재 수업에서는 Java 17 (LTS) 버전을 사용하고 있습니다. 오라클 홈페이지에서 Java 17 Windows x64 Installer를 다운로드하시면 됩니다.', 1, 1);

-- 2. 이클립스 오류 (질문: 로딩창 멈춤)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 워크스페이스 충돌 해결법', '이클립스 강제 종료로 인해 워크스페이스 락(Lock)이 걸린 것 같습니다. workspace 폴더 내의 .metadata 폴더를 삭제하고 다시 실행해 보세요.', 2, 1);

-- 3. 변수 차이 (질문: int vs long)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 메모리 효율성 관련', '기능상으로는 long을 써도 되지만, int는 4바이트, long은 8바이트를 차지합니다. 메모리 최적화를 위해 표현하려는 수의 범위에 맞는 타입을 쓰는 습관이 중요합니다.', 3, 2);

-- 4. 무한루프 (질문: for문 조건식)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 코드 확인 요청', '증감식(i++)이 빠졌거나 종료 조건이 잘못된 것 같습니다. 작성하신 코드를 캡처해서 다시 올려주시면 정확히 봐드리겠습니다.', 4, 2);

-- 5. 오라클 접속 (질문: 리스너 오류)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 서비스 실행 확인', '윈도우 검색창에 "서비스"를 입력하고 실행한 뒤, OracleServiceXE와 OracleTNSListener가 "실행 중" 상태인지 확인해 주세요.', 5, 3);

-- 6. SQL 문법 (질문: SELECT *)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 맞습니다만 주의가 필요합니다.', '네, 모든 컬럼을 조회하는 것이 맞습니다. 하지만 데이터가 많을 경우 성능 저하의 원인이 되므로 실무에서는 필요한 컬럼명만 명시하는 것이 좋습니다.', 6, 3);

-- 7. PK 필요성 (질문: 기본키 꼭 있어야 하나?)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 무결성을 위해 필수입니다.', '테이블 내의 데이터를 식별하기 위해 PK는 필수입니다. PK가 없으면 나중에 중복 데이터가 쌓였을 때 수정이나 삭제가 매우 어려워집니다.', 7, 3);

-- 8. 삭제 명령어 (질문: DELETE vs DROP)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 데이터 삭제 vs 구조 삭제', 'DELETE는 데이터만 지우는 것이라 복구(Rollback)가 가능하지만, DROP은 테이블 자체를 날려버리는 것이라 복구가 불가능합니다. 주의해서 사용하세요.', 8, 3);

-- 9. HTML 이미지 (질문: 엑박)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 경로 확인법', '이미지 파일명 뒤에 확장자(.jpg, .png)까지 정확히 썼는지 확인해 보세요. 또한 HTML 파일과 이미지 파일이 같은 폴더에 있는지도 확인해야 합니다.', 9, 4);

-- 10. CSS 컬러 (질문: 배경색)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: style 속성 예시', '태그 안에 직접 넣으시려면 <div style="background-color: red;">형태로 작성하시면 됩니다. 하지만 CSS 파일로 분리하는 것을 권장합니다.', 10, 4);

-- 11. 깃허브 권한 (질문: 403 에러)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 토큰 인증 방식', '2021년부터 비밀번호 대신 PAT(Personal Access Token)를 사용해야 합니다. 깃허브 설정에서 토큰을 발급받아 비밀번호 란에 입력해 보세요.', 11, 1);

-- 12. 머지 충돌 (질문: Conflict 해결)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 충돌 해결 가이드', '같은 파일의 같은 줄을 수정해서 그렇습니다. <<<< HEAD 부분과 들어오는 코드를 확인하고, 남길 코드만 두고 특수문자를 다 지운 뒤 저장하고 다시 커밋하세요.', 12, 1);

-- 13. 수업 시간 (질문: 내일 9시?)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 등원 시간 안내', '네, 내일 특강도 정규 수업과 동일하게 09:00에 시작합니다. 09:10분까지 입실하셔야 지각 처리가 안 됩니다.', 13, 5);

-- 14. 지각/조퇴 (질문: 병원 진료)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 증빙 서류 제출', '병원 진료확인서나 처방전을 다음 날 행정실에 제출하시면 공결 혹은 참작 처리가 가능합니다. 일단 조심히 다녀오세요.', 14, 5);

-- 15. 교재 배부 (질문: 스프링 책)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 교재 배부 일정', '스프링 교재는 다음 주 월요일, 해당 과목 시작일에 5강의실 뒤편에서 배부할 예정입니다.', 15, 5);

-- 16. 파이썬 한글 (질문: 인코딩 문제)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 인코딩 설정', '코드 최상단에 # -*- coding: utf-8 -*- 주석을 추가해 보시거나, 에디터의 인코딩 설정이 UTF-8로 되어있는지 확인 바랍니다.', 16, 2);

-- 17. 알고리즘 (질문: 코테 준비)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 단계별 학습 추천', '처음이시라면 프로그래머스 Level 0~1부터 푸시는 걸 추천합니다. 백준은 입출력 처리가 까다로워서 나중에 하셔도 됩니다.', 17, 2);

-- 18. 취업 (질문: 포트폴리오)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 프로젝트 구성', 'CRUD가 포함된 게시판 하나와, 본인이 기여도가 가장 높은 팀 프로젝트 하나를 메인으로 잡는 것이 좋습니다. 화려함보다는 기본기가 중요합니다.', 18, 1);

-- 19. 자격증 (질문: 정처기 일정)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 큐넷 확인', '올해 1회차 실기 접수는 3월 중순으로 예정되어 있습니다. 정확한 날짜는 큐넷(Q-Net) 공지사항을 확인해 주세요.', 19, 5);

-- 20. 와이파이 (질문: 비밀번호)
INSERT INTO ANSWER VALUES (ANSWER_SEQ.NEXTVAL, '답변: 원내 와이파이 안내', '학생용 와이파이는 "SIST_Student"이며, 비밀번호는 "class1234!"입니다. 강의실 벽면에도 붙어 있으니 확인해 주세요.', 20, 5);

-- [필수] 저장
COMMIT;