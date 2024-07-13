package com.alura.literalura;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.alura.literalura.service.GutendexService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    private final GutendexService gutendexService;

    public LiterAluraApplication(GutendexService gutendexService) {
        this.gutendexService = gutendexService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            handleUserOption(option, scanner);
        } while (option != 0);
    }

    private void showMenu() {
        System.out.println("Elija la opción a través de su número:");
        System.out.println("1 - Buscar libro por título");
        System.out.println("2 - Listar libros registrados");
        System.out.println("3 - Listar autores registrados");
        System.out.println("4 - Listar autores vivos en un determinado año");
        System.out.println("5 - Listar libros por idioma");
        System.out.println("6 - Mostrar cantidad de libros por idioma");
        System.out.println("7 - Generar estadísticas de descargas de libros");
        System.out.println("8 - Listar los 10 libros más descargados");
        System.out.println("9 - Buscar autor por nombre");
        System.out.println("10 - Listar autores por año de nacimiento");
        System.out.println("11 - Listar autores por año de fallecimiento");
        System.out.println("0 - Salir");
    }

    private void handleUserOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                searchBookByTitle(scanner);
                break;
            case 2:
                listRegisteredBooks();
                break;
            case 3:
                listRegisteredAuthors();
                break;
            case 4:
                listAuthorsAliveInYear(scanner);
                break;
            case 5:
                listBooksByLanguage(scanner);
                break;
            case 6:
                countBooksByLanguage(scanner);
                break;
            case 7:
                generateBookDownloadStatistics();
                break;
            case 8:
                listTop10BooksByDownloads();
                break;
            case 9:
                searchAuthorByName(scanner);
                break;
            case 10:
                listAuthorsByBirthYear(scanner);
                break;
            case 11:
                listAuthorsByDeathYear(scanner);
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    private void searchBookByTitle(Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String title = scanner.nextLine();
        Book book = gutendexService.searchAndSaveBookByTitle(title);
        if (book == null) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            System.out.println("Libro encontrado: " + book);
        }
    }

    private void listRegisteredBooks() {
        List<Book> books = gutendexService.listRegisteredBooks();
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void listRegisteredAuthors() {
        List<Author> authors = gutendexService.listRegisteredAuthors();
        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            authors.forEach(System.out::println);
        }
    }

    private void listAuthorsAliveInYear(Scanner scanner) {
        System.out.print("Ingrese el año: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        List<Author> authors = gutendexService.listAuthorsAliveInYear(year);
        if (authors.isEmpty()) {
            System.out.println("No hay autores vivos en el año " + year + ".");
        } else {
            authors.forEach(System.out::println);
        }
    }

    private void listBooksByLanguage(Scanner scanner) {
        System.out.print("Ingrese el idioma (ES, EN, FR, PT): ");
        String language = scanner.nextLine();
        List<Book> books = gutendexService.listBooksByLanguage(language);
        if (books.isEmpty()) {
            System.out.println("No hay libros en el idioma " + language + ".");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void countBooksByLanguage(Scanner scanner) {
        System.out.print("Ingrese el idioma para contar los libros (ES, EN, FR, PT): ");
        String language = scanner.nextLine();
        long count = gutendexService.countBooksByLanguage(language);
        System.out.println("Cantidad de libros en " + language + ": " + count);
    }

    private void generateBookDownloadStatistics() {
        DoubleSummaryStatistics stats = gutendexService.getBookDownloadStatistics();
        System.out.println("Estadísticas de descargas de libros:");
        System.out.println("Total de descargas: " + stats.getSum());
        System.out.println("Promedio de descargas: " + stats.getAverage());
        System.out.println("Máximo de descargas: " + stats.getMax());
        System.out.println("Mínimo de descargas: " + stats.getMin());
    }

    private void listTop10BooksByDownloads() {
        List<Book> books = gutendexService.getTop10BooksByDownloads();
        System.out.println("Top 10 libros más descargados:");
        books.forEach(System.out::println);
    }

    private void searchAuthorByName(Scanner scanner) {
        System.out.print("Ingrese el nombre del autor: ");
        String name = scanner.nextLine();
        Author author = gutendexService.searchAuthorByName(name);
        if (author == null) {
            System.out.println("No se encontró un autor con ese nombre.");
        } else {
            System.out.println("Autor encontrado: " + author);
        }
    }

    private void listAuthorsByBirthYear(Scanner scanner) {
        System.out.print("Ingrese el año de nacimiento: ");
        int birthYear = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        List<Author> authors = gutendexService.listAuthorsByBirthYear(birthYear);
        if (authors.isEmpty()) {
            System.out.println("No se encontraron autores nacidos en el año " + birthYear + ".");
        } else {
            authors.forEach(System.out::println);
        }
    }

    private void listAuthorsByDeathYear(Scanner scanner) {
        System.out.print("Ingrese el año de fallecimiento: ");
        int deathYear = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        List<Author> authors = gutendexService.listAuthorsByDeathYear(deathYear);
        if (authors.isEmpty()) {
            System.out.println("No se encontraron autores fallecidos en el año " + deathYear + ".");
        } else {
            authors.forEach(System.out::println);
        }
    }
}

