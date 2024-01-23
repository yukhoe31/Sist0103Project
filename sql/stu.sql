--test ���̺�
--primary key(not null + unique)
--��������
desc test;
--test�� ��ü ����Ÿ insert
insert into test values(1,'���缮',96.2,'1980-01-03');
--test ��ȸ
select * from test;
--test�� �Ϻ� ����Ÿ insert
insert into test(num,name) values(2,'�ڸ��');
--�Ϻ��÷��� ��ȸ
select num,name from test;
--���糯¥�� �߰�
insert into test values(3,'������',87,sysdate);

--���̺� age �÷��߰� / ���̺� �÷��߰�
--�� ALTER TABLE ���̺�� ADD �߰����÷��� ������Ÿ��;
alter table test add age number(5);
--�ּ�(addr)�� ������ �÷��� �߰��ϴµ� �ʱⰪ�� ��������� ����
alter table test add addr varchar2(30) default '������';
--�ʱⰪ�� ���α���� ������ Ȯ��
insert into test (num,addr) values(4,'����� ���α�');

--addr�� ����Ÿ�� �÷��ֱ� / ���̺� �÷��� Ÿ�Ժ���
--�� ALTER TABLE ���̺�� MODIFY �÷��� ������Ÿ��;
alter table test modify addr varchar2(70);
--Q. ageŸ���� varchar2(10)�����ϰ� �ʱⰪ�� '22'���� �����ϱ�
alter table test modify age varchar2(10) default '22';
--�Ϻθ� �־ ���� 22�� ������ Ȯ��
--���� null�� ������ �״�� �ְ� ���� insert�Ѱͺ��� �ʱⰪ�� ��
insert into test (num,name,score,birth) values(6,'������',87,sysdate);

--num�� �������� ���
select * from test order by num;
--num�� �������� ���
select * from test order by num desc;

--age�÷� ����
--�� ALTER TABLE ���̺�� DROP COLUMN �������÷���
alter table test drop column age;
--addr�÷� ����
alter table test drop column addr;

--birth�� birthday�� ���� / ���̺� �÷��� �̸�����
--�� ALTER TABLE ���̺�� RENAME COLUMN  OLD�÷��� TO NEW�÷���;
alter table test rename column birth to birthday;

--score �� jumsoo�� ����
alter table test rename column score to jumsoo;

desc test;
--����
commit;

--���̺����(�ʰԿ»���� ��������)
--drop table test;

----------------------------------

--�������� �⺻���� ���� (�ں����� �Ʒ� ���� �ʿ���� �̰͸����� ���)
create sequence seql;

--������ Ȯ��
select * from seql;

--���� ������ ���� �߻����� �ֿܼ� ���
select seql.nextval from dual;

--���� ������ �߻� ������
select seql.currval from dual;

--seql����
drop sequence seql;

--10���� 5�� �����ϴ� �������� �����ϱ� -cache���� ���ֱ�
create sequence seq1 start with 10 increment by 5 nocache;

--������ �߻�
select seq1.nextval from dual;

--������ ����, start with�� �����Ұ�, maxvalue ������ �װ����� ������ �ٽ� ó������ ������ �Ҷ�
alter sequence seq1 increment by 10 maxvalue 100 cycle;

--������ ���� 
drop sequence seq1;


-------------------------------

--seq1 : ���۰� 5, ������ 2, ���� 30 ĳ�� no cycle yes
create sequence seq1 start with 5 increment by 2 maxvalue 30 nocache cycle;

--seq2 : ���۰� 1, ������ 2, ĳ�� no
create sequence seq2 start with 1 increment by 2 nocache;

--seq3 : ���۰� 1, ������ 1, ĳ�� no
create sequence seq3 nocache;

--������ ���
select seq1.nextval,seq2.nextval,seq3.nextval from dual;

--������ ���� 
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

-------------------------------------
-------------------------------------

--������ ����
create sequence seq_person;

--���̺� ����
create table person(num number(5) primary key, pname varchar2(20),
job varchar2(30), gender varchar(10), age number(5), hp varchar2(20), 
birth date);

--birth�� ipsady�� ����
alter table person rename column birth to ipsaday;

--����Ȯ��
desc person;

--delete from person;

--nextval: ��ġ�� �ʴ� ���� ���� �߻���Ų��.
--��ȸ������ ���ؼ� insert(���α׷���,����,�����Ͼ�,��Ÿ  ����,���� )�ּ� 10�� �̻� �־��ַ�.
insert into person values(seq_person.nextval,'�̼���','���α׷���','����',33,'010-111-2222','2021-01-02');
insert into person values(seq_person.nextval,'�迵ö','����','����',30,'010-222-2222','2022-01-02');
insert into person values(seq_person.nextval,'�̹���','�����Ͼ�','����',28,'010-123-5489','2021-09-25');
insert into person values(seq_person.nextval,'���̷�','ȸ���','����',28,'010-444-7777','2018-01-01');
insert into person values(seq_person.nextval,'�����','���α׷���','����',33,'010-458-1245','2020-05-01');
insert into person values(seq_person.nextval,'��̶�','�����Ͼ�','����',29,'010-888-1111','2023-08-11');
insert into person values(seq_person.nextval,'�̶̹�','���α׷���','����',33,'010-147-7412','2023-07-21');
insert into person values(seq_person.nextval,'�ֿ�ȯ','����','����',28,'010-897-3256','2022-06-21');
insert into person values(seq_person.nextval,'�迵ȯ','����','����',35,'010-145-2289','2023-06-21');
insert into person values(seq_person.nextval,'�̼���','���α׷���','����',35,'010-145-1111','2022-06-21');
--��������
commit; 

