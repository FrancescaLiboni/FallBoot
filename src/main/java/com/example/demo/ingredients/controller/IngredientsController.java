package com.example.demo.ingredients.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ingredients.model.IngredientsModel;
import com.example.demo.ingredients.service.IngredientsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/ingredients")



public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;
    
    @GetMapping("/")
    public List<IngredientsModel> getAllIngredients() {
        return ingredientsService.getAllIngredients();
    }
    

}
