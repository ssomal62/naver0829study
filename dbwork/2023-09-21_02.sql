--PL-SQL�̶�?
--SQL �� ������ ����Ҹ� �߰��ؼ� ���α׷����� ���� PL-SQL�̶�� �Ѵ�.

--����1
DECLARE
    --���� �����ϴ� ����
    v_no number(4,1); --4�ڸ��� �Ҽ������� 1�ڸ� ���� �ִ� ���� ����
    
BEGIN
    -- sql�����̳� pl-sql ������ �ڵ��ϴ� ����(:=: ����, =��, ����)
    v_no:=12.7;
    DBMS_Output.put_line(v_no); --���
end;
/ 
-- '/'�� �����ϸ� ��! '/'������ �ּ� ����.

--����2
DECLARE
    vname VARCHAR2(20);
    vban varchar2(20);
    
    
BEGIN
  Select
    name, ban  -- ���� �Ʒ��� 
    into vname, vban
    from student where num = 5;
    
    DBMS_Output.put_line(vname||'���� '||vban||'�Դϴ�.'); --���
end;
/ 

DECLARE
 vname VARCHAR2(20);
 vmenu VARCHAR2(20);
 vprice number(7);
    
BEGIN
    select
    person_name, food_name, food_price
    into vname, vmenu, vprice
    from food f, person p
    where f.food_num = p.food_num and person_num = 9;
    
  
    
    DBMS_Output.put_line(vname||'�� '||vmenu||' '||vprice||'��'); --���
end;
/ 




----------------------------------
create SEQUENCE seq_shop start with 10 increment by 10 nocache;


--shop tabel ????
create table shop (
    sang_no number(5) constraint shop_pk_no primary key,
    sang_name varchar2(100),
    sang_price number(7),
    sang_color varchar2(20)
    
);

insert into shop values (seq_shop.nextval,'���콺',23000,'yellow');
insert into shop values (seq_shop.nextval,'���ǽ�',45000,'black');
insert into shop values (seq_shop.nextval,'����',15000,'yellow');
insert into shop values (seq_shop.nextval,'���̳�',98000,'floral');
insert into shop values (seq_shop.nextval,'����',8000,'red');
insert into shop values (seq_shop.nextval,'û����?',23000,'blue');

commit;

accept sangpum prompt 'sangpum?';

DECLARE
    vsangpum varchar2(20) := '&sangpum';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
    
BEGIN
    select sang_price, sang_color, ltrim(to_char(sang_price,'L999,999'))  -- ltrim ���� ���� ����
    into vprice, vcolor,vprice2
    from shop where sang_name = vsangpum;
    
    DBMS_Output.put_line('��ǰ�� : '||vsangpum);
    DBMS_Output.put_line('��  �� : '||vcolor);
    DBMS_Output.put_line('��  �� : '||vprice2);
    
    -- ����� 2�� �̻��̰ų� ������ ���� �߻�
    -- ����Ŭ���� ����ó�� �ϴ� ���
    Exception
        when NO_DATA_FOUND then
        DBMS_Output.put_line(vsangpum|| ' ��ǰ�� DB�� �����ϴ�.');
        when TOO_MANY_ROWS then
        DBMS_Output.put_line(vsangpum|| ' ��ǰ�� DB�� �ΰ� �̻� �����մϴ�.');
        when OTHERS then
        DBMS_Output.put_line(vsangpum|| ' ��ǰ�� ���� ���� �߻� - ���� �Ҹ�');
    
end;
/ 


/*
<if��>
if ���ǽ� then
    ����1;
else
    ����2;
end if;


<���� if��>
if ���ǽ�1 then
    ����1;
elsif ����2 then
    ����2;
    ...
end if;

*/

--����5
--������ �´� �챸�ϱ�

-- Ű����� ������ �̷¹ް��� �� ���
accept year prompt '�¾ ������ �Է��ϼ���.';

DECLARE 
    v_year number(4) := '&year'; -- �Է��� ���� ����
    v_mod number(2):= mod(v_year,12); --������ 12�� ���� �������� ���Ѵ�.
    v_ddi varchar2(10); -- �츦 ������ ����
    
BEGIN
    if v_mod = 0 then v_ddi :='������' ;
     elsif v_mod = 1 then v_ddi :='��';
     elsif v_mod = 2 then v_ddi :='��';
     elsif v_mod = 3 then v_ddi :='����';
     elsif v_mod = 4 then v_ddi :='��';
     elsif v_mod = 5 then v_ddi :='��';
     elsif v_mod = 6 then v_ddi :='ȣ����';
     elsif v_mod = 7 then v_ddi :='�䳢';
     elsif v_mod = 8 then v_ddi :='��';
     elsif v_mod = 9 then v_ddi :='��';
     elsif v_mod = 10 then v_ddi :='��';
     elsif v_mod = 11 then v_ddi :='��';
    end if;
    
    DBMS_Output.put_line(v_year||'�����'||v_ddi||'�� �Դϴ�.');
end;
/   
    
    
--����4
--db�� �÷��� Ÿ���� �������� ��� TYPE5
accept iname prompt 'name?';
DECLARE
    v_name student.name%TYPE := '&iname';
    v_height student.height%TYPE;
    v_java student.java%TYPE;
    v_spring student.spring%TYPE;
    
    
BEGIN

select height , java, spring
into v_height, v_java, v_spring
from student where name = v_name;

    DBMS_Output.put_line('�л��� : '||v_name);
    DBMS_Output.put_line('Ű : '||v_height);
    DBMS_Output.put_line('java : '||v_java);
    DBMS_Output.put_line('spring : '||v_spring);
    DBMS_Output.put_line('���� '||v_java + v_spring);
