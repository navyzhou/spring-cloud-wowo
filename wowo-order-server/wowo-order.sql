drop database if exists wowo_order;

create database wowo_order default character set utf8 collate utf8_bin;

use wowo_order;

create table if not exists orderinfo(
	ono varchar(100) primary key,
	odate datetime comment '下单日期',
	mid int(11) comment '会员编号',
	sdate datetime comment '消费日期',
	status int(2) comment '订单状态',
	price decimal(10, 2) comment '订单总价',
	invoice int(2) comment '是否已开发票'
) ENGINE = InnoDB charset=utf8 collate=utf8_bin;

create table if not exists orderiteminfo(
	ino int(11) primary key auto_increment,
	ono varchar(100),
	gid int(11) comment '商品编号',
	num int(11) comment '购买的数量',
	wprice decimal(10, 2) comment '购买价',
	gname varchar(100) comment '商品名称',
	pic varchar(100) comment '商品图片',
	price decimal(10, 2) comment '原价',
	intro varchar(200) comment '简介',
	status int(2) comment '状态',
	constraint FK_orderiteminfo_ono foreign key(ono) references orderinfo(ono)
) ENGINE = InnoDB charset=utf8 collate=utf8_bin;