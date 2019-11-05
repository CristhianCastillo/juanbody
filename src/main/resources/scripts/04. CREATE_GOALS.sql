use juanbody_db;

insert into goal(description, name, exercise_id) values ('Goal description 1', 'Goal name 1', (select e.id from exercise e where e.name = 'exercise 1'));
insert into goal(description, name, exercise_id) values ('Goal description 2', 'Goal name 2', (select e.id from exercise e where e.name = 'exercise 2'));
insert into goal(description, name, exercise_id) values ('Goal description 3', 'Goal name 3', (select e.id from exercise e where e.name = 'exercise 3'));
insert into goal(description, name, exercise_id) values ('Goal description 4', 'Goal name 4', (select e.id from exercise e where e.name = 'exercise 4'));
insert into goal(description, name, exercise_id) values ('Goal description 5', 'Goal name 5', (select e.id from exercise e where e.name = 'exercise 4'));