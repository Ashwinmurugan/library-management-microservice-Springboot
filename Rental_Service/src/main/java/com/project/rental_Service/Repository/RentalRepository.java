package com.project.rental_Service.Repository;

import com.project.rental_Service.Model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Long> {
    List<Rental> findByStatus(String status);
}
