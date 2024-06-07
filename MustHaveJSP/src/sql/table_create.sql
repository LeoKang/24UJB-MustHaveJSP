CREATE TABLE myfile (
	idx NUMBER PRIMARY KEY,
	title  varchar2(200) NOT NULL,
	cate  varchar2(30),
	ofile  varchar2(100) NOT NULL,
	sfile  varchar2(30) NOT NULL,
	postdate  DATE DEFAULT sysdate NOT NULL
)

CREATE TABLE mvcboard (
	idx NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	title varchar2(200) NOT NULL,
	content varchar2(2000) NOT NULL,
	postdate DATE DEFAULT sysdate NOT NULL,
	ofile varchar2(200),
	sfile varchar2(30),
	downcount number(5) DEFAULT 0 NOT NULL,
	pass varchar2(50) NOT NULL,
	visitcount NUMBER DEFAULT 0 NOT NULL
)