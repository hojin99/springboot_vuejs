
CREATE TABLE public.tm_bld (
	bld_adm_cd varchar(25) NULL,
	bld_type varchar(5) NULL,
	upd_dtime varchar(24) NULL,
	bld_name varchar(150) NULL,
	bld_name_dong varchar(254) NULL,
	over_flr_no numeric NULL,
	under_flr_no numeric NULL,
	bdri_cd varchar(10) NULL,
	hemd_cd varchar(8) NULL,
	bld_sub_no numeric NULL,
	zip varchar(7) NULL,
	bld_area numeric NULL,
	utmk_x numeric NULL,
	utmk_y numeric NULL,
	addr varchar(254) NULL,
	geom geometry(MULTIPOLYGON, 3857) NULL
);
CREATE INDEX tm_bld_six ON public.tm_bld USING gist (geom);

CREATE TABLE public.tm_user (
	user_seq serial,
	user_name text,
	tel text,
	age int,
	intro text
);

CREATE INDEX tm_user_uix ON public.tm_user(user_seq);
CREATE INDEX tm_user_ix ON public.tm_user(user_name);


CREATE TABLE public.tm_user_pic (
	user_seq int,
	pic bytea
);

CREATE INDEX tm_user_pic_ix ON public.tm_user_pic(user_seq);
