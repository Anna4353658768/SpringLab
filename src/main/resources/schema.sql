
CREATE TABLE IF NOT EXISTS manufacturers (
	id serial NOT NULL ,
	name character varying(30),
	country character varying(30),
	person character varying(30),
	phone character varying(30),
	CONSTRAINT manufacturers_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products (
	id serial NOT NULL ,
	name character varying(30) ,
	manufacturerid integer NOT NULL ,
	weight real ,
	width real ,
	height real ,
	length real ,
	CONSTRAINT products_pkey PRIMARY KEY (id),
	CONSTRAINT products_manufacturerid_fkey
	FOREIGN KEY (manufacturerid)
	REFERENCES public.manufacturers (id)
);

