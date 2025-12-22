@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService service;

    @PostMapping
    public Inventory save(@RequestBody Inventory i) {
        return service.save(i);
    }

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAll();
    }
}
