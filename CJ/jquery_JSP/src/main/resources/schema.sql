CREATE TABLE boardTbl(
    id Long auto_increment,
    title varchar(30) not null,
    content varchar(30) not null,
    completed tinyint(1) not null,
    createdAt timestamp not null,
    primary key (id)
);

CREATE TABLE fileTbl(
     id Long auto_increment,
     origFileName varchar(255) not null,
     fileName varchar(255) not null,
     filePath varchar(255) not null,
     createdAt timestamp not null,
     primary key (id)
);

insert into boardTbl(title, content, completed, createdAt)
values('제목1','내용1', false, now());
