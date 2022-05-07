DROP TABLE USUARIOS;
DROP TABLE INVENTARIO;
DROP TABLE VENTAS;

CREATE TABLE USUARIOS 
(NOMBRE_USUARIO VARCHAR(20) UNIQUE PRIMARY KEY,
NUMERO_EMPLEADO INT UNIQUE,
CONTRASENA VARCHAR(20) DEFAULT "usuario123",
USUARIO_ADMIN CHAR(1) CHECK(USUARIO_ADMIN IN("T", "F")));

CREATE TABLE INVENTARIO
(CODIGO_PRODUCTO INT UNIQUE PRIMARY KEY,
NOMBRE_PRODUCTO VARCHAR(20) UNIQUE,
FAMILIA_PRODUCTO VARCHAR(20) UNIQUE,
CANTIDAD_PRODCUTO INT CHECK(CANTIDAD_PRODCUTO>=0),
PRECIO_PRODUCTO DECIMAL(4,2),
IVA_PRODUCTO DECIMAL(3,2));

CREATE TABLE VENTAS
(CODIGO_PRODUCTO INT,
NOMBRE_PRODUCTO VARCHAR(20),
FAMILIA_PRODUCTO VARCHAR(20),
CANTIDAD_PRODUCTO_VENDIDO INT CHECK(CANTIDAD_PRODUCTO_VENDIDO>=0),
FECHA_VENTA DATE,
NUMERO_EMPLEADO INT);

INSERT INTO USUARIOS VALUES("admin", 0001, "admin", "T");
INSERT INTO USUARIOS VALUES("morenodavid", 0002, "12345", "F");
