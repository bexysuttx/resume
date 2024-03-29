PGDMP         '                y            resume    13.1    13.1 @    -           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            .           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            /           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            0           1262    16565    resume    DATABASE     [   CREATE DATABASE resume WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE resume;
                resume    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            1           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    16616    certificate    TABLE     �   CREATE TABLE public.certificate (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    name character varying(50) NOT NULL,
    large_url character varying(256) NOT NULL,
    small_url character varying(256) NOT NULL
);
    DROP TABLE public.certificate;
       public         heap    resume    false    3            �            1259    16729    certificate_seq    SEQUENCE     x   CREATE SEQUENCE public.certificate_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.certificate_seq;
       public          resume    false    3            �            1259    16629    course    TABLE     �   CREATE TABLE public.course (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    name character varying(60) NOT NULL,
    school character varying(60) NOT NULL,
    finish_date date
);
    DROP TABLE public.course;
       public         heap    resume    false    3            �            1259    16727 
   course_seq    SEQUENCE     s   CREATE SEQUENCE public.course_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.course_seq;
       public          resume    false    3            �            1259    16639 	   education    TABLE       CREATE TABLE public.education (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    summary character varying(100) NOT NULL,
    begin_year integer NOT NULL,
    finish_year integer,
    university text NOT NULL,
    faculty character varying(256) NOT NULL
);
    DROP TABLE public.education;
       public         heap    resume    false    3            �            1259    16725    education_seq    SEQUENCE     v   CREATE SEQUENCE public.education_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.education_seq;
       public          resume    false    3            �            1259    16652    hobby    TABLE        CREATE TABLE public.hobby (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    name character varying(30) NOT NULL
);
    DROP TABLE public.hobby;
       public         heap    resume    false    3            �            1259    16723 	   hobby_seq    SEQUENCE     r   CREATE SEQUENCE public.hobby_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.hobby_seq;
       public          resume    false    3            �            1259    16662    language    TABLE     �   CREATE TABLE public.language (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    name character varying(30) NOT NULL,
    level character varying(18) NOT NULL,
    type character varying(7) DEFAULT 0 NOT NULL
);
    DROP TABLE public.language;
       public         heap    resume    false    3            �            1259    16721    language_seq    SEQUENCE     u   CREATE SEQUENCE public.language_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.language_seq;
       public          resume    false    3            �            1259    16673    practic    TABLE     �  CREATE TABLE public.practic (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    "position" character varying(100) NOT NULL,
    company character varying(100) NOT NULL,
    begin_date date NOT NULL,
    finish_date date,
    responsibilities text NOT NULL,
    demo character varying(256) DEFAULT NULL::character varying,
    src character varying(256) DEFAULT NULL::character varying
);
    DROP TABLE public.practic;
       public         heap    resume    false    3            �            1259    16719    practic_seq    SEQUENCE     t   CREATE SEQUENCE public.practic_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.practic_seq;
       public          resume    false    3            �            1259    16589    profile    TABLE     �  CREATE TABLE public.profile (
    id bigint NOT NULL,
    uid character varying(100) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    birth_day date,
    phone character varying(20) DEFAULT NULL::character varying,
    email character varying(100) DEFAULT NULL::character varying,
    country character varying(60) DEFAULT NULL::character varying,
    city character varying(100) DEFAULT NULL::character varying,
    objective text,
    summary text,
    large_photo character varying(256) DEFAULT NULL::character varying,
    small_photo character varying(256) DEFAULT NULL::character varying,
    info text,
    password character varying(256) NOT NULL,
    completed boolean NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL,
    skype character varying(80) DEFAULT NULL::character varying,
    vkontakte character varying(256) DEFAULT NULL::character varying,
    facebook character varying(256) DEFAULT NULL::character varying,
    linkedin character varying(256) DEFAULT NULL::character varying,
    github character varying(256) DEFAULT NULL::character varying,
    stackoverflow character varying(256) DEFAULT NULL::character varying
);
    DROP TABLE public.profile;
       public         heap    resume    false    3            �            1259    16688    profile_restore    TABLE     k   CREATE TABLE public.profile_restore (
    id bigint NOT NULL,
    token character varying(256) NOT NULL
);
 #   DROP TABLE public.profile_restore;
       public         heap    resume    false    3            �            1259    16715    profile_seq    SEQUENCE     t   CREATE SEQUENCE public.profile_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.profile_seq;
       public          resume    false    3            �            1259    16702    skill    TABLE     �   CREATE TABLE public.skill (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    category character varying(50) NOT NULL,
    value text NOT NULL
);
    DROP TABLE public.skill;
       public         heap    resume    false    3            �            1259    16695    skill_category    TABLE     l   CREATE TABLE public.skill_category (
    id bigint NOT NULL,
    category character varying(30) NOT NULL
);
 "   DROP TABLE public.skill_category;
       public         heap    resume    false    3            �            1259    16717 	   skill_seq    SEQUENCE     r   CREATE SEQUENCE public.skill_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.skill_seq;
       public          resume    false    3                      0    16616    certificate 
   TABLE DATA           Q   COPY public.certificate (id, id_profile, name, large_url, small_url) FROM stdin;
    public          resume    false    201                      0    16629    course 
   TABLE DATA           K   COPY public.course (id, id_profile, name, school, finish_date) FROM stdin;
    public          resume    false    202                      0    16639 	   education 
   TABLE DATA           j   COPY public.education (id, id_profile, summary, begin_year, finish_year, university, faculty) FROM stdin;
    public          resume    false    203                      0    16652    hobby 
   TABLE DATA           5   COPY public.hobby (id, id_profile, name) FROM stdin;
    public          resume    false    204                      0    16662    language 
   TABLE DATA           E   COPY public.language (id, id_profile, name, level, type) FROM stdin;
    public          resume    false    205                      0    16673    practic 
   TABLE DATA           |   COPY public.practic (id, id_profile, "position", company, begin_date, finish_date, responsibilities, demo, src) FROM stdin;
    public          resume    false    206                      0    16589    profile 
   TABLE DATA           �   COPY public.profile (id, uid, first_name, last_name, birth_day, phone, email, country, city, objective, summary, large_photo, small_photo, info, password, completed, created, skype, vkontakte, facebook, linkedin, github, stackoverflow) FROM stdin;
    public          resume    false    200                       0    16688    profile_restore 
   TABLE DATA           4   COPY public.profile_restore (id, token) FROM stdin;
    public          resume    false    207            "          0    16702    skill 
   TABLE DATA           @   COPY public.skill (id, id_profile, category, value) FROM stdin;
    public          resume    false    209            !          0    16695    skill_category 
   TABLE DATA           6   COPY public.skill_category (id, category) FROM stdin;
    public          resume    false    208            2           0    0    certificate_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.certificate_seq', 1, false);
          public          resume    false    217            3           0    0 
   course_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.course_seq', 1, false);
          public          resume    false    216            4           0    0    education_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.education_seq', 1, false);
          public          resume    false    215            5           0    0 	   hobby_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.hobby_seq', 1, false);
          public          resume    false    214            6           0    0    language_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.language_seq', 1, false);
          public          resume    false    213            7           0    0    practic_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.practic_seq', 1, false);
          public          resume    false    212            8           0    0    profile_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.profile_seq', 1, false);
          public          resume    false    210            9           0    0 	   skill_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.skill_seq', 1, false);
          public          resume    false    211            {           2606    16623    certificate certificate_pk 
   CONSTRAINT     X   ALTER TABLE ONLY public.certificate
    ADD CONSTRAINT certificate_pk PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.certificate DROP CONSTRAINT certificate_pk;
       public            resume    false    201            }           2606    16633    course course_pk 
   CONSTRAINT     N   ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pk PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.course DROP CONSTRAINT course_pk;
       public            resume    false    202                       2606    16646    education education_pk 
   CONSTRAINT     T   ALTER TABLE ONLY public.education
    ADD CONSTRAINT education_pk PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.education DROP CONSTRAINT education_pk;
       public            resume    false    203            �           2606    16656    hobby hobby_pk 
   CONSTRAINT     L   ALTER TABLE ONLY public.hobby
    ADD CONSTRAINT hobby_pk PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.hobby DROP CONSTRAINT hobby_pk;
       public            resume    false    204            �           2606    16667    language language_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_pk PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.language DROP CONSTRAINT language_pk;
       public            resume    false    205            �           2606    16682    practic practice_pk 
   CONSTRAINT     Q   ALTER TABLE ONLY public.practic
    ADD CONSTRAINT practice_pk PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.practic DROP CONSTRAINT practice_pk;
       public            resume    false    206            s           2606    16609    profile profile_pk 
   CONSTRAINT     P   ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_pk PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.profile DROP CONSTRAINT profile_pk;
       public            resume    false    200            �           2606    16692 "   profile_restore profile_restore_pk 
   CONSTRAINT     `   ALTER TABLE ONLY public.profile_restore
    ADD CONSTRAINT profile_restore_pk PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.profile_restore DROP CONSTRAINT profile_restore_pk;
       public            resume    false    207            �           2606    16694 "   profile_restore profile_restore_un 
   CONSTRAINT     ^   ALTER TABLE ONLY public.profile_restore
    ADD CONSTRAINT profile_restore_un UNIQUE (token);
 L   ALTER TABLE ONLY public.profile_restore DROP CONSTRAINT profile_restore_un;
       public            resume    false    207            u           2606    16611    profile profile_un 
   CONSTRAINT     L   ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_un UNIQUE (uid);
 <   ALTER TABLE ONLY public.profile DROP CONSTRAINT profile_un;
       public            resume    false    200            w           2606    16613    profile profile_un2 
   CONSTRAINT     O   ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_un2 UNIQUE (phone);
 =   ALTER TABLE ONLY public.profile DROP CONSTRAINT profile_un2;
       public            resume    false    200            y           2606    16615    profile profile_un3 
   CONSTRAINT     O   ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_un3 UNIQUE (email);
 =   ALTER TABLE ONLY public.profile DROP CONSTRAINT profile_un3;
       public            resume    false    200            �           2606    16699     skill_category skill_category_pk 
   CONSTRAINT     ^   ALTER TABLE ONLY public.skill_category
    ADD CONSTRAINT skill_category_pk PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.skill_category DROP CONSTRAINT skill_category_pk;
       public            resume    false    208            �           2606    16701     skill_category skill_category_un 
   CONSTRAINT     _   ALTER TABLE ONLY public.skill_category
    ADD CONSTRAINT skill_category_un UNIQUE (category);
 J   ALTER TABLE ONLY public.skill_category DROP CONSTRAINT skill_category_un;
       public            resume    false    208            �           2606    16709    skill skill_pk 
   CONSTRAINT     L   ALTER TABLE ONLY public.skill
    ADD CONSTRAINT skill_pk PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.skill DROP CONSTRAINT skill_pk;
       public            resume    false    209            �           2606    16624    certificate certificate_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.certificate
    ADD CONSTRAINT certificate_fk FOREIGN KEY (id_profile) REFERENCES public.profile(id) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.certificate DROP CONSTRAINT certificate_fk;
       public          resume    false    201    200    3187            �           2606    16634    course course_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_fk FOREIGN KEY (id_profile) REFERENCES public.profile(id) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.course DROP CONSTRAINT course_fk;
       public          resume    false    202    3187    200            �           2606    16647    education education_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.education
    ADD CONSTRAINT education_fk FOREIGN KEY (id_profile) REFERENCES public.profile(id) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.education DROP CONSTRAINT education_fk;
       public          resume    false    3187    200    203            �           2606    16657    hobby hobby_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.hobby
    ADD CONSTRAINT hobby_fk FOREIGN KEY (id_profile) REFERENCES public.profile(id) ON UPDATE CASCADE ON DELETE CASCADE;
 8   ALTER TABLE ONLY public.hobby DROP CONSTRAINT hobby_fk;
       public          resume    false    200    204    3187            �           2606    16668    language language_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_fk FOREIGN KEY (id_profile) REFERENCES public.profile(id) ON UPDATE CASCADE ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.language DROP CONSTRAINT language_fk;
       public          resume    false    3187    205    200            �           2606    16683    practic practice_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.practic
    ADD CONSTRAINT practice_fk FOREIGN KEY (id_profile) REFERENCES public.profile(id) ON UPDATE CASCADE ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.practic DROP CONSTRAINT practice_fk;
       public          resume    false    3187    200    206            �           2606    16710    skill skill_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.skill
    ADD CONSTRAINT skill_fk FOREIGN KEY (id_profile) REFERENCES public.profile(id) ON UPDATE CASCADE ON DELETE CASCADE;
 8   ALTER TABLE ONLY public.skill DROP CONSTRAINT skill_fk;
       public          resume    false    3187    200    209                  x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �             x������ � �      "      x������ � �      !      x������ � �     