package com.example.fallboot.clothingItem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fallboot.clothingItem.model.ShopModel;

@Repository
public interface ShopRepository extends JpaRepository<ShopModel, String> {
}
