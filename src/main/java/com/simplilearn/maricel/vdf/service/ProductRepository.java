package com.simplilearn.maricel.vdf.service;

import com.simplilearn.maricel.vdf.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
