package com.example.baithuchanhmodule3.service;

import com.example.baithuchanhmodule3.DAO.CategoryRepository;
import com.example.baithuchanhmodule3.model.Category;


import java.util.ArrayList;

public class CategoryService {
    CategoryRepository categoryRepository = new CategoryRepository();
    public ArrayList<Category> findAll() {
        return categoryRepository.findAll();
    }
    public Category findById(int id){
        return categoryRepository.findById(id);
    }
}
