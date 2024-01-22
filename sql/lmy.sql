--emp ���̺� ��ü�� ��ȸ
select * from emp;
--emp ���̺��� ������ job�� ��ȸ
select ename,job from emp;
--emp ���̺��� ������ �ߺ� ������ ��ȸ
select DISTINCT job from emp;

--emp ���̺��� ����(allias)�� �־� ��� :���� ���� ������ ������ ū����ǥ("")
select ename ������, job as ������, deptno "�μ� ��ȣ" from emp;

--����(���������� �⺻_��������)
select ename �����, job "�� �� ��", sal "����" from emp order by ename; --asc������.
--����(��������)
select ename �����, job "�� �� ��", sal "����" from emp order by ename desc;


--emp���� ��翭 ��ȸ�ϴµ� �޿��� ���������� �����Ͻÿ�.
select * from emp order by sal desc;
--�÷����ε� ��ȸ ����(�Ʒ��� 6�� 6���� sal�� �ǹ�)
select * from emp order by 6 asc;
--��ȸ�ϴ� ���߿����� ������ �ǹ�(���⼭ 2�� ename,sal�߿��� 2���� sal�� �ǹ�)
select ename,sal from emp order by 2;


--ǥ����(�÷��� �̿ܿ� ����� ���ϴ� ������ select���� �ڿ� ��������ǥ('')�� ��� ���
select ename,'���� �ٹ���' from emp;
--���Ῥ���� ||
select '�� ������ ' ||job|| '�̰� ������ ' ||sal|| '�Դϴ�.' from emp;
--My name is Smith!!
select 'My name is ' ||ename|| '!!' from emp;


--���������
--emp ���� ����� ���� ����+100 �� ���ʽ���� �Է��Ͽ� ��ȸ�Ͻÿ�.
select ename "�����", sal "����", sal+100 "���ʽ�" from emp;
--professor�� ��ȸ�Ͻÿ�.
select * from professor;
--professor���� ������ �޿� ���ʽ� �ѱ޿�(�޿�+���ʽ�)�� �Է� ��ȸ�Ͻÿ�.
select name "������", pay "�޿�", bonus "���ʽ�", pay + bonus "�ѱ޿�" from professor;\

-- ���� ��ȸ�� ��, null���� 0���� �ٲٱ�: (NVL�Լ�)
-- NVL�Լ��� null���� �ٸ���(0)���� �ٲܶ� ���δ�.(Mysql������ IfNull�� �ٲ��.)
select name, pay ,NVL(bonus,0), pay + NVL(bonus,0) from professor;
-- emp���� �����, �޿�, �޿�*12(����),�޿�*12+comm(�ѱ޿�)�� ��ȸ�Ͻÿ�.
select ename "�����", sal "�޿�", sal*12 "����", NVL(comm,0) "���ʽ�", sal*12+NVL(comm,0) "�ѱ޿�" from emp;


-- where�� ����(from�� ������ ���´�.)
-- emp���� deptno�� 20���� ����� �����,������,�޿��� ��ȸ�Ͻÿ�.
select ename "�����", job "������", sal "�޿�" from emp where deptno = 20;
-- emp���� �޿��� 4000�̻��� ����� �̸��� �޿��� ��ȸ�Ͻÿ�.
select ename "�����", sal "�޿�" from emp where sal >= 4000;
-- emp���� KING�� �����ȣ�� ����� �׸��� �޿��� ��ȸ�Ͻÿ�.
select empno "�����ȣ", ename "�����", sal "�޿�" from emp where ename = 'KING';
-- �Ի����� 85�� ������ �����, �Ի����� ��ȸ�Ͻÿ�.
-- ���ڳ� ��¥�� ' '�ְ�, ���ڴ� �׳� �Է��Ѵ�. ������ ��� ��ҹ��� ����
select ename "�����", hiredate "�Ի���" from emp where hiredate >= '85/01/01';
-- student���� Ű�� 180cm�̻��� �л����� �̸��� Ű�� ��ȸ�Ͻÿ�.
select name "�̸�", height "Ű" from student where height >= 180;

-- between ������
-- student���� �����԰� 60���� 75kg ������ �л� �� �й�, �л���, ������ ������ ��ȸ�Ͻÿ�.
select studno "�й�", name "�л���", weight "������" from student where weight between 60 and 75;

-- in ������
-- student���� deptno�� 101�̰ų� 201�λ���� �̸�,deptno1�� ��ȸ�Ͻÿ�.
select name, deptno1 from student where deptno1 IN(101,201);

-- null�� ��ȸ
select name,deptno2 from student where deptno2 is null;
-- null�� �ƴѰ͸� ��ȸ
select name,deptno2 from student where deptno2 is not null;

-- Like ������ student���� �л� ���� �达�� ����� ��ȸ�ϰڴ�.
select * from student where name Like '��%'; -- %�� ���ڼ��� ������ ����.
-- �̸� �ȿ� '��'��� ���ڰ� �� ��� ��� ��ȸ
select * from student where name Like '%��%';

-- ��ü�� �ο���
select count(*)from student;
-- �÷��� cnt
select count(*) cnt from student;

-- emp���� sal�� 3000�̻��� ��츸 ����� ������ �޿��� ����Ͻÿ�.
select ename,job,sal from emp where sal>=3000;
-- emp���� sal�� 200~3000������ ��� �÷��� ����ϼ���.
select * from emp where sal between 200 and 3000;
-- �������� SALESMAN �̰ų� MANAGER�� ����� �����,�������� ����Ͻÿ�
select ename,job from emp where job in ('SALESMAN', 'MANAGER');
-- emp���� MGR�� 7902,7698,7829�� �����͸� ����Ͻÿ�.
select * from emp where MGR in (7902,7698,7829);
-- emp���� comm�� null�� ��츸 ����Ͻÿ�.
select * from emp where comm is null;
-- emp���� ������� SMITH�� ��츸 ����Ͻÿ�.
select * from emp where ename = 'SMITH';
-- student���� �л� ���� �达�� ����ϰ� Ű�� ���������� �����Ͻÿ�.
select * from student where name Like '��%' order by height;

--student���� 1�г� �л��� �̸��� ���ϰ� Ű�� �������� ��ȸ�ϼ���.
select name, birthday, height, weight from student where grade = 1;
--student���� 3�г� �л��� �̸��� ��ȭ��ȣ�� ����ϼ���. (��, �̸��� ��������)
select name �̸�, tel ��ȭ��ȣ from student where grade = 3 order by �̸�;
--Like ������ %�� �������� ���� ��ü, _����ٴ� �ϳ��� ���� ��ü
select empno, ename, hiredate,sal from emp where ename Like '__R%'; --����° ����
select empno, ename, hiredate,sal from emp where ename Like '__I%' or enmae Like '_I%'; --2���� Ȥ�� 3��° ����
select empno, ename, hiredate,sal from emp where ename Like '%N'; --N���� ������
select empno, ename, hiredate,sal from emp where ename Like '%N%'; --N�� �����ϴ�


--��¥ ���ͷ� ' '���
select empno, ename from  emp where hiredate >= '1982/01/01' or job = 'MANAGER';
select empno, ename from  emp where hiredate >= '1982/01/01' or job = 'MANAGER';

--��������(�޿��� ���������̰�, �̸��� ��������)
select empno,ename,sal from emp order by sal desc,ename;

--student���� 1�г� �л� �̸��� Ű,������ (Ű�� �����������, Ű�� ���� ��쿡 ���ؼ� �����Դ� �����������)
select name,height,weight from student where grade=1 order by height asc, weight desc;

--UNION : �� ������� �ߺ��� �� �����ϰ� ���
--UNION ALL : �ߺ������� ��� ���

--student���� 101�а��� 201�а��� �����ϴ� �л��� �̸����(union All���� �̸��� 2�� �����°ɷ� üũ����)
select name from student where deptno1=101 union
select name from student where deptno2=201;

select name from student where deptno1=101 union All
select name from student where deptno2=201;

--intersect ������ ���_�������� "������"�� ã�� ���տ���
select name from student where deptno1=101 intersect
select name from student where deptno2=201;

--�׷��Լ�
--��ü�� ������ ����
select count(*) cnt from emp;

--sal�� ���
select round(avg(sal),2) from emp; --�Ҽ��� 2�ڸ�
select round(avg(sal),1) from emp; --�Ҽ��� 1�ڸ�
select round(avg(sal),0) from emp; --�Ҽ��� ���� �ݿø�
select round(avg(sal),-1) from emp; --10���� 
select round(avg(sal),-2) from emp; --100����

--���� ��¥�� �ܼ�â�� ����ϱ�.
select sysdate from dual;
--���� ��¥�� �ֿܼ� ���
select sysdate+1 from dual;
--������ �� ��¥�� �ֿܼ� ���
select sysdate+7 from dual;

--��¥���� �⵵�� ����
select to_char(sysdate, 'year') from dual; --����� �⵵����
select to_char(sysdate, 'yyyy') from dual; --2024

--��¥���� ���� ����
select to_char(sysdate,'month') from dual; --1��
select to_char(sysdate,'mm') from dual; --01

--��¥�� �ð����
select to_char(sysdate,'yyyy-mm-dd hh-mi-ss') from dual;
select to_char(sysdate,'yyyy-mm-dd hh24-mi-ss') from dual;

--to_char�� ���ڿ��� ���밡���ϴ�.
select to_char(2458971, '999,999,999') from dual; --õ���� ���б�ȣ

select to_char(34.5,'999,999,999') from dual; 
select to_char(34.5,'9999,00') from dual; 
select to_char(34.5,'009999,00') from dual; 

--emp���� �����ȣ,�����,�޿��� ����ϵ� �޿��� õ���� ���б�ȣ�� ǥ���ϼ���.
select empno,ename,to_char(sal, '$999,999') from emp;

--emp���� �����ȣ,�����,�Ի�⵵�߿��� �⵵�� ǥ���Ͽ� ����Ͻÿ�.(1980)
select empno,ename,to_char(hiredate,'yyyy') from emp;

--����ð��� 2024/01/22�� �ֿܼ� ����Ͻÿ�.(���� ����ð��� �ٿ���)
select to_char(sysdate,'yyyy/mm/dd,hh24:mi:ss') from dual;



