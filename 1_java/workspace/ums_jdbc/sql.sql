use gb;
drop table product;
drop table user;

create table user(
	userid varchar(300) primary key,
    userpw varchar(300) not null,
    username varchar(300) not null,
    userage int,
    userphone varchar(300),
    useraddr varchar(2000)
);

create table product(
	prodnum int primary key auto_increment,
    prodname varchar(300) not null,
    prodprice int not null,
    prodamount int not null,
    prodinfo varchar(4000) not null,
    likecnt int default 0,
    userid varchar(300),
    constraint user_fk foreign key(userid) references user(userid)
);

select * from user;
select * from product;