--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

-- Started on 2017-05-16 19:00:41

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16696)
-- Name: phonebook; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE phonebook (
    id integer NOT NULL,
    first_name text NOT NULL,
    second_name text,
    third_name text,
    city text,
    street text,
    number_of_home character varying(10),
    number_of_phone_one character varying(15) NOT NULL,
    number_of_phone_two character varying(15),
    number_of_phone_three character varying(15)
);


ALTER TABLE phonebook OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16694)
-- Name: phonebook_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE phonebook_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE phonebook_id_seq OWNER TO postgres;

--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 185
-- Name: phonebook_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE phonebook_id_seq OWNED BY phonebook.id;


--
-- TOC entry 2002 (class 2604 OID 16699)
-- Name: phonebook id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY phonebook ALTER COLUMN id SET DEFAULT nextval('phonebook_id_seq'::regclass);


--
-- TOC entry 2123 (class 0 OID 16696)
-- Dependencies: 186
-- Data for Name: phonebook; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY phonebook (id, first_name, second_name, third_name, city, street, number_of_home, number_of_phone_one, number_of_phone_two, number_of_phone_three) FROM stdin;
1	&#1048;&#1074;&#1072;&#1085;	&#1050;&#1086;&#1083;&#1077;&#1089;&#1086;&#1074;	-	-	-	-	89806570901		
2	Andrey	Kolesov	-	-	-	-	89806570901		
3	&#1040;&#1085;&#1076;&#1088;&#1077;&#1081;	Kolesov	-	-	-	-	12345678910		
4	Ivan	Kolesov	-	-	-	-	12345678910		
5	Kiril	&#1050;&#1086;&#1083;&#1077;&#1089;&#1086;&#1074;	-	-	-	-	12345678910		
6	Oleg	Kolesov	-	-	-	-	12345678910		
7	Nina	Kolesov	-	-	-	-	12345678910		
8	Andrey	&#1050;&#1086;&#1083;&#1077;&#1089;&#1086;&#1074;	Vladimirovic	Gorod	-	19	12345678910		
9	&#1048;&#1074;&#1072;&#1085;	&#1057;&#1080;&#1090;&#1085;&#1077;&#1074;	Vladimirovic	Gorod	123	19	89806570901	89806570901	89806570901
\.


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 185
-- Name: phonebook_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('phonebook_id_seq', 9, true);


--
-- TOC entry 2004 (class 2606 OID 16704)
-- Name: phonebook phonebook_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY phonebook
    ADD CONSTRAINT phonebook_pkey PRIMARY KEY (id);


-- Completed on 2017-05-16 19:00:42

--
-- PostgreSQL database dump complete
--

