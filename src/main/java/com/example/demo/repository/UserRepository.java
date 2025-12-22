@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        return service.register(u);
    }
}
