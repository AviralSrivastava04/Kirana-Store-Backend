package com.example.kirana.store.dto.inputDto;

import com.example.kirana.store.enums.UserRole;
import lombok.Data;

@Data
public class UserInputDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String password;
    private UserRole role;
}
