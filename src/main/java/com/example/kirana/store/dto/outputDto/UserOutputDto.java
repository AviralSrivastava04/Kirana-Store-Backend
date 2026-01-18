package com.example.kirana.store.dto.outputDto;

import com.example.kirana.store.enums.UserRole;
import lombok.Data;

@Data
public class UserOutputDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private UserRole role;
}
