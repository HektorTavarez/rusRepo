USE shops_rus
GO
-- ----------------------------------------------------------
-- ------------------CONSULTA DESCUENTOS---------------------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusCDescuentos') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusCDescuentos
GO

GO
CREATE  PROCEDURE spRusCDescuentos
AS
BEGIN 

SELECT 
	id,
	descripcion,
	aplica,
	porcentage,
	cantidad,
	restricciones,
	antiguedad,
	superior,
	cada,
	total

FROM Descuentos 
Order by id 

END

GO

-- ----------------------------------------------------------
-- ---------------CONSULTA DESCUENTOS POR ID-----------------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusCDescuentosId') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusCDescuentosId

GO
CREATE  PROCEDURE spRusCDescuentosId(@id int)
AS
BEGIN 

SELECT 
	id,
	descripcion,
	aplica,
	porcentage,
	cantidad,
	restricciones,
	antiguedad,
	superior,
	cada,
	total

FROM Descuentos 
WHERE id = @id
Order by id 

END
GO
-- ----------------------------------------------------------
-- ---------------AGREGAR NUEVO DESCUENTO--------------------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusIDescuentos') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusIDescuentos

GO
CREATE PROCEDURE spRusIDescuentos (@descripcion VARCHAR(150)
								    ,@aplica INT	
								    ,@porcentage INT
								    ,@cantidad INT
								    ,@restricciones varchar(100)
								    ,@antiguedad INT
								    ,@superior decimal
								    ,@cada INT
								    ,@total INT
								   )
AS BEGIN TRY
	SET NOCOUNT ON;
	
	DECLARE @Error	NVARCHAR(MAX), @id INT
	
	
	SET @id = (SELECT (MAX(id) + 1) from Descuentos) 

INSERT INTO Descuentos(id,descripcion,aplica,porcentage,cantidad,restricciones,antiguedad,superior,
	cada,
	total) 
VALUES(@id,@descripcion,@aplica,@porcentage,@cantidad,@restricciones,@antiguedad,@superior,@cada,@total)

 SELECT '00' AS 'NumMensaje' , 'Oferta insertada' AS 'Mensaje', '' AS 'MensajeLog'   
 
END TRY
BEGIN CATCH  
	
		DECLARE @MensajeError			NVARCHAR(4000)
				,@NumeroError			INT
				,@GravedadError			INT
				,@EstadoError			INT
				,@LineaError			INT
				,@ProcedimientoError	NVARCHAR(200)
			
		SET @MensajeError	= ERROR_MESSAGE();
		SET @NumeroError	= ERROR_NUMBER();
		SET @GravedadError	= ERROR_SEVERITY();
		SET @EstadoError	= ERROR_STATE();
		SET @LineaError		= ERROR_LINE();
		SET	@ProcedimientoError = ISNULL (ERROR_PROCEDURE(), '-');
		
		SELECT @Error =   'TAREA OFFER INSERT , ERROR ' + CONVERT(VARCHAR(100),@NumeroError) + ' ,GRAVEDAD ' + CONVERT(VARCHAR(100),@GravedadError)
					  + ' ,ESTADO ' + CONVERT(VARCHAR(100),@EstadoError) + ' ,LINEA ' + CONVERT(VARCHAR(100),@LineaError)
					  + ' ,PROCEDIMIENTO ' + @ProcedimientoError + ' ,MENSAJE ' + @MensajeError               
		
		SELECT '01' AS 'NumMensaje' , 'Error al insertar Oferta' AS 'Mensaje', @Error AS 'MensajeLog'
	END CATCH
GO

-- ----------------------------------------------------------
-- ------------------CONSULTA CLIENTES-----------------------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusCClientes') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusCClientes
GO

GO
CREATE  PROCEDURE spRusCClientes
AS
BEGIN 

SELECT 
	c.id,
	nombres,
	paterno,
	materno,
	fecha_nacimiento,
	fecha_creacion,
	tipo_usuario as tipo,
	u.descripcion as usuario,
	d.calle,d.colonia,d.municipio,d.estado,d.numero,d.id as domicilio
