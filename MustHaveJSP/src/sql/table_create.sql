CREATE TABLE myfile (
	idx NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	title  varchar2(200) NOT NULL,
	cate  varchar2(30),
	ofile  varchar2(100) NOT NULL,
	sfile  varchar2(30) NOT NULL,
	postdate  DATE DEFAULT sysdate NOT NULL
)