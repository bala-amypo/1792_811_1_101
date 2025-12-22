package com.example.demo.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.User;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class DataUtil {

    @Bean
    CommandLineRunner loadData(
            UserRepository userRepository,
            InventoryRepository inventoryRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(
                        passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");

                userRepository.save(admin);
            }

            
            if (inventoryRepository.count() == 0) {

                Inventory item1 = new Inventory();
                item1.setProductName("Laptop");
                item1.setQuantity(10);

                Inventory item2 = new Inventory();
                item2.setProductName("Mouse");
                item2.setQuantity(50);

                inventoryRepository.save(item1);
                inventoryRepository.save(item2);
            }
        };
    }
}
