package com.example.demo.ingredients.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="ingredients")

public class IngredientsModel {

    @Id

    @Column(name ="ingredient_id")
    private Integer ingredient_id;

    @Column(name ="aliased_name")
    private String ingredient_name;

    @Column(name ="ingredient_synonyms")
    private String ingredien_synonyms;

    @Column(name ="category_id")
    private Integer category_id;

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
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
    public IngredientsModel(Integer ingredient_id, String ingredient_name, String ingredien_synonyms,
            Integer category_id) {
        this.ingredient_id = ingredient_id;
        this.ingredient_name = ingredient_name;
        this.ingredien_synonyms = ingredien_synonyms;
        this.category_id = category_id;
    }

    public IngredientsModel() {
    }
    

   
    
    
    
    
}
