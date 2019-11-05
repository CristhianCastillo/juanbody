use juanbody_db;
insert into exercise(description, name, muscle_id, training_id)
values ('descripcion 1', 'exercise 1', 
(select m.id from muscle m where m.name = 'Abductor de meñique'), 
(select t.id from training t where t.name = 'Aumento masa muscular'));

insert into exercise(description, name, muscle_id, training_id)
values ('descripcion 2', 'exercise 2', 
(select m.id from muscle m where m.name = 'Complexo menor'), 
(select t.id from training t where t.name = 'Aumento masa muscular'));

insert into exercise(description, name, muscle_id, training_id)
values ('descripcion 3', 'exercise 3', 
(select m.id from muscle m where m.name = 'Complexo menor'), 
(select t.id from training t where t.name = 'Disminucion grasa corporal'));

insert into exercise(description, name, muscle_id, training_id)
values ('descripcion 4', 'exercise 4', 
(select m.id from muscle m where m.name = 'Complexo menor'), 
(select t.id from training t where t.name = 'Definicion masa muscular'));