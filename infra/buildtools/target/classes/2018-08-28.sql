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
    city character varying(255),
    street_number character varying(255),
    zip_code character varying(255)
);


ALTER TABLE public.address OWNER TO james;

--
-- Name: contact; Type: TABLE; Schema: public; Owner: james
--

CREATE TABLE public.contact (
    id integer NOT NULL,
    details character varying(255),
    idx integer NOT NULL,
    type integer,
    person_id integer
);


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
    birth_day timestamp without time zone,
    date_hired timestamp without time zone,
    employed boolean NOT NULL,
    gender character varying(255),
    gwa double precision NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    middle_name character varying(255),
    school character varying(255),
    address_id integer
);


ALTER TABLE public.person OWNER TO james;

--
-- Name: person_roles; Type: TABLE; Schema: public; Owner: james
--

CREATE TABLE public.person_roles (
    roles_id integer NOT NULL,
    person_id integer NOT NULL
);


ALTER TABLE public.person_roles OWNER TO james;

--
-- Name: publicaddress; Type: TABLE; Schema: public; Owner: james
--

CREATE TABLE public.publicaddress (
    id integer NOT NULL,
    street_number character varying(255),
    city character varying(255),
    zip_code character varying(255)
);


ALTER TABLE public.publicaddress OWNER TO james;

--
-- Name: roles; Type: TABLE; Schema: public; Owner: james
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    label character varying(255)
);


ALTER TABLE public.roles OWNER TO james;

--
-- Name: roles_person; Type: TABLE; Schema: public; Owner: james
--

CREATE TABLE public.roles_person (
    roles_id integer NOT NULL,
    persons_id integer NOT NULL
);


ALTER TABLE public.roles_person OWNER TO james;

--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: james
--

COPY public.address (id, city, street_number, zip_code) FROM stdin;
2	Pasig	9	1600
5	Baguio	5	5555
8	Pasig	5	1604
20	Cavite	88	15000
\.


--
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: james
--

COPY public.contact (id, details, idx, type, person_id) FROM stdin;
3	09258890927	0	0	1
6	racardona@gmail.com	0	2	4
9	092759110	0	0	7
\.


--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: james
--

COPY public.person (id, birth_day, date_hired, employed, gender, gwa, first_name, last_name, middle_name, school, address_id) FROM stdin;
1	1996-09-23 00:00:00	\N	f	MALE	1.55000000000000004	James Paolo	Menguito	Wagas	UPLB	2
4	1995-09-18 00:00:00	2017-12-15 00:00:00	t	FEMALE	1.30000000000000004	Reina	Cardona	Abuan	UPLB	5
7	1997-02-18 00:00:00	\N	f	MALE	2	Peter	Cruz	Sazon	UPLB	8
19	1996-12-15 00:00:00	\N	f	MALE	2.5	Carl Adrian	de Jesus	Baria	UPLB	20
\.


--
-- Data for Name: person_roles; Type: TABLE DATA; Schema: public; Owner: james
--

COPY public.person_roles (roles_id, person_id) FROM stdin;
11	1
10	1
16	4
10	4
\.


--
-- Data for Name: publicaddress; Type: TABLE DATA; Schema: public; Owner: james
--

COPY public.publicaddress (id, street_number, city, zip_code) FROM stdin;
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: james
--

COPY public.roles (id, label) FROM stdin;
10	MASCOT
11	JANITOR
12	SUPREME OVERLORD
16	TEAM LEADER
21	JUNIOR DEVELOPER
\.


--
-- Data for Name: roles_person; Type: TABLE DATA; Schema: public; Owner: james
--

COPY public.roles_person (roles_id, persons_id) FROM stdin;
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: james
--

SELECT pg_catalog.setval('public.hibernate_sequence', 21, true);


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
-- Name: person_roles person_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.person_roles
    ADD CONSTRAINT person_roles_pkey PRIMARY KEY (person_id, roles_id);


--
-- Name: publicaddress publicaddress_pkey; Type: CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.publicaddress
    ADD CONSTRAINT publicaddress_pkey PRIMARY KEY (id);


--
-- Name: roles_person roles_person_pkey; Type: CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.roles_person
    ADD CONSTRAINT roles_person_pkey PRIMARY KEY (roles_id, persons_id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: person fkae6g74naefukvs2jbryjyx5mh; Type: FK CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT fkae6g74naefukvs2jbryjyx5mh FOREIGN KEY (address_id) REFERENCES public.address(id);


--
-- Name: contact fkjbcdaayhsa4dhcuc5q0kkw8et; Type: FK CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT fkjbcdaayhsa4dhcuc5q0kkw8et FOREIGN KEY (person_id) REFERENCES public.person(id);


--
-- Name: person_roles fkq1mo51g9rltg8fl4uffoa7e17; Type: FK CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.person_roles
    ADD CONSTRAINT fkq1mo51g9rltg8fl4uffoa7e17 FOREIGN KEY (roles_id) REFERENCES public.roles(id);


--
-- Name: person_roles fks955luj19xyjwi3s1omo1pgh4; Type: FK CONSTRAINT; Schema: public; Owner: james
--

ALTER TABLE ONLY public.person_roles
    ADD CONSTRAINT fks955luj19xyjwi3s1omo1pgh4 FOREIGN KEY (person_id) REFERENCES public.person(id);


--
-- PostgreSQL database dump complete
--

