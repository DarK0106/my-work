-- dml - EMPLOYMENT_STATUS_AUTO.sql
-- 취업상태 데이터 90건 (장려금 신청 가능일은 취업일 + 180일)
-- 취업성공 80명 취업실패 10명으로 설정
-- 작성자: 황윤재

-- ==========================================================
-- 1. [취업성공] 1~9번 (Java 1기)
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 1);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 2);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 3);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 4);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 5);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 6);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 7);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 8);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 9);

-- [취업실패] 10번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 10);

-- ==========================================================
-- 2. [취업성공] 11~19번
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 11);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-07', 'YYYY-MM-DD'), 12);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 13);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 14);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 15);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 16);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 17);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 18);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 19);

-- [취업실패] 20번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 20);

-- ==========================================================
-- 3. [취업성공] 21~29번
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 21);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-10', 'YYYY-MM-DD'), 22);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 23);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-09', 'YYYY-MM-DD'), 24);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 25);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 26);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 27);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 28);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 29);

-- [취업실패] 30번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 30);

-- ==========================================================
-- 4. [취업성공] 31~39번 (Python 과정)
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 31);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 32);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 33);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 34);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 35);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 36);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 37);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-09', 'YYYY-MM-DD'), 38);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 39);

-- [취업실패] 40번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 40);

-- ==========================================================
-- 5. [취업성공] 41~49번
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 41);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 42);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 43);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 44);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 45);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 46);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 47);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 48);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-05', 'YYYY-MM-DD'), 49);

-- [취업실패] 50번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 50);

-- ==========================================================
-- 6. [취업성공] 51~59번
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 51);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 52);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 53);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 54);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 55);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 56);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 57);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 58);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-03', 'YYYY-MM-DD'), 59);

-- [취업실패] 60번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 60);

-- ==========================================================
-- 7. [취업성공] 61~69번 (AI 과정)
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 61);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 62);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 63);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 64);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 65);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 66);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 67);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 68);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-08', 'YYYY-MM-DD'), 69);

-- [취업실패] 70번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 70);

-- ==========================================================
-- 8. [취업성공] 71~79번
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 71);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 72);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 73);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 74);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 75);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 76);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 77);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 78);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-04', 'YYYY-MM-DD'), 79);

-- [취업실패] 80번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 80);

-- ==========================================================
-- 9. [취업성공] 81~88번
-- ==========================================================
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 81);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 82);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 83);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 84);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 85);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 86);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 87);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업성공', TO_DATE('2024-12-06', 'YYYY-MM-DD'), 88);

-- [취업실패] 89, 90번
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 89);
INSERT INTO EMPLOYMENT_STATUS (employmentStatusSeq, employmentStatusState, employmentStatusDate, studentSeq) VALUES (EMPLOYMENT_STATUS_SEQ.NEXTVAL, '취업실패', NULL, 90);

-- [필수] 저장
COMMIT;