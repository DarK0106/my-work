-- dml - FAQ.sql
-- 작성자: 황윤재

-- 1. 비밀번호 변경 문의 (관리자 1번 답변)
INSERT INTO FAQ (faqSeq, faqTitle, faqContent, adminSeq)
VALUES (
    FAQ_SEQ.NEXTVAL,
    '비밀번호는 어떻게 바꾸나요?',
    '안녕하세요. 교육운영팀입니다.

비밀번호 변경은 로그인 후 우측 상단 [마이페이지] > [내 정보 관리] > [비밀번호 변경] 메뉴에서 가능합니다.
보안을 위해 주기적인 변경을 권장합니다.',
    1
);

-- 2. 초기 비밀번호 문의 (관리자 2번 답변)
INSERT INTO FAQ (faqSeq, faqTitle, faqContent, adminSeq)
VALUES (
    FAQ_SEQ.NEXTVAL,
    '초기 비밀번호는 뭐에요?',
    '안녕하세요. 시스템 관리자입니다.

모든 수강생의 초기 비밀번호는 [주민등록번호 뒷자리 7자리]로 설정되어 있습니다.
최초 로그인 후에는 반드시 본인만 알 수 있는 비밀번호로 변경해 주시기 바랍니다.',
    2
);

-- 3. 사물함 신청/변경 문의 (관리자 3번 답변)
INSERT INTO FAQ (faqSeq, faqTitle, faqContent, adminSeq)
VALUES (
    FAQ_SEQ.NEXTVAL,
    '사물함 비밀번호는 어떻게 바꾸죠?',
    '안녕하세요. 행정팀입니다.

개인 사물함은 데스크에서 배정받으실 수 있습니다.
사물함 비밀번호 변경 방법은 다음과 같습니다.
1. 기존 비밀번호 입력 후 문 열기
2. 안쪽의 버튼 누르기
3. 새로운 비밀번호 4자리 입력
4. 문 닫기',
    3
);

-- 4. 출석 조회 문의 (관리자 4번 답변)
INSERT INTO FAQ (faqSeq, faqTitle, faqContent, adminSeq)
VALUES (
    FAQ_SEQ.NEXTVAL,
    '출석 일수를 확인하고 싶어요.',
    '안녕하세요. HRD 담당자입니다.

본인의 출석 현황은 [마이페이지] > [출결 현황] 탭에서 실시간으로 확인 가능합니다.
HRD-Net 앱과 연동되는 시간은 다소 차이가 있을 수 있으니 참고 바랍니다.',
    4
);

-- 5. 지각/조퇴 기준 문의 (관리자 5번 답변)
INSERT INTO FAQ (faqSeq, faqTitle, faqContent, adminSeq)
VALUES (
    FAQ_SEQ.NEXTVAL,
    '오전 9시 이후에 출석하면 지각 처리인지 알고 싶어요.',
    '안녕하세요. 교육팀입니다.

네, 훈련 과정은 09:00 정각부터 시작되므로 09:01분부터는 [지각]으로 처리됩니다.
또한 17:50분 이전에 퇴실하실 경우 [조퇴]로 처리되며,
지각 또는 조퇴가 3회 누적될 경우 결석 1일로 산정되니 유의하시기 바랍니다.',
    5
);

-- [필수] 저장
COMMIT;