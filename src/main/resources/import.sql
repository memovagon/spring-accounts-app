
/* Concept test data for  in-memory db H2  */

INSERT INTO accounts (id, account, beneficiary, created_timestamp, updated_timestamp) VALUES (1, '0AAAAAAA', 'Adan Paino', '2018-01-20', '2018-01-21');
INSERT INTO accounts (id, account, beneficiary, created_timestamp, updated_timestamp) VALUES (2, '0BBBBBBB', 'Jaime Santana', '2018-01-20', '2018-01-22');
INSERT INTO accounts (id, account, beneficiary, created_timestamp, updated_timestamp) VALUES (3, '0CCCCCCC', 'German Villalpando', '2018-01-20','2018-01-23');
INSERT INTO accounts (id, account, beneficiary, created_timestamp, updated_timestamp) VALUES (4, '0DDDDDDD', 'Trinidad Ureña', '2018-01-20', '2018-01-24');


INSERT INTO users (id, active, username, password) VALUES (1, true, 'user', '$2a$10$yE446E0Ou8UmRR7bbXRknuIQZqQdowH.GCiQ66lRK3TfJqm9dgYGm');


INSERT INTO roles (id, name) VALUES (1, 'USER')
INSERT INTO roles (id, name) VALUES (2, 'ADMIN')


INSERT INTO users_roles (user_id, roles_id ) VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id ) VALUES (1, 2);
 



