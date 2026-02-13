-- 유저에서 수강생으로 insert 되면  4번권한 주기
CREATE OR REPLACE TRIGGER trg_student_insert_update_user_state
AFTER INSERT OR UPDATE ON student
FOR EACH ROW
WHEN (NEW.studentStatus = '수강중')
BEGIN
    UPDATE users
    SET authoritySeq = 4
    WHERE usersseq = :NEW.usersseq;
END;
/
insert into STUDENT (studentSeq, studentStatus, registeredCourseSeq, usersSeq) values (student_seq.nextval, '수강중', 9, 301);

-- 수강생이 수강종료상태가 되면 유저권하이 3번으로
CREATE OR REPLACE TRIGGER trg_student_update_users_state_endcourse
AFTER UPDATE ON STUDENT
FOR EACH ROW
WHEN (new.STUDENTSTATUS = '수강종료')
BEGIN
    UPDATE USERS
    SET AUTHORITYSEQ = 3
    where USERSSEQ = :NEW.usersseq;
END;
/


-- 업데이트로 확인
update student set STUDENTSTATUS = '수강종료' where STUDENTSEQ = 301;
update student set STUDENTSTATUS = '수강중' where STUDENTSEQ = 301;
commit;
select * from users u
    inner join student s on u.USERSSEQ = s.USERSSEQ where s.USERSSEQ = 301;
