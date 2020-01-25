create table history_ow (
   id serial primary key,
   driver_id int not null references  select driver(id),
   car_id int not null references select car(id)
);