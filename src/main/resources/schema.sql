CREATE TABLE teacher
(
    teacherid   VARCHAR(50) NOT NULL,
    teachername VARCHAR(50) NOT NULL,
    PRIMARY KEY (teacherid)
);

CREATE TABLE student
(
    studentid   VARCHAR(50) NOT NULL,
    studentname VARCHAR(50) NOT NULL,
    birthday    DATE        NOT NULL,
    PRIMARY KEY (studentid)
);

CREATE TABLE teaching
(
    teaching  VARCHAR(50) NOT NULL,
    studentid VARCHAR(50) NOT NULL,
    teacherid VARCHAR(50) NOT NULL,
    PRIMARY KEY (teaching),
    UNIQUE (studentid, teacherid)
);

CREATE SEQUENCE seq_id_counter
    START WITH 1
    MAXVALUE 10000000000
    CYCLE;