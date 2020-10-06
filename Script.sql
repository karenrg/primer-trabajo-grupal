-- Table: public.task

-- DROP TABLE public.task;

CREATE TABLE public.task
(
  id serial NOT NULL,
  name character varying,
  description character varying,
  creation_date timestamp without time zone,
  limit_date timestamp without time zone,
  update_date timestamp without time zone,
  deleted boolean,
  file bytea,
  CONSTRAINT pk_task PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.task
  OWNER TO postgres;
  
 CREATE TABLE public.type
(
  id serial NOT NULL,
  name character varying,
  description character varying,
  creation_date timestamp without time zone,
  CONSTRAINT pk_type PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.type
  OWNER TO postgres;


alter table task add column id_type int;
alter table task add constraint fk_type foreign key (id_type) references public.type (id);