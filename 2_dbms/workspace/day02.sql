#-------------------- 수강신청 관리 시스템 --------------------
#학생[학번(pk), 이름, 핸폰, 이메일, 전공, 강의명(fk)]
#강의[강의실번호(pk), 수업코드, 강의명, 교수명, 강의정보, 최대인원] 

#학생[학번(PK), 이름(NN), 학과(FK), 주민번호(UQ), 학년]
#과목[과목명(PK), 과목설명(NN), 학점(NN)]
#수업[수업코드(PK), 과목명(NN), 담당교수(FK), 정원, 요일/시간, 강의실, 개설학과(FK), 분류, 수업설명]
#교수[교수번호(PK), 교수명(NN), 핸드폰번호, 이메일, 학과(PK), 직위(CK-정교수,부교수,전임교수)]
#신청[인덱스(PK), 학번(FK), 수업코드(FK), 신청일시]
create database lecture;
use lecture;
create table lecture(
	room_num int primary key,
    code varchar(300),
    lecture_name varchar(300),
    professor_name  varchar(300),
    info varchar(300),
    capacity int,
    index idx_lecture_name (lecture_name)
);
create table student(
	student_id int primary key,
    name varchar(300),
    ph varchar(300),
    email varchar(300),
	major varchar(300),
    lecture_name varchar(300),
    constraint lecture_name_fk foreign key(lecture_name) references lecture(lecture_name)
);
drop database lecture;
describe lecture;


#-------------------- 인천공항 수하물 관리 시스템 --------------------
#이용자[이용자 번호(pk), 이름, 국적, 수하물번호(fk)]
#수하물[수하물번호(pk), 수하물정보, 체크인, 티켓 번호(fk)]
#티켓[티켓 번호(pk), 항공사, 출발지, 목적지, 게이트번호, 이용자 번호(fk)] 
create database airport;
use airport;
create table user(
	user_id int primary key,
    user_name varchar(300),
    user_nationality varchar(300),
    bag_id int
);
create table ticket(
	ticket_id int primary key,
    airline varchar(300),
    starting_point varchar(300),
    ending_point varchar(300),
    gate_num varchar(300),
    user_id int,
    constraint user_fk foreign key(user_id) references user(user_id)
);
create table baggage(
	bag_id int primary key,
    bag_info varchar(300),
    checkin boolean,
    ticket_id int,
    constraint ticket_fk foreign key(ticket_id) references ticket(ticket_id)
);
describe baggage;
describe user;
#user 테이블에 나중에 fk 제약 조건 추가
alter table user 
add constraint bag_fk foreign key(bag_id) references baggage(bag_id);
drop database airport;


#-------------------- K-리그(축구) 홈페이지 제작 --------------------
#팀정보[팀고유번호(pk), 팀이름(unique?인덱스?), 팀로고, 감독정보, 창단 연도, (순위할까말까))]
#리그정보[순위(pk), 참가팀이름(fk), 국가, 경기 횟수, 승점(스코어), 승(횟수), 패(횟수), 무(횟수)]
#경기정보[경기번호(pk), 경기일정, 경기장정보, 팀이름(fk)]
#선수정보[선수이름, 선수등번호, 포지션, 팀이름(fk)]
create database league;
drop database league;
use league;
create table team(
	team_id int primary key,
    team_name varchar(300),
    teamlogo varchar(300),
    director varchar(300),
    founded_year int,
    index idx_team_name (team_name)
);
create table league_info(
	rankint int primary key,
    team_name varchar(300),
    nation varchar(300),
    match_num int,
    score int,
    win int,
    lose int,
    tie int,
    constraint team_name_league_info_pk foreign key(team_name) references team(team_name)
);
create table `match`(
	game_num int primary key,
    game_sched varchar(300),
    stadium varchar(300),
    team_name varchar(300),
    constraint team_name_match_pk foreign key(team_name) references team(team_name)
);
create table player(
	player_num int primary key,
    player_name varchar(300),
    position varchar(300),
    team_name varchar(300),
    constraint team_name_player_pk foreign key(team_name) references team(team_name)
);
describe league_info;
drop database league;

use gb;
create table test(
	pk varchar(300) primary key,
    num1 int,
    num2 decimal(5,2),
    str1 varchar(300),
    str2 varchar(300)
);

#데이터 추가
#형변환이 자동으로 이뤄진다. 
#컬럼명을 지정해서 데이터 추가시 해당 컬럼에 들어갈 값들만 넘겨주기(컴럼명 순서가 바뀌면 바뀐 순서대로 데이터 작성)
insert into test (pk, num1, str1) values('pk001', 10, 1111);

#PK값이 동일하면 제약조건 충돌로 데이터 삽입 불가
insert into test (num1, pk) values(10, 'pk001');
insert into test (num1, pk) values(10, 'pk002');

#컬럼명을 생략할 시 테이블 구성 컬럼 순서대로 값을 모두 넘겨주기
insert into test values('pk003', 30, 222.22, 'varchar data1', 'varchar data2');

#데이터 삭제
delete from test where pk='pk002';

#Edit > Preferences > SQL Editor > 맨 아래 Safe Updates 해제 (재연결해야함)
delete from test where num1 >=0 and num1 <=10;
#컬렴명 between 값1 and 값2: 컬럼의 값이 값1과 값2의 사이인지 확인하는 조건식
delete from test where num1 between 0 and 10;

delete from test where num1 = 10 or num1 = 30;
delete from test where num1 in (10,30);

#데이터 수정
update test 
set num1 = 300
where pk = 'pk003';
update test set num1=100, str1='changed Msg' where pk='pk001';

