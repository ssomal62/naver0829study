--방법1
select ename,sal,comm from emp where sal>=1000 and sal <= 2000;

--방법2
select ename,sal,comm from emp where sal BETWEEn 1000 and 2000;

select ename, sal, comm from emp where sal<1000 or sal>2000;

select * from emp where comm is null;

select * from emp where comm is not null;

select ename, sal, comm, sal + comm from emp;  --숫자 +  null == null!!s

--NVL(컬럼명, 값) : 해당 컬럼값이 null 이면 0으로 출력.
select ename, sal, NVL(Comm,0), sal+NVL(comm,0) from emp;

--나중에 자바로 가져갈 경우 컬럼 인덱스 컬럼명으로 가져간다. 그래서 컬럼명이 복잡한 경우 별칭 지정을 한다.
select ename as "사원명" , sal as "연봉" from emp; -- 단 공백이 없을 경우 as "" 생략 가능
select ename 사원명, sal 연봉 from emp;
select empno "사원 번호", sal 사원명 from emp;

select ename 사원명, sal 연봉, NVL(comm,0)수수료, sal + NVL(comm,0) 총연봉 from emp;

select count(*) from emp;  -- 컬럼명이 'conut(*)'이라고 나옴.
select count(*) count from emp; -- 오 이름 재정의.

--문자열을 이어서 출력 >> '||' 사용
select ename||'의 직업은 '||job||'입니다.' member from emp;

select * from emp;

select ename||'의 연봉은'||(sal + NVL(comm,100)) ||'입니다.' "회원 연봉" from emp;

--sql에서 큰따옴표는 엘리어서? 에서만 쓸 수 있음 나머지는 무조건 작은 따옴표!!

--empno 여러개 조회
select empno, ename from emp where empno = 7369 or empno = 7788 or empno = 7900;

-- 여러개 조회 시 'in'을 사용해서 할 수 있음

select empno, ename from emp where empno in (7369,7788,7900);

select empno, ename from emp where empno not in (7369,7788,7900);

select ename, job from emp where job in('SALESMAN','ANALYST');

select * from emp where hiredate = '80/12/17';

select * from emp where hiredate = '1980-12-17';

SELECT * FROM EMP WHERE HIREDATE >= '1980-01-01' AND HIREDATE <= '1981-10-10';

-- 현재 날짜 조회
select sysdate from dual;

select sysdate+1 from dual;

SELECT to_char(sysdate, 'yyyy-mm-dd') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd hh:mi') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd') FROM dual;

--emp에서 ename, hiredate(yyyy-mm-dd) 를 출력하는데 1981에서 입사한 사람만 출력
SELECT ename 사원명, to_char(hiredate,'yyyy-mm-dd') 입사일 FROM emp 
    WHERE to_char(hiredate,'yyyy')=1981;
    
select count(*) from emp;
select avg(sal) from emp;
select round(avg(sal),1) from emp;-- 보통 평균을 구할 때는 ROUND 함수와 같이 사용한다.

select round(avg(sal),-2) from emp; -- 절사 처리됨. (자바에 넘어가기전에 오라클에서 우선 처리 후 자바에서 받을 것)

select sum(sal) from emp; --sal의 총 합계 

select min(sal) from emp;

select max(sal) from emp;


select ename,sal from emp where sal = (select min(sal) from emp);

select ename,sal from emp where sal = (select max(sal) from emp);

--scott의 직업과 같은 직업을 가진 사람들 조회(ENAME, JOB, SAL)
select ename,job , sal from emp where job = (select job from emp where ename = 'SCOTT');


--allen 보다 더 높은은 연봉을 받는 사람의 인원수는?
select count(*) from emp where sal > (select sal from emp where ename = 'ALLEN');

-- GROUP BY
--JOB  직업별로 일단 인원수를 구해보자]

SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB;
--위의 결과를 작업의 오름차순으로 출력
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 직업;
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 1; --위와 같은 결과 값

--인원 수의 오름차순으로 출력
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 인원수;
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 2; --위와 같은 결과 값

