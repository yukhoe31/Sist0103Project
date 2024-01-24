--day0124_lmy

--GROUP BY 복습
--부서별 급여
select deptno, Max(sal) from emp group by deptno;

--부서별 가장 급여를 많이 받는 사람
select deptno,ename,sal 
from emp 
where sal in (select Max(sal) from emp group by deptno);

--입사년도별 입사년도,인원수,평균급여 출력(입사년도의 오름차순)
select to_char(hiredate,'yyyy') 입사년도,count(*) 인원수, round(avg(sal),0) 평균급여
from emp
group by to_char(hiredate,'yyyy') order by to_char(hiredate,'yyyy');

--[RollUp 함수]
--자동으로 소계/합계를 구해주는 함수
--group by절에 주어진 조건으로 소계값을 구해준다

select deptno 부서번호,position 직위, sum(pay) 총급여
from professor
group by deptno, rollup(position);

select position,count(*),sum(pay)
from professor
group by rollup(position);


-------------------------------------

--[Cube 함수] -전체 총합계까지 출력하려면 cube
--cube
select deptno, position, count(*), sum(pay)
from professor
group by cube(deptno, position);

--[Having 절]
--Q.연봉이 2000이상인 부서의 부서번호와 평균급여를 구하시오.
select deptno, round(avg(sal),0)
from emp
group by deptno
having avg(sal) >= 2000 --having avg(집계함수 group by 뒤에만 쓰기 가능)
order by deptno;

--부서번호가 10,20인 사람 중에서 
--직군별 직원 수가 2명 이상인 경우만 조회하시오.
select job,count(*) cnt
from emp
where deptno in ('10','20')
group by job
having count(*) > 2;

-----------------------------------------------

--Q.emp에서 deptno가 10,20,30번 중에서 부서번호가 20인 직군의 부서갯수를 구하시오.
select job, deptno, count(*)
from emp
where deptno in ('10','20','30') --전체이므로 생략해도 무방
group by job, deptno
having deptno = '20';

--Q.emp에서 직군별로 직군, 직군별 급여의 합계 (Manager직군만 제외)를 구하되
--급여의 합계가 5000이상만 구해서 급여가 높은 순으로 정렬하시오.
select job 직군, sum(sal) "급여 합계"
from emp
where job not in 'MANAGER' --(Manager직군만 제외)
group by job --직군별로
having sum(sal)>=5000 --급여의 합계가 5000이상만
order by sum(sal) desc; --급여가 높은 순

--위의 쿼리에 rollup 추가하면,구한 직군별 급여합계의 총합을 구할 수 있다.
select job 직군, sum(sal) "급여 합계"
from emp
where job not in 'MANAGER' --(Manager직군만 제외)
group by rollup(job) --직군별로 합계
having sum(sal)>=5000 --급여의 합계가 5000이상만
order by sum(sal) desc; --급여가 높은 순


------------------------------------------
--day0124_lmy

--[조인]
--emp와 dept를 "조인"해서 emp사원의 이름과 부서명을 조회하시오.
--SMITH RESEARCH DALLAS
--방법1
select e.ename 사원명,d.dname 부서명,d.loc 부서지역
from emp e,dept d
where e.deptno = d.deptno; --emp테이블의 deptno와 dept테이블의 deptno는 같다.

--방법2
select emp.ename 사원명, dept.dname 부서명, dept.loc 부서위치
from emp, dept
where emp.deptno = dept.deptno;

--방법3
select ename 사원명, dname 부서명, loc 부서위치
from emp e,dept d
where e.deptno = d.deptno;

--Q.department와 professor를 "조인"하여 다음과 같이 출력하세요.
--  교수명 학과명 
select p.name 교수명, d.dname 학과명
from department d, professor p
where d.deptno = p.deptno;


--Q.emp,dept를 이용하여 부서번호가 10번인 부서의 사원들중 
--  사원명,부서명,급여를 조회하시오.
select ename 사원명, dname 부서명, sal 급여
from emp e, dept d
where e.deptno = d.deptno and d.deptno = '10';


--Q.student professor를 이용하여 다음과 같이 출력하시오
--  학번  학생명  담당교수명
select studno 학번, s.name 학생명, p.name 담당교수명
from student s, professor p
where p.profno = s.profno;


--Q.panmae,product를 이용하여 다음과 같이 출력하시오
-- 새우짱 총판매가격(p_total)
select p_name 과자이름, p_price 제품가격, p_qty 제품재고량, p_total 총가격
from panmae, product
where panmae.p_code =  product.p_code;


--Q.student department를 이용하여 다음과 같이 출력하시오
--학생명   제1전공
--서진수  컴퓨터공학과
select s.name 학생명, d.dname 제1전공
from student s, department d
where s.deptno1 = d.deptno;