#데이터 조회
select pk, num1, str1 from test where num1 > 100;
select pk, num2 from test;

# *의 의미는 '모든 것'을 의미한다.
select * from test;

#문자열끼리 대소 비교 가능(사전순으로 뒤에 있는 값이 더 큰 값)
select * from test where pk > 'pk001';

#간단한 연산 가능 (수행 순서를 알고 있어야 결과를 이해할 수 있음)
#컬럼명 자리에 연산이나 함수 호출을 써주게 되면 from 뒤에 적힌 테이블의 행의 개수만큼 결과가 나온다. 
select 1+1 from test;
#만약 where절을 이용해서 데이터를 골라냈다면, 그 조건절이 참인 행의 개수만큼 결과가 나온다.
select 1+1 from test where pk > 'pk001';

#now() 현재 시간
#조건식 없으면 행이 걸러지지 않으니, 결과값이 3개가 나옴. 그렇다고 매번 조건식을 달 순 없잖아?
select now() from test where pk = 'pk001';
#daul 테이블: 간단한 값이나 연산의 결과를 검색하기 위한 내장 테이블, 결과가 한 행으로만 나온다. 
select now() from dual;

#별칭(Alias): 컬럼명 혹은 테이블에 이름 대신 사용할 별칭을 주는 기법(컬럼명 별칭)
select 1+2*27/12-1 result from dual;
#별칭이 키워드거나 띄어쓰기가 포함된 경우에는 쌍따옴표로 묶어준다. 
select 1+2*27/12-1 "re sult" from dual;
#컬럼명에 별칭을 줄 때에는 as 키워드 사용 가능
select 1+2*27/12-1 as "re sult" from dual;
#원칙적으로 앞에 테이블명.컬럼명  /  db명.테이블명
select test.num2 from gb.test;
#테이블에도 별칭을 줄 수 있다.
select t.num2 from gb.test t;

#null 값 비교
#null 값은 =, != 으로 비교하지 않고, is, is not 으로 비교
select * from test where num2 = null;
select * from test where num2 is null;

# -----------------------------------------------------------------
#1. 주문 테이블에 데이터 3개 삽입하기 - fk가 있는 경우, 부모 데이터 먼저 삽입
select * from flower;
insert into flower values('1', '국화', '흰색', 10000, 10);
insert into flower values('2', '안개꽃', '흰색', 5000, 100);
insert into flower values('3', '장미', '빨간색', 7000, 300);
insert into flower values('4', '개나리', '민트색', 150000, 1);
select * from pot;
insert into pot values('1', 'round', 'black', 'soil', 3000, 10, 'large');
insert into pot values('2', 'square', 'white', 'plastic', 2000, 50, 'small');
insert into pot values('3', 'round', 'white', 'plastic', 2000, 50, 'small');
insert into pot values('4', 'round', 'white', 'brick', 2000, 50, 'small');
select * from `order`;
insert into `order` values('김사과', '01011111111', '서울시_강남구_역삼동', 1, 2);
insert into `order` values('반하나', '01022222222', '제주도', 2, 2);
insert into `order` values('임채리', '01033333333', '경상북도_울릉군_울릉읍_독도리', 3, 3);

#2. 영화 시간표 테이블에 데이터 2개 삽입하기
select * from movie;
insert into movie values(1, '해리포터와 마법사의 돌', '판타지', 121, '크리스 콜럼버스', '다니엘 래드클리프, 루퍼트 그린트, 엠마 왓슨', 8.12);
insert into movie values(2, '해리포터와 비밀의 방', '판타지', 130, '크리스 콜럼버스', '다니엘 래드클리프, 루퍼트 그린트, 엠마 왓슨', 7.22);
insert into movie values(3, '해리포터와 아즈카반의 죄수', '판타지', 129, '알폰소 쿠아론', '다니엘 래드클리프, 루퍼트 그린트, 엠마 왓슨', 9.01);
insert into movie values(4, '반지하의 제왕', '판타지', 480, '정다솔', '송민근, 정주연, 배규진, 엠마 왓슨', 9.99);
select * from theater;
insert into theater values(1, '강남대로 438 스타플렉스 4층', '강남점', 3600);
insert into theater values(2, '서초구 서초대로77길 3 아라타워 8층', '강남점', 1200);
insert into theater values(3, '평촌 cgv', '평촌점', 100);
select * from time_table;
insert into time_table values('2024-07-12 14:30:00', '2024-07-12 16:31:00', 1, 1);
insert into time_table values('2024-07-13 14:30:00', '2024-07-13 16:31:00', 1, 2);

#3. 영화 테이블에 있는 모든 데이터들의 장르를 액션으로 수정하기
update movie
set genre = '액션'
where genre = '판타지';
select * from movie;

#4. 주문 테이블에 있는 특정 화분을 이용한 주문들의 주문자를 김사과로 수정하기
update `order`
set name = '김사과'
where pot_id = 2;
select * from `order`;

#5. 화분 테이블에 있는 모든 데이터 삭제하기
# ----> fk 참조되어 있는 다른 테이블이 있으니, 1)참조된 테이블을 먼저 삭제하거나, 2)fk 제약 조건 해제를 해야한다.
#fk 제약 조건 해제
alter table `order` drop foreign key `pot_fk`;
delete from pot;
select * from pot;

#6. 반하나가 벽돌 화분에 민트색 개나리를 샀을 경우의 쿼리문을 작성
insert into `order` values('반하나', 01055555555, '서울시_강남구_현재여기', 4, 4);
select * from `order`;

#7. 송민근, 정주연, 배규진 출연의 판타지 영화 '반지하의 제왕'을 평촌 cgv에서 상영할 때의 궈리문들 작성
select * from movie;
