create table MEMBER(
    id int generated always as IDENTITY,
    user_id VARCHAR2(50) not null,
    password VARCHAR2(50) not null,
    regdate DATE,
    primary key(id)
);

create table BOARD(
    id int generated always as IDENTITY,
   	title VARCHAR2(50) not null,
    contents VARCHAR2(300) not null,
    create_at DATE,
    update_at DATE,
    primary key(id)
);