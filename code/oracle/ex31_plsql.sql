-- ex31_plsql

/*
    자바 + 오라클 = ANSI-SQL 만 사용(MyBatis, JPA 기술)
    자바 + MySQL = ANSI-SQL 만 사용
    
    PL/SQL
    1. 익명 프로시저
    2. 실명 프로시저
        a. 프로시저
        b. 함수(*중요)
    3. 트리거(*중요)
    4. 인덱스(*중요)
    
    
    PL/SQL
    - 기존의 ANSI_SQL + 절차 지향 언어 기능 추가(변수, 제어문 등)
    - A 업무 -> 자바 구현 or PL/SQL 구현

    프로시저, Procedure
    - 메서드, 함수 등..
    - 순서가 있는 명령어들의 집합
    
    1. 익명 프로시저
        - 저장할 필요가 없다, 한번만 쓰고 버림
        
    2. 실명 프로시저
        - 저장을 하고 재사용하겠다
        - 데이터베이스에서는 이건 데이터베이스 객체(DB Object) 라는 것
        
    PL/SQL 프로시저 구조
    
    1. 4개의 블럭으로 구성
        - DECLASE
        - BEGIN
        - EXCEPTION
        - END
        
    1-1. DECLARE
        - 선언부
        - 프로시저 내에서 사용할(= 메서드 안에서 쓸) 변수나 여러가지 객체들을 선언하는 영역
        - 생략 가능
        
    1-2 BEGIN ~ END
        - Procedure
        - BEGIN 에서 END 까지가 하나의 영역
        - 구현부(메서드의 {} 역할)
        - 구현된 코드를 작성하는 영역
        - 구현된 코드가 뭘까? -> ANSI-SQL + PL/SQL 쿼리
        - 즉 쿼리가 들어있는 메서드
        - try 절 역할
        - 생략할 수 없음
        
    1-3. EXCEPTION
        - 예외처리부
        - catch절 역할
        - 생략 가능
        
    생략 가능한건 [] 로 표현        
        
    [DECLARE
        변수 선언;
        객체 선언;]
    BEGIN
        업무 코드(ANSI-SQL or PL/SQL);
    [EXCEPTION
        예외 처리;]
    END;
    
    1. 자료형
    
    - ANSI-SQL과 동일
    
    2. 변수 선언하기
    
    - 변수이름 자료형(길이) [NOT NULL] [DEFAULT 값];
    - 컬럼 선언과 유사
    
    
*/

-- ANSI SQL을 작성할 수 있는 영역과
-- PL/SQL 을 작성할 수 있는 영역이 따로 있음

select * from dual;

dbms_output.put_line('안녕하세요'); -- syso 느낌

-- 모든 PL/SQL은 ANSI-SQL의 영역에서 쓸 수 없음
-- PL/SQL은 프로시저 영역 내에서만 실행 가능

begin
    dbms_output.put_line('안녕하세요'); -- syso 느낌
end;

-- dbms_output.put_line 의 특징 -> 옵션을 켜야됨
set serveroutput on; -- 현재 세션에(session - 접속 중)만 유효
set serverout on;
set serveroutput off;


declare
    -- 변수이름 자료형(길이) [NOT NULL] [DEFAULT 값];
    num number;
    name varchar2(30);
    today date;
