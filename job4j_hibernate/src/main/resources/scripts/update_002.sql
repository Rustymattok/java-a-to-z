CREATE TABLE IF NOT EXISTS users
(
  id serial NOT NULL,
  name text,
  expired date,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS list
(
  id serial NOT NULL,
  topic text,
  expired date,
  status boolean,
  CONSTRAINT list_pkey PRIMARY KEY (id)
)
