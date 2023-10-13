
create SEQUENCE seq_test nocache;

--table ����
create table test(
    num number(3) PRIMARY KEY, --�������� 1/
    name VARCHAR2(20) not null,  -- ��������2/ null���� ������� �ʰڴ�. ���� ������ ����
    blood char(2) default 'A', 
    weight number(5,2), -- ��5�ڸ��� �Ҽ������� 2�ڸ�����
    birth date);
    
-- �Ϻ� �����͸� �ִ� ��� �÷����� �ݵ�� ǥ���Ѵ�.
insert into test (num,name) values (seq_test.nextval,'ĵ��');


-- ���̺��� ��� �����͸� ������� �����Ÿ� Column�� ���� ����
insert into test values (seq_test.nextval,'ĳ����','AB',67.89,sysdate);

--�������ǿ� �ȸ´� ��� ���� Ȯ��
insert into test (num,blood) values (seq_test.nextval,'O');
insert into test (num,name,blood) values (2,'Lee','O'); -- ������ �ִ� �ѹ��� ���ų�..

--����� �� ������ 3�� �߰�
insert into test values (seq_test.nextval,'��ȣ��','B',78.9,'2000-10-10');
insert into test values (seq_test.nextval,'���缮','A',66.1,'1979-12-25');
insert into test values (seq_test.nextval,'�̿���','O',56.7,'1969-09-09');


--������ commit �� ���� sqlans (DML: insert, delete, update) ��� ���
commit; -- ���̻� �ѹ� �ȵ�


insert into test values (seq_test.nextval,'���̳�','AB',56.78,'1988-12-05');


--��ȣ���� �������� AB������ ����
update test set blood='AB' where name = '��ȣ��';


--�ΰ��� �÷� ����
update test set weight = 80.9 , birth = sysdate where num=1;

--����
delete from test;

rollback;

delete from test where num in(1,12);

--table ����
drop table test; --�ѹ� �ȵ�

drop SEQUENCE seq_test;



create table person(
    num number(3) CONSTRAINT person_pk_num PRIMARY key,
    blood char(2));
    
    
--���� �������� ����
    alter table person drop constraint person_num_pk;
    
-- �ٽ� primary key�� ���� �������� �߰�
    alter table person add constraint person_num_pk primary key(num);
    

--blood�� ���ؼ� check �������� �߰�

alter table person add constraint person_Ck_blood check (blood in('A','B','O','AB'));


insert into person values(1,'A');
insert into person values(1,'B'); -- ���Ἲ �������� 
insert into person values(2,'b'); -- ���� : üũ ���������� ����Ǿ����ϴ�.(�ҹ��� )
insert into person values(2,'O'); 

--�÷��� �ڴʰ� �߰��غ���.
alter table person add name varchar2(20);
alter table person add score number(5,1) default 30.5;

--�÷��� ����
alter table person drop column num;


--java ��� �÷��� number Ÿ������ �߰� �� 1-100 ���̰��� �������� �������ǵ� �߰�.
alter table person add java number(3) default 0;
alter table person add CONSTRAINT person_ck_java check (java>=0 and java <=100);


--�÷��� ���� rename column
alter table person rename column java to spring;


--������ �߰��� �÷� ������� �ֱ� ���� ��� �÷��� �ָ� �ȴ�.
insert into person(name, blood, spring, score) values ('lee','O', 90, 35);


drop TABLE person;


create table student(
    num number(5),
    name VARCHAR2(10),
    height number(5,1),
    java number(3) default 10,
    spring NUMBER(3) default 10,
    ban VARCHAR2(2)   
);

create SEQUENCE seq_stu nocache;

alter table student add constraint student_pk_num primary key(num);

alter table student add constraint student_java check (0<=java and java <=100);

alter table student add constraint student_spring check (0<= spring and spring <=100);

alter table student MODIFY ban VARCHAR2(20);

alter table student add constraint student_class check(ban in('�޴Թ�','�޴Թ�','���Թ�'));


insert into student values (seq_stu.nextval,'ȫ�浿',13.5, 33, 67, '�޴Թ�');
insert into student values (seq_stu.nextval,'�ڱ��',112.5, 99, 13, '�޴Թ�');
insert into student values (seq_stu.nextval,'�����',181.5, 78, 100, '�޴Թ�');
insert into student values (seq_stu.nextval,'����',170.5, 55, 35, '���Թ�');
insert into student values (seq_stu.nextval,'�λ��',173.9, 81, 88, '�޴Թ�');

commit;

rollback;
delete from student where num >= 8;

update student set java = 99 where num = 5;
update student set height =  100.0 where num =6;

delete from student where num = 6;

SELECT NAME �̸�, BAN ��, JAVA �ڹ�, SPRING ������, JAVA+SPRING ����, JAVA+SPRING/2 ��� FROM STUDENT ORDER BY ���� DESC;












