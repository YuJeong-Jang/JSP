create table tbl_board (
bno number(10) primary key,
title varchar2(200) not null,
content varchar2(2000) not null,
writer varchar2(50) not null,
regdate date default sysdate,
updatedate date default sysdate
);

create sequence seq_board;

insert into tbl_board(bno, title, content, writer) values(1, '테스트1', '테스트내용', 'user1');
insert into tbl_board(bno, title, content, writer) values(2, '테스트1', '테스트내용', 'user1');
insert into tbl_board(bno, title, content, writer) values(3, '테스트1', '테스트내용', 'user1');
insert into tbl_board(bno, title, content, writer) values(4, '테스트1', '테스트내용', 'user1');
insert into tbl_board(bno, title, content, writer) values(5, '테스트1', '테스트내용', 'user1');

commit;

drop sequence seq_board;

create sequence seq_board start with 6;