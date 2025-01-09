package com.example.fallboot.clothingItem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fallboot.clothingItem.model.ClothingItemsModel;
import com.example.fallboot.clothingItem.repository.ClothingItemsRepository;

@Service

public class ClothingItemsService {
    
    @Autowired
    
    private ClothingItemsRepository clothingItemsRepository;

    public List<ClothingItemsModel> getAllClothingItems(){
        return clothingItemsRepository.findAll();
    }
}
