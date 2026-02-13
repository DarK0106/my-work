-- ddlex.sql


-- 연출
create table direction
(
    seq number not null, -- 연출번호(PK)
    movie_seq number not null, -- 영화번호
    director_seq number not null, -- 감독번호
    
    -- 기본키 제약 조건
    constraint PK_DIRECTION PRIMARY KEY (SEQ),
    
    -- 외래키 제약 조건 (부모 테이블의 PK를 참조)
    constraint FK_DIRECTION_MOVIE FOREIGN KEY (MOVIE_SEQ)
        references MOVIE (movie_seq),
        
    constraint fk_Direction_movie foreign key (director_seq)
        references director (director_seq)

);

-- 스텝
create table director
(
    director_seq number not null, -- 감독번호(PK)
    name varchar2(30), -- 다른 이름
    birth date, -- 생년월일
    gender number, -- 성별
    job_seq number, -- 직업번호(FK)
    
    constraint pk_director primary key (director_seq),
    constraint fk_director foreign key (job_seq) references job (job_seq)
    
);

-- 관련영화
create table related_movie
(
    seq number not null, -- 관련영화번호
    movie_seq1 number, -- 영화번호
    movie_seq2 number, -- 영화번호2
    
    constraint  pk_related_movie primary key (seq),
    
    constraint fk_director foreign key (movie_seq1) references movie (movie_seq),
    constraint fk_director foreign key (movie_seq2) references movie (movie_seq)

);

-- 출연
create table appear
(
    seq number not null,
    movie_seq number not null,
    actor_seq number,
    
    constraint pk_appear primary key (seq),
    
    constraint fk_movie_seq foreign key (movie_seq) references movie (movie_seq),
    constraint fk_actor_Seq foreign key (actor_seq) references movie (actor_seq)

);

-- 배우
CREATE TABLE ACTOR (
    ACTOR_SEQ NUMBER        NOT NULL, -- 배우번호 (PK)
    JOB       VARCHAR2(30),           -- 직업
    NAME      VARCHAR2(30),           -- 배우이름
    BIRTH     DATE,                   -- 생년월일
    GENDER    NUMBER,                 -- 배우성별
    
    CONSTRAINT PK_ACTOR PRIMARY KEY (ACTOR_SEQ)
);