FROM Clientes c WITH(NOLOCK) INNER JOIN Tipo_Usuarios u WITH(NOLOCK)
ON c.tipo_usuario = u.id  INNER JOIN Domicilios d WITH(NOLOCK) on c.domicilio = d.id
Order by c.id 

END

GO

-- ----------------------------------------------------------
-- ------------------CONSULTA CLIENTES POR ID----------------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusCClientesId') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusCClientesId
GO

GO
CREATE  PROCEDURE spRusCClientesId(@id int)
AS
BEGIN 

SELECT 
	c.id,
	nombres,
	paterno,
	materno,
	fecha_nacimiento,
	fecha_creacion,
	tipo_usuario as tipo,
	u.descripcion as usuario,
	d.calle,d.colonia,d.municipio,d.estado,d.numero,d.id as domicilio
FROM Clientes c WITH(NOLOCK) INNER JOIN Tipo_Usuarios u WITH(NOLOCK)
ON c.tipo_usuario = u.id  INNER JOIN Domicilios d WITH(NOLOCK) on c.domicilio = d.id
WHERE c.id = @id
Order by c.id 

END

GO

-- ----------------------------------------------------------
-- ------------------CONSULTA CLIENTES POR NOMBRE----------------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusCClientesName') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusCClientesName
GO

GO
CREATE  PROCEDURE spRusCClientesName(@name varchar(200))
AS
BEGIN 

SELECT 
	c.id,
	nombres,
	paterno,
	materno,
	fecha_nacimiento,
	fecha_creacion,
	tipo_usuario as tipo,
	u.descripcion as usuario,
	d.calle,d.colonia,d.municipio,d.estado,d.numero,d.id as domicilio
FROM Clientes c WITH(NOLOCK) INNER JOIN Tipo_Usuarios u WITH(NOLOCK)
ON c.tipo_usuario = u.id  INNER JOIN Domicilios d WITH(NOLOCK) on c.domicilio = d.id
WHERE (c.nombres+''+c.paterno+''+c.materno)  LIKE  @name + '%'

Order by c.id 

END

GO
-- ----------------------------------------------------------
-- ---------------AGREGAR NUEVO CLIENTE--------------------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusIClientes') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusIClientes

GO
CREATE PROCEDURE spRusIClientes (@nombres VARCHAR(150)
								    ,@paterno VARCHAR(75)	
								    ,@materno VARCHAR(75)
								    ,@tipo_usuario INT
								    ,@fecha_nacimiento VARCHAR(10)
								    ,@calle VARCHAR(100)
								    ,@colonia VARCHAR(100)
								    ,@municipio VARCHAR(100)
								    ,@estado VARCHAR(100)
								    ,@numero VARCHAR(20)
								   )
AS BEGIN TRY
	SET NOCOUNT ON;
	
	DECLARE @Error	NVARCHAR(MAX), @id_domicilio INT,@id_cliente INT
	
    SET @id_domicilio = (SELECT (MAX(id) + 1) FROM Domicilios) 
	
INSERT INTO Domicilios(id,calle,colonia,municipio,estado,numero)
VALUES(@id_domicilio,@calle,@colonia,@municipio,@estado,@numero)

SET @id_cliente = (SELECT (MAX(id) + 1) FROM Clientes) 

INSERT INTO Clientes(id,nombres,paterno,materno,fecha_nacimiento,tipo_usuario,domicilio)
VALUES(@id_cliente,@nombres,@paterno,@materno,@fecha_nacimiento,@tipo_usuario,@id_domicilio)


 SELECT '00' AS 'NumMensaje' , 'Cliente insertado' AS 'Mensaje', '' AS 'MensajeLog'   
 
