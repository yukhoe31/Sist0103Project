--lmy_day0123.sql

--Group by [Ư���������� �������� �׷�ȭ�ϱ�]
--professor ���̺��� �а����� �������� ��ձ޿��� ����Ͻÿ�
--group by���� �� �÷��� ��ȸ�� �� ù���� �÷��� �д�.

select deptno �а�, avg(pay)��ձ޿� 
from professor
group by deptno;

--Q.professor���̺��� ���޺��� �������� ��ձ޿��� ����Ͻÿ�.
select position ����, round(avg(pay),2) ��ձ޿�
from professor
group by position;


--Q.professor���̺��� �а���,���޺��� �������� ��ձ޿��� ����Ͻÿ�.
select deptno, position, avg(pay)
from professor
group by deptno, position;

--Q.student���� "�г⺰" ���Ű�� �ְ� �����Ը� ���Ͻÿ�.
select grade,avg(height),max(weight) --"�г⺰"�̹Ƿ� �̰� ���� ���� select
from student
group by grade;

--Q.���� "���޺�"�� �ְ� �޿��� �ְ� ���ʽ��� ��ȸ�Ͻÿ�.
select position,max(pay),max(bonus) --"���޺�"�̹Ƿ� position�� �Ǿ�.
from professor
group by position;

--Q.emp���� "������"�� ������ ������ ���� ������� ���Ͻÿ�.
select job, count(job) --"������"�̹Ƿ� job�� �Ǿ�.
from emp
group by job;

--Q.emp���� ������ sal�� ��ձ޿��� ���Ͻÿ�.
select job ����, round(avg(sal),2) "��� �޿�"
from emp 
group by job;


--
--[�������� 0123]

--1. emp���� �̸��� A�� S�� �����ϴ� ������
select * from emp where ename like 'A%' or ename like 'B%';

--2. emp���� �̸�2��° ���ڰ� A�λ�� ����Ͻÿ�
select * from emp where ename like '_A%';

--3. emp���� �μ���ȣ�� �ߺ����� ����Ͻÿ�
select distinct deptno from emp;

--4. emp���� MGR���� �ο����� ���Ͻÿ�.
select mgr, count(mgr) "MGR�� �ο���" 
from emp 
group by mgr;

--5.emp���� job�������� sal�� ��ձ޿��� �ְ�޿��� ���Ͻÿ�
select job ����, round(avg(sal),2) ��ձ޿�, max(sal) �ְ�޿�
from emp
group by job;

--6. emp���� sal�� ��պ��� ������ ����� �̸�,�޿��� ����Ͻÿ�
select ename �̸�,sal �޿�
from emp
where sal>(select avg(sal) from emp); --��������

--7. emp���� �Ի����� 4���� ����� �̸�,�Ի����� ����Ͻÿ�
select ename �̸�, hiredate �Ի���
from emp
where to_char(hiredate, 'mm') = '04';

--8. FORD�� �޿��� �����ϰų� ������ �޴� ����� ������ �޿��� ����Ͻÿ�
select ename �����,sal �޿�
from emp
where sal >= (select sal from emp where ename='FORD');

--9. student���̺��� 1������ 101���� �а��� ��ո����� ���� 
--   �����԰� ���� �л����� �̸��� �����Ը� ����Ͻÿ�
select name �̸�, weight ������
from student
where weight > (select avg(weight) from student where deptno1=101);

--10. professor���� �ֽ��� �������� ���߿� �Ի��� �������� 
--    �̸��� �޿� �Ի����� ����Ͻÿ�
select name �̸�, pay �޿�, hiredate �Ի���
from professor
where hiredate >= (select hiredate from professor where name ='�ֽ���');

--11. professor���̺��� ���������� ���ʽ��� �ϰ� 200�������� �����Ͻÿ�
update professor
set bonus = 200
where position='������';
--select * from professor;

--12. professor���̺��� hpage���� �̸��� homepage�� �����Ͻÿ�
-- ���̺��� �� �̸��� �����Ϸ��� 'alter table'���� ����� �� �ִ�.
alter table professor
rename column hpage to homepage;
--select * from professor;

--13.professor���̺� totsal���� �߰��Ͻÿ�
alter table professor
add totsal NUMBER;

--14. ���� totsal���� pay�� bonus�� ���Ͽ� �����͸� �߰��Ͻÿ�
update professor 
set totsal = pay + NVL(bonus,0);
select * from professor;

--15.dept ���̺��� 40�� �μ��� ��ġ�� seattle�� �̵��ϵ��� �����ϼ���
update dept
set loc = 'SEATTLE'
where deptno = 40;

--16.dept2�� �÷�AREA�� LOC�� �����Ͻÿ�.
alter table dept2
rename column area to loc;

--17.member���̺��� id�� bobby�λ���� �����Ͻÿ�
--Ư�� ���� �����ϱ� : delete�� ���
delete from member
where id='bobby';

--18.emp���� ������ ��ձ޿�,�ѱ޿�,�ְ�޿�,�����޿��� ���Ͻÿ�.
select job ����,round(avg(sal),2) ��ձ޿�,sum(sal) �ѱ޿�,max(sal) �ְ�޿�,min(sal) �����޿�
from emp
group by job;

--19.emp���� �̸��� S�� �����ϴ� ����� ���� �μ������ 
--�μ���ȣ�� �̸��� ����Ͻÿ�.
select deptno �μ���ȣ, ename �̸�
from emp
where deptno in (select deptno from emp where ename like 'S%');

--20.Member���̺� �Ѹ��� �����͸� ���Ƿ� �߰��ϼ���(��ü�� �߰�)
insert into member(no,name,jumin,passwd,id,an_key,an_key_dap)
values(1002,'������',9801012088888,'b1234','delly','�����̸�?','��Ѹ�');

commit;






