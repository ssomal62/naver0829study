--���1
select ename,sal,comm from emp where sal>=1000 and sal <= 2000;

--���2
select ename,sal,comm from emp where sal BETWEEn 1000 and 2000;

select ename, sal, comm from emp where sal<1000 or sal>2000;

select * from emp where comm is null;

select * from emp where comm is not null;

select ename, sal, comm, sal + comm from emp;  --���� +  null == null!!s

--NVL(�÷���, ��) : �ش� �÷����� null �̸� 0���� ���.
select ename, sal, NVL(Comm,0), sal+NVL(comm,0) from emp;

--���߿� �ڹٷ� ������ ��� �÷� �ε��� �÷������� ��������. �׷��� �÷����� ������ ��� ��Ī ������ �Ѵ�.
select ename as "�����" , sal as "����" from emp; -- �� ������ ���� ��� as "" ���� ����
select ename �����, sal ���� from emp;
select empno "��� ��ȣ", sal ����� from emp;

select ename �����, sal ����, NVL(comm,0)������, sal + NVL(comm,0) �ѿ��� from emp;

select count(*) from emp;  -- �÷����� 'conut(*)'�̶�� ����.
select count(*) count from emp; -- �� �̸� ������.

--���ڿ��� �̾ ��� >> '||' ���
select ename||'�� ������ '||job||'�Դϴ�.' member from emp;

select * from emp;

select ename||'�� ������'||(sal + NVL(comm,100)) ||'�Դϴ�.' "ȸ�� ����" from emp;

--sql���� ū����ǥ�� �����? ������ �� �� ���� �������� ������ ���� ����ǥ!!

--empno ������ ��ȸ
select empno, ename from emp where empno = 7369 or empno = 7788 or empno = 7900;

-- ������ ��ȸ �� 'in'�� ����ؼ� �� �� ����

select empno, ename from emp where empno in (7369,7788,7900);

select empno, ename from emp where empno not in (7369,7788,7900);

select ename, job from emp where job in('SALESMAN','ANALYST');

select * from emp where hiredate = '80/12/17';

select * from emp where hiredate = '1980-12-17';

SELECT * FROM EMP WHERE HIREDATE >= '1980-01-01' AND HIREDATE <= '1981-10-10';

-- ���� ��¥ ��ȸ
select sysdate from dual;

select sysdate+1 from dual;

SELECT to_char(sysdate, 'yyyy-mm-dd') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd hh:mi') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd') FROM dual;

--emp���� ename, hiredate(yyyy-mm-dd) �� ����ϴµ� 1981���� �Ի��� ����� ���
SELECT ename �����, to_char(hiredate,'yyyy-mm-dd') �Ի��� FROM emp 
    WHERE to_char(hiredate,'yyyy')=1981;
    
select count(*) from emp;
select avg(sal) from emp;
select round(avg(sal),1) from emp;-- ���� ����� ���� ���� ROUND �Լ��� ���� ����Ѵ�.

select round(avg(sal),-2) from emp; -- ���� ó����. (�ڹٿ� �Ѿ������ ����Ŭ���� �켱 ó�� �� �ڹٿ��� ���� ��)

select sum(sal) from emp; --sal�� �� �հ� 

select min(sal) from emp;

select max(sal) from emp;


select ename,sal from emp where sal = (select min(sal) from emp);

select ename,sal from emp where sal = (select max(sal) from emp);

--scott�� ������ ���� ������ ���� ����� ��ȸ(ENAME, JOB, SAL)
select ename,job , sal from emp where job = (select job from emp where ename = 'SCOTT');


--allen ���� �� ������ ������ �޴� ����� �ο�����?
select count(*) from emp where sal > (select sal from emp where ename = 'ALLEN');

-- GROUP BY
--JOB  �������� �ϴ� �ο����� ���غ���]

SELECT JOB ����, COUNT(*) �ο��� FROM EMP GROUP BY JOB;
--���� ����� �۾��� ������������ ���
SELECT JOB ����, COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY ����;
SELECT JOB ����, COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY 1; --���� ���� ��� ��

--�ο� ���� ������������ ���
SELECT JOB ����, COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY �ο���;
SELECT JOB ����, COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY 2; --���� ���� ��� ��

