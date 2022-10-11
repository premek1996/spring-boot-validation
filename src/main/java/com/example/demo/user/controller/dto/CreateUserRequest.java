package com.example.demo.user.controller.dto;

import com.example.demo.user.model.User;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
public class CreateUserRequest {

    // username should not be null or empty
    // username should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "name should have at least 2 characters")
    private String name;

    // email should not be null or empty
    // email should have a valid format
    @NotEmpty
    @Email
    private String email;

    // password should not be null or empty
    // password should have at least 8 characters
    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;

    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

}
