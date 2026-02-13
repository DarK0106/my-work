-- dml - ADMIN.sql
-- 관리자 / ADMIN
-- 작성자: 황윤재

INSERT INTO ADMIN (adminSeq, adminName, adminID, adminPW, authoritySeq)
VALUES (ADMIN_SEQ.NEXTVAL, '김철수', 'adm1001', 'pass1234', 1);

INSERT INTO ADMIN (adminSeq, adminName, adminID, adminPW, authoritySeq)
VALUES (ADMIN_SEQ.NEXTVAL, '이영희', 'sys2020', 'admin5678', 1);

INSERT INTO ADMIN (adminSeq, adminName, adminID, adminPW, authoritySeq)
VALUES (ADMIN_SEQ.NEXTVAL, '박민준', 'oper3333', 'qwer1111', 1);

INSERT INTO ADMIN (adminSeq, adminName, adminID, adminPW, authoritySeq)
VALUES (ADMIN_SEQ.NEXTVAL, '정수민', 'hr8888', 'manage99', 1);

INSERT INTO ADMIN (adminSeq, adminName, adminID, adminPW, authoritySeq)
VALUES (ADMIN_SEQ.NEXTVAL, '최지훈', 'sec777', 'safe0000', 1);

-- [필수] 저장
COMMIT;