package com.carton.example.repositary;

import com.carton.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepositary extends JpaRepository<Product, Integer> {



}