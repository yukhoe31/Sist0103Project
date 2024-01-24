--day0124_stu

--[��������]
--�������� �־ ���ο� ���̺� ����
create table sawon (num number(5) CONSTRAINT sawon_pk_num primary key,
name varchar2(20), 
gender varchar2(10),
buseo varchar2(30) CONSTRAINT sawon_ck_buseo check (buseo in ('���ߺ�','�λ��','������')),
pay number(10) default 1200000);


--������
create sequence seq_sawon;


--insert 10������ ���ּ���
insert into sawon values(seq_sawon.nextval, '�̼���','����','���ߺ�',3450000);
insert into sawon values(seq_sawon.nextval, '�̼���','����','������',2560000);
insert into sawon values(seq_sawon.nextval, '������','����','���ߺ�',3250000);
insert into sawon values(seq_sawon.nextval, '������','����','���ߺ�',2490000);
insert into sawon values(seq_sawon.nextval, '�ֹμ�','����','�λ��',4200000);
insert into sawon values(seq_sawon.nextval, '���μ�','����','���ߺ�',3900000);
insert into sawon values(seq_sawon.nextval, '�����','����','������',2890000);
insert into sawon values(seq_sawon.nextval, '�̹α�','����','�λ��',3490000);
insert into sawon values(seq_sawon.nextval, '�ֽ�ö','����','���ߺ�',2890000);
insert into sawon values(seq_sawon.nextval, '�ֹ���','����','������',2450000);

--��������
commit;

--�׷��Լ� ����ؼ� �׽�Ʈ
--�μ��� �ο����� �ְ�޿� �����޿��� ��ȸ�Ͻÿ�.
select buseo �μ���, count(buseo) �μ��ο���, max(pay) �ְ�޿�, min(pay) �����޿�
from sawon
group by buseo;

--���� �������� �ְ�޿� �����޿��� ȭ����� ���̰� 3�ڸ� �ĸ��� ������ ���ּ���.
select buseo �μ���, count(buseo) �μ��ο���, to_char(max(pay),'L999,999,999') �ְ�޿�, 
       to_char(min(pay),'L999,999,999') �����޿�
from sawon
group by buseo;


--�μ��� �ο����� ��ձ޿��� ����Ͻÿ�.
--������ �μ���, �ο���, ��� �޿���� ����Ͻÿ�.(�ο����� �ڿ� '��'�̶�� ���ϰ�)
select buseo �μ���,count(buseo)||'��' �ο���, 
       to_char(avg(pay),'L999,999,999') "��� �޿�"
from sawon
group by buseo;

--���� �ο����� ��ձ޿�,�ְ�޿�,�����޿��� ���Ͻÿ�.
select gender ����,count(gender) �ο���,round(avg(pay),0) ��ձ޿�,
       max(pay) �ְ�޿�,min(pay) �����޿�
from sawon
group by gender;

--�μ��� �׷��߿��� �μ��� �ο��� 4�� �̻��� ��츸 ����Ͻÿ�.(�μ���,�ο���,��ձ޿�)
--group by�� ����� ������ having
select buseo �μ���, count(buseo) �ο���, round(avg(pay),0) ��ձ޿�
from sawon
group by buseo
having count(buseo)>=4;


--�������� �����ϱ�
--sawon���̺��� sawon_ck_buseo �� �����غ���.
alter table sawon drop CONSTRAINT sawon_ck_buseo;

--���������Ƿ� �ٸ� �μ��� insert�غ���
insert into sawon values(seq_sawon.nextval,'���߱�','����','�ؿܿ�����',5840000);

--sawon�� name�÷��� unique �������� �߰��ϱ�(sawon_uk_name)
--UNIQUE�� NOT NULL�� �ٸ��� �÷����� �ٽ� �ѹ� �� ����� �־���Ѵ�. UNIQUE(name)
ALTER table sawon add CONSTRAINT sawon_uk_name UNIQUE(name);


--delete from sawon where num=2;
select * from sawon;

------------------------------------------����

--day0124_stu

