--day0125 _stu

select * from company;
select * from c_sawon;
select * from c_sawon2;

--ON DELETE CASCADE (feat. foreign key 로 연결된 row 한 번에 지우는 방법) 
--부모글 삭제시 그 부모글의 자식글도 자동으로 삭제됨

--부모테이블의 10번 id 삭제해보자 될까?=>오류나고 안지워짐(자식 레코드가 발견되었습니다.)
delete from company where company_id = 10;

--자식레코드 없는 30번 id삭제해보자
delete from company where company_id=40;

--아까우니까 롤백(뒤로가기 기능이다.)
rollback;

--자식글이 있어도 원글삭제 가능하도록 만들기(on delete cascade: 부모글을 지우면 그 자식레코드로 삭제)
create table c_sawon2(company_id number(5),
sawon_name varchar2(20),position varchar2(20),
email varchar2(20), hp varchar2(20),
CONSTRAINT c_sawon2_fk_id foreign key(company_id) references company(company_id) on delete cascade);

--c_sawon2에 역시 추가3개
insert into c_sawon values(20,'윤미래','대리','yoon@naver.com','011-444-5555');

--c_sawon 모든레코드 삭제
delete from c_sawon;

--c_sawon2에서는 부모글의 자식글이 등록된것이있다. 이럴경우라도 삭제될까?
delete from company where company_id=20;


--------------------------
--day0125 _stu

/*
[0125 정규화 릴레이션 및 레코드작성및 삭제연습]

오라클 조인
1.outer join : 조건에 일치하지 않아도 출력
2.self join : 자신의 테이블과의 조인
3.inner join : 기본키(primary key)와 외부키(foreign key)를 사용해서 join(가장많이 사용)

on delete cascade: 
  외부키로 테이블로 연결되었다 하더라도 
  부모테이블의 데이터를 삭제하면 
  자식테이블의 데이터까지도 자동으로 삭제시켜주는 기능

*/
--테이블 삭제(자식테이블 먼저 삭제 후 부모테이블 삭제)
/*
drop table c_sawon2;--삭제
drop table companysawon;--삭제
drop table company;--삭제
drop table c_sawon;--삭제
drop table test;--삭제
*/
-----------

--day0125 _stu

--시퀀스 먼저 생성
create SEQUENCE seq_shop;

--shop 테이블 (부모테이블)
create table shop(num number(5) primary key, 
sangpum varchar2(30), color varchar2(30));

--shop 에 insert 상품추가
insert into shop values(seq_shop.nextval,'요가매트','핑크');
insert into shop values(seq_shop.nextval,'아령','블랙');
insert into shop values(seq_shop.nextval,'레깅스','베이지');
insert into shop values(seq_shop.nextval,'요가나시','화이트');
insert into shop values(seq_shop.nextval,'양말','블루');

--최종저장
commit;


--cart1 테이블, 상품정보는 shop테이블의 num값을 외부키로 지정한다.
create table cart1(idx number(5) primary key,
num number(5) CONSTRAINT cart_fk_num REFERENCES shop(num),
cnt number(5), guipday date);

--cart2 테이블, 상품정보는 shop테이블의 num값을 외부키로 지정한다.
--부모테이블 상품지우면 그 상품과 연결된 카트를 자동으로 지워준다.
create table cart2(idx number(5) primary key,
num number(5),
cnt number(5), guipday date,
CONSTRAINT cart_fk2_num foreign key(num) REFERENCES shop(num) on delete cascade);

--cart1에 상품추가,1번 상품 카트에 담기
insert into cart1 values(seq_shop.nextval,1,2,sysdate); --1번 요가매트 2개 추가
--cart1에 상품추가,5번 상품 카트에 담기
insert into cart1 values(seq_shop.nextval,5,10,sysdate); --5번 양말 10켤레 추가
--shop에 없는 상품을 cart1에 추가=>오류
insert into cart1 values(seq_shop.nextval,6,10,sysdate); --6번(없는상품) 10개 추가

--cart2담기..상품3번 카트담기
insert into cart2 values(seq_shop.nextval, 3,4,sysdate);
insert into cart2 values(seq_shop.nextval, 2,2,sysdate);

--최종저장
commit;


--cart1에는 1번 5번 상품이 추가되었다.

