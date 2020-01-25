create table engine (
  id serial primary key
);
create table car (
  id serial primary key,
  engine_id int not null unique references engine(id)
);
create table driver (
  id serial primary key
);
create table history_owner (
   id serial primary key,
   driver_id int not null references driver(id),
   car_id int not null references car(id)
);
ALTER TABLE car ADD COLUMN name text;
ALTER TABLE engine ADD COLUMN name text;
ALTER TABLE driver ADD COLUMN name text;
INSERT INTO engine (name) VALUES ('Z1');
INSERT INTO engine (name) VALUES ('Z2');
INSERT INTO engine (name) VALUES ('Z3');
INSERT INTO engine (name) VALUES ('Z4');
INSERT INTO engine (name) VALUES ('Z5');
INSERT INTO car (name,engine_id) VALUES ('Ford',1);
INSERT INTO car (name,engine_id) VALUES ('Volvo',2);
INSERT INTO car (name,engine_id) VALUES ('Ford',3);
INSERT INTO car (name,engine_id) VALUES ('Ford',4);
INSERT INTO car (name,engine_id) VALUES ('Volvo',5);
INSERT INTO driver (name) VALUES ('Vladimir');
INSERT INTO driver (name) VALUES ('Aksana');
INSERT INTO history_owner (driver_id,car_id) VALUES (1,2);
INSERT INTO history_owner (driver_id,car_id) VALUES (1,3);
INSERT INTO history_owner (driver_id,car_id) VALUES (2,1);