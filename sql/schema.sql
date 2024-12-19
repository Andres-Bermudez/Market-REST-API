-- -----------------------------------------------------
-- Tabla "CATEGORIAS"
-- -----------------------------------------------------
CREATE TABLE  categories (
  "id_category" SERIAL NOT NULL,
  "description" VARCHAR(45) NOT NULL,
  "status" BOOLEAN NOT NULL,

  PRIMARY KEY ("id_category"));


-- -----------------------------------------------------
-- Tabla "PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE  products (
  "id_product" SERIAL NOT NULL,
  "name" VARCHAR(45) NULL,
  "id_category" INT NOT NULL,
  "bar_code" VARCHAR(150) NULL,
  "sales_price" DECIMAL(16,2) NULL,
  "stock_quantity" INT NOT NULL,
  "status" BOOLEAN NULL,

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
  "id" VARCHAR(20) NOT NULL,
  "name" VARCHAR(40) NULL,
  "lastname" VARCHAR(100) NULL,
  "phone" NUMERIC NULL,
  "address" VARCHAR(80) NULL,
  "email" VARCHAR(70) NULL,

  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "COMPRAS"
-- -----------------------------------------------------
CREATE TABLE  purchases (
  "id_purchase" SERIAL NOT NULL,
  "id_customer" VARCHAR(20) NOT NULL,
  "date" TIMESTAMP NULL,
  "payment_method" CHAR(1) NULL,
  "comment" VARCHAR(300) NULL,
  "status" CHAR(1) NULL,

  PRIMARY KEY ("id_purchase"),
  CONSTRAINT "fk_purchases_customers1"
    FOREIGN KEY ("id_customer")
    REFERENCES customers ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "COMPRAS_REALIZADAS"
-- -----------------------------------------------------
CREATE TABLE  purchases_made (
  "id_purchase" INT NOT NULL,
  "id_product" INT NOT NULL,
  "quantity" INT NULL,
  "total" DECIMAL(16,2) NULL,
  "status" BOOLEAN NULL,

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
