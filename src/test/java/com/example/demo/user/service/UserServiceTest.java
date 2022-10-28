package com.example.demo.user.service;

import com.example.demo.user.controller.dto.CreateUserDTO;
import com.example.demo.user.controller.dto.UserResponseDTO;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("it should add new user")
    void test1() {
        var createUserDTO = CreateUserDTO
                .builder()
                .name("name")
                .email("email@interia.pl")
                .password("12345678")
                .build();

        var user = User
                .builder()
                .id(1L)
                .name("name")
                .email("email@interia.pl")
                .password("12345678")
                .build();

        when(userRepository.save(createUserDTO.toUser()))
                .thenReturn(user);

        assertThat(userService.createUser(createUserDTO))
                .usingRecursiveComparison()
                .isEqualTo(UserResponseDTO.of(user));
    }

}