package com.example.demo.service;




@Service
public class UserService {

    @Autowired
    private UserRepository
    userRepository;

    public User findByUsername(String username ) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return useRepository.save
    }
}