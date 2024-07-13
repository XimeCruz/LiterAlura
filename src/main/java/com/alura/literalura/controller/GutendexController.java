package com.alura.literalura.controller;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.alura.literalura.service.GutendexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@RestController
public class GutendexController {
    private final GutendexService gutendexService;

    public GutendexController(GutendexService gutendexService) {
        this.gutendexService = gutendexService;
    }

    @GetMapping("/search")
    public Book searchBook(@RequestParam String title) {
        return gutendexService.searchAndSaveBookByTitle(title);
    }

    @GetMapping("/books")
    public List<Book> listRegisteredBooks() {
        return gutendexService.listRegisteredBooks();
    }

    @GetMapping("/authors")
    public List<Author> listRegisteredAuthors() {
        return gutendexService.listRegisteredAuthors();
    }

    @GetMapping("/authors/alive")
    public List<Author> listAuthorsAliveInYear(@RequestParam int year) {
        return gutendexService.listAuthorsAliveInYear(year);
    }

    @GetMapping("/books/language")
    public List<Book> listBooksByLanguage(@RequestParam String language) {
        return gutendexService.listBooksByLanguage(language);
    }

    @GetMapping("/books/count")
    public long countBooksByLanguage(@RequestParam String language) {
        return gutendexService.countBooksByLanguage(language);
    }

    @GetMapping("/books/statistics")
    public DoubleSummaryStatistics getBookDownloadStatistics() {
        return gutendexService.getBookDownloadStatistics();
    }

    @GetMapping("/books/top10")
    public List<Book> getTop10BooksByDownloads() {
        return gutendexService.getTop10BooksByDownloads();
    }

    @GetMapping("/authors/search")
    public Author searchAuthorByName(@RequestParam String name) {
        return gutendexService.searchAuthorByName(name);
    }

    @GetMapping("/authors/birthYear")
    public List<Author> listAuthorsByBirthYear(@RequestParam int birthYear) {
        return gutendexService.listAuthorsByBirthYear(birthYear);
    }

    @GetMapping("/authors/deathYear")
    public List<Author> listAuthorsByDeathYear(@RequestParam int deathYear) {
        return gutendexService.listAuthorsByDeathYear(deathYear);
    }
}
