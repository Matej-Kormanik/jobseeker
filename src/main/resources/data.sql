insert into users (type, id, email, enabled, password, username) values ('APP_USER', 1001, 'matej.kormanik@gmail.com', true, 'kokot', 'kormamat');
insert into app_user (first_name, last_name, id) VALUES ('Matej', 'Kormanik', 1001);

insert into users (type, id, email, enabled, password, username) values ('EMPLOYER', 1002, 'company@company.com', true, 'kokot', 'profinit');
insert into employer (about, name, id) VALUES ('descriptipn', 'profinit',1002);