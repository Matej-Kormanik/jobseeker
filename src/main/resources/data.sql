-- ==============================================================================================================================================

insert into users (type, id, email, enabled, password, username) values ('APP_USER', 1001, 'matej.kormanik@gmail.com', true, 'kokot', 'kormamat');
insert into app_user (first_name, last_name, id) VALUES ('Matej', 'Kormanik', 1001);
insert into users (type, id, email, enabled, password, username) values ('APP_USER', 1003, 'julo.petrik@gmail.com', true, 'kokot', 'petrijul');
insert into app_user (first_name, last_name, id) VALUES ('Julo', 'Petrik', 1003);
insert into users (type, id, email, enabled, password, username) values ('EMPLOYER', 1004, 'company@company.com', true, 'kokot', 'Google Inc.');
insert into employer (about, name, id) VALUES ('descriptipn', 'Google',1004);
insert into users (type, id, email, enabled, password, username) values ('EMPLOYER', 1005, 'company@company.com', true, 'kokot', 'CSOB');
insert into employer (about, name, id) VALUES ('descriptipn', 'CSOB',1005);

-- ==============================================================================================================================================

insert into education (id, description, from_date, major, school, to_date, user_id)
VALUES (2001, 'stredna skola', '2009-06-01', 'elektrotechnika', 'SOSE LH', '2013-06-15', 1001);
insert into education (id, description, from_date, major, school, to_date, user_id)
VALUES (2002, 'Univerzita', '2013-09-01', 'software enginering', 'FEL CVUT', '2017-06-15', 1001);
insert into education (id, description, from_date, major, school, to_date, user_id)
VALUES (2003, 'gymnzazium', '2008-05-07', 'gympl', 'Gymnazium Humenne', '2015-05-10', 1003);
insert into education (id, description, from_date, major, school, to_date, user_id)
VALUES (2004, 'Univerzita', '2009-06-01', 'elektrotechnika', 'SOSE LH', '2013-06-15', 1003);
-- ==============================================================================================================================================

insert into experience (id, company, description, from_date, title, to_date, user_id)
VALUES (3001, 'Tesla L.h.', 'kokociny z vrtackou', '2012-04-15', 'operator', '2013-08-15', 1001);
insert into experience (id, company, description, from_date, title, to_date, user_id)
VALUES (3002, 'Eltek a.s.', 'kokociny z vrtackou', '2013-04-15', 'operator', '2014-10-15', 1001);
insert into experience (id, company, description, from_date, title, to_date, user_id)
VALUES (3003, 'Apple Inc.', 'programator', '2016-04-15', 'SW developer', '2016-08-15', 1003);
insert into experience (id, company, description, from_date, title, to_date, user_id)
VALUES (3004, 'Adobe', 'product designer', '2017-04-15', 'product designer', '2017-08-15', 1003);
-- ==============================================================================================================================================

insert into job_post (id, created_date, description, title, type, employer_id)
VALUES (4001, '2020-05-29', 'roznasac pizze', 'pizza delivery guy', 'PART_TIME', 1004);
insert into job_post (id, created_date, description, title, type, employer_id)
VALUES (4002, '2020-06-02', 'stahovanie nabytku', 'stahovak', 'FULL_TIME', 1004);
insert into job_post (id, created_date, description, title, type, employer_id)
VALUES (4003, '2020-05-29', 'upratovanie kancelarii', 'upratovac', 'FAST_JOB', 1005);
insert into job_post (id, created_date, description, title, type, employer_id)
VALUES (4004, '2020-07-05', 'casnicka picovina', 'casnik', 'FAST_JOB', 1005);
-- ==============================================================================================================================================

insert into location (id, city, country, house_number, latitude, longitude, street, zip, employer_id)
VALUES (5001, 'Prague', 'CZ', '17', 50.099893, 14.388295, 'Evropska', '1600', 1004);
insert into location (id, city, country, house_number, latitude, longitude, street, zip, employer_id)
VALUES (5002, 'Prague', 'CZ', '20', 50.126516, 14.423495, 'Hnezdenska', '18100', 1005);
-- ==============================================================================================================================================

insert into review (id, feedback, stars, user_id) VALUES (6001, 'dobry kokot ten chlapec', 1, 1001);
insert into review (id, feedback, stars, user_id) VALUES (6002, 'dobry pracant', 2, 1003);
insert into review (id, feedback, stars, user_id) VALUES (6003, 'fajn firma', 3, 1004);
insert into review (id, feedback, stars, user_id) VALUES (6004, 'nikdy viac ku kokotom', 4, 1005);
-- ==============================================================================================================================================

insert into skill (id, skill_seniority, skill_name) VALUES (7001, 'BEGINNER', 'Docker');
insert into skill_user_join (skill_id, user_id) VALUES (7001, 1001);

insert into skill (id, skill_seniority, skill_name) VALUES (7002, 'ADVANCED', 'Java');
insert into skill_user_join (skill_id, user_id) VALUES (7002, 1001);

insert into skill (id, skill_seniority, skill_name) VALUES (7003, 'EXPERT', 'Javascript');
insert into skill_user_join (skill_id, user_id) VALUES (7003, 1003);

insert into skill (id, skill_seniority, skill_name) VALUES (7004, 'AVERAGE', 'Vue JS');
insert into skill_user_join (skill_id, user_id) VALUES (7004, 1003);
-- ==============================================================================================================================================





