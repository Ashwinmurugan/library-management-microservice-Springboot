package com.project.Book_Service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("book_title")
    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "author")
    private String author;

    @JsonProperty("totalCopies")
    @Column(name = "total_copies")
    private Integer totalCopies;

    @JsonProperty("availableCopies")
    @Column(name = "available_copies")
    private Integer availableCopies;

    public void updateDetails(Book incomingBook) {
        if (incomingBook.getBookTitle() != null) {
            this.bookTitle = incomingBook.getBookTitle();
        }
        if (incomingBook.getAuthor() != null) {
            this.author = incomingBook.getAuthor();
        }
        if (incomingBook.getTotalCopies() != null && incomingBook.getTotalCopies() > 0) {
            this.totalCopies = incomingBook.getTotalCopies();
        }
        if (incomingBook.getAvailableCopies() != null) {
            this.availableCopies = incomingBook.getAvailableCopies();
        }
    }
}