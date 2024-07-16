use gb;
select * from `order`;
select * from flower;

#join on을 사용하면 테이블이 하나 더 만들어진다. 거기에 조건을 걸려면 where 절을 사용한다.
select
	o.name,
    f.name,
    f.color
from `order` o
	inner join flower f on o.flower_id = f.flower_id
where f.color = '민트색';

#조건에 벗어나는 결과값을 넣으면 포함되지 않는다.
insert into `order` values('김사과', 01011111111, '서울시 강남구 역삼동', null, 1);

#그래서
#left outer join: 주테이블인 from을 기준으로 데이터 테이블 만들 때
select
	o.name "꽃 이름",
    ifnull(f.name, '구매x') "구매자 이름",
    ifnull(f.color, '구매x') 색깔
from `order` o
	left outer join flower f on o.flower_id = f.flower_id;

#natural join(join ~ using)
select
	o.name,
    f.name,
    f.color
from `order` o
	join flower f using(flower_id);
    
#limit: 몇개씩 게시글 테이블 가져올 때 사용
use world;
select * from country;
select * from country where continent = 'Asia' order by name desc limit 5;
select * from country where continent = 'Asia' order by name desc limit 10,10;
select * from country limit 14,1;

#sub query: sql문 내부에 sql문 작성
select ceil(avg(population)) from country;
select 10 from country;
select 
	name, 
    population, 
    (select ceil(avg(population)) from country) 평균인구수 
from country;

select
	name, 
    population
from country
where population > (select ceil(avg(population)) from country);

#-------------------------- 연습하기 database : sakila --------------------------
use sakila;
select * from film;
select * from category;
select * from film_category;
select * from customer;
select * from address;
select * from language;
select * from city;
select * from country;
select * from film_actor;
select * from actor;
select * from rental;
select * from inventory;
select * from staff;
   
#영화제목, 카테고리 검색 -> 중간테이블에서 2개의 테이블을 조인
select 
	f.title "film title", 
    c.name "category"
from film f
	join film_category fc on f.film_id = fc.film_id
    join category c on fc.category_id = c.category_id;

#melissa king 회원의 주소와 핸드폰번호 검색 -> first/last name으로 회원 찾아, adress_id로 주소 테이블 조인, 주소와 핸폰 검색
select
	a.address, a.phone
from customer c
	join address a on a.address_id = c.address_id
where c.first_name = 'Melissa' and c.last_name = 'king';
#서브쿼리로 해보기
select address, phone from address where address_id = (select address_id from customer where first_name = 'melissa' and last_name = 'king');

#'model fish' 영화의 언어 검색 ->  film 테이블에서 title, langugae_id로 조인해서 / language 테이블에 name 검색
select
	f.title "film title",
    l.name "language of film"
from film f
	join language l on l.language_id = f.language_id
where f.title = 'model fish';

#A로 시작하는 도시들이 속한 나라의 이름과 그 도시명 검색 -> city 테이블에서 a로 시작하는 city에서 도시명, country_id로 조인해서 / country 테이블에서 나라이름
select 
	c.city, cy.country
from city c
	join country cy on c.country_id = cy.country_id
where c.city like 'A%';

#'model fish' 영화에 출연한 배우들의 이름 검색 (8개 검색)
#-> film 테이블에서 title이 model fish인 경우, film_actor 중간테이블과 film_id로 조인, actor_id로 조인, 조인한 actor 테이블에서 first/last name 검색 
select
	a.first_name, a.last_name
from film f
	join film_actor fa on fa.film_id = f.film_id
    join actor a on a.actor_id = fa.actor_id
where f.title = 'model fish';

#jane jackman이 출연한 영화제목들 검색 
#-> actor 테이블에서 jane jackman을 찾고, actor_id로 film_actor 중간테이블과 조인해서, film_id로 조인한 film title 들을 찾는다
select
	f.title
from actor a
	join film_actor fa on fa.actor_id = a.actor_id
    join film f on f.film_id = fa.film_id
where a.first_name = 'jane' and a.last_name = 'jackman';

#궁금해서 찾아보기
#jane jackman의 actor_id = 131번
select actor_id from actor a where a.first_name = 'jane' and a.last_name = 'jackman';
#actor_id = 131이 참가한 영화
select film_id from film_actor where actor_id = 131;

#judith cox가 사는 도시의 이름 검색 
#-> customer 테이블에서 judith cox를 찾아, address_id로 address 중간테이블과 조인해서 city_id 찾아, city 테이블과 조인해서 city 검색
select c.address_id from customer c where c.first_name = 'judith' and c.last_name = 'cox';
select
	ct.city "도시명"
from customer c
	join address a on a.address_id = c.address_id
    join city ct on ct.city_id = a.city_id
where c.first_name = 'judith' and c.last_name = 'cox'; 

#'model fish' 영화를 빌려간 회원들의 이름 검색 
#film - inventory(film_id) - rental(inventory_id) - customer
#film 테이블에서 title로 model fish를 찾고, 
#film 테이블과 film_id로 inventory 중간 테이블 조인, 
#rental 테이블과 inventory_id로 중간 테이블 조인,
# customer 테이블에서 first/last_name 검색
select 
	c.first_name,
    c.last_name
from film f
	join inventory i on i.film_id = f.film_id
    join rental r on r.inventory_id = r.inventory_id
    join customer c on c.customer_id = r.customer_id
where f.title = 'model fish';

use gb;
select * from test;
