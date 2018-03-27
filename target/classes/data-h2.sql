DROP TABLE IF EXISTS QUESTION;
CREATE TABLE QUESTION(
	QUESTION_ID NUMBER(10) PRIMARY KEY,
	BUCKET_ID NUMBER(10),
	IS_ACTIVE NUMBER(1),
	QUESTION_TEXT VARCHAR(100),
	SAMPLE_ANSWER_1 VARCHAR(200),
	SAMPLE_ANSWER_2 VARCHAR(200),
	SAMPLE_ANSWER_3 VARCHAR(200),
	SAMPLE_ANSWER_4 VARCHAR(200),
	SAMPLE_ANSWER_5 VARCHAR(200)
);

DROP TABLE IF EXISTS TAG;
CREATE TABLE TAG(
	TAG_ID NUMBER(10) PRIMARY KEY,
	TAG_NAME VARCHAR(100)
);

DROP TABLE IF EXISTS QUESTION_TAG_LOOKUP;
CREATE TABLE QUESTION_TAG_LOOKUP(
	QUESTION_TAG_LOOKUP_ID NUMBER(10) PRIMARY KEY,
	TAG_ID NUMBER(10),
	QUESTION_ID NUMBER(10)
);

DROP SEQUENCE IF EXISTS QUESTION_SEQUENCE;
CREATE SEQUENCE IF NOT EXISTS QUESTION_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 1;

DROP SEQUENCE IF EXISTS TAG_SEQUENCE;
CREATE SEQUENCE IF NOT EXISTS TAG_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 1;

DROP SEQUENCE IF EXISTS QUESTION_TAG_LOOKUP_SEQUENCE;
CREATE SEQUENCE IF NOT EXISTS QUESTION_TAG_LOOKUP_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 1;

insert into QUESTION (QUESTION_ID, BUCKET_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER_1, SAMPLE_ANSWER_2, SAMPLE_ANSWER_3, SAMPLE_ANSWER_4, SAMPLE_ANSWER_5) values (QUESTION_SEQUENCE.NEXTVAL, 100, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Etiam pretium iaculis justo.', 'Pellentesque at nulla.', 'Morbi porttitor lorem id ligula.', 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', 'Suspendisse ornare consequat lectus.'); 
insert into QUESTION (QUESTION_ID, BUCKET_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER_1, SAMPLE_ANSWER_2, SAMPLE_ANSWER_3, SAMPLE_ANSWER_4, SAMPLE_ANSWER_5) values (QUESTION_SEQUENCE.NEXTVAL, 98, 0, 'Duis bibendum.', 'Phasellus in felis.', 'Integer tincidunt ante vel ipsum.', 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 'Aenean auctor gravida sem.', 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.'); 
insert into QUESTION (QUESTION_ID, BUCKET_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER_1, SAMPLE_ANSWER_2, SAMPLE_ANSWER_3, SAMPLE_ANSWER_4, SAMPLE_ANSWER_5) values (QUESTION_SEQUENCE.NEXTVAL, 94, 1, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.','Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.',  'Vitae mattis nibh ligula nec sem.', 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 'In hac habitasse platea dictumst.', 'In hac habitasse platea dictumst.'); 
insert into QUESTION (QUESTION_ID, BUCKET_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER_1, SAMPLE_ANSWER_2, SAMPLE_ANSWER_3, SAMPLE_ANSWER_4, SAMPLE_ANSWER_5) values (QUESTION_SEQUENCE.NEXTVAL, 12, 1, 'Fusce posuere felis sed lacus.', 'Praesent lectus.', 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 'Sed ante.', 'Donec quis orci eget orci vehicula condimentum.', 'Aliquam sit amet diam in magna bibendum imperdiet.'); 
insert into QUESTION (QUESTION_ID, BUCKET_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER_1, SAMPLE_ANSWER_2, SAMPLE_ANSWER_3, SAMPLE_ANSWER_4, SAMPLE_ANSWER_5) values (QUESTION_SEQUENCE.NEXTVAL, 18, 1, 'Nunc nisl.', 'Maecenas pulvinar lobortis est.', 'Vivamus vel nulla eget eros elementum pellentesque.', 'Donec posuere metus vitae ipsum.', 'Pellentesque eget nunc.', 'Vivamus vestibulum sagittis sapien.'); 
insert into QUESTION (QUESTION_ID, BUCKET_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER_1, SAMPLE_ANSWER_2, SAMPLE_ANSWER_3, SAMPLE_ANSWER_4, SAMPLE_ANSWER_5) values (QUESTION_SEQUENCE.NEXTVAL, 97, 0, 'Etiam vel augue.', 'Nulla mollis molestie lorem.', 'Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', 'In sagittis dui vel nisl.', 'Nam tristique tortor eu pede.', 'Etiam faucibus cursus urna.'); 

insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Stim');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Home Ing');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Zathin');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Duobam');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Trippledex');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Y-Solowarm');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Sonair');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Flowdesk');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Hatity');
insert into TAG (TAG_ID, TAG_NAME) values (TAG_SEQUENCE.NEXTVAL, 'Vagram');

insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 1, 1);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 2, 1);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 3, 1);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 4, 1);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 1, 2);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 2, 2);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 3, 2);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 3, 1);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 4, 2);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL,5, 3);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 5, 4);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 5, 5);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL, 6, 1);
insert into QUESTION_TAG_LOOKUP (QUESTION_TAG_LOOKUP_ID, TAG_ID, QUESTION_ID) values (QUESTION_TAG_LOOKUP_SEQUENCE.NEXTVAL,6, 3);

