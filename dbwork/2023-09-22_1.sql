
create or replace PROCEDURE mytest
is

begin 
      DBMS_Output.put_line('ù ���ν����� ��������!!');
    
end;
/
--mytest ���ν��� ȣ��

exec mytest;


create or replace PROCEDURE gugu(dan number)
is
begin 
    if dan<2 or dan>9 then
      DBMS_Output.put_line('�߸��� ���� �Դϴ�. 2-9������ �Է��ϰԳ�');

    else
      DBMS_Output.put_line('**' ||dan||'��**');
      for a in 1..9 loop
        DBMS_Output.put_line(dan||'��'||a||dan*a);
      end loop;
    end if;
    
end;
/
--mytest ���ν��� ȣ��

exec gugu(5);

--------------------------------------------
--shop�� �������߰��غ��� !!

insert into shop values(seq_shop.nextval, '���̽����콺', 23000, 'black');

--shop�� color Ÿ�� ���ڿ� ���� ����
alter table shop modify sang_color varchar2(30); 

insert into shop values(seq_shop.nextval, '��û', 15000, 'black');
insert into shop values(seq_shop.nextval, '����', 99000, 'blue');
insert into shop values(seq_shop.nextval, 'üũ����', 145000, 'pink');
insert into shop values(seq_shop.nextval, '��ĿƮ', 180000, 'blue');
insert into shop values(seq_shop.nextval, '��������', 40800, 'khaki');



create or replace PROCEDURE sangpum (sang VARCHAR2)
is
Cursor s1
is
select * from shop where sang_name like '%'||sang||'%';

-- �˻��� ��ǰ������ ���� ����
v_cnt number(2);

begin 
select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
if v_cnt = 0 then
    DBMS_Output.put_line(sange||'��ǰ�� ��Ͽ� �����ϴ�.');
else
    DBMS_Output.put_line(sang||'��ǰ ��ȸ�ϱ�');
    DBMS_Output.put_line('��'||v_cnt|| '�� ��ȸ');
    DBMS_Output.put_line('��ǰ��ȣ    ��ǰ��     ����     ����');
    DBMS_Output.put_line('--------------------------------------');
for s in s1 loop
     DBMS_Output.put_line(s.sang_no||'  '||s.sang_name||'  '||s.sang_price||'  '||s.sang_color);
     exit when s1%notfound;

 end loop;
 end if;
 
end;
/
exec sangpum('����');

-------------------------------------------------------------

