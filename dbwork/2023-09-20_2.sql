
create SEQUENCE seq_test nocache;

--table 생성
create table test(
    num number(3) PRIMARY KEY, --제약조건 1/
    name VARCHAR2(20) not null,  -- 제약조건2/ null값을 허용하지 않겠다. 값이 없으면 오류
    blood char(2) default 'A', 
    weight number(5,2), -- 총5자리의 소수점이하 2자리까지
    birth date);
    
-- 일부 데이터만 넣는 경우 컬럼명을 반드시 표기한다.
insert into test (num,name) values (seq_test.nextval,'캔디');


-- 테이블의 모든 데이터를 순서대로 넣을거면 Column값 생략 가능
insert into test values (seq_test.nextval,'캐서린','AB',67.89,sysdate);

--제약조건에 안맞는 경우 오류 확인
insert into test (num,blood) values (seq_test.nextval,'O');
insert into test (num,name,blood) values (2,'Lee','O'); -- 기존에 있는 넘버에 들어가거나..

--제대로 된 데이터 3개 추가
insert into test values (seq_test.nextval,'강호동','B',78.9,'2000-10-10');
insert into test values (seq_test.nextval,'유재석','A',66.1,'1979-12-25');
insert into test values (seq_test.nextval,'이영자','O',56.7,'1969-09-09');


--마지막 commit 한 이후 sqlans (DML: insert, delete, update) 모두 취소
commit; -- 더이상 롤백 안됨


insert into test values (seq_test.nextval,'김이나','AB',56.78,'1988-12-05');


--강호동의 혈액형을 AB형으로 수정
update test set blood='AB' where name = '강호동';


--두개의 컬럼 수정
update test set weight = 80.9 , birth = sysdate where num=1;

--삭제
delete from test;

rollback;

delete from test where num in(1,12);

--table 제거
drop table test; --롤백 안됨

drop SEQUENCE seq_test;



create table person(
    num number(3) CONSTRAINT person_pk_num PRIMARY key,
    blood char(2));
    
    
--기존 제약조건 제거
    alter table person drop constraint person_num_pk;
    
-- 다시 primary key에 대한 제약조건 추가
    alter table person add constraint person_num_pk primary key(num);
    

--blood에 대해서 check 제약조건 추가

alter table person add constraint person_Ck_blood check (blood in('A','B','O','AB'));


insert into person values(1,'A');
insert into person values(1,'B'); -- 무결성 제약조건 
insert into person values(2,'b'); -- 오류 : 체크 제약조건이 위배되었습니다.(소문자 )
insert into person values(2,'O'); 

--컬럼을 뒤늦게 추가해보자.
alter table person add name varchar2(20);
alter table person add score number(5,1) default 30.5;

--컬럼명 제거
alter table person drop column num;


--java 라는 컬럼을 number 타입으로 추가 후 1-100 사이값만 들어오도록 제약조건도 추가.
alter table person add java number(3) default 0;
alter table person add CONSTRAINT person_ck_java check (java>=0 and java <=100);


--컬럼명 변경 rename column
alter table person rename column java to spring;


--데이터 추가시 컬럼 순서대로 주기 싫을 경우 컬럼명 주면 된다.
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

alter table student add constraint student_class check(ban in('햇님반','달님반','별님반'));


insert into student values (seq_stu.nextval,'홍길동',13.5, 33, 67, '달님반');
insert into student values (seq_stu.nextval,'박길수',112.5, 99, 13, '햇님반');
insert into student values (seq_stu.nextval,'얌얌이',181.5, 78, 100, '달님반');
insert into student values (seq_stu.nextval,'쿠라라',170.5, 55, 35, '별님반');
insert into student values (seq_stu.nextval,'인사람',173.9, 81, 88, '햇님반');

commit;

rollback;
delete from student where num >= 8;

update student set java = 99 where num = 5;
update student set height =  100.0 where num =6;

delete from student where num = 6;

SELECT NAME 이름, BAN 반, JAVA 자바, SPRING 스프링, JAVA+SPRING 총점, JAVA+SPRING/2 평균 FROM STUDENT ORDER BY 총점 DESC;












