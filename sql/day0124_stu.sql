--day0124_stu

--[제약조건]
--제약조건 주어서 새로운 테이블 생성
create table sawon (num number(5) CONSTRAINT sawon_pk_num primary key,
name varchar2(20), 
gender varchar2(10),
buseo varchar2(30) CONSTRAINT sawon_ck_buseo check (buseo in ('개발부','인사부','교육부')),
pay number(10) default 1200000);


--시퀀스
create sequence seq_sawon;


--insert 10개정도 해주세요
insert into sawon values(seq_sawon.nextval, '이순신','남자','개발부',3450000);
insert into sawon values(seq_sawon.nextval, '이수지','여자','교육부',2560000);
insert into sawon values(seq_sawon.nextval, '김현영','여자','개발부',3250000);
insert into sawon values(seq_sawon.nextval, '권혁필','남자','개발부',2490000);
insert into sawon values(seq_sawon.nextval, '최민수','남자','인사부',4200000);
insert into sawon values(seq_sawon.nextval, '윤민수','남자','개발부',3900000);
insert into sawon values(seq_sawon.nextval, '김민지','여자','교육부',2890000);
insert into sawon values(seq_sawon.nextval, '이민기','남자','인사부',3490000);
insert into sawon values(seq_sawon.nextval, '최승철','남자','개발부',2890000);
insert into sawon values(seq_sawon.nextval, '최민지','여자','교육부',2450000);

--최종저장
commit;

--그룹함수 사용해서 테스트
--부서별 인원수와 최고급여 최저급여를 조회하시오.
select buseo 부서명, count(buseo) 부서인원수, max(pay) 최고급여, min(pay) 최저급여
from sawon
group by buseo;

--위의 쿼리문에 최고급여 최저급여에 화폐단위 붙이고 3자리 컴마도 나오게 해주세요.
select buseo 부서명, count(buseo) 부서인원수, to_char(max(pay),'L999,999,999') 최고급여, 
       to_char(min(pay),'L999,999,999') 최저급여
from sawon
group by buseo;


--부서별 인원수와 평균급여를 출력하시오.
--제복은 부서명, 인원수, 평균 급여라고 출력하시오.(인원수는 뒤에 '명'이라고 붙일것)
select buseo 부서명,count(buseo)||'명' 인원수, 
       to_char(avg(pay),'L999,999,999') "평균 급여"
from sawon
group by buseo;

--성별 인원수와 평균급여,최고급여,최저급여를 구하시오.
select gender 성별,count(gender) 인원수,round(avg(pay),0) 평균급여,
       max(pay) 최고급여,min(pay) 최저급여
from sawon
group by gender;

--부서별 그룹중에서 부서별 인원이 4명 이상인 경우만 출력하시오.(부서명,인원수,평균급여)
--group by와 연결된 조건은 having
select buseo 부서명, count(buseo) 인원수, round(avg(pay),0) 평균급여
from sawon
group by buseo
having count(buseo)>=4;


--제약조건 제거하기
--sawon테이블의 sawon_ck_buseo 를 제거해보자.
alter table sawon drop CONSTRAINT sawon_ck_buseo;

--제거했으므로 다른 부서도 insert해보기
insert into sawon values(seq_sawon.nextval,'송중기','남자','해외영업부',5840000);

--sawon의 name컬럼에 unique 제약조건 추가하기(sawon_uk_name)
--UNIQUE는 NOT NULL과 다르게 컬럼명을 다시 한번 더 명시해 주어야한다. UNIQUE(name)
ALTER table sawon add CONSTRAINT sawon_uk_name UNIQUE(name);


--delete from sawon where num=2;
select * from sawon;

------------------------------------------점심

--day0124_stu

/*
[DB정규화에 대해서 수업진행예정]

1.일단 비정규화된 테이블을 만들어서 데이터를 넣고 조회연습
2.그 이후에 다시 두개의 테이블로 나누어서 데이터를 넣고 외부키를 이용해서 연결해보자
3.데이터 삭제시 정규화된 테이블의 경우 문제가 발생할 수 있다.
  cascade연산자를 이용해서 테이블을 생성후 삭제할 수 있다.
*/

----[비정규화]
--비정규화된 테이블
--회사,직원 테이블; companysawon
--회사명: company 문자열(20)
--회사주소: address 문자열(30)
--회사전화: phone  문자열(20)
--직원명: sawon_name 문자열(20)
--직급: position 문자열(20)
--이메일: email  문자열(20)
--휴대폰: hp  문자열(20)

create table companysawon (company varchar2(20), address varchar2(30),
phone varchar2(20), sawon_name varchar2(20), position varchar2(20),
email varchar2(20), hp varchar2(20));

insert into companysawon values ('삼성','서울시 강남구','02-222-1234','홍길동','과장','hong@gamil.com','010-111-1234');
insert into companysawon values ('LG','서울시 서초구','02-111-1111','김신영','부장','kim@gamil.com','010-222-3333');
insert into companysawon values ('한화','경기도 용인시','031-222-1111','유민상','사원','you@gamil.com','010-125-4567');

--거래처 회사에 대한 정보를 거래처직원ㅇ르 내가 추가할때마다 모두 추가해야한다.. 즉 메모리 낭비가 심하다.
--회사를 이전 아니면 직급이 바뀌면 많은 데이터를 한번에 모두 수정해야하므로 정말 번거롭다.
--그래서 DB[정규화]가 필요하다. 거래처 회사 정보 따로 직원정보 따로 분리해서 만들어본다.

----[정규화]
--정규화 디자인
--회사아이디 : compant_id 숫자(5) 기본키
--회사명 : company 문자열(20)
--회사주소 : address 문자열(30)

create table company(company_id number(5) primary key,
company varchar2(20), address varchar2(30), phone varchar2(20));

--데이터 추가
insert into company values(10,'LG','서울시 서초구','02-111-2222');
insert into company values(20,'한화','경기도 용인시','031-222-1111');
insert into company values(30,'삼성','서울시 강남구','02-333-5555');

--거래처 직원 테이블: c_sawon
--직원명: sawon_name 문자열(20)
--직급: position 문자열(20)
--이메일: email  문자열(20)
--휴대폰: hp  문자열(20)
--회사아이디: company_id number(5) : 외부키(Foreign key)

create table c_sawon(company_id number(5), 
sawon_name varchar2(20), position varchar2(20),
email varchar2(20), hp varchar2(20),
CONSTRAINT c_sawon_fk_id foreign key(company_id) references company(company_id));

--위의 c_sawon테이블에 insert
insert into c_sawon values(10,'이성일','과장','lee@naver.com','011-111-4444');
insert into c_sawon values(20,'김미향','대리','kim@naver.com','011-222-4444');
insert into c_sawon values(30,'윤미래','대리','yoon@naver.com','011-444-5555');


--company와 관계되어진 테이블(c_sawon)에서 10,20번을 추가하였다.
--20번 한화를 지워보자
delete from company where company_id=20;

--30번 삭제..연결된 자식들이 없으므로 삭제에서 자유롭다.
delete from company where company_id=30;


select * from company;
select * from c_sawon;










