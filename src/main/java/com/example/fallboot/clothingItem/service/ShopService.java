@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ClothingItemRepository clothingItemRepository; // Per recuperare i vestiti di un negozio

    public ShopService(ShopRepository shopRepository, ClothingItemRepository clothingItemRepository) {
        this.shopRepository = shopRepository;
        this.clothingItemRepository = clothingItemRepository;
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Shop getShopById(UUID id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public Shop updateShop(UUID id, Shop updatedShop) {
        Shop existingShop = getShopById(id);
        existingShop.setName(updatedShop.getName());
        existingShop.setAddress(updatedShop.getAddress());
        existingShop.setCity(updatedShop.getCity());
        existingShop.setCountry(updatedShop.getCountry());
        return shopRepository.save(existingShop);
    }

    public void deleteShop(UUID id) {
        shopRepository.deleteById(id);
    }

    public Map<String, Object> getShopDetails(UUID id) {
        Shop shop = getShopById(id);
        List<ClothingItem> items = clothingItemRepository.findByShopId(id);
        Map<String, Object> details = new HashMap<>();
        details.put("shop", shop);
        details.put("clothingItems", items);
        return details;
    }

    public List<Map<String, Object>> searchClothingItems(String search) {
        List<ClothingItem> items = clothingItemRepository.findByNameContainingIgnoreCase(search);
        return items.stream().map(item -> {
            Map<String, Object> details = new HashMap<>();
            details.put("clothingItem", item);
            details.put("shop", shopRepository.findById(item.getShopId()).orElse(null));
            return details;
        }).collect(Collectors.toList());
    }
}
