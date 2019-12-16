
CREATE TABLE IF NOT EXISTS list
(
  id serial NOT NULL,
  topic text,
  expired date,
  status text,
  CONSTRAINT list_pkey PRIMARY KEY (id)
)
