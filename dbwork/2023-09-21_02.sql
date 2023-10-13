--PL-SQL이란?
--SQL 언어에 절차적 언어요소를 추가해서 프로그래밍한 것을 PL-SQL이라고 한다.

--예제1
DECLARE
    --변수 선언하는 영역
    v_no number(4,1); --4자리에 소숫점이하 1자리 값을 넣는 변수 선언
    
BEGIN
    -- sql구문이나 pl-sql 문으로 코딩하는 영역(:=: 대입, =비교, 동등)
    v_no:=12.7;
    DBMS_Output.put_line(v_no); --출력
end;
/ 
-- '/'로 실행하면 끝! '/'옆에는 주석 금지.

--예제2
DECLARE
    vname VARCHAR2(20);
    vban varchar2(20);
    
    
BEGIN
  Select
    name, ban  -- 각각 아래로 
    into vname, vban
    from student where num = 5;
    
    DBMS_Output.put_line(vname||'님은 '||vban||'입니다.'); --출력
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
    
  
    
    DBMS_Output.put_line(vname||'님 '||vmenu||' '||vprice||'원'); --출력
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

insert into shop values (seq_shop.nextval,'블라우스',23000,'yellow');
insert into shop values (seq_shop.nextval,'원피스',45000,'black');
insert into shop values (seq_shop.nextval,'나나',15000,'yellow');
insert into shop values (seq_shop.nextval,'브이넥',98000,'floral');
insert into shop values (seq_shop.nextval,'나나',8000,'red');
insert into shop values (seq_shop.nextval,'청바지?',23000,'blue');

commit;

accept sangpum prompt 'sangpum?';

DECLARE
    vsangpum varchar2(20) := '&sangpum';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
    
BEGIN
    select sang_price, sang_color, ltrim(to_char(sang_price,'L999,999'))  -- ltrim 왼쪽 공백 제거
    into vprice, vcolor,vprice2
    from shop where sang_name = vsangpum;
    
    DBMS_Output.put_line('상품명 : '||vsangpum);
    DBMS_Output.put_line('색  상 : '||vcolor);
    DBMS_Output.put_line('단  가 : '||vprice2);
    
    -- 결과가 2개 이상이거나 없으면 오류 발생
    -- 오라클에서 예외처리 하는 방법
    Exception
        when NO_DATA_FOUND then
        DBMS_Output.put_line(vsangpum|| ' 상품은 DB에 없습니다.');
        when TOO_MANY_ROWS then
        DBMS_Output.put_line(vsangpum|| ' 상품이 DB에 두개 이상 존재합니다.');
        when OTHERS then
        DBMS_Output.put_line(vsangpum|| ' 상품에 대한 오류 발생 - 원인 불명');
    
end;
/ 


/*
<if문>
if 조건식 then
    문장1;
else
    문장2;
end if;


<다중 if문>
if 조건식1 then
    문장1;
elsif 조건2 then
    문장2;
    ...
end if;

*/

--예제5
--연도에 맞는 띠구하기

-- 키보드로 연도를 이력받고자 할 경우
accept year prompt '태어난 연도를 입력하세요.';

DECLARE 
    v_year number(4) := '&year'; -- 입력한 값을 대입
    v_mod number(2):= mod(v_year,12); --연도를 12로 나눈 나머지를 구한다.
    v_ddi varchar2(10); -- 띠를 저장할 변수
    
BEGIN
    if v_mod = 0 then v_ddi :='원숭이' ;
     elsif v_mod = 1 then v_ddi :='닭';
     elsif v_mod = 2 then v_ddi :='개';
     elsif v_mod = 3 then v_ddi :='돼지';
     elsif v_mod = 4 then v_ddi :='쥐';
     elsif v_mod = 5 then v_ddi :='소';
     elsif v_mod = 6 then v_ddi :='호랑이';
     elsif v_mod = 7 then v_ddi :='토끼';
     elsif v_mod = 8 then v_ddi :='용';
     elsif v_mod = 9 then v_ddi :='뱀';
     elsif v_mod = 10 then v_ddi :='말';
     elsif v_mod = 11 then v_ddi :='양';
    end if;
    
    DBMS_Output.put_line(v_year||'년생은'||v_ddi||'띠 입니다.');
end;
/   
    
    
--예제4
--db의 컬럼의 타입을 가져오는 방법 TYPE5
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

    DBMS_Output.put_line('학생명 : '||v_name);
    DBMS_Output.put_line('키 : '||v_height);
    DBMS_Output.put_line('java : '||v_java);
    DBMS_Output.put_line('spring : '||v_spring);
    DBMS_Output.put_line('총점 '||v_java + v_spring);
end;
/


--- 반복문
/*
반복문 : loop
loop
    문장들;
    exit when 조건;
end loop;
*/


