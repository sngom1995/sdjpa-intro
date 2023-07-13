drop table if exists author;
drop table if exists author_seq;
create table author (
    id int auto_increment primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null
) engine=InnoDB;

create  table author_seq (
    next_val bigint
)engine=InnoDB;
insert into author_seq values (1);
