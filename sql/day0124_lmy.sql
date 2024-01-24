--day0124_lmy

--GROUP BY ����
--�μ��� �޿�
select deptno, Max(sal) from emp group by deptno;

--�μ��� ���� �޿��� ���� �޴� ���
select deptno,ename,sal 
from emp 
where sal in (select Max(sal) from emp group by deptno);

--�Ի�⵵�� �Ի�⵵,�ο���,��ձ޿� ���(�Ի�⵵�� ��������)
select to_char(hiredate,'yyyy') �Ի�⵵,count(*) �ο���, round(avg(sal),0) ��ձ޿�
from emp
group by to_char(hiredate,'yyyy') order by to_char(hiredate,'yyyy');

--[RollUp �Լ�]
--�ڵ����� �Ұ�/�հ踦 �����ִ� �Լ�
--group by���� �־��� �������� �Ұ谪�� �����ش�

select deptno �μ���ȣ,position ����, sum(pay) �ѱ޿�
from professor
group by deptno, rollup(position);

select position,count(*),sum(pay)
from professor
group by rollup(position);


-------------------------------------

--[Cube �Լ�] -��ü ���հ���� ����Ϸ��� cube
--cube
select deptno, position, count(*), sum(pay)
from professor
group by cube(deptno, position);

--[Having ��]
--Q.������ 2000�̻��� �μ��� �μ���ȣ�� ��ձ޿��� ���Ͻÿ�.
select deptno, round(avg(sal),0)
from emp
group by deptno
having avg(sal) >= 2000 --having avg(�����Լ� group by �ڿ��� ���� ����)
order by deptno;

--�μ���ȣ�� 10,20�� ��� �߿��� 
--������ ���� ���� 2�� �̻��� ��츸 ��ȸ�Ͻÿ�.
select job,count(*) cnt
from emp
where deptno in ('10','20')
group by job
having count(*) > 2;

-----------------------------------------------

--Q.emp���� deptno�� 10,20,30�� �߿��� �μ���ȣ�� 20�� ������ �μ������� ���Ͻÿ�.
select job, deptno, count(*)
from emp
where deptno in ('10','20','30') --��ü�̹Ƿ� �����ص� ����
group by job, deptno
having deptno = '20';

--Q.emp���� �������� ����, ������ �޿��� �հ� (Manager������ ����)�� ���ϵ�
--�޿��� �հ谡 5000�̻� ���ؼ� �޿��� ���� ������ �����Ͻÿ�.
select job ����, sum(sal) "�޿� �հ�"
from emp
where job not in 'MANAGER' --(Manager������ ����)
group by job --��������
having sum(sal)>=5000 --�޿��� �հ谡 5000�̻�
order by sum(sal) desc; --�޿��� ���� ��

--���� ������ rollup �߰��ϸ�,���� ������ �޿��հ��� ������ ���� �� �ִ�.
select job ����, sum(sal) "�޿� �հ�"
from emp
where job not in 'MANAGER' --(Manager������ ����)
group by rollup(job) --�������� �հ�
having sum(sal)>=5000 --�޿��� �հ谡 5000�̻�
order by sum(sal) desc; --�޿��� ���� ��


------------------------------------------
--day0124_lmy

--[����]
--emp�� dept�� "����"�ؼ� emp����� �̸��� �μ����� ��ȸ�Ͻÿ�.
--SMITH RESEARCH DALLAS
--���1
select e.ename �����,d.dname �μ���,d.loc �μ�����
from emp e,dept d
where e.deptno = d.deptno; --emp���̺��� deptno�� dept���̺��� deptno�� ����.

--���2
select emp.ename �����, dept.dname �μ���, dept.loc �μ���ġ
from emp, dept
where emp.deptno = dept.deptno;

--���3
select ename �����, dname �μ���, loc �μ���ġ
from emp e,dept d
where e.deptno = d.deptno;

--Q.department�� professor�� "����"�Ͽ� ������ ���� ����ϼ���.
--  ������ �а��� 
select p.name ������, d.dname �а���
from department d, professor p
where d.deptno = p.deptno;


--Q.emp,dept�� �̿��Ͽ� �μ���ȣ�� 10���� �μ��� ������� 
--  �����,�μ���,�޿��� ��ȸ�Ͻÿ�.
select ename �����, dname �μ���, sal �޿�
from emp e, dept d
where e.deptno = d.deptno and d.deptno = '10';


--Q.student professor�� �̿��Ͽ� ������ ���� ����Ͻÿ�
--  �й�  �л���  ��米����
select studno �й�, s.name �л���, p.name ��米����
from student s, professor p
where p.profno = s.profno;


--Q.panmae,product�� �̿��Ͽ� ������ ���� ����Ͻÿ�
-- ����¯ ���ǸŰ���(p_total)
select p_name �����̸�, p_price ��ǰ����, p_qty ��ǰ���, p_total �Ѱ���
from panmae, product
where panmae.p_code =  product.p_code;


--Q.student department�� �̿��Ͽ� ������ ���� ����Ͻÿ�
--�л���   ��1����
--������  ��ǻ�Ͱ��а�
select s.name �л���, d.dname ��1����
from student s, department d
where s.deptno1 = d.deptno;













