package com.example.demo.user.controller.dto;

import com.example.demo.user.model.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final String password;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
