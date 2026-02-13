-- view 취업 성공 실시간 뷰

CREATE OR REPLACE VIEW vwSuccessJob AS
SELECT
    us.usersName AS 학생이름,
    es.employmentStatusDate AS 취업확정일,

    CASE
        WHEN es.employmentStatusDate IS NOT NULL AND es.employmentStatusDate <= SYSDATE THEN '취업성공'
    END AS 취업상태_실시간

FROM STUDENT st
JOIN USERS us ON us.usersSeq = st.usersSeq
JOIN EMPLOYMENT_STATUS es ON es.STUDENTSEQ = st.STUDENTSEQ
WHERE es.employmentStatusDate IS NOT NULL
AND es.employmentStatusDate <= SYSDATE;

drop view vwSuccessJob;

-- 뷰 실행
SELECT * FROM vwSuccessJob;

-- 업데이트로 데이터 바꿔보기
UPDATE EMPLOYMENT_STATUS
SET employmentStatusDate = '2026-03-03'
WHERE studentSeq = (
    SELECT studentSeq
    FROM STUDENT
    WHERE usersSeq = 1
);

