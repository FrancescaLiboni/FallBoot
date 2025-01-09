package com.example.demo.ingredients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ingredients.model.IngredientsModel;
import com.example.demo.ingredients.repository.IngredientsRepository;

@Service

public class IngredientsService {
    
    @Autowired
    
    private IngredientsRepository ingredientsRepository;

    public List<IngredientsModel> getAllIngredients(){
        return ingredientsRepository.findAll();
    }
}
