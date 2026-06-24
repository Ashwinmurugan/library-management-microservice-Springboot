package com.project.rental_Service.Client;

import com.project.rental_Service.DTO.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;

@FeignClient(name = "book-service")
public interface BookClient {

    @GetMapping("/book/getbooks")
    List<BookDTO> getBooks();

    @GetMapping("/book/getbooks/{id}")
    BookDTO getBookById(@PathVariable("id") Long id);

    @PutMapping("/book/updatebook/{id}/borrow")
    String decreaseStock(@PathVariable("id") Long id);

    @PutMapping("/book/updatebook/{id}/return")
    String increaseStock(@PathVariable("id") Long id);
}
