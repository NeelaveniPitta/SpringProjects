package com.ashi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
