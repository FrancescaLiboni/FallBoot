package com.example.fallboot.clothingItem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fallboot.clothingItem.model.ClothingItemModel;
import com.example.fallboot.clothingItem.model.ShopModel;
import com.example.fallboot.clothingItem.repository.ClothingItemRepository;
import com.example.fallboot.clothingItem.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;
    private ClothingItemRepository clothingItemRepository; // Per recuperare i vestiti di un negozio

    public ShopService(ShopRepository shopRepository, ClothingItemRepository clothingItemRepository) {
        this.shopRepository = shopRepository;
        this.clothingItemRepository = clothingItemRepository;
    }

    public List<ShopModel> getAllShops() {
        return shopRepository.findAll();
    }

    public ShopModel getShopById(String id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public ShopModel addShop(ShopModel shop) {
        return shopRepository.save(shop);
    }

    public ShopModel updateShop(String id, ShopModel updatedShop) {
        ShopModel existingShop = getShopById(id);
        existingShop.setName(updatedShop.getName());
        existingShop.setAddress(updatedShop.getAddress());
        existingShop.setCity(updatedShop.getCity());
        existingShop.setCountry(updatedShop.getCountry());
        return shopRepository.save(existingShop);
    }

    public void deleteShop(String id) {
        shopRepository.deleteById(id);
    }

    public Map<String, Object> getShopDetails(String id) {
        ShopModel shop = getShopById(id);
        List<ClothingItemModel> items = clothingItemRepository.findByShopId(id);
        Map<String, Object> details = new HashMap<>();
        details.put("shop", shop);
        details.put("clothingItems", items);
        return details;
    }

    public List<Map<String, Object>> searchClothingItems(String search) {
        List<ClothingItemModel> items = clothingItemRepository.findByNameContainingIgnoreCase(search);
        return items.stream().map(item -> {
            Map<String, Object> details = new HashMap<>();
            details.put("clothingItem", item);
            details.put("shop", shopRepository.findById(item.getId()).orElse(null));
            return details;
        }).collect(Collectors.toList());
    }
}
