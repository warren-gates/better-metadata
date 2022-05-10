CREATE TABLE Person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    dob DATE NULL,
    intValue INT NULL
);

create table PET
(
    ID       INTEGER auto_increment,
    NAME     CHARACTER VARYING not null,
    OWNER_ID INTEGER           not null,
    constraint PET_PK
        primary key (ID)

-- ,
--     constraint PET_PERSON_ID_FK
--        foreign key (OWNER_ID) references PERSON
);

create table PERSON_PET
(
    PERSON_ID int not null,
    PET_ID    int not null,

    primary key (PERSON_ID, PET_ID),
    foreign key (PERSON_ID) references PERSON (ID),
    foreign key (PET_ID) references PET (ID)
);

CREATE TABLE departments
(
    department_id       CHARACTER VARYING NOT NULL,
    department_location CHARACTER VARYING NOT NULL,
    PRIMARY KEY (department_id)
);

CREATE TABLE employees
(
    username      CHARACTER VARYING NOT NULL,
    department_id CHARACTER VARYING NOT NULL,
    PRIMARY KEY (username),
    FOREIGN KEY (department_id) REFERENCES departments
);

CREATE TABLE teams
(
    team_id       int auto_increment,
    department_id CHARACTER VARYING NOT NULL,
    team_name     CHARACTER VARYING NOT NULL,
    team_members  int               NOT NULL,

    PRIMARY KEY (team_id),
    UNIQUE (department_id, team_name),
    FOREIGN KEY (department_id) REFERENCES departments
);

create table pk_test_parent
(
    pk_column_1  int,
    pk_column_2  int,
    value_column varchar not null,

    primary key (pk_column_1, pk_column_2)
);

create table pk_test_child
(
    pk_column_1  int,
    pk_column_2  int,
    pk_column_3  int,
    value_column varchar not null,

    primary key (pk_column_1, pk_column_2, pk_column_3),
    foreign key (pk_column_1, pk_column_2) references pk_test_parent
);