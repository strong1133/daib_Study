CREATE TABLE boardTbl(

    id Long auto_increment,
    title varchar(30) not null,
    content varchar(30) not null,
    completed tinyint(1) not null,
    createdAt DATE not null,
    primary key (id)
);

insert into boardTbl(title, content, completed, createdAt)
values('제목1','내용1', false, '2021-07-21' );