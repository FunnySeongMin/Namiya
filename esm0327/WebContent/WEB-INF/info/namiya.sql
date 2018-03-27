DROP TABLE namiya_user;

CREATE TABLE namiya_user (
   id VARCHAR2(100) PRIMARY KEY,
   nickname VARCHAR2(100) NOT NULL,
   password VARCHAR2(100) NOT NULL,
   grade NUMBER DEFAULT 1
);

DROP TABLE namiya_post;
CREATE TABLE namiya_post (
    p_no NUMBER PRIMARY KEY,
    p_title VARCHAR2(100) NOT NULL,
    p_content VARCHAR2(100) NOT NULL,
    p_date DATE DEFAULT SYSDATE,
    lock NUMBER NOT NULL,
    reply NUMBER DEFAULT 0,
    id VARCHAR2(100) NOT NULL,
    CONSTRAINT fk_id FOREIGN KEY(id) REFERENCES namiya_user(id)
);

CREATE SEQUENCE namiya_post_seq;