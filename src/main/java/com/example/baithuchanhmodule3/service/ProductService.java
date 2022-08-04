package com.example.baithuchanhmodule3.service;

import com.example.baithuchanhmodule3.DAO.ProductRepository;
import com.example.baithuchanhmodule3.model.Product;

import java.util.ArrayList;

public class ProductService {
    ProductRepository productRepository = new ProductRepository();


    public ArrayList<Product> findAll() {
        return productRepository.findAll();
    }

    public void create(Product product) {
        productRepository.create(product);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
    public ArrayList<Product> findBookByName(String name) {
        return productRepository.searchByLikeName(name);
    }



}
