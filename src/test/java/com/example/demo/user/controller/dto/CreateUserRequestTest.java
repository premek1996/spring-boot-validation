package com.example.demo.user.controller.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;

class CreateUserRequestTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    @DisplayName("it should not fail when dto is correct")
    void test1() {
        var createUserRequest = CreateUserRequest
                .builder()
                .name("name")
                .email("email@interia.pl")
                .password("12345678")
                .build();

        var violations = validator.validate(createUserRequest);
        assertThat(violations).isEmpty();
    }

    @Test
    @DisplayName("it should fail when name is missing")
    void test2() {
        var createUserRequest = CreateUserRequest
                .builder()
                .email("email@interia.pl")
                .password("12345678")
                .build();

        var violations = validator.validate(createUserRequest);
        assertThat(violations).isNotEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "      ", "a"})
    @DisplayName("it should fail when name is not correct")
    void test3(String name) {
        var createUserRequest = CreateUserRequest
                .builder()
                .name(name)
                .email("email@interia.pl")
                .password("12345678")
                .build();

        var violations = validator.validate(createUserRequest);
        assertThat(violations).isNotEmpty();
    }

    @Test
    @DisplayName("it should fail when email is missing")
    void test4() {
        var createUserRequest = CreateUserRequest
                .builder()
                .name("name")
                .password("12345678")
                .build();

        var violations = validator.validate(createUserRequest);
        assertThat(violations).isNotEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "      ", "a", "email.pl"})
    @DisplayName("it should fail when email is not correct")
    void test5(String email) {
        CreateUserRequest createUserRequest = CreateUserRequest
                .builder()
                .name("name")
                .email(email)
                .password("12345678")
                .build();

        var violations = validator.validate(createUserRequest);
        assertThat(violations).isNotEmpty();
    }

    @Test
    @DisplayName("it should fail when password is missing")
    void test6() {
        CreateUserRequest createUserRequest = CreateUserRequest
                .builder()
                .name("name")
                .email("email@interia.pl")
                .build();

        var violations = validator.validate(createUserRequest);
        assertThat(violations).isNotEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "                    ", "a", "1234567"})
    @DisplayName("it should fail when email is not correct")
    void test7(String password) {
        var createUserRequest = CreateUserRequest
                .builder()
                .name("name")
                .email("email@interia.pl")
                .password(password)
                .build();

        var violations = validator.validate(createUserRequest);
        assertThat(violations).isNotEmpty();
    }

}