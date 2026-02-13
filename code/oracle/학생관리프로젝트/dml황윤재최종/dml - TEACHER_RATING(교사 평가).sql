-- dml - TEACHER_RATING.sql
-- 교사 평가 / TEACHER_RATING (총 15개)
-- 점수: 0.5점 단위 / 작성자: 황윤재

-- 1. [칭찬] 1번 교사님 (9.5점 ~ 10점)
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 10, '모르는 부분 질문하면 끝까지 이해시켜 주셔서 정말 감사했습니다.', 1, 1);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 9.5, '실무 경험이 많으셔서 그런지 현업 썰 듣는 게 재미있었어요.', 2, 1);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 10, '수업 준비를 정말 철저하게 해오시는 게 느껴집니다.', 3, 1);

-- 2. [보통] 2번 교사님 (7.5점 ~ 8.5점)
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 8.0, '강의 내용은 좋은데 목소리가 조금 작으셔서 뒤에 앉으면 잘 안 들려요.', 4, 2);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 8.5, '친절하시긴 한데 진도를 조금만 천천히 나가주셨으면 좋겠습니다.', 5, 2);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 7.5, '판서하실 때 글씨를 조금만 더 크게 써주세요!', 6, 2);

-- 3. [비판/개선] 3번 교사님 (4.5점 ~ 6.5점)
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 5.5, '질문했을 때 약간 귀찮아하시는 느낌을 받았습니다. 상처받았어요.', 7, 3);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 6.0, '수업 시간 중간에 사담이 너무 길어서 집중이 깨집니다.', 8, 3);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 4.5, '교재만 읽어주시는 느낌이라 아쉬웠습니다.', 9, 3);

-- 4. [열정] 4번 교사님 (9.0점 ~ 9.5점)
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 9.5, '밤늦게 카톡으로 질문해도 친절하게 받아주시는 열정맨!', 10, 4);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 9.0, '학생 한 명 한 명 포기하지 않고 챙겨주시는 모습이 감동입니다.', 1, 4);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 9.5, '덕분에 자바가 재밌어졌어요. 감사합니다!', 2, 4);

-- 5. [기타] 5번 교사님 (다양한 의견)
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 8.5, '코드 리뷰를 꼼꼼하게 해주셔서 실력이 많이 늘었습니다.', 3, 5);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 7.0, '강의실이 너무 더웠는데 에어컨 조절 좀 신경 써주세요.', 4, 5);
INSERT INTO TEACHER_RATING VALUES (TEACHER_RATING_SEQ.NEXTVAL, 10, '최고의 선생님! 다음 과정도 이분께 듣고 싶어요.', 5, 5);

-- [필수] 저장
COMMIT;