--�����ο� Ȯ��
select count(*) from person;

--�̸� ������������ ���
select * from person order by pname; --asc�� ���� ����

--���� ���� ���
select * from person order by age desc;
select * from person order by 5 desc; --5�� ���� ��� = ���� ���� ���

--gender �������� ���� ��� �̸� ��������
select * from person order by gender, pname;

--������ ���
select job from person;

--������ ���, �ߺ� ����
select distinct job from person;

--�̸��� �̶̹��� ����� ���
select * from person where pname = '�̶̹�';

--�̸� �ι�° ���� ����� '��'�λ�� ���
select * from person where pname like '_��%';

--���� �达�� ����� ���
select * from person where pname like '��%';

--�ڵ��� �������� 1111�� ������ ��� ���
select * from person where hp like '%1111';

--�Ի���� 1���� ����� ���
select * from person where to_char(ipsaday, 'mm') = '01';

--�Ի�⵵�� 2024���� ����� ����Ͻÿ�
select * from person where to_char(ipsaday, 'yyyy') = '2023';

--���̰� 25~30 ������ ����� ��ȸ(2����)
select * from person where age between 25 and 30;
select * from person where age>=25 and age<=30;

--������ �����̰ų� ���α׷����� ��� ���(2����)
select * from person where job in ('���α׷���', '����');
select * from person where job='���α׷���' or job='����';

--���� �达�̰ų� �̾��� ����� ��ȸ�Ͻÿ�.
select * from person where pname like '��%' or pname like '��%';

--�����̸鼭 ���̰� 30�� �̻��� ��� ��ȸ
select * from person where gender='����' and age>=30;

--��ճ��̱��ϱ�(�Ҽ��� 2�ڸ�)
select round(avg(age),2) from person;

--��ճ��̺��� ���� ����� �̸��� ����,���̸� ���Ͻÿ�.(��������)
select pname,job,age from person where age >= (select avg(age)from person);

select * from person;


--person�� ���̺� ���纻 �����ϱ� person3
create table person3 as select * from person;

--������ ���� �����ϱ�.. ������ �Ⱦ��� ��� ������ ����..�����ʼ�
update person3 set job='��ȣ��', age = 22;

--������ �߸������� ������ ������� �ǵ�����
Rollback;

--3���� ���� ���� �����ϱ�
update person3 set job='��ȣ��', age = 22 where num=3;

--�达�̸鼭 ������ ����� ������ ���ڷ� �����ϱ�
update person3 set gender='����' where pname like '��%' and job='����';

--num�� 8���� ����� ������ ���ΰ��̸� �Ի����� 24/01/01�� �����ϼ���.
update person3 set job='���ΰ��̸�', ipsaday='2024-01-01' where num=8;

--��������
commit;

--����
--num 5�� ����
delete from person3 where num=5;



--���� �߿��� ���̰� 33�� �̻� ��� �����Ͻÿ�.
delete from person3 where gender ='����' and age>=33;

--�ڵ��� ���ڸ��� 111�� ����� ���̸� 39��,�Ի����� 22/01/01�� �����Ͻÿ�.
update person3 set age=39,ipsaday='2022-01-01' where hp like '%1111';

--������ ��ȣ���̰ų� �����Ͼ��� ��� ��� ����
delete from person3 where job='��ȣ��' or job='�����Ͼ�';

select * from person3;


--drop table person3;


--�÷��� �߰��ϴµ� �ּ� addr 30����Ʈ ���ڿ��� �߰��϶� (�⺻���� �����)
alter table person3 add addr varchar(30) default '�����';

--�÷��� ���� hp==>handphone
alter table person3 rename column hp to handphone;

--������ �߰��ϴµ� �Ϻθ� �ֱ�(num,pname,gender,job)
insert into person3 (num,pname,gender,job)values(seq_person.nextval,'�輱��','����','������');

--������ �߰��ϴµ� �Ϻθ� �ֱ�(num,pname,addr,ipsaday)
insert into person3 (num,pname,addr,ipsaday)values(seq_person.nextval,'���̿�','�뱸��','2021-01-24');

--null�ϰ�� ������ ������ ����մϴ�.(NVL�̿�, ������ null�� ��� ��������, ���̰� null�ΰ�� 20���� ���)
select pname �̸�, NVL(job,'����') ����,NVL(age,20) ���� from person3;

--�ڵ����� null�ΰ�� ****�� ���
select pname �̸�, NVL(handphone,'****') �ڵ�����ȣ from person3;
--

select * from person3;




