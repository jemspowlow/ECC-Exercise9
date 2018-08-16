--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4 (Ubuntu 10.4-2.pgdg16.04+1)
-- Dumped by pg_dump version 10.4 (Ubuntu 10.4-2.pgdg16.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: address; Type: TABLE; Schema: public; Owner: james
--

CREATE TABLE public.address (
    id integer NOT NULL,
    street_number character varying(255),
    city character varying(255),
    zip_code character varying(255)
);

GRANT ALL PRIVILEGES ON public.address TO james;
ALTER TABLE public.address OWNER TO james;

--
-- Name: contact; Type: TABLE; Schema: public; Owner: james
--

CREATE TABLE public.contact (
    id integer NOT NULL,
    type character varying(255),
    details character varying(255),
    person_id integer,
    idx integer
);

GRANT ALL PRIVILEGES ON public.contact TO james;
ALTER TABLE public.contact OWNER TO james;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: james
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO james;

--
-- Name: person; Type: TABLE; Schema: public; Owner: james
--

CREATE TABLE public.person (
    id integer NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    middle_name character varying(255),
    birth_day date,
    date_hired date,
    gwa double precision,
    gender character varying(255),
    employed character(1),
    school character varying(255),
    address integer NOT NULL
);


GRANT ALL PRIVILEGES ON public.person TO james;
ALTER TABLE public.person OWNER TO james;

--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: james
--

INSERT INTO public.address (id, street_number, city, zip_code) VALUES
VALUES (5,	9,	Pasig,	1600),
(35,	55,	Ropor,	6666),
(37,	5,	Pasig,	1600),
(41,	8,	Pasay,	1600);



--
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: james
--

INSERT INTO public.contact (id, type, details, person_id, idx) VALUES
(42,	EMAIL,	rsequior@gmail.com,	40,	0),
(43,	MOBILE,	09994378828, 40,	1),
(44,	LANDLINE,	6304455,	40,	2),
(47,	EMAIL,	jamespaolo.menguito@gmail.com,	6,	0),
(68,	MOBILE,	2323232,	32,	0),
(73,	EMAIL,	wewe@gmail.com,	6,	1),
(76,	LANDLINE,	099999,	36,	1);


--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: james
--

INSERT INTO public.person (id, first_name, last_name, middle_name, birth_day, date_hired, gwa, gender, employed, school, address)
VALUES(6,	James,	Menguito,	Wagas,	1996-09-23,	2018-06-18,	2.5,	MALE,	T,	UPLB,	5),
(34,	Robert,	Man,	Lol,	1943-12-12,	\N,	2.5,	\N,	F,	WUT,	35),
(32,	Reina,	Cardona,	Abuan,	1996-12-23,	\N,	1,	\N,	F,	UPLB,	33),
(36,	Peter,	Cruz,	Sazon,	1997-02-16,	\N,	2.5,	MALE,	F,	UPLB,	37),
(40,	Rani,	Sequior,	Aquino,	2004-05-14,	\N,	1,	FEMALE,	F, PCC,	41);




--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: james
--

SELECT pg_catalog.setval('public.hibernate_sequence', 76, true);


--
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- Name: contact contact_pkey; Type: CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (id);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: person fkbs1pxpi8sc2h5t4bc5uov92p; Type: FK CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT fkbs1pxpi8sc2h5t4bc5uov92p FOREIGN KEY (address) REFERENCES public.address(id);


--
-- Name: contact fkjbcdaayhsa4dhcuc5q0kkw8et; Type: FK CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT fkjbcdaayhsa4dhcuc5q0kkw8et FOREIGN KEY (person_id) REFERENCES public.person(id);


--
-- PostgreSQL database dump complete
--

