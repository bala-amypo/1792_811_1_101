@RestController
@RequestMapping("/api/sales")
public class SalesHistoryController {

    @Autowired
    SalesHistoryService service;

    @PostMapping
    public SalesHistory save(@RequestBody SalesHistory s) {
        return service.save(s);
    }

    @GetMapping
    public List<SalesHistory> getAll() {
        return service.getAll();
    }
}
