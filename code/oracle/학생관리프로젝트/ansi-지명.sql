-- 제2강의실'에 배치된 컴퓨터 중, 상태가 '고장'이거나 '수리중'인 컴퓨터의 관리 번호(ComputerSeq)와 현재 상태를 출력하시오.

select c.COMPUTERSEQ as 컴퓨터번호, cs.COMPUTERSTATUSSTATE as 현재상태
from COMPUTER c
        inner join LECTURE l on c.LECTURESEQ = l.LECTURESEQ
            inner join COMPUTER_STATUS cs on cs.COMPUTERSTATUSSEQ = c.COMPUTERSTATUSSEQ
where cs.COMPUTERSTATUSSTATE in ('고장', '수리중') and l.LECTURESEQ = 2;


-- Java 풀스택 과정(1기)' 커리큘럼에서 사용하는 모든 '교재명'과 '출판사'를 출력하시오.

select DISTINCT b.BOOKNAME as 교재명, b.BOOKPUBLISHER as 출판사 from COURSE co
    inner join CURRICULUM cu on co.COURSESEQ = cu.COURSESEQ
        inner join subject s on s.SUBJECTSEQ = cu.SUBJECTSEQ
            inner join OPENED_SUBJECT os on os.SUBJECTSEQ = s.SUBJECTSEQ
                inner join book b on os.OPENEDSUBJECTSEQ = b.OPENEDSUBJECTSEQ
where os.REGISTEREDCOURSESEQ = (select MIN(rc.REGISTEREDCOURSESEQ) from course c
    inner join REGISTERED_COURSE rc on c.COURSESEQ = rc.COURSESEQ
        inner join OPENED_SUBJECT os on rc.REGISTEREDCOURSESEQ = os.REGISTEREDCOURSESEQ
where c.coursename = 'Java 기반 풀스택 개발자 양성 과정') ;
