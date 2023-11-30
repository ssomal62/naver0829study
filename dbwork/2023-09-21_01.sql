--2023-09-21 DB����ȭ (ê����Ƽ ���� ����)
-- �ܺ�Ű�� ���̺� ���� �ÿ� �����ص� �ǰ�, 


create table stuinfo(
    idx number(5) CONSTRAINT stuinfo_pk_idx PRIMARY key,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));
    
    
-- student�� num�� �ܺ�Ű�� ���� (PPT 29p) (�̶� ����, student�� num�� �ݵ�� primary key�� ���� : �ߺ��� �Ǹ� �ȵǱ� ������)
alter table stuinfo add constraint stuinfo_fk_num FOREIGN key(num) REFERENCES student(num);

--stuinfo�� �����͸� �߰��غ��� (���� ��ȣ�� insert �� � ������ ������ Ȯ�� �ʿ�
--���� _ ���Ἲ �������� (�θ��� Ű�� ���)
-- student ���̺��� �θ� ���̺� : �ű⿡ num15�� ��� ���� ��
insert into stuinfo values (seq_stu.nextval, 15, '����� ������', '010-2232-4545');

insert into stuinfo values (seq_stu.nextval, 14, '����� ������', '010-2232-4545');
insert into stuinfo values (seq_stu.nextval, 7, '���ֵ�', '010-6442-5855');
insert into stuinfo values (seq_stu.nextval, 10, '���Ǳ�', '010-4555-6688');

--stuinfro �� ��ȸ
select * from stuinfo;

--student�� ��ȸ
select * from student;


--���������� ��ϵ� �л��� ���ؼ� ��� ������ ����غ��� (inner join, equi join)
select 
    stu.num, name, java, spring, ban, addr, hp
from student stu, stuinfo info
where stu.num = info.num;


--�÷��� �տ� ������ ������̺� �Ҽ����� �ٿ��µ� ���ʿ� ���� �÷��� ���ٸ� ��������.


--���� ������ ��ϵǾ� ���� ���� �л��鵵 ���� ����غ���.(outer join,
--sub table dp(+)  // info�� �������̺���.
--����� �ȵ� column�� null�� ��µ�.
select 
    stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp
from student stu, stuinfo info
where stu.num = info.num(+);


--���� ����� null �� �л��� ��� into.addr(�ƹ��ų�) is null
select 
    stu.num, name, java, spring, ban, addr, hp
from student stu, stuinfo info
where stu.num = info.num(+) and into.addr is null;

--sub ���̺� ����� �����Ͱ� �ִµ� �θ����̺�(student)�� �ش��� �����͸� �����ϰ��� �� ���
-- �����߻� : ���Ἲ ���������� ����Ǿ����ϴ�. �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�.

delete from student where num = 10; --���� // stuinfo�� ����Ÿ�� ���, 
-- �ڽ� ��Һ��� ���� �� �θ� ��Ҹ� �����ؾ���.


delete from student where num = 14;

--student�� 14�� �����͸� ��������
-- �ڽ� ���̺� (stuinfo�� num�� 14�� �����͸� ���� ���� �� student ����)

delete from stuinfo where num = 14; 
delete from student where num = 14;
-- 

drop table student; --���� �߻�.

drop table stuinfo;
-----------------------------------------------
--��ǰ������ ���� shop�� ���̺�
-- ��ٱ��Ͽ� ���� cart ���̺��� ����µ� ��ǰ���� ������ ���ؼ� shop�� num�� �ܺ�Ű�� ����
-- ��ǰ�� �����ϸ� ��ٱ����� �ش� �����Ͱ� �ڵ����� �����ǵ��� on delete cascade �����غ���

create SEQUENCE seq_shop start with 10 increment by 10 nocache;


--shop tabel ����
create table shop (
    sang_no number(5) constraint shop_pk_no primary key,
    sang_name varchar2(100),
    sang_price number(7),
    sang_color varchar2(20)
    
);

-- �ܺ�Ű�� ����� cart ���̺��� ���� - shop�� ��ǰ�� ����� ��ٱ��� ����� �ڵ����� ����������
-- cascade �� �����ؼ� �����غ���

create table cart(
    cart_no number(5) constraint cart_pk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday DATE
);

alter table cart add constraint cart_fk_shopno foreign key(sang_no) references shop(sang_no) on delete cascade;--�������̺��� �־ �θ����Ϳ��� ���� ����


--model(ERD)Ȯ���غ�����

--5���� ��ǰ�� ����غ���
insert into shop values (seq_shop.nextval,'���콺',23000,'yellow');
insert into shop values (seq_shop.nextval,'û����',45000,'black');
insert into shop values (seq_shop.nextval,'���̳�',15000,'yellow');
insert into shop values (seq_shop.nextval,'���ǽ�',98000,'floral');
insert into shop values (seq_shop.nextval,'���뽺',8000,'red');
insert into shop values (seq_shop.nextval,'���̳�',23000,'blue');

commit;

--cart �� ���콺, ���̳�Ƽ, üũ���� 3���� ���ؼ� �߰� -��¥�� ���� ��¥�� (sysdate)
insert into cart values (seq_shop.nextval, 10, 2, sysdate);
insert into cart values (seq_shop.nextval, 30, 3, '2023-09-20');
insert into cart values (seq_shop.nextval, 50, 1, sysdate);

--��ȸ (inner join)
-- ��ǰ��, ����, ����, ����, ������ (yyyy-mm-ddm hh24:mi)
select s.sang_no, sang_name, sang_price,sang_color, cnt, to_char(cartday, 'yyyy-mm-dd hh24:mi') cartday
from shop s, cart c
where s.sang_no = c.sang_no;


--�ƹ��� cart �� ���� ���� ��ǰ�� ��ȸ
--��ǰ��, ����, ������ ���
select sang_name, sang_price, sang_color
from shop s, cart c
where s.sang_no  = c.sang_no(+) and c.cnt is null;

--cascade�� ���������Ƿ� cart�� ��� ��ǰ�� ������ �ȴ�.(�̶� cart�� �ڵ����� ������)
delete from shop where sang_no =10;

drop table cart;

drop table shop; --�����͸� 

drop SEQUENCE seq_shop;
---------------------------
--<����>
--������ : seq_food
--��������� �޴� ���̺� (���̺�� : food)
--food_num ����(5) �⺻Ű, fname(���ڿ� 20) : �޴���, fprice(���� 7) : ����

--sub ���̺� : �����̺�(person)
--person_num ����(5) �⺻Ű, food_num �ܺ�Ű ���� (cascade ����)
--person_name ���ڿ�(10) : ����
--������ : bookingday : dateŸ��

--food�� 5���� �޴��� �������(���İ�Ƽ, ������ũ, ����, ����)
--�ֹ��� �������� �߰��غ���.
-- �޴� �� ���İ�Ƽ�� ���� �� �ֹ��� ���̺����� �������� �� Ȯ��
-- ��ȸ: ������, �ֹ��ڸ�, ���ĸ�, ����, ������ (���� �ѱ۷� �߰�)
----------------------------------------

create SEQUENCE seq_food nocache;

create table food(

    food_num number(5) CONSTRAINT food_pk_no primary key,
    food_name VARCHAR2(20),
    food_price number(7)
);

create table person(
person_num number(5) constraint person_pk_no primary key,
person_name varchar2(10),
bookingday date
);

alter table person add Food_num number(5);

alter table person add CONSTRAINT person_fk_foodno foreign key(food_num) references food(food_num) on delete cascade;

insert into food values(seq_food.nextval, '���İ�Ƽ' , 19000);
insert into food values(seq_food.nextval, '����' , 19000);
insert into food values(seq_food.nextval, '����������ũ' , 56000);
insert into food values(seq_food.nextval, 'Ƽ��������ũ' , 63000);
insert into food values(seq_food.nextval, '�����ν�����ũ' , 43000);


insert into person values (seq_food.nextval, '���ڶ�', sysdate, 1);
insert into person values (seq_food.nextval, '����', sysdate, 2);
insert into person values (seq_food.nextval, '���Ե�', sysdate, 3);
insert into person values (seq_food.nextval, '���ϴ�', sysdate, 1);


select f.food_num, person_name �ֹ��ڸ�, food_name ���ĸ�, food_price ����, to_char(bookingday,'yyyy-mm-dd') ������
from food f, person p
where f.food_num = p.food_num;