/*
[DB����ȭ�� ���ؼ� �������࿹��]

1.�ϴ� ������ȭ�� ���̺��� ���� �����͸� �ְ� ��ȸ����
2.�� ���Ŀ� �ٽ� �ΰ��� ���̺�� ����� �����͸� �ְ� �ܺ�Ű�� �̿��ؼ� �����غ���
3.������ ������ ����ȭ�� ���̺��� ��� ������ �߻��� �� �ִ�.
  cascade�����ڸ� �̿��ؼ� ���̺��� ������ ������ �� �ִ�.
*/

----[������ȭ]
--������ȭ�� ���̺�
--ȸ��,���� ���̺�; companysawon
--ȸ���: company ���ڿ�(20)
--ȸ���ּ�: address ���ڿ�(30)
--ȸ����ȭ: phone  ���ڿ�(20)
--������: sawon_name ���ڿ�(20)
--����: position ���ڿ�(20)
--�̸���: email  ���ڿ�(20)
--�޴���: hp  ���ڿ�(20)

create table companysawon (company varchar2(20), address varchar2(30),
phone varchar2(20), sawon_name varchar2(20), position varchar2(20),
email varchar2(20), hp varchar2(20));

insert into companysawon values ('�Ｚ','����� ������','02-222-1234','ȫ�浿','����','hong@gamil.com','010-111-1234');
insert into companysawon values ('LG','����� ���ʱ�','02-111-1111','��ſ�','����','kim@gamil.com','010-222-3333');
insert into companysawon values ('��ȭ','��⵵ ���ν�','031-222-1111','���λ�','���','you@gamil.com','010-125-4567');

--�ŷ�ó ȸ�翡 ���� ������ �ŷ�ó�������� ���� �߰��Ҷ����� ��� �߰��ؾ��Ѵ�.. �� �޸� ���� ���ϴ�.
--ȸ�縦 ���� �ƴϸ� ������ �ٲ�� ���� �����͸� �ѹ��� ��� �����ؾ��ϹǷ� ���� ���ŷӴ�.
--�׷��� DB[����ȭ]�� �ʿ��ϴ�. �ŷ�ó ȸ�� ���� ���� �������� ���� �и��ؼ� ������.

----[����ȭ]
--����ȭ ������
--ȸ����̵� : compant_id ����(5) �⺻Ű
--ȸ��� : company ���ڿ�(20)
--ȸ���ּ� : address ���ڿ�(30)

create table company(company_id number(5) primary key,
company varchar2(20), address varchar2(30), phone varchar2(20));

--������ �߰�
insert into company values(10,'LG','����� ���ʱ�','02-111-2222');
insert into company values(20,'��ȭ','��⵵ ���ν�','031-222-1111');
insert into company values(30,'�Ｚ','����� ������','02-333-5555');

--�ŷ�ó ���� ���̺�: c_sawon
--������: sawon_name ���ڿ�(20)
--����: position ���ڿ�(20)
--�̸���: email  ���ڿ�(20)
--�޴���: hp  ���ڿ�(20)
--ȸ����̵�: company_id number(5) : �ܺ�Ű(Foreign key)

create table c_sawon(company_id number(5), 
sawon_name varchar2(20), position varchar2(20),
email varchar2(20), hp varchar2(20),
CONSTRAINT c_sawon_fk_id foreign key(company_id) references company(company_id));

--���� c_sawon���̺� insert
insert into c_sawon values(10,'�̼���','����','lee@naver.com','011-111-4444');
insert into c_sawon values(20,'�����','�븮','kim@naver.com','011-222-4444');
insert into c_sawon values(30,'���̷�','�븮','yoon@naver.com','011-444-5555');


--company�� ����Ǿ��� ���̺�(c_sawon)���� 10,20���� �߰��Ͽ���.
--20�� ��ȭ�� ��������
delete from company where company_id=20;

--30�� ����..����� �ڽĵ��� �����Ƿ� �������� �����Ӵ�.
delete from company where company_id=30;


select * from company;
select * from c_sawon;










