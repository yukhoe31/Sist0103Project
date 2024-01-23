--test 테이블
--primary key(not null + unique)
--구조보기
desc test;
--test에 전체 데이타 insert
insert into test values(1,'유재석',96.2,'1980-01-03');
--test 조회
select * from test;
--test에 일부 데이타 insert
insert into test(num,name) values(2,'박명수');
--일부컬럼만 조회
select num,name from test;
--현재날짜로 추가
insert into test values(3,'정형돈',87,sysdate);

--테이블에 age 컬럼추가 / 테이블에 컬럼추가
--☞ ALTER TABLE 테이블명 ADD 추가할컬럼명 데이터타입;
alter table test add age number(5);
--주소(addr)를 저장할 컬럼을 추가하는데 초기값을 강남구라고 지정
alter table test add addr varchar2(30) default '강남구';
--초기값이 구로구라고 들어갔는지 확인
insert into test (num,addr) values(4,'서울시 구로구');

--addr의 문자타입 늘려주기 / 테이블 컬럼의 타입변경
--☞ ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입;
alter table test modify addr varchar2(70);
--Q. age타입을 varchar2(10)변경하고 초기값을 '22'으로 설정하기
alter table test modify age varchar2(10) default '22';
--일부만 넣어서 나이 22로 들어가는지 확인
--기존 null로 들어간것은 그대로 있고 새로 insert한것부터 초기값이 들어감
insert into test (num,name,score,birth) values(6,'정형돈',87,sysdate);

--num의 오름차순 출력
select * from test order by num;
--num의 내림차순 출력
select * from test order by num desc;

--age컬럼 삭제
--☞ ALTER TABLE 테이블명 DROP COLUMN 삭제할컬럼명
alter table test drop column age;
--addr컬럼 삭제
alter table test drop column addr;

--birth를 birthday로 수정 / 테이블 컬럼의 이름변경
--☞ ALTER TABLE 테이블명 RENAME COLUMN  OLD컬럼명 TO NEW컬럼명;
alter table test rename column birth to birthday;

--score 를 jumsoo로 변경
alter table test rename column score to jumsoo;

desc test;
--저장
commit;

--테이블삭제(늦게온사람은 하지말것)
--drop table test;

----------------------------------

--시퀀스를 기본으로 생성 (★보통은 아래 내용 필요없이 이것만으로 충분)
create sequence seql;

--시퀀스 확인
select * from seql;

--다음 시퀀스 값을 발생시켜 콘솔에 출력
select seql.nextval from dual;

--현재 마지막 발생 시퀀스
select seql.currval from dual;

--seql삭제
drop sequence seql;

--10부터 5씩 증가하는 시퀀스를 생성하기 -cache값은 없애기
create sequence seq1 start with 10 increment by 5 nocache;

--시퀀스 발생
select seq1.nextval from dual;

--시퀀스 수정, start with는 수정불가, maxvalue 지점후 그값까지 나오면 다시 처음부터 나오게 할때
alter sequence seq1 increment by 10 maxvalue 100 cycle;

--시퀀스 삭제 
drop sequence seq1;


-------------------------------

--seq1 : 시작값 5, 증가값 2, 끝값 30 캐시 no cycle yes
create sequence seq1 start with 5 increment by 2 maxvalue 30 nocache cycle;

--seq2 : 시작값 1, 증가값 2, 캐시 no
create sequence seq2 start with 1 increment by 2 nocache;

--seq3 : 시작값 1, 증가값 1, 캐시 no
create sequence seq3 nocache;

--시퀀스 출력
select seq1.nextval,seq2.nextval,seq3.nextval from dual;

--시퀀스 삭제 
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

-------------------------------------
-------------------------------------

--시퀀스 생성
create sequence seq_person;

--테이블 생성
create table person(num number(5) primary key, pname varchar2(20),
job varchar2(30), gender varchar(10), age number(5), hp varchar2(20), 
birth date);

--birth를 ipsady로 변경
alter table person rename column birth to ipsaday;

--구조확인
desc person;

--delete from person;

--nextval: 겹치지 않는 다음 값을 발생시킨다.
--조회연습을 위해서 insert(프로그래머,교사,엔지니어,기타  남자,여자 )최소 10개 이상씩 넣어주러.
insert into person values(seq_person.nextval,'이수연','프로그래머','여자',33,'010-111-2222','2021-01-02');
insert into person values(seq_person.nextval,'김영철','교사','남자',30,'010-222-2222','2022-01-02');
insert into person values(seq_person.nextval,'이범수','엔지니어','남자',28,'010-123-5489','2021-09-25');
insert into person values(seq_person.nextval,'윤미래','회계사','여자',28,'010-444-7777','2018-01-01');
insert into person values(seq_person.nextval,'윤계상','프로그래머','남자',33,'010-458-1245','2020-05-01');
insert into person values(seq_person.nextval,'김미라','엔지니어','여자',29,'010-888-1111','2023-08-11');
insert into person values(seq_person.nextval,'이미라','프로그래머','여자',33,'010-147-7412','2023-07-21');
insert into person values(seq_person.nextval,'주영환','교사','남자',28,'010-897-3256','2022-06-21');
insert into person values(seq_person.nextval,'김영환','교수','남자',35,'010-145-2289','2023-06-21');
insert into person values(seq_person.nextval,'이수연','프로그래머','여자',35,'010-145-1111','2022-06-21');
--최종저장
commit; 

