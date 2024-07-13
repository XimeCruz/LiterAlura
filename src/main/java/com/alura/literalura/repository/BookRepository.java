package com.alura.literalura.repository;

import com.alura.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguage(String language);
    boolean existsByTitle(String title);

    @Query("SELECT COUNT(b) FROM Book b WHERE b.language = ?1")
    long countByLanguage(String language);
}

