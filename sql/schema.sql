-- -----------------------------------------------------
-- Tabla "CATEGORIAS"
-- -----------------------------------------------------
CREATE TABLE  categories (
  "id_category" SERIAL,
  "description" VARCHAR(100) NOT NULL,
  "status" BOOLEAN NOT NULL,

  PRIMARY KEY ("id_category"));


-- -----------------------------------------------------
-- Tabla "PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE  products (
  "id_product" SERIAL,
  "name" VARCHAR(100) NULL,
  "id_category" BIGINT NOT NULL,
  "bar_code" VARCHAR(300) NOT NULL,
  "sales_price" DECIMAL(16,2) NOT NULL,
  "stock_quantity" BIGINT NOT NULL,
  "status" BOOLEAN NOT NULL,

  PRIMARY KEY ("id_product"),

  CONSTRAINT "fk_products_categories"
    FOREIGN KEY ("id_category")
    REFERENCES categories ("id_category")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Tabla "CLIENTES"
-- -----------------------------------------------------
CREATE TABLE  customers (
  "id_customer" SERIAL ,
  "name" VARCHAR(100) NOT NULL,
  "lastname" VARCHAR(100) NOT NULL,
  "phone" BIGINT NOT NULL,
  "address" VARCHAR(100) NOT NULL,
  "email" VARCHAR(100) NOT NULL,

  PRIMARY KEY ("id_customer"));


-- -----------------------------------------------------
-- Table "COMPRAS"
-- -----------------------------------------------------
CREATE TABLE  purchases (
  "id_purchase" SERIAL,
  "id_customer" BIGINT NOT NULL,
  "date" TIMESTAMP NULL,
  "payment_method" CHAR(1) NOT NULL,
  "comment" VARCHAR(300) NOT NULL,
  "status" BOOLEAN NOT NULL,

  PRIMARY KEY ("id_purchase"),

  CONSTRAINT "fk_purchases_customers1"
    FOREIGN KEY ("id_customer")
    REFERENCES customers ("id_customer")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "COMPRAS_REALIZADAS"
-- -----------------------------------------------------
CREATE TABLE  purchases_made (
  "id_purchase" BIGINT NOT NULL,
  "id_product" BIGINT NOT NULL,
  "quantity" BIGINT NOT NULL,
  "total" DECIMAL(16,2) NOT NULL,
  "status" BOOLEAN NOT NULL,

  PRIMARY KEY ("id_purchase", "id_product"),

  CONSTRAINT "fk_purchases_made_products1"
    FOREIGN KEY ("id_product")
    REFERENCES products ("id_product")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT "fk_purchases_made_purchases1"
    FOREIGN KEY ("id_purchase")
    REFERENCES purchases ("id_purchase")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
