package com.example.demo.user.controller;

import com.example.demo.user.controller.dto.CreateUserDTO;
import com.example.demo.user.controller.dto.UserResponseDTO;
import com.example.demo.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("it should add new user")
    @SneakyThrows
    void test1() {

        var createUserDTO = CreateUserDTO
                .builder()
                .name("name")
                .email("email@interia.pl")
                .password("12345678")
                .build();

        var userResponseDTO = UserResponseDTO
                .builder()
                .id(1L)
                .name("name")
                .email("email@interia.pl")
                .password("12345678")
                .build();

        when(userService.createUser(createUserDTO))
                .thenReturn(userResponseDTO);

        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUserDTO))
                ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.email").value("email@interia.pl"))
                .andExpect(jsonPath("$.password").value("12345678"));
    }

    @Test
    @DisplayName("it should fail when dto with new user is missing")
    @SneakyThrows
    void test2() {
        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        ).andExpect(status().isBadRequest());
    }

}