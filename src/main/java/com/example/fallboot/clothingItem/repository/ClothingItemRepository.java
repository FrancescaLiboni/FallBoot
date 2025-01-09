package com.example.fallboot.clothingItem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fallboot.clothingItem.model.ClothingItemModel;

public interface ClothingItemRepository extends JpaRepository<ClothingItemModel, String> {

    // Find clothing items by part of the name (like search query)
    List<ClothingItemModel> findByNameContainingIgnoreCase(String search);

    // Find clothing items by size
    List<ClothingItemModel> findBySize(String size);

    // Find clothing items that are in stock
    List<ClothingItemModel> findByInStockTrue();

    List<ClothingItemModel> findByShopId(String shopId);

}
