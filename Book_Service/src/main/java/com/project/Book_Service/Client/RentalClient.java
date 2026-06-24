package com.project.Book_Service.Client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "rental-service")
public interface RentalClient {
}
