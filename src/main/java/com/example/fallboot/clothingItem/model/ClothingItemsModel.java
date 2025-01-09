package com.example.fallboot.clothingItem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="clothingItems")

public class ClothingItemsModel {

    @Id

    @Column(name ="clothingItem_id")
    private Integer clothingItem_id;

    @Column(name ="aliased_name")
    private String clothingItem_name;

    @Column(name ="clothingItem_synonyms")
    private String ingredien_synonyms;

    @Column(name ="category_id")
    private Integer category_id;

    public Integer getClothingItem_id() {
        return clothingItem_id;
    }

    public void setClothingItem_id(Integer clothingItem_id) {
        this.clothingItem_id = clothingItem_id;
    }

    public String getClothingItem_name() {
        return clothingItem_name;
    }

    public void setClothingItem_name(String clothingItem_name) {
        this.clothingItem_name = clothingItem_name;
    }

    public String getIngredien_synonyms() {
        return ingredien_synonyms;
    }

    public void setIngredien_synonyms(String ingredien_synonyms) {
        this.ingredien_synonyms = ingredien_synonyms;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }


    //constructor
    public ClothingItemsModel(Integer clothingItem_id, String clothingItem_name, String ingredien_synonyms,
            Integer category_id) {
        this.clothingItem_id = clothingItem_id;
        this.clothingItem_name = clothingItem_name;
        this.ingredien_synonyms = ingredien_synonyms;
        this.category_id = category_id;
    }

    public ClothingItemsModel() {
    }
    

   
    
    
    
    
}
