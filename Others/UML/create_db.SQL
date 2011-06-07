SET FOREIGN_KEY_CHECKS=0;



CREATE TABLE customer
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	PRIMARY KEY (id),
	UNIQUE UQ_customer_id(id)
) 
;


CREATE TABLE inventory
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id),
	UNIQUE UQ_inventory_id(id)
) 
;


CREATE TABLE inventory_item
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	product_sku_number INTEGER NOT NULL,
	inventory_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	UNIQUE UQ_inventory_item_id(id),
	KEY (inventory_id),
	KEY (product_sku_number)
) 
;


CREATE TABLE order
(
	order_number INTEGER NOT NULL AUTO_INCREMENT,
	customer_id INTEGER NOT NULL,
	amount_with_discount DECIMAL(24,2) NOT NULL,
	date DATE NOT NULL DEFAULT now,
	PRIMARY KEY (order_number),
	UNIQUE UQ_order_order_number(order_number),
	KEY (customer_id)
) 
;


CREATE TABLE order_item
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	order_order_number INTEGER NOT NULL,
	product_sku_number INTEGER NOT NULL,
	quantity INTEGER NOT NULL,
	PRIMARY KEY (id),
	UNIQUE UQ_order_item_id(id),
	KEY (order_order_number),
	KEY (product_sku_number)
) 
;


CREATE TABLE product
(
	sku_number INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	amount DECIMAL(24,2) NOT NULL,
	PRIMARY KEY (sku_number),
	UNIQUE UQ_product_sku_number(sku_number)
) 
;



SET FOREIGN_KEY_CHECKS=1;


ALTER TABLE inventory_item ADD CONSTRAINT FK_inventory_item_inventory 
	FOREIGN KEY (inventory_id) REFERENCES inventory (id)
;

ALTER TABLE inventory_item ADD CONSTRAINT FK_inventory_item_product 
	FOREIGN KEY (product_sku_number) REFERENCES product (sku_number)
;

ALTER TABLE order ADD CONSTRAINT FK_order_customer 
	FOREIGN KEY (customer_id) REFERENCES customer (id)
;

ALTER TABLE order_item ADD CONSTRAINT FK_order_item_order 
	FOREIGN KEY (order_order_number) REFERENCES order (order_number)
;

ALTER TABLE order_item ADD CONSTRAINT FK_order_item_product 
	FOREIGN KEY (product_sku_number) REFERENCES product (sku_number)
;
