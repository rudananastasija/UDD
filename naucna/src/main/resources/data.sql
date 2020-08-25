delete from naucna_oblast;
insert into naucna_oblast (id, name) values (1, 'mat');
insert into naucna_oblast (id, name) values (2, 'fiz');
insert into naucna_oblast (id, name) values (3, 'biol');
delete from user; 
insert into user(id,ime,prezime,email,grad,drzava,titula,recenzent,username,lozinka,uloga,verifikovan,placeno,duzina,sirina) values (
155,'Admin','Adminic','upp.rudan@gmail.com','NS','SRB','dr',false,'admin','$2a$10$.xqfFJKIOGxEzUz0f2ZIYOx7roR8kv8647OcxhqWsVhs6PwbdK4Mm','admin',true,false,45.2671,19.8335);
--recenzenti
--rudan
insert into user(id,ime,prezime,email,grad,drzava,titula,recenzent,username,lozinka,uloga,verifikovan,placeno,duzina,sirina) values (
123,'Rec1','Recic','rec1@gmail.com','NS','SRB','dr',true,'rec1','$2a$10$.xqfFJKIOGxEzUz0f2ZIYOx7roR8kv8647OcxhqWsVhs6PwbdK4Mm','REC',true,false,45.267136,19.833549);
--milica
insert into user(id,ime,prezime,email,grad,drzava,titula,recenzent,username,lozinka,uloga,verifikovan,placeno,duzina,sirina) values (
125,'Rec2','Recic','rec2@gmail.com','NS','SRB','dr',true,'rec2','$2a$10$eBGUHIMgZK3ncFhw7CrSTuCnh.fHNMpVBmS.cL5hJU.7hvMfIIUBm','REC',true,false,40.7128,-74.0060);
insert into user(id,ime,prezime,email,grad,drzava,titula,recenzent,username,lozinka,uloga,verifikovan,placeno,duzina,sirina) values (
111,'Rec3','Recic','rec3@gmail.com','NS','SRB','dr',true,'rec3','$2a$10$eBGUHIMgZK3ncFhw7CrSTuCnh.fHNMpVBmS.cL5hJU.7hvMfIIUBm','REC',true,false,44.7866,20.4489);
insert into user(id,ime,prezime,email,grad,drzava,titula,recenzent,username,lozinka,uloga,verifikovan,placeno,duzina,sirina) values (
112,'Rec4','Recic','rec4@gmail.com','NS','SRB','dr',true,'rec4','$2a$10$eBGUHIMgZK3ncFhw7CrSTuCnh.fHNMpVBmS.cL5hJU.7hvMfIIUBm','REC',true,false,48.2082,16.3738);
insert into user(id,ime,prezime,email,grad,drzava,titula,recenzent,username,lozinka,uloga,verifikovan,placeno,duzina,sirina) values (
1236,'Rec5','Recic','rec5@gmail.com','NS','SRB','dr',true,'rec5','$2a$10$eBGUHIMgZK3ncFhw7CrSTuCnh.fHNMpVBmS.cL5hJU.7hvMfIIUBm','REC',true,false,11.7866,10.1234);
--urednici
insert into user(id,ime,prezime,email,grad,drzava,titula,recenzent,username,lozinka,uloga,verifikovan,placeno,duzina,sirina) values (
1919,'Urednik1','Recic','rudananastasijaa@gmail.com','NS','SRB','dr',false,'miso','$2a$10$eBGUHIMgZK3ncFhw7CrSTuCnh.fHNMpVBmS.cL5hJU.7hvMfIIUBm','urednik',true,false,45.2671,19.8335);
insert into user(id,ime,prezime,email,grad,drzava,titula,recenzent,username,lozinka,uloga,verifikovan,placeno,duzina,sirina) values (
1278,'Urednik2','Recic','anastasijarudan54@gmail.com','NS','SRB','dr',false,'milica','$2a$10$eBGUHIMgZK3ncFhw7CrSTuCnh.fHNMpVBmS.cL5hJU.7hvMfIIUBm','urednik',true,false,45.2671,19.8335);

delete from user_naucna_oblast;
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1919,1);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1919,2);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1919,3);

insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1278,1);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1278,2);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1278,3);

insert into user_naucna_oblast(user_id,naucna_oblast_id) values (111,1);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (112,2);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (111,2);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (112,1);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (112,3);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1236,1);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1236,2);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (1236,3);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (123,1);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (123,2);

insert into user_naucna_oblast(user_id,naucna_oblast_id) values (125,2);
insert into user_naucna_oblast(user_id,naucna_oblast_id) values (125,3);

delete from role;
insert into role values (1, 'ROLE_USER');
insert into role values (2, 'ROLE_ADMIN');
insert into role values (3, 'ROLE_UREDNIK');
insert into role values (4, 'ROLE_AUTOR');
insert into role values (5, 'ROLE_RECENZENT');


delete from privilege;
insert into privilege values (1, 'POTVRDI_RECENZENT');
insert into privilege values (2, 'KREIRANJE_CASOPISA');

delete from roles_privileges;
insert into roles_privileges values (2, 1);
insert into roles_privileges values (3, 2);

delete from user_roles;
insert into user_roles values (155, 2);
insert into user_roles values (123, 5);
insert into user_roles values (125, 5);
insert into user_roles values (1919, 3);
insert into user_roles values (1278, 3);
insert into user_roles values (111, 5);
insert into user_roles values (112, 5);
insert into user_roles values (1236, 5);