#DAY 15
___

###레코드 복사
>전체 복사 형식
>
	ceate table tablename
	as
	select 필드명,... from 테이블 이름
>    => 제약 조건자체가 복사되지 않음

>구조물만 복사 형식
>
	create table 테이블 명 
    as 
    select * from  복사할 테이블 명 where 1=0;
	
    
---
	Ex)전체복사
    --emp 복사
	create table c_emp
	as 
	select * from emp;--전체 복사

	select * from c_emp;
---
	Ex2)deptno가 20번인 사람들만
	create table c_emp2
	as 
	select ename, job, deptno from emp where deptno=20;-- 복사
	select * from c_emp2;
    
---	
	Ex3) emp 부서가 30번인 empno, ename, job,sal 복사
	create table c_emp3
	as
	select empno, ename, job, sal from emp where deptno=30;
	select * from c_emp3;
---
    Ex4) 교수테이블에서 전임강사만 추출하여 테이블 생성
	select * from professor ;
	create table pror_te
	as
	select * from professor where position='전임강사';

---

	Ex5) emp 에서 매니저 번호가 7566번인 사람만 추출하여 새로운 테이블 생성
	select * from emp ;
	desc emp;--mgr 타입 확인
	create table emp_manager
	as select * from emp where mgr=7566;

	SELECT * FROM emp_manager;
    
---
	Ex6) 구조물만 복사
    create table emp_str 
    as 
    select * from emp where 1=0;
	select * from emp_str;
    
    ++참고 order by 필드 번호
    select * from emp where empno ='7369';
	select * from emp where 1=0;
	select * from emp order by ename desc;
	select * from emp order by 2 desc;--해당 필드의 번호로 호출 가능
    

###union
> 두개의 테이블의 레토드를 합침(중복제거)

	select * from emp 
	union select * from c_emp;

	insert into c_emp values(7788, 'kingsmall', 'manager', '7777','02/01/17', 5000,10000,50);


	select empno, ename, job, sal from emp --필드 개수가 맞지 않음, data 타입 일치 필요
	union 
	select * from c_emp4;--query block has incorrect number of result columns

	select empno, ename, job, hiredate from emp --에러 sal은 number 타입, data 타입 일치 필요
	union 
	select * from c_emp4;

	select empno, ename, job, mgr from emp --필드 개수가 맞지 않음, data 타입 개수 일치 필요
	union 
	select * from c_emp4;


>union all

	select * from emp 
	union all --중복형 제거
	select * from c_emp;


###서브쿼리
>
>

	서브 쿼리 
	select * from emp2;
	select * from emp2 where name='백원만';

	select * from emp2 where pay>60000000;
	=>서브쿼리 : select 문 안에 select문
	select * from emp2 where pay> (select pay from emp2 where name='백원만');


###View
> 가상테이블
> 보안을 위해 사용함


	create view v_emp
	as select empno, ename, deptno from emp;

	select * from v_emp;
	drop view v_emp;--emp 그대로임
	drop table emp;--v_emp 도 파괴됨

	Ex)30번 부서 사원들의 직위, 이름 , 월급을 담는 view
	select * from emp;
	create view v_emp2
	as select empno, ename, job, sal from emp where deptno=30; 

	select * from v_emp2;

	--30부서 사원들의 직위 이름 월급을 담는 view 별치으 월금 3000이하
	create view v_emp3
	as 
	select empno 직원번호, ename 이름 , job 직위, sal 급여 from emp where deptno=30 and sal >2000; 


	--부서별 최대급여, 최소급여, 평균 급여 view 
	--주의 : 실제로 테이블이 생성될 때 그룹함수는 자체가 필드명이 될 수 없어서 해당 별칭이 필요

	create view v_emp4
	as 
	select max(sal) 최대,min(sal) 최소,avg(sal)평균 from emp group by deptno;

	--student 학년별 평균키 165 이상 몸무게 60이상 사람들만 출력
	--조건 where / having
	--group by 에는 having(where 사용 불가)
	--round 소수점 개수 지정
	create view v_student_grade
	as
	select grade 학년, round(avg(height),0) "평균 키", avg(weight) "몸무게" from student 
	group by grade
	having avg(height)>=165 and avg(weight)>=60;
	select * from v_student_grade;

###sequence

>자동 칼럼 넣기 sequence
>형식 : 
>- create sequence 시퀀스이름--1부터시작
start with 시작값
increment by 증가치
maxvalue 최대값
minvalue 최소값;

	drop SEQUENCE autonum;

	create sequence seq_broadNum
	start with 10
	increment by 10
	maxvalue 100 
	minvalue 0;
	
    ex)
	select autonum.nextval from dual;

	select autonum.currval from dual;

	create table Multi_T(
	no number,
	name varchar2(10)
	)segment creation immediate;

	create SEQUENCE autonum;

	select * from multi_T;--구조 확인
	insert into multi_t values(autonum.nextval,'aa');
	insert into multi_t values(autonum.nextval,'bb');
	insert into multi_t values(autonum.nextval,'cc');

	select * from multi_T;--구조 확인
	insert into multi_t values(SEQ_BROADNUM.nextval,'dd');
	insert into multi_t values(SEQ_BROADNUM.nextval,'ee');
	insert into multi_t values(SEQ_BROADNUM.nextval,'ff');
	insert into multi_t values(SEQ_BROADNUM.nextval,'gg');
	delete multi_t where name='ff';--중간 번호 삭제