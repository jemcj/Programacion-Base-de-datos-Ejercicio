El proyecto consta de 4 carpetas: DAO, DO, model, utils. Además tiene aparte un archivo main

DAO
Esta carpeta contiene todas las funciones que modifican la base de datos, con funciones para sacar la informacion, meter informacion
borrarla y modificarla. Estan funcionaes estan adaptadas a cada una de las tablas que se modifican desde la aplicacion

DO 
Esta carpeta contiene archivos que guardan los objetos que representan los registros de las tablas que se modifican en el DAO, para poder
operar con ellas.

Model
Contiene el CrudModel, que tiene funciones abstractas que heredan todos los DAOs del proyecto

Utils
Contiene el archivo que conecta la aplicacion a la base de datos

Main
Ejecuta la aplicacion