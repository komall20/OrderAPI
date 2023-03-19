-- Table: public.customer_orders

-- DROP TABLE IF EXISTS public.customer_orders;

CREATE TABLE IF NOT EXISTS public.customer_orders
(
    id integer NOT NULL DEFAULT nextval('customer_orders_id_seq'::regclass),
    customer_id integer NOT NULL,
    order_id integer NOT NULL,
    store_id integer NOT NULL,
    order_status character varying(10) COLLATE pg_catalog."default" NOT NULL,
    order_amount numeric NOT NULL,
    payment_status character varying(10) COLLATE pg_catalog."default" NOT NULL,
    customer_email character varying(50) COLLATE pg_catalog."default",
    customer_mobile character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT customer_orders_pkey PRIMARY KEY (id),
    CONSTRAINT customer_id_order_id_store_id UNIQUE (customer_id, order_id, store_id)
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer_orders
    OWNER to postgres;

-- Table: public.order_items

-- DROP TABLE IF EXISTS public.order_items;

CREATE TABLE IF NOT EXISTS public.order_items
(
    id integer NOT NULL DEFAULT nextval('order_items_id_seq'::regclass),
    order_id integer NOT NULL,
    item_id integer NOT NULL,
    item_price numeric NOT NULL,
    item_description character varying(25) COLLATE pg_catalog."default" NOT NULL,
    item_quantity integer NOT NULL,
    CONSTRAINT order_items_pkey PRIMARY KEY (id),
    CONSTRAINT customer_order_id FOREIGN KEY (order_id)
        REFERENCES public.customer_orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.order_items
    OWNER to postgres;