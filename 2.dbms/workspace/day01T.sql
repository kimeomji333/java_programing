#그냥 써도 세미콜로만 제대로 붙이면 영향 X
#실행 : 실행할 명령어에 커서를 두고 Ctrl + Enter
create database gb;
drop database gb;

#데이터베이스 사용
use gb;

#자동차 테이블
#모델, 색깔, 가격
#테이블 생성
create table car(
	model varchar(300),
    color varchar(300),
    price int
);

#테이블 삭제
drop table car;

#테이블 수정
#컬럼 추가
alter table car add(owner varchar(300));
#컬럼 자료형 수정
alter table car modify owner varchar(301);
#컬럼 삭제
alter table car drop owner;

#alter문을 사용하게 되면 그 모든 과정들을 읽어봐야 테이블 최종 형태가 나온다.
#테이블을 수정하기보단, drop 하고 새로운 형태의 create 문을 다시 수행
drop table car;
create table car(
	model varchar(300),
    color varchar(300),
    price int,
    owner varchar(300)
);

#primary key
create table car(
	carnum varchar(300) primary key,
	model varchar(300),
    color varchar(300),
    price int,
    owner varchar(300)
);
create table car(
	carnum varchar(300),
	model varchar(300),
    color varchar(300),
    price int,
    owner varchar(300),
    constraint primary key(carnum)
);

#foreign key
create table user(
	userid varchar(300) primary key,
    username varchar(300)
);

create table product(
	prodnum int primary key,
    prodname varchar(300),
    prodprice int,
    userid varchar(300),
    constraint user_fk foreign key(userid) references user(userid)
);

#각 테이블 당 컬럼 최소 4 ~ 5개
#동물 테이블
#check 제약조건
#check(조건식) --> 조건식이 참인 데이터들만 삽입 가능
#컬럼 in (값1, 값2, ...) : 컬럼의 값이 값1 또는 값2 또는 ... 이면 참
#컬럼 = 값1 or 컬럼 = 값2 or ...
create table animal(
	animal_id varchar(300) primary key,
	name varchar(300),
    gender char(1) check(gender in ('M','W')),
    age int
);

#학생 테이블
#unique 제약조건 : 중복되는 값이 들어오면 오류 발생
create table student(
	stud_no varchar(300) primary key,
	name varchar(300),
    grade int,
    age int,
    major varchar(300),
    jumin varchar(300) unique
);

#꽃집에서 사용할 프로그램에 필요한 테이블
create table flower(
	flower_id varchar(300) primary key,
	name varchar(300),
    color varchar(300),
    price int,
    amount int
);
create table pot(
	pot_id varchar(300) primary key,
	shape varchar(300),
    color varchar(300),
    material varchar(300),
    price int,
    amount int,
    size varchar(300)
);
create table `order`(
	name varchar(300),
    phone varchar(300),
    addr varchar(300),
    flower_id varchar(300),
    pot_id varchar(300),
    constraint flower_fk foreign key(flower_id) references flower(flower_id),
    constraint pot_fk foreign key(pot_id) references pot(pot_id)
);

#CGV에서 사용할 사내 프로그램에 필요한 테이블
create table movie(
	movie_id varchar(300) primary key,
	title varchar(300),
	genre varchar(300),
    running_time varchar(300),
    director varchar(300),
    actor varchar(1000),
    score decimal(3,2)
);
create table theater(
	theater_id varchar(300) primary key,
    addr varchar(1000),
    num varchar(300),
    seat_count int
);
create table time_table(
	start_time datetime,
    end_time datetime,
    movie_id varchar(300),
    theater_id varchar(300),
    constraint movie_fk foreign key(movie_id) references movie(movie_id),
    constraint theater_fk foreign key(theater_id) references theater(theater_id)
);

#애견샵에서 사용할 회원 관리 프로그램에 필요한 테이블
#호그와트에서 사용할 프로그램의 테이블








