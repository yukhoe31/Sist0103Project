--Q day0122
--dept2테이블의 area를 중복제거후 출력하시오
select DISTINCT area from dept2;

--emp테이블에서 다음과같이 출력하시오
--SMITH님의 직업은 CLERK입니다
select '' ||ename|| '님의 직업은 ' ||job|| '입니다.' from emp;
--SMITH(CLERK)
select '' ||ename|| '(' ||job|| ')' from emp;

--professor에서 교수명,급여,보너스,총급여를 출력하시오
select name "교수명",pay "급여", NVL(bonus,0) "보너스", pay + NVL(bonus,0) "총급여" from professor;

--GOGAK테이블에서 point가 500000 이상인 사람의 이름,주민번호를 출력하라
select gname "이름", gno "주민번호" from gogak where point>=500000;

--student에서 서진수의 학년,전화번호 출력하시오
select grade "학년",tel "전화번호" from student where name = '서진수';

--student에서 deptno1이 201 이거나 301인 사람의 이름과 주민번호를 출력하시오
select name "이름", studno "주민번호" from student where deptno1 in (201, 301);

--gogak에서 point 가 30~50만 사이인 사람의 이름을 출력하시오
select gname from gogak where point between 300000 and 500000;

--professor에서 성이 김씨인 사람의 이름,직위,전공과목을 출력하시오
select name, position, deptno from professor where name Like '김%';

--emp에서 comm이 null인 사람의 이름과 급여 출력
select ename, sal from emp where comm is null;

--emp에서 comm의 null값을 0으로 바꾸어서 직업이 MANAGER인 사람만 이름과 보너스 출력하시오
select ename, NVL(comm,0) from emp where job = 'MANAGER';

--emp :  사원명 급여 연봉(급여*12),보너스,총연봉(연봉+보너스) 로 출력하시오
select ename "사원명",sal "급여",sal*12 "연봉", NVL(comm,0) "보너스",sal*12+NVL(comm,0) "총연봉" from emp;

--professor에서 103번 학과 교수들의 교수명,급여,보너스,연봉 출력하시오  (연봉=급여*12+보너스)
select name "교수명",pay "급여",NVL(bonus,0) "보너스",pay*12+NVL(bonus,0) "연봉" from professor;

--student테이블 4학년 학생의 이름 키 몸무게 출력(몸무게 많은순 정렬)
select name,height,weight from student where grade = 4 order by weight desc;

--student에서 1학년 학생의 평균키를 구하시오(소수점 1자리)
select round (avg(height),1) from student where grade = 1;

--student에서 4학년 학생의 평균몸무게를 구하시오(소수점2자리)
select round (avg(weight),2) from student where grade = 4;

--emp에서 직업이 CLERK,PRESIDENT,ANALYST인 사람의 사번,사원명,직업을 출력하시오
select empno "사번", ename "사원명", job "직업" from emp where job in ('CLERK','PRESIDENT','ANALYST');

--professor에서 pay가 300~500사이인 사람의 교수명,급여를 출력하시오
select name "교수명", pay "급여" from professor where pay between 300 and 500;

--professor에서 10월에 입사한 교수의 이름과 직위를 출력하시오
select name, position from professor where EXTRACT (MONTH FROM hiredate)=10;

--emp에서 세번째 이름이 R인 사람을 출력하시오
select * from emp where ename Like '__R%';