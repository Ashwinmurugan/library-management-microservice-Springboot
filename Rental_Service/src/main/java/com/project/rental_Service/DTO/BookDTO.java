package com.project.rental_Service.DTO;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String bookTitle;
    private int availableCopies;
}