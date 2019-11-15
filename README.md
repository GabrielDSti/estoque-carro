# estoque-carro


SQL inicial:


CREATE SEQUENCE carro_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999999
    START 1
    CACHE 1;


CREATE TABLE carro
(
  id bigint NOT NULL DEFAULT nextval('carro_id_seq'::regclass),
  nome character varying(50),
  ano integer,
  cor character varying(50),
  placa character varying(50),
  qtde integer,
  CONSTRAINT carro_pk PRIMARY KEY (id)
)
