use gb;
drop table t_user;
create table t_user(
	userid varchar(300) primary key,
    userpw varchar(300) not null,
    username varchar(300) not null,
    usergender char(3) not null,
    zipcode varchar(300) not null,
    addr varchar(1000),
    addrdetail varchar(2000) not null,
    addretc varchar(300),
    userhobby varchar(1000)
);
select * from t_user;

drop table t_board;
create table t_board(
	boardnum bigint primary key auto_increment,
    boardtitle varchar(300) not null,
    boardcontents text not null,
    regdate datetime default now(),
    updatedate datetime default now(),
    readcount int default 0,
    userid varchar(300)
);
insert into t_board (boardtitle, boardcontents, userid) values('테스트 제목1','테스트 내용1','apple');

drop table t_file;
create table t_file(
	systemname varchar(3000),
    orgname varchar(3000),
    boardnum bigint
);