begin -- declare ~ begin 을 헤더라고 본다
    -- PL/SQL 의 대입 연산자는 :=
    num := 10;
    dbms_output.put_line(num);
    
    name := '홍길동';
    dbms_output.put_line(name);
    
    today := sysdate;
    dbms_output.put_line(today);
    
    dbms_output.put_line(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'));
    dbms_output.put_line(today);
end;
/
-- 앞뒤로 / 넣어야 Ctrl Enter를 알아서 읽는다?


declare
    num1 number;
    num2 number;
    num3 number := 30;
    num4 number default 40;
    num5 number not null := 50; -- 선언과 동시에 초기화가 필수인 not null
begin
    num1 := 10;
    dbms_output.put_line(num1);
    
    -- 초기화 안한 변수를 바로 출력
    dbms_output.put_line('num2:' || num2); -- null 출력
    
    dbms_output.put_line('num3:' || num3);
    
    dbms_output.put_line('num4:' || num4); -- null 상태의 변수를 초기화해주는 default
    
    dbms_output.put_line('num5:' || num5);
    
    num3 := null;
    dbms_output.put_line('num3:' || num3); -- num3에 원래 30 들어있었는데 null 넣으면 null 됨
    
    -- num5 := null;
    dbms_output.put_line('num5:' || num5); -- not null 로 태어난 num5는 null 넣기 불가능
    
end;
/


/*
    변수를 왜 만들까?
    - 일반적인 값을 저장하는 용도
    - select 결과를 저장하는 용도로 사용(*중요)

*/


declare
    -- 컬럼 이름이랑 헷갈리지 말라고 앞에 v붙인거
    vbuseo varchar2(15);
begin
    -- ANSI-SQL(select 문)
    -- ORA-06550: 줄 6, 열5:PLS-00428: 해당 SELECT 문에 INTO 절이 필요합니다.
    -- ANSI-SQL의 select 문의 결과셋을 PL/SQL에게 전달할 수 없다.
    -- select buseo from tblInsa where name = '홍길동';
    
    select buseo into vbuseo from tblInsa where name = '홍길동';
    dbms_output.put_line(vbuseo);
end;
/

-- tblInsa -> 성과급을 받는 직원
create table tblBonus
(
    name varchar2(15)

);

-- 1. 개발부 부장이 보너스를 받게 되었다 -> select name ~ ...
-- 2. 알아낸 이름으로 bonus 테이블에 insert

select * from tblInsa where buseo = '개발부' and jikwi = '부장';

insert into tblBonus (name) values ('이순애');

insert into tblBonus (name) 
    values ((select name from tblInsa where buseo = '개발부' and jikwi = '부장'));
    
select * from tblBonus;


declare
    vname varchar2(15);
begin
    -- 1.
    select name into vname from tblInsa where buseo = '총무부' and jikwi = '부장';
    dbms_output.put_line(vname);
    
    -- 2.
    insert into tblBonus (name) values (vname);
end;
/

-- select into 절
-- select 의 결과셋이 1줄일때
-- select 의 결과셋이 n줄일때 <- 커서라는걸 배워야함

-- 1. 원자값(단일 컬럼)일 때
-- 2. 다중값(다중 컬럼)일 때


declare
--    vname varchar2(15);
--    vbuseo varchar2(15);
--    vjikwi varchar2(15);
--    vbasicpay number;

    vname tblInsa.name%type;
    vbuseo tblInsa.name%buseo;
    vjikwi tblInsa.name%jikwi;
    vbasicpay tblInsa.name%basicpay;
begin
    select
        name, buseo, jikwi, basicpay into vname, vbuseo, vjikwi, vbasicpay 
    from tblInsa
        where name = '홍길동';
        
    -- select into 주의점
    -- 1. 컬럼의 개수와 변수의 개수가 일치할 것
    -- 2. 컬럼의 순서와 변수의 순서 일치, 자료형 이상하게 쓰지 말기
    -- 3. 변수의 바이트 수 확인하기
    
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
    dbms_output.put_line(vbasicpay);
        
end;
/

/*
    타입 참조
    - 사용하는 테이블의 특정 컬럼의 자료형 + 길이를 알아내서 변수에 적용
    - 적용되는 정보
        1. 자료형
        2. 길이




*/


declare
    -- vbuseo = varchar2(15);
    vbuseo tblInsa.buseo%type;
begin
    select buseo into vbuseo from tblInsa where name = '홍길동';
    dbms_output.put_line(vbuseo);
end;
/


declare
    -- vbuseo = varchar2(15);
    vbuseo tblInsa.buseo%type;
    
    -- 레코드(모든 컬럼)를 담을 수 있는 변수 -> 배열이나 객체 느낌, 집합 느낌
    vrow tblInsa%rowtype;
begin
--    select num, name, buseo, jikwi, ibsadate, city, ssn, tel, basicpay, sudang
--        from tblInsa where name = '홍길동';
    
    select * into vrow
        from tblInsa
            where name = '홍길동';
            
    -- dbms_output.put_line(vrow);
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.jikwi);
    
    -- select * from tblInsa where name = '홍길동';
    -- dbms_output.put_line(vbuseo);
