-- scotrr ������ ���̺�� ��ȸ �����ϱ�.

select * from emp; ----��ü ���̺��� ������ ��ȸ
select * from emp order by ename asc; -- ename�� ������������ ��ȸ (asc�� �����ص� ��)
select * from emp order by ename desc; -- ename�� ������������ ��ȸ (desc�� �����ص� ��)

select empno, ename from emp; --�Ϻ� column�� ��ȸ

select job from emp; --job column�� ��ȸ
-- ���� ������ ��� �ѹ����� ���
select DISTINCT job from emp order by 1; -- column�� �Ѱ� �̹Ƿ� job ��� 1�̶�� �ᵵ �ȴ�.

-- sal�� 3000�̻��� �͸� ��ȸ
select * from emp where sal>=3000;  



