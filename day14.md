#DAY14
___

###database
>관계형 : 테이블(table)
- 열(속성)
- 도메인 : 필드를 뺀 같은 성격의 열
- 레코드(튜플)

>계층형 : 
>네크워트형 :

>file=> database =>databank
>

###제약조건(2)
>between
>check
>default
>

###select 
1) delete
> delete tablename [where 조건문]
> 레코드 삭제

	select * from test;
	delete test;--레코드 전체 삭제
	insert into test values(1,'sj');
	insert into test values(2,'happy');
	insert into test values(3,'sleep');
	delete test where no=2;
---
2)insert 
	
	select * from multi;

	insert into multi values('sj', 22,'서초구');--순서를 모를때 적은 순서 맞춰서
	insert into multi(name, address, age) values('aa','서초',23);
	insert into multi(name, age) values('cc',23);--원하는 필드만

3) update
> 레코드 수정

	update professor set name='이도연';--주의 : 전체 레코드 수정
---
	update professor set name='조인형' where name='sujeong';
	update professor set name='조인형',id='aa', deptno=103 where name='조인형'; --여러개 바꾸기

4) drop
>table 삭제

	drop table test;--table 자체 제거
    
5)rollback

    select * from professor;
	update professor set name='이도연';
	rollback;
---
5)commit
	select * from emp2;
	delete emp2;
	rollback; --실행했던 명령 취소
	commit;--실행했던 명령 완료

	select * from emp2 where hobby='음악감상';
	delete emp2 where hobby='음악감상';--조건에 맞는 레코드 삭제
	commit;-- 커밋 명령 후 복구 불가

---
6)truncate
>truncate tablename
>모든 레코드 삭제

	


###연산자
mod

between

in--권장

is null/ is not null


###연습문제

--직책 중에 정교수->전임교수/pay<100이하 5%인상

	update professor set position='전임교수' where position='정교수';
	update professor set pay=pay*1.05 where pay<=300;

--homepage null 표시 삭제

	update professor set hpage=' ' where hpage is null; --공백 넣기...를 잘 기억해라 나렉...
    
--bonus에서 null 표시 0으로 표시

	update professor set bonus=0 where bonus is null;
    update professor set bonus=nvl(bonus,10) where bonus =0; --nvl() 함수
    
--emp2 취미 술 => 음주가무 변경

	select * from emp2;
	desc emp2;
	update emp2 set hobby='음주가무' where hobby ='술';

--emp2 이씨 성 가진 모든 사람들 중에 계약직 사람들 인턴직

	select * from emp2 where name like '이%';
	update emp2 set emp_type='인턴직' where emp_type='계약직' and name like '이%';
    
---
    
###집계함수(그룹함수)
1)sum(컬럼명)
>합계

	select sum(weight) as "몸무게 합", avg(weight) as 평균 from student;
---
2) avg(컬럼명) 
>평균(null값은제외하고나눔)
	
    select avg(pay), max(pay),min(pay), count(pay) from professor;
---
3 )max(컬럼명) 
>최대값

	select max(pay) from professor;

---
4) min(컬럼명) 
>최소값

	select min(pay) from professor;
---    
5) count(컬럼명) 
>count(*) => null을포함한총레코드수

	select count(*) from professor;--null 포함 레코드 개수
>총 레코드수(null값은제외함)

	select count(bonus) from professor; --null 미포함 레코드 개수
    
6) rank
>rank(expr) whithin group(order by 컬럼명asc | desc )
=> 전체값을 대상으로 각 값의 순위를 구함.

7) group by 칼럼명(그룹화)
>그룹 함수는 일반 필드(사용자 정의)와 같이 쓸 수 없다. => 일반 필드 그룹화 필요

	select name, avg(pay), max(pay),min(pay), count(pay) from professor  group by name;--그룹화



--문제 학년별 키, 몸무게 합

	--나
    select sum(weight), sum(height) from student where grade=1;
	select sum(weight), sum(height) from student where grade=2;
	select sum(weight), sum(height) from student where grade=3;

	--쌤
	select grade,sum(weight), sum(height) from student group by grade;

---
###join
>select 칼럼명 from 테이블 명  join 테이블 명	on 조건;
>두 개 이상의 테이블을 하나의 테이블로 만들어 한 번의 검색으로 여러 컬럼의 정보를 확인할 때 사용
>pk_fk 관계에서 만 가능
>fk에 들어가는 정보는 pk에 있는 정보 내 것을 벗어나면 안됨.
>pk 키의 필드가 사라지면 fk(참조)하는 필드도 삭제
- inner( = ) : 양쪽에 공통된 것만 출력
- outer : left(*=)/ right(=*) / full
 - left : 왼쪽에 있는 데이터는 모두, 오른쪽에 있는 데이터는 칼럼가 일치하는 것만 출력
 - right : 
 - full : 

---
	select * from emp;
	select * from dept;
	-- 공통 : deptno

	select ename, job, sal, deptno , dname, loc
	from emp e, dept d;--에러 deptno 가 양쪽에 있으므로 에러

	select ename, job, sal, d.deptno , dname, loc
	from emp e join dept d
	on e.deptno=d.deptno;--디폴드 : inner join, deptno 가 일치하는 것만 출력


	select ename, job, sal, d.deptno , dname, loc
	from emp e left outer join dept d
	on e.deptno=d.deptno;--왼쪽에 있는 데이터는 모두, 오른쪽에 있는 데이터는 deptno가 일치하는 것만 출력
 
	select ename, job, sal, d.deptno , dname, loc
	from dept d left outer join emp e
	on e.deptno=d.deptno; --
 
	select ename, job, sal, d.deptno , dname, loc
	from dept d right outer join emp e
	on e.deptno=d.deptno;