--직업별로 인원수, 평균연봉과 최저연봉, 최고연봉을 출력해보자
SELECT JOB 직업, COUNT(*) "인원 수", ROUND(AVG(SAL),0) 평균연봉, MAX(SAL) 최고연봉,
    MIN(SAL) 최저연봉 FROM EMP GROUP BY JOB;
    
--그룹에 대한 조건을 줄 경우 HAVING 사용
-- 위의 SQL 문에 인원 수가 3명 이상인 그룹만 출력
SELECT JOB 직업, COUNT(*) "인원 수", ROUND(AVG(SAL),0) 평균연봉, MAX(SAL) 최고연봉,
    MIN(SAL) 최저연봉 FROM EMP GROUP BY JOB HAVING COUNT(*)>=3;
    
    
    
-- <오라클 함수들>

--절대값
SELECT ABS(-5), ABS(5) FROM DUAL; 

--소수점 올림
SELECT CEIL(2.1), CEIL(2.9) FROM DUAL; 

--소수점 내림
SELECT FLOOR(2.1), FLOOR(2.9) FROM DUAL; 

--나머지 구할 때 (7%2)
SELECT MOD(7,2) FROM DUAL;

--제곱식 2^3
SELECT POWER(2,3) FROM DUAL;

--변환 함수
SELECT '7' + 7 FROM DUAL;
SELECT TO_NUMBER ('7')+7 FROM DUAL; --14
SELECT TO_CHAR(SYSDATE , 'YYYY-MM-DD') FROM DUAL; --가장 많이 씀

--문자 함수
SELECT CONCAT('HELLO','WORLD') FROM DUAL; -- 이 프로그램은 두개밖에 못묶어서 콘캣 잘 안씀.
SELECT 'HELLO'||'WORLD'||'ORACLE' FROM DUAL;

SELECT * FROM BOARD WHERE SUBJECT LIKE '%'||변수명||'%'; -- 오라클
SELECT * FROM BOARD WHERE SUBJECT LIKE CONCAT('%',변수명,'%'); -- 오라클
    -- 서브젝트에서 변수명이 포함한 단어가 출력 (나중용 지금 실행 안됨)


SELECT LPAD(23500,10,'*') FROM DUAL; -- 총 10자리 중 남는 왼쪽자리에 *로 채우기 (민증번호 가릴 때 쓰는 느낌이랑 비슷)
SELECT RPAD(23500,10,'*') FROM DUAL; -- 총 10자리 중 남는 왼쪽자리에 *로 채우기

SELECT INITCAP('HELLO') FROM DUAL; -- 첫글자만 대문자
SELECT LOWER('HELLO') FROM DUAL; --전체 소문자
SELECT UPPER('HELLO') FROM DUAL; --전체 대문자


SELECT INITCAP (ENAME), LOWER (ENAME), UPPER (ENAME) FROM EMP;

SELECT SUBSTR('HELLO kITTY',3,3) fROM DUAL;
SELECT SUBSTR('HELLO kITTY',-3,3) fROM DUAL;

-- ENAME, SAL 출력 (ENAME은 두글자만 추출해서 출력 후 뒤에 *** 붙여서 출력, SAL은 총 7자리로 출력하는데 앞에 ** 출력)

SELECT SUBSTR(ENAME,1,2)||'***' 사원명, LPAD(SAL,7,'*') 연봉 FROM emp;

SELEct '*'||'      HEllo    '||'*' FROM Dual;
SELEct '*'||TRIM('     HELLO    ')||'*' FROM Dual;


SELECT DECODE (2,1, 'one', 2,'two',3,'three',4,'four')FROM dual;
Select ename, deptno, decode(deptno, 10, '부산','20','대구','30','제주도') from emp;

--select Distict job from emp order by l;

select job,count(*) count from emp group by job order by count desc;

select job, round(avg(sal),0) 평균급여 from emp group by job order by 2;

select job, max(sal) 최대급여, min(sal) 최소급여 from emp  group by job;

select ename, deptno, decode(deptno, 10, '홍보부',20,'개발부',30,'관리부') 부서 from emp;

select ename, sal from emp where sal>(select avg(sal) from emp);

select ename,hiredate from emp where to_char(hiredatem,'mm')=5;

select ename,sal from emp where sal>= (select sal from emp where lower(ename)='scott');






