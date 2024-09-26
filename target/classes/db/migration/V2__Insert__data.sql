INSERT INTO ROLE (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO USER (id, username, password) VALUES (1, 'admin', '$2a$10$x2scVe3DlJiusUuULPEDM.SLOyiYQSNsFPwmyUeUzThFf8ij1A0Aq')
INSERT INTO USER (id, username, password) VALUES (2, 'user', '$2a$10$TSf5yQPYhz1ERFvP2wBSvu7.95spJHgIdcRqEpH/VUfbIq8clUgwK')

INSERT INTO user_roles (user_id, role_id) VALUES (1,1)
INSERT INTO user_roles (user_id, role_id) VALUES (1,2)
INSERT INTO user_roles (user_id, role_id) VALUES (2,2)

INSERT INTO PERSON VALUES(1,34,'1998-03-12 00:00:00.000000','Male','Jakarta','Jadi 2');
INSERT INTO PERSON VALUES(2,32,'2000-07-05 00:00:00.000000','Female','Aceh','Jane Smith');
INSERT INTO PERSON VALUES(3,39,'1995-04-18 00:00:00.000000','Male','Lampung','Michael Johnsons');
INSERT INTO PERSON VALUES(4,29,'1992-11-27 00:00:00.000000','Female','Jambi','Emily Davis');
INSERT INTO PERSON VALUES(5,36,'2001-01-08 00:00:00.000000','Male','Bali','Chris Brown');
INSERT INTO PERSON VALUES(6,31,'1999-08-14 00:00:00.000000','Female','Riau','Laura Wilson');
INSERT INTO PERSON VALUES(7,37,'1990-09-03 00:00:00.000000','Male','Jakarta','David Miller');
INSERT INTO PERSON VALUES(8,33,'1997-06-22 00:00:00.000000','Female','Aceh','Sophia Moore');
INSERT INTO PERSON VALUES(9,35,'1988-09-30 00:00:00.000000','Male','Lampung','Daniel Anderson');
INSERT INTO PERSON VALUES(10,30,'1994-11-16 00:00:00.000000','Female','Jambi','Mia Thomas');