-- function 훈련지원금 신청가능자
-- 목적: 오늘 날짜와 비교하여 훈련지원금 신청해야하는 사람들을 보여준다
-- 작성자: 김민도

-- 비고: 훈련지원금은 수강할 과정이 시작되면 바로 신청할 수 있고 일회성 지급이며, 과정이 끝나면 소급신청 불가능하다
--      이미 신청했지만 미지급인 사람들은 보여주지 않는다

-- 신청가능하지만 신청하지 않는 사람만 보여준다(현재DB에 등록된 상태)
create or replace function func_apply_allowance
return SYS_REFCURSOR
is
    v_cursor SYS_REFCURSOR;
begin
    open v_cursor for
        select
            S.STUDENTSEQ as 학생번호,
            U.USERSNAME as 이름,
            S.STUDENTSTATUS as 수강상태,
            RC.REGISTEREDCOURSESTARTDATE as 과정시작일,
            RC.REGISTEREDCOURSEENDDATE as 과정종료일
        from STUDENT S
            join USERS U
                on S.USERSSEQ = U.USERSSEQ
            join REGISTERED_COURSE RC
                on RC.REGISTEREDCOURSESEQ = S.REGISTEREDCOURSESEQ
        where TRUNC(SYSDATE) between RC.REGISTEREDCOURSESTARTDATE and RC.REGISTEREDCOURSEENDDATE
          and S.STUDENTSTATUS = '수강중'
          and NOT EXISTS(
              select 1
              from TRAINING_ALLOWANCE TA
              where TA.STUDENTSEQ = S.STUDENTSEQ
        );

    return v_cursor;
end;
/

-- 확인용
select func_apply_allowance() from dual;