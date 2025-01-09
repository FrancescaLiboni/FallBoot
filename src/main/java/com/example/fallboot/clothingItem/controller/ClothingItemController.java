package com.example.fallboot.clothingItem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fallboot.clothingItem.model.ClothingItemModel;
import com.example.fallboot.clothingItem.service.ClothingItemService;


@RestController
@RequestMapping("/clothing-items")
public class ClothingItemController {

    @Autowired
    private ClothingItemService clothingItemService;

    // 1. GET /clothing-items: Recupera l'elenco di tutti gli articoli di abbigliamento
    @GetMapping
    public List<ClothingItemModel> getAllClothingItems() {
        return clothingItemService.getAllClothingItems();
    }

    // 2. GET /clothing-items/{id}: Recupera i dettagli di un articolo specifico
    @GetMapping("/{id}")
    public ResponseEntity<ClothingItemModel> getClothingItemById(@PathVariable String id) {
        Optional<ClothingItemModel> item = clothingItemService.getClothingItemById(id);
        return item.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 3. GET /clothing-items/{search}: Recupera gli articoli che contengono una stringa specifica nel nome
    @GetMapping("/search/{search}")
    public List<ClothingItemModel> searchClothingItems(@PathVariable String search) {
        return clothingItemService.searchClothingItemsByName(search);
    }

    // 4. GET /clothing-items/{size}: Recupera gli articoli di una specifica taglia
    @GetMapping("/size/{size}")
    public List<ClothingItemModel> getClothingItemsBySize(@PathVariable String size) {
        return clothingItemService.getClothingItemsBySize(size);
    }

    // 5. GET /clothing-items/in-stock: Recupera gli articoli disponibili (in stock)
    @GetMapping("/in-stock")
    public List<ClothingItemModel> getClothingItemsInStock() {
        return clothingItemService.getClothingItemsInStock();
    }

    // 6. POST /clothing-items: Aggiunge un nuovo articolo
    @PostMapping
    public ResponseEntity<ClothingItemModel> addClothingItem(@RequestBody ClothingItemModel clothingItem) {
        ClothingItemModel newItem = clothingItemService.addClothingItem(clothingItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    // 7. PUT /clothing-items/{id}: Modifica i dettagli di un articolo esistente
    @PutMapping("/{id}")
    public ResponseEntity<ClothingItemModel> updateClothingItem(@PathVariable String id, @RequestBody ClothingItemModel clothingItem) {
        if (clothingItemService.getClothingItemById(id).isPresent()) {
            ClothingItemModel updatedItem = clothingItemService.updateClothingItem(id, clothingItem);
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 8. DELETE /clothing-items/{id}: Elimina un articolo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothingItem(@PathVariable String id) {
        if (clothingItemService.getClothingItemById(id).isPresent()) {
            clothingItemService.deleteClothingItem(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
