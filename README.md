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

## Uso

Una vez que la aplicación esté en ejecución, interactúa con ella a través de la consola. Se mostrará un menú con las siguientes opciones:

1. Buscar libro por título:

+ Ingresa el título del libro y la aplicación buscará en la API de Gutendex y almacenará el libro y su autor en la base de datos.

2. Listar libros registrados:

+ Muestra todos los libros almacenados en la base de datos.

3. Listar autores registrados:

+ Muestra todos los autores almacenados en la base de datos.

4. Listar autores vivos en un determinado año:

+ Ingresa un año y la aplicación listará todos los autores que estaban vivos en ese año.

5. Listar libros por idioma:

+ Ingresa un idioma (ES, EN, FR, PT) y la aplicación mostrará todos los libros en ese idioma.

6. Mostrar cantidad de libros por idioma:

+ Ingresa un idioma (ES, EN, FR, PT) y la aplicación mostrará la cantidad de libros en ese idioma.

6. Generar estadísticas de descargas de libros:

+ Muestra estadísticas como el total, promedio, máximo y mínimo de descargas de libros.
  
7. Listar los 10 libros más descargados:

+ Muestra los 10 libros más descargados en la base de datos.

8. Buscar autor por nombre:

+ Ingresa el nombre del autor y la aplicación buscará en la base de datos el autor que coincida.

9. Listar autores por año de nacimiento:

+ Ingresa un año de nacimiento y la aplicación listará todos los autores nacidos en ese año.

10. Listar autores por año de fallecimiento:

+ Ingresa un año de fallecimiento y la aplicación listará todos los autores fallecidos en ese año.

11. Salir:

+ Cierra la aplicación.

## Ejemplo de uso

	Elija la opción a través de su número:
	1 - Buscar libro por título
	2 - Listar libros registrados
	3 - Listar autores registrados
	4 - Listar autores vivos en un determinado año
	5 - Listar libros por idioma
	6 - Mostrar cantidad de libros por idioma
	7 - Generar estadísticas de descargas de libros
	8 - Listar los 10 libros más descargados
	9 - Buscar autor por nombre
	10 - Listar autores por año de nacimiento
	11 - Listar autores por año de fallecimiento
	0 - Salir
	
 ## Contribuciones

Las contribuciones son bienvenidas. Para contribuir, por favor sigue los siguientes pasos:

1. Fork el repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Commit tus cambios (`git commit -m 'Agrega nueva funcionalidad'`).
4. Push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.


## Licencia

Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo [LICENSE](https://opensource.org/license/mit).





