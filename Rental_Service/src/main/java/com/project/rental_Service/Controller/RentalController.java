package com.project.rental_Service.Controller;


import com.project.rental_Service.DTO.BorrowRequestDTO;
import com.project.rental_Service.Model.Rental;
import com.project.rental_Service.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/borrow")
    public String borrowBook(@RequestBody BorrowRequestDTO request) {
        return rentalService.borrowBook(request);
    }

    @GetMapping("/getrental/{id}")
    public Optional<Rental> getrentalbooksbyId(@PathVariable Long id) {
        return rentalService.getrentalbooksbyId(id);
    }

    @GetMapping("/status/{status}")
    public List<Rental> getActiveRentals(@PathVariable String status) {
        return rentalService.getActiveRentals(status);
    }

    @PutMapping("/return/{id}")
    public String returnBook(@PathVariable Long id) {
        return rentalService.returnBook(id);
    }

}
