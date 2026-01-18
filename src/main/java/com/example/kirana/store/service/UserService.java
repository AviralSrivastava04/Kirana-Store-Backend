package com.example.kirana.store.service;

import com.example.kirana.store.dto.inputDto.UserInputDto;
import com.example.kirana.store.dto.outputDto.UserOutputDto;
import com.example.kirana.store.entity.User;
import com.example.kirana.store.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String register(UserInputDto userInputDto ) {

        if (userRepo.existsByEmail(userInputDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setFirstName(userInputDto.getFirstName());
        user.setLastName(userInputDto.getLastName());
        user.setEmail(userInputDto.getEmail());
        user.setAddress(userInputDto.getAddress());
        user.setPhone(userInputDto.getPhone());
        user.setPassword(userInputDto.getPassword());
        user.setRole(userInputDto.getRole());
        userRepo.save(user);

        return "User Created!!!";
    }
}
