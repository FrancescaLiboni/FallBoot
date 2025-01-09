package com.example.fallboot.clothingItem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fallboot.clothingItem.model.ClothingItemModel;
import com.example.fallboot.clothingItem.repository.ClothingItemRepository;

@Service
public class ClothingItemService {

    @Autowired
    private ClothingItemRepository clothingItemRepository;

    // Retrieve all clothing items
    public List<ClothingItemModel> getAllClothingItems() {
        return clothingItemRepository.findAll();
    }

    // Retrieve a specific clothing item by ID
    public Optional<ClothingItemModel> getClothingItemById(String id) {
        return clothingItemRepository.findById(id);
    }

    // Search for clothing items by name
    public List<ClothingItemModel> searchClothingItemsByName(String search) {
        return clothingItemRepository.findByNameContainingIgnoreCase(search);
    }

    // Retrieve clothing items by size
    public List<ClothingItemModel> getClothingItemsBySize(String size) {
        return clothingItemRepository.findBySize(size);
    }

    // Retrieve clothing items that are in stock
    public List<ClothingItemModel> getClothingItemsInStock() {
        return clothingItemRepository.findByInStockTrue();
    }

    // Add a new clothing item
    public ClothingItemModel addClothingItem(ClothingItemModel clothingItem) {
        return clothingItemRepository.save(clothingItem);
    }

    // Update an existing clothing item
    public ClothingItemModel updateClothingItem(String id, ClothingItemModel clothingItem) {
        clothingItem.setId(id); // Ensure the item is updated by the correct ID
        return clothingItemRepository.save(clothingItem);
    }

    // Delete a clothing item by ID
    public void deleteClothingItem(String id) {
        clothingItemRepository.deleteById(id);
    }
}