--�������� �ο���, ��տ����� ��������, �ְ����� ����غ���
SELECT JOB ����, COUNT(*) "�ο� ��", ROUND(AVG(SAL),0) ��տ���, MAX(SAL) �ְ���,
    MIN(SAL) �������� FROM EMP GROUP BY JOB;
    
--�׷쿡 ���� ������ �� ��� HAVING ���
-- ���� SQL ���� �ο� ���� 3�� �̻��� �׷츸 ���
SELECT JOB ����, COUNT(*) "�ο� ��", ROUND(AVG(SAL),0) ��տ���, MAX(SAL) �ְ���,
    MIN(SAL) �������� FROM EMP GROUP BY JOB HAVING COUNT(*)>=3;
    
    
    
-- <����Ŭ �Լ���>

--���밪
SELECT ABS(-5), ABS(5) FROM DUAL; 

--�Ҽ��� �ø�
SELECT CEIL(2.1), CEIL(2.9) FROM DUAL; 

--�Ҽ��� ����
SELECT FLOOR(2.1), FLOOR(2.9) FROM DUAL; 

--������ ���� �� (7%2)
SELECT MOD(7,2) FROM DUAL;

--������ 2^3
SELECT POWER(2,3) FROM DUAL;

--��ȯ �Լ�
SELECT '7' + 7 FROM DUAL;
SELECT TO_NUMBER ('7')+7 FROM DUAL; --14
SELECT TO_CHAR(SYSDATE , 'YYYY-MM-DD') FROM DUAL; --���� ���� ��

--���� �Լ�
SELECT CONCAT('HELLO','WORLD') FROM DUAL; -- �� ���α׷��� �ΰ��ۿ� ����� ��Ĺ �� �Ⱦ�.
SELECT 'HELLO'||'WORLD'||'ORACLE' FROM DUAL;

SELECT * FROM BOARD WHERE SUBJECT LIKE '%'||������||'%'; -- ����Ŭ
SELECT * FROM BOARD WHERE SUBJECT LIKE CONCAT('%',������,'%'); -- ����Ŭ
    -- ������Ʈ���� �������� ������ �ܾ ��� (���߿� ���� ���� �ȵ�)


SELECT LPAD(23500,10,'*') FROM DUAL; -- �� 10�ڸ� �� ���� �����ڸ��� *�� ä��� (������ȣ ���� �� ���� �����̶� ���)
SELECT RPAD(23500,10,'*') FROM DUAL; -- �� 10�ڸ� �� ���� �����ڸ��� *�� ä���

SELECT INITCAP('HELLO') FROM DUAL; -- ù���ڸ� �빮��
SELECT LOWER('HELLO') FROM DUAL; --��ü �ҹ���
SELECT UPPER('HELLO') FROM DUAL; --��ü �빮��


SELECT INITCAP (ENAME), LOWER (ENAME), UPPER (ENAME) FROM EMP;

SELECT SUBSTR('HELLO kITTY',3,3) fROM DUAL;
SELECT SUBSTR('HELLO kITTY',-3,3) fROM DUAL;

-- ENAME, SAL ��� (ENAME�� �α��ڸ� �����ؼ� ��� �� �ڿ� *** �ٿ��� ���, SAL�� �� 7�ڸ��� ����ϴµ� �տ� ** ���)

SELECT SUBSTR(ENAME,1,2)||'***' �����, LPAD(SAL,7,'*') ���� FROM emp;

SELEct '*'||'      HEllo    '||'*' FROM Dual;
SELEct '*'||TRIM('     HELLO    ')||'*' FROM Dual;


SELECT DECODE (2,1, 'one', 2,'two',3,'three',4,'four')FROM dual;
Select ename, deptno, decode(deptno, 10, '�λ�','20','�뱸','30','���ֵ�') from emp;

--select Distict job from emp order by l;

select job,count(*) count from emp group by job order by count desc;

select job, round(avg(sal),0) ��ձ޿� from emp group by job order by 2;

select job, max(sal) �ִ�޿�, min(sal) �ּұ޿� from emp  group by job;

select ename, deptno, decode(deptno, 10, 'ȫ����',20,'���ߺ�',30,'������') �μ� from emp;

select ename, sal from emp where sal>(select avg(sal) from emp);

select ename,hiredate from emp where to_char(hiredatem,'mm')=5;

select ename,sal from emp where sal>= (select sal from emp where lower(ename)='scott');






