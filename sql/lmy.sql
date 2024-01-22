--emp 테이블 전체를 조회
select * from emp;
--emp 테이블의 사원명과 job만 조회
select ename,job from emp;
--emp 테이블에서 직업만 중복 제거후 조회
select DISTINCT job from emp;

--emp 테이블에서 별명(allias)을 주어 출력 :별명에 공백 있으면 부조건 큰따옴표("")
select ename 직원명, job as 직업군, deptno "부서 번호" from emp;

--정렬(오름차순이 기본_생략가능)
select ename 사원명, job "직 업 군", sal "연봉" from emp order by ename; --asc생략됨.
--정렬(내림차순)
select ename 사원명, job "직 업 군", sal "연봉" from emp order by ename desc;


--emp에서 모든열 조회하는데 급여가 많은순부터 정렬하시요.
select * from emp order by sal desc;
--컬럼으로도 조회 가능(아래의 6은 6열인 sal을 의미)
select * from emp order by 6 asc;
--조회하는 열중에서의 순번을 의미(여기서 2는 ename,sal중에서 2열인 sal을 의미)
select ename,sal from emp order by 2;


--표현식(컬럼명 이외에 출력을 원하는 내용을 select구문 뒤에 작은따옴표('')로 묶어서 사용
select ename,'지금 근무중' from emp;
--연결연산자 ||
select '내 직업은 ' ||job|| '이고 연봉은 ' ||sal|| '입니다.' from emp;
--My name is Smith!!
select 'My name is ' ||ename|| '!!' from emp;


--산술연산자
--emp 에서 사원명 연봉 연봉+100 을 보너스라고 입력하여 조회하시오.
select ename "사원명", sal "연봉", sal+100 "보너스" from emp;
--professor를 조회하시오.
select * from professor;
--professor에서 교수명 급여 보너스 총급여(급여+보너스)를 입력 조회하시오.
select name "교수명", pay "급여", bonus "보너스", pay + bonus "총급여" from professor;\

-- 위의 조회값 중, null값은 0으로 바꾸기: (NVL함수)
-- NVL함수는 null값을 다른값(0)으로 바꿀때 쓰인다.(Mysql에서는 IfNull로 바뀐다.)
select name, pay ,NVL(bonus,0), pay + NVL(bonus,0) from professor;
-- emp에서 사원명, 급여, 급여*12(연봉),급여*12+comm(총급여)로 조회하시오.
select ename "사원명", sal "급여", sal*12 "연봉", NVL(comm,0) "보너스", sal*12+NVL(comm,0) "총급여" from emp;


-- where절 조건(from절 다음에 나온다.)
-- emp에서 deptno가 20번인 사람의 사원명,직업군,급여를 조회하시오.
select ename "사원명", job "직업군", sal "급여" from emp where deptno = 20;
-- emp에서 급여가 4000이상인 사람의 이름과 급여를 조회하시오.
select ename "사원명", sal "급여" from emp where sal >= 4000;
-- emp에서 KING의 사원번호와 사원명 그리고 급여를 조회하시오.
select empno "사원번호", ename "사원명", sal "급여" from emp where ename = 'KING';
-- 입사일이 85년 이후인 사원명, 입사일을 조회하시오.
-- 문자나 날짜는 ' '주고, 숫자는 그냥 입력한다. 문자일 경우 대소문자 구분
select ename "사원명", hiredate "입사일" from emp where hiredate >= '85/01/01';
-- student에서 키가 180cm이상인 학생들의 이름과 키를 조회하시오.
select name "이름", height "키" from student where height >= 180;

-- between 연산자
-- student에서 몸무게가 60에서 75kg 사이인 학생 중 학번, 학생명, 몸무게 순으로 조회하시오.
select studno "학번", name "학생명", weight "몸무게" from student where weight between 60 and 75;

-- in 연산자
-- student에서 deptno가 101이거나 201인사람의 이름,deptno1을 조회하시오.
select name, deptno1 from student where deptno1 IN(101,201);

-- null만 조회
select name,deptno2 from student where deptno2 is null;
-- null이 아닌것만 조회
select name,deptno2 from student where deptno2 is not null;

-- Like 연산자 student에서 학생 성이 김씨인 사람만 조회하겠다.
select * from student where name Like '김%'; -- %뒤 글자수의 제한이 없다.
-- 이름 안에 '영'라는 글자가 들어간 사람 모두 조회
select * from student where name Like '%영%';

-- 전체의 인원수
select count(*)from student;
-- 컬럼명 cnt
select count(*) cnt from student;

-- emp에서 sal이 3000이상인 경우만 사원명 직업군 급여를 출력하시오.
select ename,job,sal from emp where sal>=3000;
-- emp에서 sal이 200~3000사이의 모든 컬럼을 출력하세요.
select * from emp where sal between 200 and 3000;
-- 직업군이 SALESMAN 이거나 MANAGER인 사람의 사원명,직업군을 출력하시오
select ename,job from emp where job in ('SALESMAN', 'MANAGER');
-- emp에서 MGR이 7902,7698,7829인 데이터를 출력하시오.
select * from emp where MGR in (7902,7698,7829);
-- emp에서 comm이 null인 경우만 출력하시오.
select * from emp where comm is null;
-- emp에서 사원명이 SMITH인 경우만 출력하시오.
select * from emp where ename = 'SMITH';
-- student에서 학생 성이 김씨만 출력하고 키가 작은순으로 정렬하시오.
select * from student where name Like '김%' order by height;

--student에서 1학년 학생의 이름과 생일과 키와 몸무베를 조회하세요.
select name, birthday, height, weight from student where grade = 1;
--student에서 3학년 학생의 이름과 전화번호를 출력하세요. (단, 이름의 오름차순)
select name 이름, tel 전화번호 from student where grade = 3 order by 이름;
--Like 연산자 %는 여러개의 문자 대체, _언더바는 하나의 문자 대체
select empno, ename, hiredate,sal from emp where ename Like '__R%'; --세번째 글자
select empno, ename, hiredate,sal from emp where ename Like '__I%' or enmae Like '_I%'; --2번쨰 혹은 3번째 글자
select empno, ename, hiredate,sal from emp where ename Like '%N'; --N으로 끝나는
select empno, ename, hiredate,sal from emp where ename Like '%N%'; --N을 포함하는


--날짜 리터럴 ' '사용
select empno, ename from  emp where hiredate >= '1982/01/01' or job = 'MANAGER';
select empno, ename from  emp where hiredate >= '1982/01/01' or job = 'MANAGER';

--다중정렬(급여가 내림차순이고, 이름이 오름차순)
select empno,ename,sal from emp order by sal desc,ename;

--student에서 1학년 학생 이름과 키,몸무게 (키는 작은사람부터, 키가 같을 경우에 한해서 몸무게는 많은사람부터)
select name,height,weight from student where grade=1 order by height asc, weight desc;

--UNION : 두 결과에서 중복된 값 제거하고 출력
--UNION ALL : 중복값까지 모두 출력

--student에서 101학과와 201학과를 전공하는 학생들 이름출력(union All에서 이름이 2번 나오는걸로 체크가능)
select name from student where deptno1=101 union
select name from student where deptno2=201;

select name from student where deptno1=101 union All
select name from student where deptno2=201;

--intersect 연산자 사용_두집합의 "교집합"을 찾는 집합연산
select name from student where deptno1=101 intersect
select name from student where deptno2=201;

--그룹함수
--전체의 데이터 갯수
select count(*) cnt from emp;

--sal의 평균
select round(avg(sal),2) from emp; --소수점 2자리
select round(avg(sal),1) from emp; --소수점 1자리
select round(avg(sal),0) from emp; --소수점 없이 반올림
select round(avg(sal),-1) from emp; --10단위 
select round(avg(sal),-2) from emp; --100단위

--현재 날짜를 콘솔창에 출력하기.
select sysdate from dual;
--내일 날짜를 콘솔에 출력
select sysdate+1 from dual;
--일주일 뒤 날짜를 콘솔에 출력
select sysdate+7 from dual;

--날짜에서 년도만 추출
select to_char(sysdate, 'year') from dual; --영어로 년도나옴
select to_char(sysdate, 'yyyy') from dual; --2024

--날짜에서 월만 추출
select to_char(sysdate,'month') from dual; --1월
select to_char(sysdate,'mm') from dual; --01

--날짜와 시간출력
select to_char(sysdate,'yyyy-mm-dd hh-mi-ss') from dual;
select to_char(sysdate,'yyyy-mm-dd hh24-mi-ss') from dual;

--to_char는 숫자에도 적용가능하다.
select to_char(2458971, '999,999,999') from dual; --천단위 구분기호

select to_char(34.5,'999,999,999') from dual; 
select to_char(34.5,'9999,00') from dual; 
select to_char(34.5,'009999,00') from dual; 

--emp에서 사원번호,사원명,급여를 출력하되 급여는 천단위 구분기호로 표시하세요.
select empno,ename,to_char(sal, '$999,999') from emp;

--emp에서 사원번호,사원명,입사년도중에서 년도만 표시하여 출력하시오.(1980)
select empno,ename,to_char(hiredate,'yyyy') from emp;

--현재시간을 2024/01/22로 콘솔에 출력하시오.(옆에 현재시간도 붙여라)
select to_char(sysdate,'yyyy/mm/dd,hh24:mi:ss') from dual;