--shop에서 1번이 삭제되는지 확인?
delete from shop where num=1;
--ORA-02292: 무결성 제약조건(STU.CART_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었

--4번상품은 아무도 안남았으므로 오류만 난다.
delete from shop where num=4;

--아까우니까 살린다.
rollback;


--cart2에는 2번 3번 상품이 담겨있다.
--cart2에 담긴 2번 상품이 있더라도 shop에서 2번 상품은 삭제가 될까요?
--답:yes
delete from shop where num=3;

rollback;


--join을 위해서 cart2에 데이타 조금더 추가하자.
insert into cart2 values(seq_shop.nextval,1,3,sysdate);
insert into cart2 values(seq_shop.nextval,5,10,sysdate);
insert into cart2 values(seq_shop.nextval,1,1,sysdate);
insert into cart2 values(seq_shop.nextval,1,2,sysdate);

--cart1에 담긴 상품을 shop테이블과 join해서 자세히 출력해보자.
--방법1
select cart1.idx, shop.sangpum, shop.color, cart1.cnt, cart1.guipday
from shop,cart1
where shop.num = cart1.num;

--방법2
select c.idx, c.num, s.sangpum, s.color, c.cnt, c.guipday
from shop s, cart1 c
where s.num = c.num;

--방법3
select idx, c.num, sangpum, color, cnt, guipday
from shop s, cart1 c
where s.num = c.num;


--cart2 편한 방식으로 join 출력해보자.
select idx,c.num,sangpum,color,cnt,guipday
from shop s,cart2 c
where s.num = c.num;


select * from shop;
select * from cart2;
select * from cart1;

---------------------------------------------


--foreign key & join

--bno:게시판 번호
create table board (bno number(3) CONSTRAINT board_pk_bno primary key,
writer varchar2(30),subject varchar2(50), writeday date);


--board의 insert
insert into board values(seq_sawon.nextval, '재슥이','우리 모임관련',sysdate);
insert into board values(seq_sawon.nextval, '기쁨이','스터디모임',sysdate);
insert into board values(seq_sawon.nextval, '영재이','다이어트 관련부록',sysdate);
insert into board values(seq_sawon.nextval, '먹는게 희망','점심먹자오늘',sysdate);
insert into board values(seq_sawon.nextval, '늘피곤','오늘 저녁에 만나자',sysdate);

commit;

--answer라는 테이블을 생성, bno는 board의 외부키로 설정하고
--부모테이블 글 지우면 그 글에 달린 댓글은 자동으로 삭제되도록
create table answer(num number(5) CONSTRAINT answer_pk_num primary key,
bno number(3) CONSTRAINT answer_fk_bno REFERENCES board(bno) on delete cascade,
nickname varchar2(20), content varchar2(50));

--원하는 글번호에 댓글 추가하기
insert into answer values (seq_sawon.nextval,21,'명수','야 나도 나가도 되니?');
insert into answer values (seq_sawon.nextval,23,'살찐토끼','다이어트 관심있어여ㅠㅠ');
insert into answer values (seq_sawon.nextval,23,'살빼야','저도 부록좀 보내주시겠어요?');
insert into answer values (seq_sawon.nextval,24,'중국집조아','점심메뉴로 짜장면 어때?');
insert into answer values (seq_sawon.nextval,21,'하하','재슥아 나좀 늦는다.');

commit;


--join해서 출력
--bno(글번호) writer(작성자) subject(제목) nickname(댓글단사람) content(댓글내용) writeday(원글작성날짜)

select b.bno 글번호, writer 작성자, subject 제목, nickname 댓글단사람,content 댓글내용, writeday 원글작성날짜
from board b, answer a
where b.bno = a.bno;

--원글21번 삭제후 answer테이블 댓글 사라졌는지 확인할것
delete from board where bno=21;



select * from board;
select * from answer;


--2개 테이블 삭제 : 자식테이블 삭제 후 부모테이블 삭제
drop table answer;--자식테이블
drop table board;--부모테이블

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
    fno number(5) CONSTRAINT foodshop_pk PRIMARY KEY ,
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
    CONSTRAINT jumin_fk_fno FOREIGN KEY (fno) REFERENCES foodshop(fno)  ON DELETE CASCADE  --
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


--drop 테이블로 테이블을 통으로 날릴려면 무조건 자식 테이블을 먼저 지워야한다.
--drop table jumin;  
--drop table foodshop;

--하지만 delete문 같이 데이터만 지울 경우, 자식 테이블에 on delete casade가 있으면, 
--자식테이블과 부모 테이블이 외래키로 엮여 있더라도 상관없이 자식 테이블의 내용을 지울 수 있다.
--예: 일부 게시판 뻘글에 누가 댓글을 달면, 내가 쓴 내 뻘글을 마음대로 지울 수 없는경우 
--> "게시글에 댓글이 있어서 게시글을 지울 수 없습니다."
--이런 문구가 나올 때는  "ON DELETE CASCADE" 을 사용하지 않아서 이래!!!