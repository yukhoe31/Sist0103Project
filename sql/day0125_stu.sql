--day0125 _stu

select * from company;
select * from c_sawon;
select * from c_sawon2;

--ON DELETE CASCADE (feat. foreign key �� ����� row �� ���� ����� ���) 
--�θ�� ������ �� �θ���� �ڽı۵� �ڵ����� ������

--�θ����̺��� 10�� id �����غ��� �ɱ�?=>�������� ��������(�ڽ� ���ڵ尡 �߰ߵǾ����ϴ�.)
delete from company where company_id = 10;

--�ڽķ��ڵ� ���� 30�� id�����غ���
delete from company where company_id=40;

--�Ʊ��ϱ� �ѹ�(�ڷΰ��� ����̴�.)
rollback;

--�ڽı��� �־ ���ۻ��� �����ϵ��� �����(on delete cascade: �θ���� ����� �� �ڽķ��ڵ�� ����)
create table c_sawon2(company_id number(5),
sawon_name varchar2(20),position varchar2(20),
email varchar2(20), hp varchar2(20),
CONSTRAINT c_sawon2_fk_id foreign key(company_id) references company(company_id) on delete cascade);

--c_sawon2�� ���� �߰�3��
insert into c_sawon values(20,'���̷�','�븮','yoon@naver.com','011-444-5555');

--c_sawon ��緹�ڵ� ����
delete from c_sawon;

--c_sawon2������ �θ���� �ڽı��� ��ϵȰ����ִ�. �̷����� �����ɱ�?
delete from company where company_id=20;


--------------------------
--day0125 _stu

/*
[0125 ����ȭ �����̼� �� ���ڵ��ۼ��� ��������]

����Ŭ ����
1.outer join : ���ǿ� ��ġ���� �ʾƵ� ���
2.self join : �ڽ��� ���̺���� ����
3.inner join : �⺻Ű(primary key)�� �ܺ�Ű(foreign key)�� ����ؼ� join(���帹�� ���)

on delete cascade: 
  �ܺ�Ű�� ���̺�� ����Ǿ��� �ϴ��� 
  �θ����̺��� �����͸� �����ϸ� 
  �ڽ����̺��� �����ͱ����� �ڵ����� ���������ִ� ���

*/
--���̺� ����(�ڽ����̺� ���� ���� �� �θ����̺� ����)
/*
drop table c_sawon2;--����
drop table companysawon;--����
drop table company;--����
drop table c_sawon;--����
drop table test;--����
*/
-----------

--day0125 _stu

--������ ���� ����
create SEQUENCE seq_shop;

--shop ���̺� (�θ����̺�)
create table shop(num number(5) primary key, 
sangpum varchar2(30), color varchar2(30));

--shop �� insert ��ǰ�߰�
insert into shop values(seq_shop.nextval,'�䰡��Ʈ','��ũ');
insert into shop values(seq_shop.nextval,'�Ʒ�','��');
insert into shop values(seq_shop.nextval,'���뽺','������');
insert into shop values(seq_shop.nextval,'�䰡����','ȭ��Ʈ');
insert into shop values(seq_shop.nextval,'�縻','���');

--��������
commit;


--cart1 ���̺�, ��ǰ������ shop���̺��� num���� �ܺ�Ű�� �����Ѵ�.
create table cart1(idx number(5) primary key,
num number(5) CONSTRAINT cart_fk_num REFERENCES shop(num),
cnt number(5), guipday date);

--cart2 ���̺�, ��ǰ������ shop���̺��� num���� �ܺ�Ű�� �����Ѵ�.
--�θ����̺� ��ǰ����� �� ��ǰ�� ����� īƮ�� �ڵ����� �����ش�.
create table cart2(idx number(5) primary key,
num number(5),
cnt number(5), guipday date,
CONSTRAINT cart_fk2_num foreign key(num) REFERENCES shop(num) on delete cascade);

--cart1�� ��ǰ�߰�,1�� ��ǰ īƮ�� ���
insert into cart1 values(seq_shop.nextval,1,2,sysdate); --1�� �䰡��Ʈ 2�� �߰�
--cart1�� ��ǰ�߰�,5�� ��ǰ īƮ�� ���
insert into cart1 values(seq_shop.nextval,5,10,sysdate); --5�� �縻 10�ӷ� �߰�
--shop�� ���� ��ǰ�� cart1�� �߰�=>����
insert into cart1 values(seq_shop.nextval,6,10,sysdate); --6��(���»�ǰ) 10�� �߰�

