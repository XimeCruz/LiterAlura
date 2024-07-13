package com.alura.literalura.service;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.client.GutendexClient;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GutendexService {
    private final GutendexClient gutendexClient;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public GutendexService(GutendexClient gutendexClient, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.gutendexClient = gutendexClient;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book searchAndSaveBookByTitle(String title) {
        try {
            Book book = gutendexClient.searchBookByTitle(title);
            if (book != null) {
                Author author = book.getAuthor();
                if (!authorRepository.existsByFullName(author.getFullName())) {
                    authorRepository.save(author);
                } else {
                    author = authorRepository.findByFullName(author.getFullName());
                }
                book.setAuthor(author);
                if (!bookRepository.existsByTitle(book.getTitle())) {
                    bookRepository.save(book);
                }
            }
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> listRegisteredBooks() {
        return bookRepository.findAll();
    }

    public List<Author> listRegisteredAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> listAuthorsAliveInYear(int year) {
        return authorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year);
    }

    public List<Book> listBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public long countBooksByLanguage(String language) {
        return bookRepository.countByLanguage(language);
    }

    public DoubleSummaryStatistics getBookDownloadStatistics() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .mapToDouble(Book::getDownloadCount)
                .summaryStatistics();
    }

    public List<Book> getTop10BooksByDownloads() {
        return bookRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Book::getDownloadCount).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public Author searchAuthorByName(String name) {
        return authorRepository.findByFullNameContainingIgnoreCase(name);
    }

    public List<Author> listAuthorsByBirthYear(int birthYear) {
        return authorRepository.findByBirthYear(birthYear);
    }

    public List<Author> listAuthorsByDeathYear(int deathYear) {
        return authorRepository.findByDeathYear(deathYear);
    }
}
