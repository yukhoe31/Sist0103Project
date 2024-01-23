--lmy_day0123.sql

--Group by [특정조건으로 세부적인 그룹화하기]
--professor 테이블에서 학과별로 교수들의 평균급여를 출력하시오
--group by절에 들어간 컬럼을 조회할 때 첫번재 컬럼에 둔다.

select deptno 학과, avg(pay)평균급여 
from professor
group by deptno;

--Q.professor테이블에서 직급별로 교수들의 평균급여를 출력하시오.
select position 직급, round(avg(pay),2) 평균급여
from professor
group by position;


--Q.professor테이블에서 학과별,직급별로 교수들의 평균급여를 출력하시오.
select deptno, position, avg(pay)
from professor
group by deptno, position;

--Q.student에서 "학년별" 평균키와 최고 몸무게를 구하시오.
select grade,avg(height),max(weight) --"학년별"이므로 이걸 제일 먼저 select
from student
group by grade;

--Q.교수 "직급별"로 최고 급여와 최고 보너스를 조회하시오.
select position,max(pay),max(bonus) --"직급별"이므로 position이 맨앞.
from professor
group by position;

--Q.emp에서 "직군별"로 동일한 직군을 가진 사원수를 구하시오.
select job, count(job) --"직군별"이므로 job이 맨앞.
from emp
group by job;

--Q.emp에서 직무별 sal의 평균급여를 구하시오.
select job 직무, round(avg(sal),2) "평균 급여"
from emp 
group by job;


--
--[연습문제 0123]

--1. emp에서 이름이 A나 S로 시작하는 사람출력
select * from emp where ename like 'A%' or ename like 'B%';

--2. emp에서 이름2번째 글자가 A인사람 출력하시오
select * from emp where ename like '_A%';

--3. emp에서 부서번호를 중복없이 출력하시오
select distinct deptno from emp;

--4. emp에서 MGR별로 인원수를 구하시오.
select mgr, count(mgr) "MGR별 인원수" 
from emp 
group by mgr;

--5.emp에서 job종류별로 sal의 평균급여와 최고급여를 구하시오
select job 직무, round(avg(sal),2) 평균급여, max(sal) 최고급여
from emp
group by job;

--6. emp에서 sal의 평균보다 더높은 사람의 이름,급여를 출력하시오
select ename 이름,sal 급여
from emp
where sal>(select avg(sal) from emp); --서브쿼리

--7. emp에서 입사일이 4월인 사람만 이름,입사일을 출력하시오
select ename 이름, hiredate 입사일
from emp
where to_char(hiredate, 'mm') = '04';

--8. FORD의 급여와 동일하거나 더많이 받는 사람의 사원명과 급여를 출력하시오
select ename 사원명,sal 급여
from emp
where sal >= (select sal from emp where ename='FORD');

--9. student테이블에서 1전공이 101번인 학과의 평균몸무게 보다 
--   몸무게가 많은 학생들의 이름과 몸무게를 출력하시오
select name 이름, weight 몸무게
from student
where weight > (select avg(weight) from student where deptno1=101);

--10. professor에서 주승재 교수보다 나중에 입사한 교수들의 
--    이름과 급여 입사일을 출력하시오
select name 이름, pay 급여, hiredate 입사일
from professor
where hiredate >= (select hiredate from professor where name ='주승재');

--11. professor테이블에서 정교수들의 보너스를 일괄 200만원으로 수정하시오
update professor
set bonus = 200
where position='정교수';
--select * from professor;

--12. professor테이블에서 hpage열의 이름을 homepage로 수정하시오
-- 테이블의 열 이름을 수정하려면 'alter table'문을 사용할 수 있다.
alter table professor
rename column hpage to homepage;
--select * from professor;

--13.professor테이블에 totsal열을 추가하시오
alter table professor
add totsal NUMBER;

--14. 위의 totsal열에 pay와 bonus를 더하여 데이터를 추가하시오
update professor 
set totsal = pay + NVL(bonus,0);
select * from professor;

--15.dept 테이블에서 40번 부서의 위치가 seattle로 이동하도록 변경하세요
update dept
set loc = 'SEATTLE'
where deptno = 40;

--16.dept2의 컬럼AREA를 LOC로 변경하시오.
alter table dept2
rename column area to loc;

--17.member테이블에서 id가 bobby인사람을 삭제하시오
--특정 행을 삭제하기 : delete문 사용
delete from member
where id='bobby';

--18.emp에서 직무별 평균급여,총급여,최고급여,최저급여를 구하시오.
select job 직무,round(avg(sal),2) 평균급여,sum(sal) 총급여,max(sal) 최고급여,min(sal) 최저급여
from emp
group by job;

--19.emp에서 이름이 S로 시작하는 사람과 같은 부서사람의 
--부서번호와 이름을 출력하시오.
select deptno 부서번호, ename 이름
from emp
where deptno in (select deptno from emp where ename like 'S%');

--20.Member테이블에 한명의 데이터를 임의로 추가하세요(전체열 추가)
insert into member(no,name,jumin,passwd,id,an_key,an_key_dap)
values(1002,'서유리',9801012088888,'b1234','delly','남편이름?','김둘리');

commit;