--cart2���..��ǰ3�� īƮ���
insert into cart2 values(seq_shop.nextval, 3,4,sysdate);
insert into cart2 values(seq_shop.nextval, 2,2,sysdate);

--��������
commit;


--cart1���� 1�� 5�� ��ǰ�� �߰��Ǿ���.

--shop���� 1���� �����Ǵ��� Ȯ��?
delete from shop where num=1;
--ORA-02292: ���Ἲ ��������(STU.CART_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ�

--4����ǰ�� �ƹ��� �ȳ������Ƿ� ������ ����.
delete from shop where num=4;

--�Ʊ��ϱ� �츰��.
rollback;


--cart2���� 2�� 3�� ��ǰ�� ����ִ�.
--cart2�� ��� 2�� ��ǰ�� �ִ��� shop���� 2�� ��ǰ�� ������ �ɱ��?
--��:yes
delete from shop where num=3;

rollback;


--join�� ���ؼ� cart2�� ����Ÿ ���ݴ� �߰�����.
insert into cart2 values(seq_shop.nextval,1,3,sysdate);
insert into cart2 values(seq_shop.nextval,5,10,sysdate);
insert into cart2 values(seq_shop.nextval,1,1,sysdate);
insert into cart2 values(seq_shop.nextval,1,2,sysdate);

--cart1�� ��� ��ǰ�� shop���̺�� join�ؼ� �ڼ��� ����غ���.
--���1
select cart1.idx, shop.sangpum, shop.color, cart1.cnt, cart1.guipday
from shop,cart1
where shop.num = cart1.num;

--���2
select c.idx, c.num, s.sangpum, s.color, c.cnt, c.guipday
from shop s, cart1 c
where s.num = c.num;

--���3
select idx, c.num, sangpum, color, cnt, guipday
from shop s, cart1 c
where s.num = c.num;


--cart2 ���� ������� join ����غ���.
select idx,c.num,sangpum,color,cnt,guipday
from shop s,cart2 c
where s.num = c.num;


select * from shop;
select * from cart2;
select * from cart1;

---------------------------------------------


--foreign key & join

--bno:�Խ��� ��ȣ
create table board (bno number(3) CONSTRAINT board_pk_bno primary key,
writer varchar2(30),subject varchar2(50), writeday date);


--board�� insert
insert into board values(seq_sawon.nextval, '�罻��','�츮 ���Ӱ���',sysdate);
insert into board values(seq_sawon.nextval, '�����','���͵����',sysdate);
insert into board values(seq_sawon.nextval, '������','���̾�Ʈ ���úη�',sysdate);
insert into board values(seq_sawon.nextval, '�Դ°� ���','���ɸ��ڿ���',sysdate);
insert into board values(seq_sawon.nextval, '���ǰ�','���� ���ῡ ������',sysdate);

commit;

--answer��� ���̺��� ����, bno�� board�� �ܺ�Ű�� �����ϰ�
--�θ����̺� �� ����� �� �ۿ� �޸� ����� �ڵ����� �����ǵ���
create table answer(num number(5) CONSTRAINT answer_pk_num primary key,
bno number(3) CONSTRAINT answer_fk_bno REFERENCES board(bno) on delete cascade,
nickname varchar2(20), content varchar2(50));

--���ϴ� �۹�ȣ�� ��� �߰��ϱ�
insert into answer values (seq_sawon.nextval,21,'���','�� ���� ������ �Ǵ�?');
insert into answer values (seq_sawon.nextval,23,'�����䳢','���̾�Ʈ �����־�Ф�');
insert into answer values (seq_sawon.nextval,23,'�컩��','���� �η��� �����ֽðھ��?');
insert into answer values (seq_sawon.nextval,24,'�߱�������','���ɸ޴��� ¥��� �?');
insert into answer values (seq_sawon.nextval,21,'����','�罻�� ���� �ʴ´�.');

commit;


--join�ؼ� ���
--bno(�۹�ȣ) writer(�ۼ���) subject(����) nickname(��۴ܻ��) content(��۳���) writeday(�����ۼ���¥)

select b.bno �۹�ȣ, writer �ۼ���, subject ����, nickname ��۴ܻ��,content ��۳���, writeday �����ۼ���¥
from board b, answer a
where b.bno = a.bno;

--����21�� ������ answer���̺� ��� ��������� Ȯ���Ұ�
delete from board where bno=21;



select * from board;
select * from answer;


--2�� ���̺� ���� : �ڽ����̺� ���� �� �θ����̺� ����
drop table answer;--�ڽ����̺�
drop table board;--�θ����̺�

------------------------------

/*
Q.����ȭ����
����̳� ����ó�� ������,�ֹ�

������: seq_food
���̺��: foodshop
          jumun
          
foodshop
���������� �˾Ƽ� �ּ���
�����ʹ� �ּ� 5�� �̻� �ֱ�
fno, fname, price, fshopname, shoploc

jumun
-:�ܺ�Ű�� fno�� �ܺ�Ű�� ����(�θ����� ������ �ڵ������ǵ���)
order_num(������), order_name �ֹ����̸�, fno(���Ĺ�ȣ_�ܷ�Ű), order_addr �ֹ����ּ�


���䳪 ���ó�� ���(1:1 ī��)

����
order_num(�ֹ���ȣ),fno(���Ĺ�ȣ),order_name(�ֹ���),food_name(���ĸ�) 
,price(����),f_shopname(��ȣ��),shop_loc(������ġ),order_addr(�ֹ��� ��ġ)



*/

create SEQUENCE seq_food;--������ �Ϸ�

--foodshop���̺�: fno(���Ĺ�ȣ), fname(�����̸�), price(����), fshopname, shoploc
CREATE TABLE foodshop (
    fno number(5) CONSTRAINT foodshop_pk PRIMARY KEY ,
    fname VARCHAR(20),
    price number(10),
    fshopname VARCHAR(25),
    shoploc VARCHAR(35) 
);



insert into foodshop values(1,'�ܹ���', 7000, '������ġ', '����� ������');
insert into foodshop values(2,'����Ƣ��', 5000, '������ġ', '����� ������');
insert into foodshop values(3,'������ġ', 6000, '���� ������ġ', '����� ���ʱ�');
insert into foodshop values(4,'������', 8000, '���ⶱ����', '����� ������');
insert into foodshop values(5,'��¡��Ƣ��', 3000, '���ⶱ����', '����� ������');

commit;


--��� �ֹ�jumun ���̺��ε� ���� �߸����� jumin���̺�� ��...
--jumin���̺�:order_num(������), order_name, fno(���Ĺ�ȣ_�ܷ�Ű), order_addr

CREATE TABLE jumin (
    order_num number(5) CONSTRAINT jumin_pk_onum PRIMARY KEY,
    order_name VARCHAR(25),
    fno number(5),
    order_addr VARCHAR(25),
    CONSTRAINT jumin_fk_fno FOREIGN KEY (fno) REFERENCES foodshop(fno)  ON DELETE CASCADE  --
);


insert into jumin values(seq_food.nextval,'ȫ�浿',1,'����� ������');
insert into jumin values(seq_food.nextval,'���̵�',2,'����� ���α�');
insert into jumin values(seq_food.nextval,'�ּ���',3,'����� �߱�');
insert into jumin values(seq_food.nextval,'��浿',4,'����� ���빮��');
insert into jumin values(seq_food.nextval,'��浿',5,'����� ���빮��');

select * from jumin;
select * from foodshop;

--�������� �����ֱ�
select order_num �ֹ���ȣ, f.fno ���Ĺ�ȣ, order_name �ֹ���, fname ���ĸ�, 
price ����, fshopname ��ȣ��, shoploc ������ġ, order_addr "�ֹ��� ��ġ"
from foodshop f, jumin j
where f.fno = j.fno
order by order_name; --�ֹ����� �������� ����


--drop ���̺�� ���̺��� ������ �������� ������ �ڽ� ���̺��� ���� �������Ѵ�.
--drop table jumin;  
--drop table foodshop;

--������ delete�� ���� �����͸� ���� ���, �ڽ� ���̺� on delete casade�� ������, 
--�ڽ����̺�� �θ� ���̺��� �ܷ�Ű�� ���� �ִ��� ������� �ڽ� ���̺��� ������ ���� �� �ִ�.
--��: �Ϻ� �Խ��� ���ۿ� ���� ����� �޸�, ���� �� �� ������ ������� ���� �� ���°�� 
--> "�Խñۿ� ����� �־ �Խñ��� ���� �� �����ϴ�."
--�̷� ������ ���� ����  "ON DELETE CASCADE" �� ������� �ʾƼ� �̷�!!!