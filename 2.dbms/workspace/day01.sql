#세미콜론만 제대로 붙이면 영향 없다. hello world!
#실행: 실행할 명령어에 커서를 두고 crtl + enter
create database gb;
drop database gb;

#데이터베이스 사용
use gb;

#자동차 테이블
#모델 색깔, 가격
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
#컬럼 자료형 수정 - 안에 데이터가 있다면 수정 안돼
alter table car modify owner varchar(301);
#컬럼 삭제
alter table car drop owner;

#alter문을 사용하게 되면 그 모든 과정들을 읽어봐야 테이블 최종 형태가 나온다.
#그래서 테이블을 수정하기보단, drop 후 새로운 형태의 create문을 다시 수행
drop table car;
create table car(
	model varchar(300),
    color varchar(300),
    price int,
    owner varchar(300)
);

#제약조건
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


#각 테이블당 컬럼 최소 4~5개 구상
#-------------------- 동물원 --------------------
# 동물[번호, 종, 이름, 성별(남/여), 접종(유/무)]
# 관리자[관리자번호, 관리자이름, 소속, 핸드폰번호, 담당동물]
#check 제약조건: check(조건식) -> 조건식이 참인 데이터들만 삽입 가능
#컬럼 in (값1, 값2, ...) : 컬럼의 값이 값1 또는 값2 또는 ... 이면 참
#컬럼 = 값1 or 컬럼 = 값2 or ...
create database zoo;
use zoo;
create table animal(
	animal_id int primary key,
	species varchar(300),
    name varchar(300),
    gender boolean,
    #gender char(1) check(gender in ('M', 'W')) 
    injection boolean
);
create table manager(
	manager_id int primary key,
    manager_name varchar(300),
    manager_agency varchar(300),
    manager_hp varchar(300),
    animal_id int,
    constraint animal_fk foreign key(animal_id) references animal(animal_id)
);

#-------------------- 학교 --------------------
#학생[번호(학번), 이름, 나이, 성별(남/여), 법적보호자_핸드폰번호]
#성적[성적번호, 총점, 석사, 학생이름]
#unique 제약 조건: 중복되는 값이 들어오면 오류 발생
create database school;
use school;
create table student(
	stud_id	int primary key,
    name varchar(300),
    age int,
    gender boolean,
    parents_hp varchar(300),
    jumin varchar(300) unique
);
create table grade(
	grade_id int primary key,
	total_score int,
	ranking int,
    stud_id	int,
    constraint student_fk foreign key(stud_id) references student(stud_id)
);

#------------------- 꽃집 --------------------
#꽃집에서 사용할 프로그램에 필요한 테이블
#꽃집[꽃번호, 꽃이름, 꽃가격, 꽃수량]
#주문[주문 번호, 주문 내역, 주문 가격, 결제 유무, 구매자]
#고객[구매자번호, 구매자이름, 구매자 핸드폰, 전달 주소]
create database flower_shop;
use flower_shop;
create table flower(
	flower_id int primary key,
    name varchar(300),
    price int,
    stock int
);
create table order_table(
	order_id int primary key,
    order_contents varchar(300),
    order_price int,
    payment_status boolean,
    flower_id int,
    user_id int,
    constraint flower_fk foreign key(flower_id) references flower(flower_id),
    constraint user_fk foreign key(user_id) references user(user_id)
);
create table user(
	user_id int primary key,
    name varchar(300),
    ph varchar(300),
    addr varchar(300)
);

#-------------------- 영화관 --------------------
#CGV에서 사용할 사내 프로그램에 필요한 테이블
#영화[영화번호, 영화제목, 영화감독, 영화장르, 상영시간표]
#팝콘가게[팝콘맛, 음료종류, 세트유무, 고객번호]
#고객[고객번호, 영화번호]
create database cgv;
use cgv;
create table movie(
	movie_id int primary key,
    title varchar(300),
    actor varchar(300),
    timeline varchar(300),
    genre varchar(300),
    score decimal(3,2)
);
#pk를 만들지 않아도 된다: 테이블의 레코드들이 중복되거나 식별이 필요하지 않는 경우
create table time_table(
	start_time datetime,
    end_time datetime,
    movie_id int, 
    constraint movie_fk foreign key(movie_id) references movie(movie_id)
);
create table popcorn_shop(
	popcorn_flavor varchar(300) primary key,
    juice varchar(300),
    combo boolean,
    constraint user_fk foreign key(user_id) references user(user_id)
);
create table user(
	user_id int primary key,
    constraint movie_fk foreign key(movie_id) references movie(movie_id)
);

#-------------------- 애견샵 --------------------
#애견샵에서 사용할 회원 관리 프로그래밍 필요한 테이블
#회원번호, 회원이름, 회원강아지이름, 회원번호
create table pet_shop(
	user_id int primary key,
    name varchar(300),
    dog_name varchar(300),
    ph varchar(300)
);

#-------------------- 호그와트 --------------------
#호그와트에서 사용할 프로그램의 테이블
#교수님이름, 과목명, 경력, 기숙사 
create table hogwarts(
	professor_id int primary key,
	professor_name varchar(300),
    subject_name varchar(300),
    carrer int,
    dormitory varchar(300)
);