--최종인원 확인
select count(*) from person;

--이름 오름차순으로 출력
select * from person order by pname; --asc는 생략 가능

--나이 역순 출력
select * from person order by age desc;
select * from person order by 5 desc; --5열 역순 출력 = 나이 역순 출력

--gender 오름차순 같을 경우 이름 오름차순
select * from person order by gender, pname;

--직업만 출력
select job from person;

--직업만 출력, 중복 제거
select distinct job from person;

--이름이 이미라인 사람만 출력
select * from person where pname = '이미라';

--이름 두번째 글자 가운데가 '수'인사람 출력
select * from person where pname like '_수%';

--성이 김씨인 사람만 출력
select * from person where pname like '김%';

--핸드폰 마지막이 1111로 끝나는 사람 출력
select * from person where hp like '%1111';

--입사월이 1월인 사람만 출력
select * from person where to_char(ipsaday, 'mm') = '01';

--입사년도가 2024년인 사람을 출력하시오
select * from person where to_char(ipsaday, 'yyyy') = '2023';

--나이가 25~30 사이인 사람만 조회(2가지)
select * from person where age between 25 and 30;
select * from person where age>=25 and age<=30;

--직업이 교사이거나 프로그래머인 사람 출력(2가지)
select * from person where job in ('프로그래머', '교사');
select * from person where job='프로그래머' or job='교사';

--성이 김씨이거나 이씨인 사람을 조회하시오.
select * from person where pname like '김%' or pname like '이%';

--여자이면서 나이가 30세 이상인 사람 조회
select * from person where gender='여자' and age>=30;

--평균나이구하기(소수점 2자리)
select round(avg(age),2) from person;

--평균나이보다 많은 사람의 이름과 직업,나이를 구하시오.(서브쿼리)
select pname,job,age from person where age >= (select avg(age)from person);

select * from person;


--person의 테이블 복사본 생성하기 person3
create table person3 as select * from person;

--직업과 나이 수정하기.. 조건을 안쓸시 모든 데이터 수정..조건필수
update person3 set job='간호사', age = 22;

--위에서 잘못수정한 데이터 원래대로 되돌리기
Rollback;

--3번의 직업 나이 수정하기
update person3 set job='간호사', age = 22 where num=3;

--김씨이면서 교수인 사람의 젠더를 여자로 수정하기
update person3 set gender='여자' where pname like '김%' and job='교수';

--num이 8번인 사람의 직업을 프로게이머 입사일을 24/01/01로 변경하세요.
update person3 set job='프로게이머', ipsaday='2024-01-01' where num=8;

--최종저장
commit;

--삭제
--num 5번 삭제
delete from person3 where num=5;



--여자 중에서 나이가 33세 이상만 모두 삭제하시오.
delete from person3 where gender ='여자' and age>=33;

--핸드폰 뒷자리가 111인 사람의 나이를 39살,입사일을 22/01/01로 수정하시오.
update person3 set age=39,ipsaday='2022-01-01' where hp like '%1111';

--직업이 간호사이거나 엔지니어인 사람 모두 삭제
delete from person3 where job='간호사' or job='엔지니어';

select * from person3;


--drop table person3;


--컬럼을 추가하는데 주소 addr 30바이트 문자열로 추가하라 (기본값은 서울시)
alter table person3 add addr varchar(30) default '서울시';

--컬럼명 변경 hp==>handphone
alter table person3 rename column hp to handphone;

--데이터 추가하는데 일부만 넣기(num,pname,gender,job)
insert into person3 (num,pname,gender,job)values(seq_person.nextval,'김선아','여자','연예인');

--데이터 추가하는데 일부만 넣기(num,pname,addr,ipsaday)
insert into person3 (num,pname,addr,ipsaday)values(seq_person.nextval,'윤미영','대구시','2021-01-24');

--null일경우 정해진 값으로 출력합니다.(NVL이용, 직업이 null인 경우 무직으로, 나이가 null인경우 20으로 출력)
select pname 이름, NVL(job,'무직') 직업,NVL(age,20) 나이 from person3;

--핸드폰이 null인경우 ****로 출력
select pname 이름, NVL(handphone,'****') 핸드폰번호 from person3;
--

select * from person3;




