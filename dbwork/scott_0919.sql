-- scotrr 연습용 테이블로 조회 연습하기.

select * from emp; ----전체 테이블의 테이터 조회
select * from emp order by ename asc; -- ename의 오름차순으로 조회 (asc는 생략해도 됨)
select * from emp order by ename desc; -- ename의 내림차순으로 조회 (desc는 생략해도 됨)

select empno, ename from emp; --일부 column만 조회

select job from emp; --job column만 조회
-- 같은 직업일 경우 한번씩만 출력
select DISTINCT job from emp order by 1; -- column이 한개 이므로 job 대신 1이라고 써도 된다.

-- sal이 3000이상인 것만 조회
select * from emp where sal>=3000;  

-- sal이 2000이상이면서 deptno가 20인 사람 (nad)
select name, sal, deptno from emp where sal>=2000 and deptno = 20;

Select * from emp where ename like 'A%'; --A로 시작하는 모든사람

--'%'는 모든 이라는 의미.
Select * from emp where ename like '_A%';

Select * FROM emp where ename like '__A%';

--s로 시작하거나 -j로 시작하는 사람

Select * FROM emp where ename like 'S%' or  ename like 'J%';

