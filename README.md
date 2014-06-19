Database name = usercomments

사용자 테이블 추가
create table user ( id int(11) primary key auto_increment, username varchar(20) not null, password varchar(20) not null);

댓글 테이블 추가
create table comment( id int not null, commentid int primary key auto_increment, author varchar(20) not null, comment varchar(20) default '', recommendation int(20) default 0, opposition int(20) default 0, date varchar(20) not null, foreign key (id) references user (id) on delete cascade);

선거 테이블 추가
create table electionmember (userid int(11) not null, recommendation int(11) not null, opposition int(11) not null);

