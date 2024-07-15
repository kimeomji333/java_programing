use gb;
drop table test;
create table test(
	num int primary key auto_increment,
    strdata varchar(300),
	doubledata decimal(3,2) default 0.00,
    timedata datetime
);
select * from test;
insert into test (strdata) values('Hello0');
insert into test (strdata) values('Hello1');
insert into test (num, strdata) values(100, 'Hello2');
insert into test (strdata) values('Hello3');

#date, datetime 타입
insert into test (timedata) values('2024-07-15 09:00:00');
select now() from dual;
insert into test (timedata) values(now());

#default 제약조건
insert into test (strdata, timedata) values('Hello4', now());

#database: world
use world;
select * from city;
select * from country;

#like 조건식: 검색 구현할 때 사용
select * from country where name like('%korea%');

#문자열 연결, 문자열 길이
select concat('He', 'llo', 'DBMS'), length('flower') from dual;

#숫자 올림, 내림, 반올림
select ceil(3.24), floor(3.14), round(3.45) from dual;
select ceil(3.24), floor(3.14), round(3.45, 1) from dual;

#형변환 함수
select cast(10 as char), convert(10, char) from dual;

#null 처리 함수
select name, gnp, gnpold from country;
select name, gnp, ifnull(gnpold, '기록없음') gnpold from country;

#그룹 함수
#null 인 경우, count와 avg의 경우에는 값이 달라지기 때문에 * 사용시 주의하기
select count(*), sum(population), max(population), min(population), avg(population) from country;
select count(*), count(gnpold) from country;
select count(ifnull(gnpold, '값 없음')) from country;

#order by 절 (select뒤에 일어남)
select name, population, gnp from country order by gnp desc;
#컬럼의 번호로 정렬 가능(3번째 열 기준으로 정렬)
select name, population, gnp from country order by 3 desc;
select name, population, gnp, gnp/population "인당 gnp" from country order by 4 desc;
#컬럼의 별칭으로 정렬 가능(``사용)
select name, population, gnp, gnp/population "인당 gnp" from country order by `인당 gnp` desc;

#group by 절(기준되는 그룹들을 앞에 적음)
select continent, region, count(*) from country group by continent, region;

#having 절
select continent, region, count(*) from country
group by continent, region having count(*) >= 10;

#그룹함수는 데이터를 걸러내는 WHERE절에는 사용할 수 없다.
select * from country where pupolation > avg(population);

#-------------------- 연습 문제 --------------------------
select * from country;
#소속 대륙이 Asia인 나라 검색
select * from country where continent = 'Asia';

#소속 대륙이 Europe이 아닌 나라 검색
select * from country where continent != 'Europe';

#인구수가 1000만 이하인 나라 검색
select * from country where population <= 10000000;

#인구수가 7000만 이상인 나라 검색
select * from country where population >= 70000000;

#인구수가 4500만 이상이면서 넓이가 10만 제곱 km 이하인 나라 검색
select * from country where population >= 45000000 and surfaceArea <= 100000;

#소속 대륙은 Asia 이고 건국 연도가 1948인 나라 검색
select * from country where continent = 'Asia' and indepyear = 1948;

#지역이 동아프리카 이고 건국 연도가 1970~1980년 인 나라 검색
select * from country where region = 'eastern africa' and indepyear between 1970 and 1980;
#조건식 and가 or보다 우선(괄호 잘 사용). and가 여러개 있을 경우. 앞에서부터 진행.

#이름에 North가 들어간 나라를 검색 
select * from country where name like '%North%';

#Asia 대륙에 속하고 끝이 a로 끝나는 나라들 검색
select * from country where continent = 'Asia' and name like '%a';

#Europe 대륙에 속하고 이름 글자수가 6글자이며 f가 들어가는 나라를 검색
select * from country 
where continent = 'Europe' and length(name) = 6 and name like '%f%';

#대륙별 평균 gnp 검색
select continent, avg(gnp) "평균 gnp" from country group by continent;

#gnp 평균이 100000 이상인 지역들의 지역명, gnp최대값, gnp최소값, gnp평균 검색
select 
	region 지역명, 
	max(gnp) gnp최대값, 
    min(gnp) gnp최소값, 
    avg(gnp) gnp평균
from country 
group by region 
having avg(gnp) >= 100000;

#대륙별 평균 인구를 검색하되 15000000명을 넘는 대륙만 검색
select continent, avg(population) "평균 인구" from country 
group by continent
having avg(population) > 15000000;

#인구수가 20000000을 넘는 나라들의 평균 넓이가 2000000 제곱 km를 넘는 대륙들만 검색
#인구수가 20000000을 넘는 나라들 <- where 절 이용했어야지 ~~~~~ 오늘 문제의 핵심!
select continent from country
where population > 20000000
group by continent
having avg(surfaceArea) > 2000000;

#대륙별, 지역별로 나라들의 평균 수명 검색
select continent, region, avg(lifeexpectancy) "평균 수명" from country
group by continent, region;

#아시아, 유럽에 속한 나라들 중에 정치제도별로 정치제도, 나라수, 평균수명, 평균 gnp 검색
select governmentform 정치제도, count(name) 나라수, avg(lifeexpectancy) 평균수명, avg(gnp) 평균gnp from country
where continent in ('Asia', 'Europe')
group by governmentform;

select * from country;