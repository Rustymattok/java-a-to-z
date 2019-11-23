CREATE TABLE IF NOT EXISTS users
(
  id serial NOT NULL,
  name text,
  expired date,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)