end;
/


declare
    vnum number := 10;
    
begin
    if vnum > 0 then
        dbms_output.put_line('양수');
    elsif vnum < 0 then -- else if
        dbms_output.put_line('음수');
    else
        dbms_output.put_line('0');
    end if;
    
end;
/

drop table tblBonus;

create table tblBonus
(
    seq number primary key, -- 번호(PK)
    num number not null references tblInsa(num), -- 직원번호(FK)
    bonus number not null -- 성과급

);

/*
    제어문?
    1. 조건문
        - if
        - case
    
    2. 반복문
        - loop(단순 반곱)
        - for loop
        - while loop



*/


-- 직원 1명 선택(num) -> 보너스 지급
-- 차등 지급
-- 과장, 부장 <- basicpay * 1.5
-- 사원, 대리 <- basicpay * 2


declare
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
    vjikwi tblInsa.jikwi%type;
begin
    -- 1.
    selet num, basicpay, jikwi into vnum, vbasicpay, vjikwi
    from tblInsa
        where num = 1001;
        
    -- 2.
    if (vjikwi = '과장' or vjikwi = '부장') then
        vbonus := vbasicpay * 1.5;
    elsif (vjikwi in ('사원', '대리')) then
        vbonus := vbasicpay * 2;
        
    insert into tblBonus (seq, num, bonus)
        values ((select nvl(max(seq) + 1) from tblBonus), vnum, vbonus);
end;
/

select nvl(max(seq), 0) from tblBonus;
select nvl((max(seq), 0) + 1) from tblBonus;

declare
    vnum number := 1; -- 루프 변수 역할

begin

    loop
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
        
        exit when vnum > 10;
    end loop;

end;
/

-- for loop
begin

    -- IntStream.range(1, 10)
    -- 향상된 for 문 역할
    for i in 1..10 loop -- in reverse <- 역순
        dbms_output.put_line(i);
    end loop;

end;
/

-- while loop
declare
    vnum number := 1;
    
begin
    while vnum <= 10 loop
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
    end loop;
    
end;
/

-- 함수(반드시 input과 output 이 존재해야함)

-- 자바로 치면 public int sum(int a, int b)
create or replace function fnSum 
(   
    a number, 
    b numer
) 
return number
is
-- 변수 선언

begin
    return a + b;
end fnSum;
/

select 10, 20 fnSum(10, 20) from dual;

-- 1. 성별작업을 자주 해야 한다?
-- 2. 이 작업을 다른 팀원들도 해야한다?
select 
    name, ssn, basicpay,
--    case
--        when substr(ssn, 8, 1) = '1' then '남자'
--        when substr(ssn, 8, 1) = '2' then '여자'
--    end as gender
    fnGender(ssn) as gender,
--    case
--        when jikwi in ('과장', '부장') then (basicpay + sudang) * 1.5
--        when jikwi in ('대리', '사원') then (basicpay + sudang) * 2
--    end as bonus
    fnBonus(jikwi, basicpay, sudang, jikwi) as bonus
from tblInsa;


create or replace function fnGender
(
    ssn varchar2 -- 길이는 안 적는 게 맞습니다! (잘하셨어요)
)
return varchar2 -- 여기에 세미콜론(;) 삭제!
is
    v_gender char(1); -- 값을 받아줄 변수 하나 선언
begin
    -- 뒷자리 첫 번째 글자 추출
    v_gender := substr(ssn, 8, 1);

    if v_gender in ('1', '3') then -- 1 또는 3이면 남자
        return '남자';
    elsif v_gender in ('2', '4') then -- 2 또는 4면 여자
        return '여자';
    else
        return '알수없음'; -- null보다는 명확한 텍스트 추천
    end if;
end fnGender;
/


create or replace function fnBonus
(
    ssn varchar2,
    basicpay number,
    sudang number,
    jikwi varchar2

)
return number

is 
    vbonus number;

begin
    if jikwi in ('과장', '부장') then
        vbonus := (basicpay + sudang) * 1.5;
    elsif jikwi in ('사원', '대리') then
        vbonus := (basicpay + sudang) * 2;
    end if;
    
    return vbonus;
    

end fnBonus;
/