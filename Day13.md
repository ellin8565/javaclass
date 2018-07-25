#DAY13
____

cmd => \\\70.12.112.50(ip) or M1201INS(name)
접속 : http://70.12.112.50/
id : java
pw : java
happydoyeon88@gmail.com
010-9872-0202
___

###oracle database 설치

>1.oracle 다운
>(http://blog.naver.com/PostView.nhn?blogId=aristort&logNo=20177920427)
>2.sql developer 다운
>3.9.cmd창 : sqlplus "/as sysdba"
>4.alter user system identified by oracle;
>5.conn system/oracle
>6.show uesr
>7.create user 계정명 identified by 비밀번호;
>8.alter user 계정명  account lock;
>9.grant connect, resource to 계정명;



DML/DDL/DCL

JDBC

AWT/SWING

***

###데이터 베이스
>여러 사람에게 공유되어 사용될 목적으로 가지고 구조적인 방식으로 관리되는 데이터의 집합.
>- DBMS : 데이터를 정리하고 보관하기위한 용도로 사용


---
###SQL의 종류
>DQL :data Query language
>- 데이터 검색
==Ex) select-테이블 내 데이터 검색==

>DML : data manipulation Language
>- 데이터변경/추가
==Ex) Insert- 테이블에 데이터 삽입/ 입력
Update-기존 테이블 안의 데이터 수정
Delete-테이블의 데이터 삭제==


>DDL : data definition language
- DataBase 구조정의
==Ex)Create- 데이터 베이스 테이블 생성
Alter-데이터 베이스 테이블 재정의
Drop-데이터베이스 테이블 삭제 ==

>DCL : data Control Language
>- 권한지정, 제거
==Ex) Grant-테이블에 권한 부여
Revoke-부여한 권한 취소/회수==


######+참고 : 실행 원하는 코드  ctrl+enter

---
	select * from tab;
    //결과 -sj
    없음
    //결과 -admin
    table 출력
    
___
    --주석표시
	--table create
	--create table 테이블 명(필드명 자료형, 필트명 자료형(크기),...);
	create table test(
	no number,
	name varchar2(10));
    
    //출력
    Table TEST이(가) 생성되었습니다.
    
    
    
###파일 넣기
1)콘솔모드(cmd)로 파일 넣기
>프롬프트 변경 :
SQL> set sqlprompt "_user>"
conn sj/oracle; 

>파일 넣기 :
>SJ>@C:\Users\student\Desktop\oracleSQl\sampledata.sql

2) spldeveloper 
>워크시트 생성
>파일 끌어다 넣기
>ctrl+enter

###DataType
>문자형 
>- char(byte)
>- varchar2(byte): 4000byte 최대
>- '문자'
>
>숫자형
>- number(전체자리수, 소수점자리수):디폴트 4byte
>- int
>
>날짜형
>- sysdate
>- '년-월-일'


###테이블 생성
>create table 테이블 명()
	
    create table test(
	no number, -- 자료형 : number
	name varchar2(10)); --자료형 : char, varchar, varchar2

###테이블 구조확인
	desc test; --테이블 구조 보기

###제약조건
>**null** : 입력 불가(null)
>
>**not null** : 반드시 입력
>
>**constraint 별칭 primary key** :기본키
>-  null 불가, 중복불가

     
---
	
    create table test2(
	no number, -- 자료형 : number
	name varchar2(10) not null
	); 
    
	select * from test2;
	insert into test2 values(1,'sj');
	insert into test2(no) values(1);--오류 not null 조건
	insert into test2(name) values('강감찬');

	create table userlist(
	id varchar2(10) constraint id_pk primary key,--기본키
	name varchar2(10) not null);

	insert into userlist values('aa', 'sj');
	insert into userlist values('bb', 'bb');
	insert into userlist values('cc', 'sj');
	insert into userlist values('aa', '강감찬');--오류 : id 중복 불가
	select * from userlist;
    
---

###제공된 가상 테이블 :dual

	 select sysdate from dual;--가상 



###select
1) 원하는 것만 보기

	select * from emp2; -- * 전체보기
	select empno, name from emp2; --empno, name 원하는 필드만 보기
	select birthday, deptno , emp_type, position from emp2;
---
2) 필드명 바꿔서 보여주기
	
    select birthday as 생년월일, deptno "부서 번호",emp_type 타입, position 직위 from emp2;
    // 공백이 입력될시에 " " 반드시 입력, as 생략가능
---

3)중복 제거 : distinct

	select * from student;
	select DISTINCT grade from student; --중복제거
---
4)조건 검색 : where
	
>select * from professor where 조건;

---
	select * from professor where position ='정교수';
	select name, id,position from professor where position ='정교수';
	select * from professor where position ='정교수' and id='simson';--and
	select * from professor where position ='정교수' or id='sweety';--or

	--문제 : 부서번호 101인 것만 출력
	desc professor; --구조 확인 후 number 타입인 것을 확인
	select * from professor where deptno =101;
    select profno, id, hiredate, name, pay from professor where deptno =101 or pay>=550;
    
---
5)정렬 asc, desc

	select name, id from professor order by name asc;--asc 오름차순 (생략가능)
	select name, id from professor order by name desc;--내림차순 생략불가
    select name, id from professor order by name asc, id desc;
    --우선순위 name으로 정렬
---
6)조건 검색 like ... %.../ like ..._... 

>% : 모든 문자 검색=>단독으로 쓸수 없. like 연산자
>_ : 한 문자 검색=>단독으로 쓸수 없. like 연산자

	select name, id from professor where name like '김%';--% : 모든, _ : 한 문자 =>단독으로 쓸수 없. like 연산자
    
	select name, id from professor where name like '%정';--끝글자

	select name, id from professor where name like '_수%';--중간 글자

	select name, id from professor where name like '__';--이름 2글자

---

###예제 풀기
	
    --문제2 : 이름에서 '김영조' 인 사람들/ '김'씨 성을 가진 사람들/이름이 두글자인 사람

	select name, id from professor where name like '김영조';
	select name, id from professor where name like '김%';
	select name, id from professor where name like '__';
	
    --문제3 : id에 s or a글자가 들어가는 사람/ 전임강사
	select name, id, position from professor where id like '%a%';
	select name, id, position from professor where position ='전임강사';

	--문제 4 multi table 생성, 필드 name, age, address 

	create table multi(
	name varchar2(10),
	age number,
	address varchar2(100)
	);

	insert into multi values('sj', 22,'서초구');
	insert into multi values('sb', 22,'송파구');
	insert into multi values('je',24,'서초구');

	select * from multi;
	
    --문제5 : ppt p 15, 16
    select name|| '의 키는 '||height||' 몸무게는 '||weight||'입니다.' "학생의 키와 몸무게" from student;

	select name||'('||position ||'), '||name||''''||position||'''' "교수님들" from professor;