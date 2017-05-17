--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

-- Started on 2017-05-16 19:00:41;

CREATE DATABASE test;


SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;



CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;




COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE phonebook (
    id SERIAL NOT NULL PRIMARY KEY ,
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


ALTER TABLE phonebook_id_seq OWNER TO postgres;



ALTER SEQUENCE phonebook_id_seq OWNED BY phonebook.id;




ALTER TABLE ONLY phonebook ALTER COLUMN id SET DEFAULT nextval('phonebook_id_seq'::regclass);




INSERT INTO phonebook (first_name, second_name, third_name, city, street, number_of_home, number_of_phone_one, number_of_phone_two, number_of_phone_three) VALUES
  ('Nelzya','Steret','-','-','-','-','89806570901','','');









