use gb;

create table t_user(
	userid varchar(300) primary key,
	userpw varchar(300) not null,
	username varchar(300) not null,
	usergender char(3) not null,
	zipcode varchar(300) not null,
	addr varchar(1000),
	addrdetail varchar(2000) not null,
	addetc varchar(300),
	userhobby varchar(1000) 
);

create table t_board(
	boardnum bigint primary key auto_increment,
	boardtitle varchar(300) not null,
	boardcontents text not null,
	regdate datetime default now(),
	updatedate datetime default now(),
	readcount int default 0,
	userid varchar(300)
);

create table t_file(
	systemname varchar(3000),
	orgname varchar(3000),
	boardnum bigint
);

create table t_reply(
	replynum bigint primary key auto_increment,
	replycontents varchar(3000),
	regdate datetime default now(),
	updatedate datetime default now(),
	boardnum bigint,
	userid varchar(300) 
);