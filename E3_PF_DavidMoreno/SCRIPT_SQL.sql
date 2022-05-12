DROP TABLE USUARIOS;
DROP TABLE INVENTARIO;
DROP TABLE VENTAS;

CREATE TABLE USUARIOS 
(NOMBRE_USUARIO VARCHAR(20) UNIQUE PRIMARY KEY,
NUMERO_EMPLEADO INT UNIQUE AUTO_INCREMENT,
CONTRASENA VARCHAR(20) DEFAULT "usuario123",
USUARIO_ADMIN CHAR(1) CHECK(USUARIO_ADMIN IN("T", "F"))) AUTO_INCREMENT=10001;

CREATE TABLE INVENTARIO
(CODIGO_PRODUCTO INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
NOMBRE_PRODUCTO VARCHAR(99) UNIQUE,
FAMILIA_PRODUCTO VARCHAR(20),
CANTIDAD_PRODCUTO INT CHECK(CANTIDAD_PRODCUTO>=0),
PRECIO_PRODUCTO DECIMAL(4,2),
IVA_PRODUCTO DECIMAL(3,2)) AUTO_INCREMENT=20001;

CREATE TABLE VENTAS
(NUMERO_VENTA INT PRIMARY KEY AUTO_INCREMENT,
CODIGO_PRODUCTO INT,
NOMBRE_PRODUCTO VARCHAR(20),
FAMILIA_PRODUCTO VARCHAR(20),
CANTIDAD_PRODUCTO_VENDIDO INT CHECK(CANTIDAD_PRODUCTO_VENDIDO>=0),
FECHA_VENTA DATE,
NUMERO_EMPLEADO INT);

INSERT INTO USUARIOS VALUES("admin", NULL,"admin", "T");
INSERT INTO USUARIOS VALUES("morenodavid", NULL, "12345", "F");
INSERT INTO USUARIOS VALUES("user1", NULL, "12345", "F");
INSERT INTO USUARIOS VALUES("user2", NULL, "12345", "F");

/*IVA Superreducido*/
INSERT INTO INVENTARIO VALUES(NULL, "Docena de Huevos", "Frescos", 20, 5.55, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Docena de Huevos XL", "Frescos", 20, 6.55, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Docena de Huevos Codorniz", "Frescos", 20, 6.55, 1.04);

INSERT INTO INVENTARIO VALUES(NULL, "Leche Desnatada", "Lacteos", 50, 0.55, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Leche Semidesnatada", "Lacteos", 50, 0.65, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Leche Entera", "Lacteos", 50, 0.75, 1.04);

INSERT INTO INVENTARIO VALUES(NULL, "Queso Semicurado", "Lacteos", 20, 3.97, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Queso Curado", "Lacteos", 20, 4.97, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Queso Rallado Mozzarella", "Lacteos", 20, 1.49, 1.04);

INSERT INTO INVENTARIO VALUES(NULL, "Harina de trigo", "Cereales", 20, 0.54, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Harina de trigo fuerza", "Cereales", 20, 0.93, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Harina de trigo reposteria", "Cereales", 20, 0.99, 1.04);

INSERT INTO INVENTARIO VALUES(NULL, "Banana 1Kg", "Frutas", 20, 0.95, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Aguacate 500g", "Frutas", 20, 1.99, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Manzana Golden 1Kg", "Frutas", 20, 1.75, 1.04);

INSERT INTO INVENTARIO VALUES(NULL, "Cebolla 1Kg", "Hortalizas", 20, 1.79, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Espinaca troceada", "Hortaliza", 20, 0.99, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Zanahoria 1Kg", "Hortalizas", 20, 0.69, 1.04);

INSERT INTO INVENTARIO VALUES(NULL, "Lechuga iceberg", "Verduras", 20, 0.99, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Brocoli", "Verduras", 20, 1.19, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Coliflor", "Verduras", 20, 2.53, 1.04);

INSERT INTO INVENTARIO VALUES(NULL, "Patata 5Kg", "Tuberculos", 20, 4.99, 1.04);

INSERT INTO INVENTARIO VALUES(NULL, "Lentejas 1Kg", "Legumbres", 20, 1.95, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Alubia pinta 1Kg", "Legumbres", 20, 1.99, 1.04);
INSERT INTO INVENTARIO VALUES(NULL, "Garbanzos 1Kg", "Legumbres", 20, 2.59, 1.04);

/*IVA Reducido*/
INSERT INTO INVENTARIO VALUES(NULL, "Pan de picos", "Cereales", 20, 0.89, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Pan de pueblo", "Cereales", 20, 1.15, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Barra de pan", "Cereales", 20, 0.35, 1.10);

INSERT INTO INVENTARIO VALUES(NULL, "Agua mineral 1.5L", "Agua", 20, 0.21, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Agua mineral 5L", "Agua", 20, 0.52, 1.10);

INSERT INTO INVENTARIO VALUES(NULL, "Refresco de limon", "Refrescos", 20, 0.49, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Refresco de cola 1L", "Refrescos", 20, 0.49, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Refresco de te 1L", "Refrescos", 20, 0.74, 1.10);

INSERT INTO INVENTARIO VALUES(NULL, "Judias verdes en bote", "Verduras", 20, 0.85, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Guisantes finos en bote", "Verduras", 20, 0.55, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Fabada asturiana en bote", "Legumbres", 20, 1.26, 1.10);

INSERT INTO INVENTARIO VALUES(NULL, "Compresas ultrafinas", "Higiene Femenina", 20, 1.50, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Toallitas intimas", "Higiene Femenina", 20, 1.44, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Gel intimas", "Higiene Femenina", 20, 1.40, 1.10);

INSERT INTO INVENTARIO VALUES(NULL, "Tiras de maíz barbacoa 150g", "Snacks", 20, 0.85, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Conos de maíz queso 150g", "Snacks", 20, 0.68, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Galletas saladas 350g", "Snacks", 20, 0.85, 1.10);

INSERT INTO INVENTARIO VALUES(NULL, "Dentrifico anticaries", "Higiene", 20, 3.45, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Espuma de afeitar 250ml", "Higiene", 20, 0.71, 1.10);
INSERT INTO INVENTARIO VALUES(NULL, "Preservativo natural 12 ud", "Higiene", 20, 6.99, 1.10);





