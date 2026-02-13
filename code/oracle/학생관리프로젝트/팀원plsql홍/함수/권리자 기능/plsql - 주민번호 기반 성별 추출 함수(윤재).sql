-- 주민번호 뒷자리로 성별을 자동 추출하는 함수

-- 주민번호 기반 성별 추출 함수
CREATE OR REPLACE FUNCTION FN_GET_GENDER (
    p_ssn VARCHAR2 -- 주민번호 (예: 990101-1234567)
) RETURN VARCHAR2
IS
    v_gender_code CHAR(1);
    v_gender VARCHAR2(10);
BEGIN
    -- 주민번호 뒷자리 첫 번째 숫자 추출 (하이픈 포함 8번째)
    v_gender_code := SUBSTR(p_ssn, 8, 1);

    IF v_gender_code IN ('1', '3') THEN
        v_gender := '남자';
    ELSE
        v_gender := '여자';
    END IF;

    RETURN v_gender;
END;
/

-- [사용 예시]
SELECT
    u.usersName AS 이름,
    u.usersSSN AS 주민번호,
    -- 여기서 함수 호출! (DB에 저장된 게 아니라, 즉석에서 계산된 결과)
    FN_GET_GENDER(u.usersSSN) AS 성별
FROM STUDENT s
INNER JOIN USERS u ON s.usersSeq = u.usersSeq;



