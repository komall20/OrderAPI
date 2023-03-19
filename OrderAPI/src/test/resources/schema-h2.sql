-- DROP TABLE IF EXISTS customer_orders;

CREATE TABLE IF NOT EXISTS customer_orders
(
    id serial PRIMARY KEY,
    customer_id integer NOT NULL,
    order_id integer NOT NULL,
    store_id integer NOT NULL,
    order_status character varying(10) NOT NULL,
    order_amount numeric NOT NULL,
    payment_status character varying(10)  NOT NULL,
    customer_email character varying(50),
    customer_mobile character varying(10),
    CONSTRAINT customer_id_order_id_store_id UNIQUE (customer_id, order_id, store_id)
)


-- DROP TABLE IF EXISTS order_items;

CREATE TABLE IF NOT EXISTS order_items
(
    id serial PRIMARY KEY,
    order_id integer NOT NULL,
    item_id integer NOT NULL,
    item_price numeric NOT NULL,
    item_description character varying(25)  NOT NULL,
    item_quantity integer NOT NULL,
    CONSTRAINT customer_order_id FOREIGN KEY (order_id)
        REFERENCES customer_orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
