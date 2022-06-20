-- create database web3;
use web3;

create table tbl_member(
	name varchar(255) not null,
	regdate datetime(6),
	moddate datetime(6),
	lastlogindate datetime(6),
	primary key(name)
)engine=InnoDB DEFAULT CHARSET=utf8;

create table transfer_info(
	transferid INTEGER PRIMARY KEY AUTO_INCREMENT,
	toaddress varchar(255),
	amount LONG,
    description VARCHAR(200),
	member_name varchar(255),
	foreign key(member_name) references tbl_member(name) on delete cascade
)engine=InnoDB DEFAULT CHARSET=utf8;

select * from tbl_member;
select * from transfer_info;
-- drop table transfer_innfo;
-- drop table tbl_member;
commit;