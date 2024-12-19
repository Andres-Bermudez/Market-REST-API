# Market

- Esquema de la base de datos:
![schemaDB.png](images/schemaDB.png)

Este proyecto esta creado con una arquitectura por capas
orientada al dominio.

Se creo un archivo .properties para un ambiente de desarrollo
y otro diferente para un ambiente de produccion.

En este proyecto se usa Gradle como gestor de dependencias.

### Seguimiento del proyecto:
1. Creacion del proyecto con Spring Boot.
2. Configuracion del archivo .properties
3. Creacion de la estructura del proyecto.
4. Agregar dependencia Spring Data JPA.
5. Crear una base de datos en PostgreSQL.
6. Crear el esquema de la base de datos e insertar datos.
7. Agregar el driver de PostgreSQL.
8. Conectar la aplicacion a la base de datos.
9. Creacion de las entidades en Java utilizando JPA.
10. Crear una entidad con clave primaria compuesta.
11. Creacion de las relaciones entre las tablas.
12. Creacion de los repositorios para interactuar con la base de datos
    mediante JPA.
13. Utilizacion de Query Methods para realizar consultas SQL.