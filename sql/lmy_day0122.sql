--Q day0122
--dept2���̺��� area�� �ߺ������� ����Ͻÿ�
select DISTINCT area from dept2;

--emp���̺��� ���������� ����Ͻÿ�
--SMITH���� ������ CLERK�Դϴ�
select '' ||ename|| '���� ������ ' ||job|| '�Դϴ�.' from emp;
--SMITH(CLERK)
select '' ||ename|| '(' ||job|| ')' from emp;

--professor���� ������,�޿�,���ʽ�,�ѱ޿��� ����Ͻÿ�
select name "������",pay "�޿�", NVL(bonus,0) "���ʽ�", pay + NVL(bonus,0) "�ѱ޿�" from professor;

--GOGAK���̺��� point�� 500000 �̻��� ����� �̸�,�ֹι�ȣ�� ����϶�
select gname "�̸�", gno "�ֹι�ȣ" from gogak where point>=500000;

--student���� �������� �г�,��ȭ��ȣ ����Ͻÿ�
select grade "�г�",tel "��ȭ��ȣ" from student where name = '������';

--student���� deptno1�� 201 �̰ų� 301�� ����� �̸��� �ֹι�ȣ�� ����Ͻÿ�
select name "�̸�", studno "�ֹι�ȣ" from student where deptno1 in (201, 301);

--gogak���� point �� 30~50�� ������ ����� �̸��� ����Ͻÿ�
select gname from gogak where point between 300000 and 500000;

--professor���� ���� �达�� ����� �̸�,����,���������� ����Ͻÿ�
select name, position, deptno from professor where name Like '��%';

--emp���� comm�� null�� ����� �̸��� �޿� ���
select ename, sal from emp where comm is null;

--emp���� comm�� null���� 0���� �ٲپ ������ MANAGER�� ����� �̸��� ���ʽ� ����Ͻÿ�
select ename, NVL(comm,0) from emp where job = 'MANAGER';

--emp :  ����� �޿� ����(�޿�*12),���ʽ�,�ѿ���(����+���ʽ�) �� ����Ͻÿ�
select ename "�����",sal "�޿�",sal*12 "����", NVL(comm,0) "���ʽ�",sal*12+NVL(comm,0) "�ѿ���" from emp;

--professor���� 103�� �а� �������� ������,�޿�,���ʽ�,���� ����Ͻÿ�  (����=�޿�*12+���ʽ�)
select name "������",pay "�޿�",NVL(bonus,0) "���ʽ�",pay*12+NVL(bonus,0) "����" from professor;

--student���̺� 4�г� �л��� �̸� Ű ������ ���(������ ������ ����)
select name,height,weight from student where grade = 4 order by weight desc;

--student���� 1�г� �л��� ���Ű�� ���Ͻÿ�(�Ҽ��� 1�ڸ�)
select round (avg(height),1) from student where grade = 1;

--student���� 4�г� �л��� ��ո����Ը� ���Ͻÿ�(�Ҽ���2�ڸ�)
select round (avg(weight),2) from student where grade = 4;

--emp���� ������ CLERK,PRESIDENT,ANALYST�� ����� ���,�����,������ ����Ͻÿ�
select empno "���", ename "�����", job "����" from emp where job in ('CLERK','PRESIDENT','ANALYST');

--professor���� pay�� 300~500������ ����� ������,�޿��� ����Ͻÿ�
select name "������", pay "�޿�" from professor where pay between 300 and 500;

--professor���� 10���� �Ի��� ������ �̸��� ������ ����Ͻÿ�
select name, position from professor where EXTRACT (MONTH FROM hiredate)=10;

--emp���� ����° �̸��� R�� ����� ����Ͻÿ�
select * from emp where ename Like '__R%';