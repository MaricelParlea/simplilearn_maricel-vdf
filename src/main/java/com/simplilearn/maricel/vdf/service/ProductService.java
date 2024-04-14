package com.simplilearn.maricel.vdf.service;

import com.simplilearn.maricel.vdf.exceptions.ProductNotFoundException;
import com.simplilearn.maricel.vdf.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id) throws ProductNotFoundException;
    List<Product> getProductsByCategory(String category);
    List<Product> addProduct(Product product) throws ProductNotFoundException;
    Product updateProduct(int id, Product product) throws ProductNotFoundException;
    List<Product> deleteProduct(int id) throws ProductNotFoundException;
}
