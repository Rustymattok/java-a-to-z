CREATE TABLE IF NOT EXISTS halldb
(
  hall_no integer NOT NULL,
  row text,
  place text,
  status text,
  price double precision,
  CONSTRAINT halldb_pkey PRIMARY KEY (hall_no)
)
WITH (
  OIDS=FALSE
); 
CREATE OR REPLACE FUNCTION sum() RETURNS int8 AS $$
DECLARE
  s int := 0;
  d int := 0;
  k int := 0;
BEGIN
  LOOP
   IF s > 9 THEN
        EXIT;  -- выход из цикла
    END IF;
    s := s + 1;
    FOR i IN 1..19 LOOP
     k := k + 1;
     d := i;
      INSERT INTO halldb VALUES(k,s::text,d::text,'free',200);
     END LOOP;
  END LOOP;
  RETURN s;
END;
$$ LANGUAGE plpgsql;
SELECT sum();

CREATE TABLE IF NOT EXISTS accountdb
(
  hall_no integer,
  name text,
  phone text,
  balance double precision,
  CONSTRAINT accountdb_hall_no_fkey FOREIGN KEY (hall_no)
      REFERENCES halldb (hall_no) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
