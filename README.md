# LiterAlura

LiterAlura es una aplicación de consola desarrollada en Java utilizando Spring Boot y PostgreSQL. La aplicación permite buscar información sobre libros a través de la API de Gutendex y gestionar un catálogo de libros y autores. Este proyecto forma parte del desafío del programa ONE (Oracle Next Education).

## Características

- Búsqueda de libros por título
- Almacenamiento de libros y autores en una base de datos PostgreSQL
- Listado de todos los libros registrados
- Listado de todos los autores registrados
- Listado de autores vivos en un determinado año
- Listado de libros por idioma
- Contador de libros por idioma
- Generar estadísticas de descargas de libros
- Listar los 10 libros más descargados
- Buscar autor por nombre
- Listar autores por año de nacimiento
- Listar autores por año de fallecimiento

## Requisitos

- Java JDK 17 o superior
- Maven 4 o superior
- Spring Boot 3.2.3
- PostgreSQL 16 o superior
- IntelliJ IDEA (opcional, pero recomendado)

## Configuración del Proyecto

1. **Clonar el repositorio:**

   ```
   git clone https://github.com/tu-usuario/literalura.git
   cd literalura

2. **Configurar la base de datos PostgreSQL:**

- Crear una base de datos llamada literalura.
- Configurar las credenciales de acceso a la base de datos en el archivo application.properties

   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

 3. **Construir y ejecutar el proyecto:**

   ```
   mvn clean install
   mvn spring-boot:run

	```


