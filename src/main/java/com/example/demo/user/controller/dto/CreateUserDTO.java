package com.example.demo.user.controller.dto;

import com.example.demo.user.model.User;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@EqualsAndHashCode
public class CreateUserDTO {

    // username should not be null or blank
    // username should have at least 2 characters
    @NotBlank
    @Size(min = 2, message = "name should have at least 2 characters")
    private String name;

    // email should not be null or blank
    // email should have a valid format
    @NotBlank
    @Email
    private String email;

    // password should not be null or blank
    // password should have at least 8 characters
    @NotBlank
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
