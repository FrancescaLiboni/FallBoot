@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public Shop getShopById(@PathVariable UUID id) {
        return shopService.getShopById(id);
    }

    @PostMapping
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    @PutMapping("/{id}")
    public Shop updateShop(@PathVariable UUID id, @RequestBody Shop updatedShop) {
        return shopService.updateShop(id, updatedShop);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable UUID id) {
        shopService.deleteShop(id);
    }

    @GetMapping("/{id}/details")
    public Map<String, Object> getShopDetails(@PathVariable UUID id) {
        return shopService.getShopDetails(id);
    }

    @GetMapping("/clothing-items/{search}/details")
    public List<Map<String, Object>> searchClothingItems(@PathVariable String search) {
        return shopService.searchClothingItems(search);
    }
}
