package com.alura.literalura.client;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class GutendexClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public GutendexClient() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        this.objectMapper = new ObjectMapper();
    }

    public Book searchBookByTitle(String title) throws Exception {
        String url = "https://gutendex.com/books/?search=" + title;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return parseBookResponse(response.body());
    }

    private Book parseBookResponse(String responseBody) throws Exception {
        JsonNode root = objectMapper.readTree(responseBody);
        JsonNode results = root.path("results");
        if (results.isArray() && results.size() > 0) {
            JsonNode node = results.get(0);
            Book book = new Book();
            book.setTitle(node.path("title").asText());
            book.setLanguage(node.path("languages").get(0).asText());
            book.setDownloadCount(node.path("download_count").asInt());

            Author author = new Author();
            JsonNode authorNode = node.path("authors").get(0);
            author.setFullName(authorNode.path("name").asText());
            author.setBirthYear(authorNode.path("birth_year").asInt());
            author.setDeathYear(authorNode.path("death_year").asInt());
            book.setAuthor(author);

            return book;
        }
        return null;
    }
}
