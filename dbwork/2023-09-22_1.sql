
create or replace PROCEDURE mytest
is

begin 
      DBMS_Output.put_line('첫 프로시저를 만들었어오!!');
    
end;
/
--mytest 프로시저 호출

exec mytest;


create or replace PROCEDURE gugu(dan number)
is
begin 
    if dan<2 or dan>9 then
      DBMS_Output.put_line('잘못된 숫자 입니다. 2-9까지만 입력하게나');

    else
      DBMS_Output.put_line('**' ||dan||'단**');
      for a in 1..9 loop
        DBMS_Output.put_line(dan||'×'||a||dan*a);
      end loop;
    end if;
    
end;
/
--mytest 프로시저 호출

exec gugu(5);

--------------------------------------------
--shop에 데이터추가해보자 !!

insert into shop values(seq_shop.nextval, '레이스블라우스', 23000, 'black');

--shop의 color 타입 문자열 길이 변경
alter table shop modify sang_color varchar2(30); 

insert into shop values(seq_shop.nextval, '찢청', 15000, 'black');
insert into shop values(seq_shop.nextval, '조끼', 99000, 'blue');
insert into shop values(seq_shop.nextval, '체크조끼', 145000, 'pink');
insert into shop values(seq_shop.nextval, '스커트', 180000, 'blue');
insert into shop values(seq_shop.nextval, '조거팬츠', 40800, 'khaki');



create or replace PROCEDURE sangpum (sang VARCHAR2)
is
Cursor s1
is
select * from shop where sang_name like '%'||sang||'%';

-- 검색된 상품갯수를 구할 변수
v_cnt number(2);

begin 
select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
if v_cnt = 0 then
    DBMS_Output.put_line(sange||'상품은 목록에 없습니다.');
else
    DBMS_Output.put_line(sang||'상품 조회하기');
    DBMS_Output.put_line('총'||v_cnt|| '개 조회');
    DBMS_Output.put_line('상품번호    상품명     가격     색상');
    DBMS_Output.put_line('--------------------------------------');
for s in s1 loop
     DBMS_Output.put_line(s.sang_no||'  '||s.sang_name||'  '||s.sang_price||'  '||s.sang_color);
     exit when s1%notfound;

 end loop;
 end if;
 
end;
/
exec sangpum('조끼');

-------------------------------------------------------------

