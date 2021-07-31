USE shops_rus
GO
insert into Categorias(id,descripcion)values(1,'Electronica')
insert into Categorias(id,descripcion)values(2,'Linea Blanca')
insert into Categorias(id,descripcion)values(3,'Comestibles')

INSERT INTO Tiendas(id,nombre,calle,colonia,municipio,estado,telefono)values(1,'ShopsRus Cuernavaca 01','Las flores','Bugambilias','Cuernavaca','Morelos','7771408998')

INSERT INTO Tipo_Usuarios(id,descripcion)values(1,'afiliado')
INSERT INTO Tipo_Usuarios(id,descripcion)values(2,'empleado')
INSERT INTO Tipo_Usuarios(id,descripcion)values(3,'cliente')

insert into Domicilios(id,calle,colonia,municipio,estado,numero)values(1,'Las flores','Bugambilias','Cuernavaca','Morelos','303B')
insert into Domicilios(id,calle,colonia,municipio,estado,numero)values(2,'Girasoles','Campo Verde','Cuauhtemoc','Morelos','')
insert into Domicilios(id,calle,colonia,municipio,estado,numero)values(3,'Orion','Palmas','Temixco','Morelos','6')

INSERT INTO Descuentos (id,descripcion,aplica,porcentage,cantidad,restricciones,antiguedad,superior,cada,total) VALUES(1,'Descuento de 10% sobre el total de la compra para un Afiliado',1,10,0,'3',0,0,0,1)
INSERT INTO Descuentos (id,descripcion,aplica,porcentage,cantidad,restricciones,antiguedad,superior,cada,total) VALUES(2,'Descuento de 30% sobre el total de la compra para un Empleado',2,30,0,'3',0,0,0,1)
INSERT INTO Descuentos (id,descripcion,aplica,porcentage,cantidad,restricciones,antiguedad,superior,cada,total) VALUES(3,'Descuento de 5% sobre el total de la compra para un Cliente, con una antiguedad de 2 años o más',3,5,0,'3',2,0,0,1)
INSERT INTO Descuentos (id,descripcion,aplica,porcentage,cantidad,restricciones,antiguedad,superior,cada,total) VALUES(4,'Descuento de 5 Dolares por cada 100 de Compra para un Afiliado',1,0,5,'',0,100,100,0)
INSERT INTO Descuentos (id,descripcion,aplica,porcentage,cantidad,restricciones,antiguedad,superior,cada,total) VALUES(5,'Descuento de 5 Dolares por cada 100 de Compra para un Empleado',2,0,5,'',0,100,100,0)
INSERT INTO Descuentos (id,descripcion,aplica,porcentage,cantidad,restricciones,antiguedad,superior,cada,total) VALUES(6,'Descuento de 5 Dolares por cada 100 de Compra para un Cliente',3,0,5,'',0,100,100,0)

INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(1,'Computadora Lenovo','ThinkPad E14 2da Gen (14 pulgadas, Intel)',40.00,1)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(2,'Moto E6i','Moto E6i - Gris Metálico 8 ram',60.00,1)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(3,'Computadora ASUS','SEEYUIUY E14 2da Gen 16gb Ram',80.00,1)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(4,'Grand Prime','Samsung Grand Prime',20.00,1)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(5,'Lavadora Wirpool','Lavadora Wirpool 12KG 4 ciclos de lavado',50.00,2)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(6,'Secadora ADC','Mabe LMA76112CBAB 16Kg Blanca',25.00,2)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(7,'Cereal All Bran','Empaque 20 cajas Original',20.00,3)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(8,'Frijol Del Valle','Caja con 20kg Frijol Peruano',10.00,3)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(9,'Arroz Morelos','Caja de 10 Kg',15.00,3)
INSERT INTO Productos(id,nombre,descripcion,precio,categoria)VALUES(10,'azucar','Costal 5 kg',30.00,3)



insert into Clientes(id,nombres,paterno,materno,fecha_nacimiento,tipo_usuario,domicilio)values(1,'Hector','Tavarez','Sotelo','1985-04-09',1,1)
insert into Clientes(id,nombres,paterno,materno,fecha_nacimiento,tipo_usuario,domicilio)values(2,'Miguel','Tavarez','Sotelo','1985-13-04',2,2)
insert into Clientes(id,nombres,paterno,materno,fecha_nacimiento,tipo_usuario,domicilio)values(3,'Luis Alberto','Lopez','Solares','1980-13-05',3,3)
insert into Clientes(id,nombres,paterno,materno,fecha_nacimiento,tipo_usuario,domicilio)values(4,'Elizabeth','Gonzalez','Moncada','1980-13-05',3,3)
insert into Clientes(id,nombres,paterno,materno,fecha_nacimiento,tipo_usuario,domicilio)values(5,'Danna','Montes','Maldonado','1980-13-05',3,3)

UPDATE CLIENTES SET fecha_creacion = '2018-03-09' where id in(3,4)

insert into Facturas(id,tienda,cliente)values(1,1,1)-- afiliado con 10% de descuento
insert into Facturas(id,tienda,cliente)values(2,1,2)-- empleado con 30% de descuento
insert into Facturas(id,tienda,cliente)values(3,1,3)-- cliente con 5% de descuento si es mayor a 2 años de antiguedad
insert into Facturas(id,tienda,cliente)values(4,1,5)-- cliente solo con descento por monto de 100


insert into Detalle_Facturas(id,factura,producto)values(1,1,1)
insert into Detalle_Facturas(id,factura,producto)values(2,1,2)
insert into Detalle_Facturas(id,factura,producto)values(3,1,3)

insert into Detalle_Facturas(id,factura,producto)values(4,2,1)
insert into Detalle_Facturas(id,factura,producto)values(5,2,2)
insert into Detalle_Facturas(id,factura,producto)values(6,2,3)

insert into Detalle_Facturas(id,factura,producto)values(7,3,1)
insert into Detalle_Facturas(id,factura,producto)values(8,3,2)
insert into Detalle_Facturas(id,factura,producto)values(9,3,3)

insert into Detalle_Facturas(id,factura,producto)values(10,4,1)
insert into Detalle_Facturas(id,factura,producto)values(11,4,2)
insert into Detalle_Facturas(id,factura,producto)values(12,4,3)