END TRY
BEGIN CATCH  
	
		DECLARE @MensajeError			NVARCHAR(4000)
				,@NumeroError			INT
				,@GravedadError			INT
				,@EstadoError			INT
				,@LineaError			INT
				,@ProcedimientoError	NVARCHAR(200)
			
		SET @MensajeError	= ERROR_MESSAGE();
		SET @NumeroError	= ERROR_NUMBER();
		SET @GravedadError	= ERROR_SEVERITY();
		SET @EstadoError	= ERROR_STATE();
		SET @LineaError		= ERROR_LINE();
		SET	@ProcedimientoError = ISNULL (ERROR_PROCEDURE(), '-');
		
		SELECT @Error =   'TAREA CLIENT INSERT , ERROR ' + CONVERT(VARCHAR(100),@NumeroError) + ' ,GRAVEDAD ' + CONVERT(VARCHAR(100),@GravedadError)
					  + ' ,ESTADO ' + CONVERT(VARCHAR(100),@EstadoError) + ' ,LINEA ' + CONVERT(VARCHAR(100),@LineaError)
					  + ' ,PROCEDIMIENTO ' + @ProcedimientoError + ' ,MENSAJE ' + @MensajeError               
		
		SELECT '01' AS 'NumMensaje' , 'Error al insertar Cliente' AS 'Mensaje', @Error AS 'MensajeLog'
	END CATCH
GO


-- ----------------------------------------------------------
-- ------------------CONSULTA FACTURA POR ID----------------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusCfacturaId') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusCfacturaId
GO

CREATE  PROCEDURE spRusCfacturaId(@id int)
AS

SELECT f.id,tienda,cliente,t.nombre as nombre_tienda
FROM Facturas f WITH(NOLOCK) INNER JOIN Tiendas t on f.tienda = t.id
WHERE f.id = @id
ORDER BY f.id 

GO
-- ----------------------------------------------------------
-- ------------CONSULTA PRODUCTOS POR ID DE FACTURA----------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusCDetalleFacturaId') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusCDetalleFacturaId
GO

CREATE  PROCEDURE spRusCDetalleFacturaId(@id int)
AS

SELECT 
	f.id as factura, 
	p.nombre as producto,
	p.id as id,
	p.precio as precio,
	p.categoria as categoria
	
FROM
	Detalle_Facturas df WITH(NOLOCK) INNER JOIN Facturas f WITH(NOLOCK)
	ON f.id = df.factura  INNER JOIN Productos p WITH(NOLOCK)
	ON df.producto = p.id 
WHERE factura = @id
ORDER BY f.id 


GO
-- ----------------------------------------------------------
-- ---------- CONSULTA OFERTAS VALIDAS POR USUARIO ----------
-- ----------------------------------------------------------
IF EXISTS (SELECT 0 FROM SYSOBJECTS WHERE ID = OBJECT_ID('dbo.spRusCOfertasUsuario') AND TYPE = 'P') 
DROP PROCEDURE dbo.spRusCOfertasUsuario
GO

CREATE  PROCEDURE spRusCOfertasUsuario(@id int,
									   @monto decimal,
									   @antiguedad int)
AS
DECLARE @porcentage INT


SET @porcentage = (SELECT MAX(porcentage)
FROM
	Descuentos d 
WHERE aplica = @id)


SELECT id,
	descripcion,
	aplica,
	porcentage,
	cantidad,
	restricciones,
	antiguedad,
	superior,
	cada,
	total	
FROM
	Descuentos d 
WHERE aplica = @id 
and (superior <= @monto OR superior = 0 )
and antiguedad <= @antiguedad
and (porcentage = @porcentage OR porcentage = 0 ) 
ORDER BY porcentage desc 



-- EXEC spRusCDescuentos
-- EXEC spRusCDescuentosId 1
-- EXEC spRusIDescuentosId 'Afiliado',1,10,0,'Un descuento por Factura, No aplica a comestibles'
-- EXEC spRusCClientes
-- EXEC spRusCClientesId 1
-- EXEC spRusCClientesName 'Hectortava' 
-- EXEC spRusIClientes  'Juan Luis','Guerra','Montes',3,'1980-04-07','Molinos','Portales','Benito Juarez','Guerrero','208'
-- EXEC spRusCfacturaId 4 
-- EXEC spRusCDetalleFacturaId 4
-- EXEC spRusCOfertasUsuario 5,180,0



