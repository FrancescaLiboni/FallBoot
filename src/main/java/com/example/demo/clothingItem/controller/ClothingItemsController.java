package com.example.fallboot.clothingItem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fallboot.clothingItem.model.ClothingItemsModel;
import com.example.fallboot.clothingItem.service.ClothingItemsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/clothingItems")



public class ClothingItemsController {

    @Autowired
    private ClothingItemsService clothingItemsService;
    
    @GetMapping("/")
    public List<ClothingItemsModel> getAllClothingItems() {
        return clothingItemsService.getAllClothingItems();
    }
    

}
