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
    fno number(5) CONSTRAINT foodshop_pk PRIMARY KEY,
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
    CONSTRAINT jumin_fk_fno FOREIGN KEY (fno) REFERENCES foodshop(fno) 
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


drop table jumin;
drop table foodshop;

