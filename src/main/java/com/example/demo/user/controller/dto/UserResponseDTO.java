package com.example.demo.user.controller.dto;

import com.example.demo.user.model.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDTO {

    private final Long id;
    private final String name;
    private final String email;
    private final String password;

    public static UserResponseDTO of(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
