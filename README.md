# shopRus
Api ShopsRus


<br />

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisitos</a></li>
        <li><a href="#installation">Instalación</a></li>
        <li><a href="#usage">Uso</a></li>
      </ul>
    </li>   
  </ol>
</details>

<!-- GETTING STARTED -->
## Getting Started
### Prerequisites


 <ul>
    <li>Desarrollado en Java version 1.8</li>
    <li>Spring Boot</li>
    <li>Sql Server 2008R2</li>
    <li>Intalación de Lombok en eclipse</li>
  </ul>

### Installation

Clonar el repositorio
   ```sh
   git clone https://github.com/HektorTavarez/rusRepo.git
   ```

 <ul>
    <li>Importar proyecto en Eclipse</li>
    <li>Cambiar Variables en archivo properties para conexión a BD </li>
    <li>Crear la BD shops_rus y dentro ejecutar los siguientes archivos</li>  
    <li>Ejecutar en SQL Server  archivo creacionEstructuras.sql que se encuentra en la carpeta TOOLS</li>
    <li>Ejecutar en SQL Server archivo inserts.sql que se encuentra en la carpeta TOOLS</li>
    <li>Ejecutar en SQL Server archivo SPS.sql que se encuentra en la carpeta TOOLS</li>
    <li>Ejecutar proyecto como Spring Boot App</li>
  </ul>

## Usage

Para probar el api cargar en postman el archivo de peticiones generado con el nombre shopsrus.postman_collection.json que se encuentra en la carpeta TOOLS, 
en el viene el listado de peticiones así como los datos necesarios para realizar las pruebas 

<br />

N:En el documento flujosDePrueba.docx se indica el método de servicio que Cubre con cada requerimiento, de igual forma se agrega el archivo shopsrus.postman_collection.json 
 Que contiene la información necesaria para realizar las peticiones. 



<!-- CONTACT -->
## Contact
hektormts@gmail.com