accept num prompt '출력할 숫자?';
DECLARE

    v_no number(2) := '&num';
    
BEGIN
  loop
        v_no := v_no+1;
        DBMS_Output.put_line('no='||v_no);
        exit when v_no = 10; --10일 경우 반복문을 빠져나간다.
   end loop;
end;
/ 




--구구단
accept num prompt '출력할 숫자?';
DECLARE

     v_num1 number(2) := '&num';
     v_num2 number(2) := 1;
     
    
BEGIN
    loop
        DBMS_Output.put_line( v_num1||'×'|| v_num2 ||'='|| v_num1* v_num2);
        v_num2 := v_num2 + 1;
        exit when v_num2 = 10; 
    end loop;

end;
/ 


/*
for 변수 in [reverse] 시작값... 최종값 loop
    문장들;
end loop;
*/


accept num prompt '출력할 숫자?';
DECLARE

     v_num1 number(2) := '&num';
     v_num2 number(2);
     
    
BEGIN
    for v_num2 in  1 .. 9 loop
     DBMS_Output.put_line( v_num1||'×'|| v_num2 ||'='|| v_num1* v_num2);
    end loop;

end;
/ 

--레코드 단위로 데이터 가져오기
DECLARE
    v_num student.num%TYPE := 12;
    v_stu aiur.student%rowtype ; --레코드 단위로 읽어 올 경우
    
BEGIN
  select * into v_stu
  from student where num = v_num;
    DBMS_Output.put_line('이름 ' ||v_stu.name ); 
    DBMS_Output.put_line('키 ' ||v_stu.height ); 
    DBMS_Output.put_line('자바 ' ||v_stu.java ); 
    DBMS_Output.put_line('스프링 ' ||v_stu.spring ); 
    DBMS_Output.put_line('자바 ' ||v_stu.ban); 
end;
/ 

--db의 여러 데이터를 조회할 경우
/*
    Cursor : sql문을 실행 할 때마다 명령이 분석되고 실행되어 결과를 보관하기 위한 특별한 메모리 영역을 사용하는데 
    이 영역을 참조하는 것이 Cursor이다.
    
    select문에서 여러 데이터 조회 시 사용하는 객체이다.
    
    커서 속성
    sql%rowcount : 실행된 갯수 반환
    sql%found : 가장 최근의 sql 문이 하나 이상의 행에 영향을 준 경우 treu
    sql%notfound : 결과 행이 없는 경우
    sql%isopen : 항상 false(항상 close를 하기때문에 항상 false)
*/

--예제 12


DECLARE
 v_sno number(3) :=20;
 v_shop aiur.shop%rowtype;
    
    
BEGIN

select * into v_shop
from shop where sang_no= v_son;
  
    
    DBMS_Output.put_line('상품명 : ' ||v_shop.sang_name); 
    DBMS_Output.put_line('조회 횟수 : ' ||sql&rowcount); 
    
    -- student의 java 점수 변경하기
    update student set java = 99;
    DBMS_Output.put_line('수정된 횟수 : ' ||sql&rowcount); 
    
end;
/ 

-- 여러 레코드 조회



DECLARE
    Cursor s1  --커서를 지정하면 아래 실행문에 대한 결과를 커서가 가지고 있게 됨.
    is 
    select * from shop;
        
BEGIN
    
    
    DBMS_Output.put_line('상품번호  상품명  색상  가격'); 
    DBMS_Output.put_line('-----------------------------'); 
    for s in s1 loop   
        exit when s1%notfound; -- 더이상 데이터가 없으면 빠져나간다.
        DBMS_Output.put_line(s.sang_no||' '||s.sang_name||' '||s.sang_color||' '||s.sang_price);
    end loop;
end;
/ 


-- 예제 14
-- 상품명, 색상, 가격을 입력하면 shop,db에 추가하기

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
    DBMS_Output.put_line('상품정보를 추가했습니다.'); 
    
end;
/ 

----------------------

--문제 : food테이블

/*

fname, fprice, no 입력을 받아서 
no가 1이면 fname, fprice로 데이터 추가를 하고,
no가 2이면 food 전체 데이터 출력.

*/

accept choice prompt '1.메뉴 등록 | 2. 메뉴 출력';
accept addmenu prompt '음식명 입력';
accept setprice prompt '가격 입력';

DECLARE

    v_num number(2) := '&choice';
    v_food food.food_name%TYPE := '&addmenu';
    v_price food.food_price%TYPE := '&setprice';
    
    Cursor c1

BEGIN
    
    if v_num = 1 then
    
    insert into food values (seq_food,nextval, v_food, v_price);
    DBMS_Output.put_line('메뉴를 추가했습니다.'); 
    


    end if;
    commit;

end;
/ 

























