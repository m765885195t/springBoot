create database if not exists demo;
use demo;
drop table if exists demo_stu;
create table demo.demo_stu (
  `name` varchar(20) not null,
  `age`  varchar(20) not null,
  `sex`  varchar(20) not null,
  primary key (`name`),
  unique key `age_index` (`name`, `age`)
);

insert into demo_stu (name, age, sex) VALUES ("motian","20","男");