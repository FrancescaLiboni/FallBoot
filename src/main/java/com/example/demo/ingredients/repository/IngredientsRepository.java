package com.example.demo.ingredients.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ingredients.model.IngredientsModel;

public interface IngredientsRepository extends JpaRepository<IngredientsModel, Integer>{

    
} 
    

