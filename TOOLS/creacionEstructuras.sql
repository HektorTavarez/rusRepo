--CREATE DATABASE shops_rus
--GO
USE shops_rus
GO
-- --------------------------------------------------------------
-- --------------------------CATEGORIAS--------------------------
-- --------------------------------------------------------------
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Detalle_Facturas'))
BEGIN
  DROP TABLE Detalle_Facturas
END
GO
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Facturas'))
BEGIN
  DROP TABLE Facturas
END
GO
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Clientes'))
BEGIN
  DROP TABLE Clientes
END
GO
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Productos'))
BEGIN
  DROP TABLE Productos
END
GO
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Descuentos'))
BEGIN
  DROP TABLE Descuentos
END
GO
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Categorias'))
BEGIN
  DROP TABLE Categorias
END
GO
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Domicilios'))
BEGIN
  DROP TABLE Domicilios
END
GO
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Tiendas'))
BEGIN
  DROP TABLE Tiendas
END
GO
IF (EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'Tipo_Usuarios'))
BEGIN
  DROP TABLE Tipo_Usuarios
END

-- --------------------------------------------------------------
-- -----------------------Tipo_Usuario---------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Tipo_Usuarios(
	id INT NOT NULL,
	descripcion VARCHAR(150) NOT NULL	
	CONSTRAINT PK_Tipo_Usuario PRIMARY KEY (id)
)

-- --------------------------------------------------------------
-- -----------------------Tiendas---------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Tiendas(
	id INT NOT NULL,
	nombre VARCHAR(150) NOT NULL,
	calle VARCHAR(100) NOT NULL,
	colonia VARCHAR(100) NOT NULL,
	municipio VARCHAR(100) NOT NULL,
	estado VARCHAR(100) NOT NULL,
	telefono VARCHAR(10) NOT NULL,	
	CONSTRAINT PK_Tiendas PRIMARY KEY (id)
)

-- --------------------------------------------------------------
-- --------------------------DOMICILIO---------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Domicilios(
	id INT NOT NULL,
	calle VARCHAR(100) NULL,
	colonia VARCHAR(100)  NULL,
	municipio VARCHAR(100)  NULL,
	estado VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NULL,
	CONSTRAINT PK_Domicilio PRIMARY KEY (id)
)
-- --------------------------------------------------------------
-- --------------------------CATEGORIAS---------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Categorias(
	id INT NOT NULL,
	descripcion VARCHAR (50)NOT NULL,	
	CONSTRAINT PK_Categorias PRIMARY KEY (id)
)
-- --------------------------------------------------------------
-- --------------------------DESCUENTOS--------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Descuentos(
	id INT NOT NULL,
	descripcion VARCHAR(150) NOT NULL,
	aplica INT NOT NULL,
	porcentage INT NOT NULL,
	cantidad INT NOT NULL,
	restricciones VARCHAR(150) NOT NULL,
	antiguedad INT NOT NULL,	
	superior decimal NOT NULL,
	cada INT NOT NULL,
	total INT NOT NULL,
	CONSTRAINT PK_Descuentos PRIMARY KEY (id),
	FOREIGN KEY (aplica) REFERENCES Tipo_Usuarios(id)
)
-- --------------------------------------------------------------
-- --------------------------PRODUCTOS---------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Productos(
	id INT NOT NULL,
	nombre VARCHAR (50)NOT NULL,	
	descripcion VARCHAR (80)NOT NULL,
	precio NUMERIC(10,2) NOT NULL,
	categoria INT NOT NULL,
	CONSTRAINT PK_Productos PRIMARY KEY (id),
    FOREIGN KEY (categoria) REFERENCES Categorias(id)
)
-- --------------------------------------------------------------
-- --------------------------CLIENTES---------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Clientes(
	id INT NOT NULL,
	nombres VARCHAR(150) NOT NULL,
	paterno VARCHAR(75) NOT NULL,
	materno VARCHAR(75) NOT NULL,
	fecha_nacimiento DATETIME NOT NULL,
    fecha_creacion DATETIME NOT NULL DEFAULT GETDATE(),	
    tipo_usuario INT NOT NULL,	
    domicilio INT NOT NULL
	CONSTRAINT PK_Clientes PRIMARY KEY (id),
	FOREIGN KEY (tipo_usuario) REFERENCES Tipo_Usuarios(id),
	FOREIGN KEY (domicilio) REFERENCES Domicilios(id)
)
-- --------------------------------------------------------------
-- --------------------------FACTURAS---------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Facturas(
	id INT NOT NULL,
	tienda INT NOT NULL,
	cliente INT NOT NULL,	
	CONSTRAINT PK_Facturas PRIMARY KEY (id),
	FOREIGN KEY (tienda) REFERENCES Tiendas(id),
	FOREIGN KEY (cliente) REFERENCES Clientes(id)
)

-- --------------------------------------------------------------
-- --------------------DETALLE-FACTURAS--------------------------
-- --------------------------------------------------------------
GO
CREATE TABLE Detalle_Facturas(
	id INT NOT NULL,
	factura INT NOT NULL,
	producto INT NOT NULL,	
	CONSTRAINT PK_Detalle_Facturas PRIMARY KEY (id),
	FOREIGN KEY (factura) REFERENCES Facturas(id),
	FOREIGN KEY (producto) REFERENCES Productos(id),
)

--INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(1,'Computadora Lenovo','ThinkPad E14 2da Gen (14 pulgadas, Intel)',12000.00,1)
--INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(2,'Moto E6i','Moto E6i - Gris Metálico 8 ram',6000.00,1)



