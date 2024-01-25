------------------------------

/*
Q.정규화문제
배민이나 요기요처럼 음식점,주문

시퀀스: seq_food
테이블명: foodshop
          jumun
          
foodshop
제약조건은 알아서 주세여
데이터는 최소 5개 이상 넣기
fno, fname, price, fshopname, shoploc

jumun
-:외부키는 fno를 외부키로 설정(부모데이터 삭제시 자동삭제되도록)
order_num(시퀀스), order_name 주문자이름, fno(음식번호_외래키), order_addr 주문자주소


요기요나 배민처럼 출력(1:1 카톡)

순서
order_num(주문번호),fno(음식번호),order_name(주문자),food_name(음식명) 
,price(가격),f_shopname(상호명),shop_loc(상점위치),order_addr(주문자 위치)



*/

create SEQUENCE seq_food;--시퀀스 완료

--foodshop테이블: fno(음식번호), fname(음식이름), price(가격), fshopname, shoploc
CREATE TABLE foodshop (
    fno number(5) CONSTRAINT foodshop_pk PRIMARY KEY,
    fname VARCHAR(20),
    price number(10),
    fshopname VARCHAR(25),
    shoploc VARCHAR(35) 
   
);



insert into foodshop values(1,'햄버거', 7000, '맘스터치', '서울시 강남구');
insert into foodshop values(2,'감자튀김', 5000, '맘스터치', '서울시 강남구');
insert into foodshop values(3,'샌드위치', 6000, '조스 샌드위치', '서울시 서초구');
insert into foodshop values(4,'떡볶이', 8000, '엽기떡볶이', '서울시 강동구');
insert into foodshop values(5,'오징어튀김', 3000, '엽기떡볶이', '서울시 강동구');

commit;


--사실 주문jumun 테이블인데 내가 잘못보고 jumin테이블로 씀...
--jumin테이블:order_num(시퀀스), order_name, fno(음식번호_외래키), order_addr

CREATE TABLE jumin (
    order_num number(5) CONSTRAINT jumin_pk_onum PRIMARY KEY,
    order_name VARCHAR(25),
    fno number(5),
    order_addr VARCHAR(25),
    CONSTRAINT jumin_fk_fno FOREIGN KEY (fno) REFERENCES foodshop(fno) 
);


insert into jumin values(seq_food.nextval,'홍길동',1,'서울시 강남구');
insert into jumin values(seq_food.nextval,'박이동',2,'서울시 구로구');
insert into jumin values(seq_food.nextval,'최서동',3,'서울시 중구');
insert into jumin values(seq_food.nextval,'김길동',4,'서울시 서대문구');
insert into jumin values(seq_food.nextval,'김길동',5,'서울시 서대문구');

select * from jumin;
select * from foodshop;

--최종내역 보여주기
select order_num 주문번호, f.fno 음식번호, order_name 주문자, fname 음식명, 
price 가격, fshopname 상호명, shoploc 상점위치, order_addr "주문자 위치"
from foodshop f, jumin j
where f.fno = j.fno
order by order_name; --주문자의 오름차순 순서


drop table jumin;
drop table foodshop;

