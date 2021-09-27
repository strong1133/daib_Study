

CREATE TABLE fileTbl(
     id Long auto_increment,
     origFileName varchar(255) not null,
     fileName varchar(255) not null,
     filePath varchar(255) not null,
     createdAt timestamp not null,
     primary key (id)
);
