package com.example.camelAPI.repo;


import com.example.camelAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
