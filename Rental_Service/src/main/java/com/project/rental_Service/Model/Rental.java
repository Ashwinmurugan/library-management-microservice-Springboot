package com.project.rental_Service.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "rental")
@NoArgsConstructor
public class Rental {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonProperty("book_id")
    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @JsonProperty("user_id")
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @JsonProperty("borrow_data")
    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;

    @JsonProperty("return_date")
    @Column(name = "return_date",nullable = true)
    private LocalDate returnDate;

    @JsonProperty("status")
    @Column(name = "status", nullable = false)
    private String status;
}
