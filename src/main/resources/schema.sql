
CREATE TABLE IF NOT EXISTS manufacturers (
	id serial NOT NULL ,
	name character varying(50),
	country character varying(50),
	person character varying(50),
	phone character varying(50),
	CONSTRAINT manufacturers_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products (
	id serial NOT NULL ,
	name character varying(50) ,
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

