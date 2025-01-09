package com.example.fallboot.clothingItem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fallboot.clothingItem.model.ShopModel;
import com.example.fallboot.clothingItem.service.ShopService;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<ShopModel> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public ShopModel getShopById(@PathVariable String id) {
        return shopService.getShopById(id);
    }

    @PostMapping
    public ShopModel addShop(@RequestBody ShopModel shop) {
        return shopService.addShop(shop);
    }

    @PutMapping("/{id}")
    public ShopModel updateShop(@PathVariable String id, @RequestBody ShopModel updatedShop) {
        return shopService.updateShop(id, updatedShop);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable String id) {
        shopService.deleteShop(id);
    }

    @GetMapping("/{id}/details")
    public Map<String, Object> getShopDetails(@PathVariable String id) {
        return shopService.getShopDetails(id);
    }

    @GetMapping("/clothing-items/{search}/details")
    public List<Map<String, Object>> searchClothingItems(@PathVariable String search) {
        return shopService.searchClothingItems(search);
    }
}