end;
/


--- �ݺ���
/*
�ݺ��� : loop
loop
    �����;
    exit when ����;
end loop;
*/


accept num prompt '����� ����?';
DECLARE

    v_no number(2) := '&num';
    
BEGIN
  loop
        v_no := v_no+1;
        DBMS_Output.put_line('no='||v_no);
        exit when v_no = 10; --10�� ��� �ݺ����� ����������.
   end loop;
end;
/ 




--������
accept num prompt '����� ����?';
DECLARE

     v_num1 number(2) := '&num';
     v_num2 number(2) := 1;
     
    
BEGIN
    loop
        DBMS_Output.put_line( v_num1||'��'|| v_num2 ||'='|| v_num1* v_num2);
        v_num2 := v_num2 + 1;
        exit when v_num2 = 10; 
    end loop;

end;
/ 


/*
for ���� in [reverse] ���۰�... ������ loop
    �����;
end loop;
*/


accept num prompt '����� ����?';
DECLARE

     v_num1 number(2) := '&num';
     v_num2 number(2);
     
    
BEGIN
    for v_num2 in  1 .. 9 loop
     DBMS_Output.put_line( v_num1||'��'|| v_num2 ||'='|| v_num1* v_num2);
    end loop;

end;
/ 

--���ڵ� ������ ������ ��������
DECLARE
    v_num student.num%TYPE := 12;
    v_stu aiur.student%rowtype ; --���ڵ� ������ �о� �� ���
    
BEGIN
  select * into v_stu
  from student where num = v_num;
    DBMS_Output.put_line('�̸� ' ||v_stu.name ); 
    DBMS_Output.put_line('Ű ' ||v_stu.height ); 
    DBMS_Output.put_line('�ڹ� ' ||v_stu.java ); 
    DBMS_Output.put_line('������ ' ||v_stu.spring ); 
    DBMS_Output.put_line('�ڹ� ' ||v_stu.ban); 
end;
/ 

--db�� ���� �����͸� ��ȸ�� ���
/*
    Cursor : sql���� ���� �� ������ ����� �м��ǰ� ����Ǿ� ����� �����ϱ� ���� Ư���� �޸� ������ ����ϴµ� 
    �� ������ �����ϴ� ���� Cursor�̴�.
    
    select������ ���� ������ ��ȸ �� ����ϴ� ��ü�̴�.
    
    Ŀ�� �Ӽ�
    sql%rowcount : ����� ���� ��ȯ
    sql%found : ���� �ֱ��� sql ���� �ϳ� �̻��� �࿡ ������ �� ��� treu
    sql%notfound : ��� ���� ���� ���
    sql%isopen : �׻� false(�׻� close�� �ϱ⶧���� �׻� false)
*/

--���� 12


DECLARE
 v_sno number(3) :=20;
 v_shop aiur.shop%rowtype;
    
    
BEGIN

select * into v_shop
from shop where sang_no= v_son;
  
    
    DBMS_Output.put_line('��ǰ�� : ' ||v_shop.sang_name); 
    DBMS_Output.put_line('��ȸ Ƚ�� : ' ||sql&rowcount); 
    
    -- student�� java ���� �����ϱ�
    update student set java = 99;
    DBMS_Output.put_line('������ Ƚ�� : ' ||sql&rowcount); 
    
end;
/ 

-- ���� ���ڵ� ��ȸ



DECLARE
    Cursor s1  --Ŀ���� �����ϸ� �Ʒ� ���๮�� ���� ����� Ŀ���� ������ �ְ� ��.
    is 
    select * from shop;
        
BEGIN
    
    
    DBMS_Output.put_line('��ǰ��ȣ  ��ǰ��  ����  ����'); 
    DBMS_Output.put_line('-----------------------------'); 
    for s in s1 loop   
        exit when s1%notfound; -- ���̻� �����Ͱ� ������ ����������.
        DBMS_Output.put_line(s.sang_no||' '||s.sang_name||' '||s.sang_color||' '||s.sang_price);
    end loop;
end;
/ 


-- ���� 14
-- ��ǰ��, ����, ������ �Է��ϸ� shop,db�� �߰��ϱ�

accept isang prompt 'sangpum?';
accept iclolr prompt 'color?';
accept iprice prompt 'price?';

DECLARE

    v_sang shop.sang_name%TYPE := '&isang';
    v_color shop.sang_color%TYPE := '&icolor';
    v_price shop.sang_price%TYPE := '&iprice';

BEGIN
    
    insert into shop values(seq_shop.nextval, v_sang,v_price,v_color);
    commit;
    DBMS_Output.put_line('��ǰ������ �߰��߽��ϴ�.'); 
    
end;
/ 

----------------------

--���� : food���̺�

/*

fname, fprice, no �Է��� �޾Ƽ� 
no�� 1�̸� fname, fprice�� ������ �߰��� �ϰ�,
no�� 2�̸� food ��ü ������ ���.

*/

accept choice prompt '1.�޴� ��� | 2. �޴� ���';
accept addmenu prompt '���ĸ� �Է�';
accept setprice prompt '���� �Է�';

DECLARE

    v_num number(2) := '&choice';
    v_food food.food_name%TYPE := '&addmenu';
    v_price food.food_price%TYPE := '&setprice';
    
    Cursor c1

BEGIN
    
    if v_num = 1 then
    
    insert into food values (seq_food,nextval, v_food, v_price);
    DBMS_Output.put_line('�޴��� �߰��߽��ϴ�.'); 
    


    end if;
    commit;

end;
/ 

























