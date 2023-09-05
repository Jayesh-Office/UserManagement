package com.example.userdetailstest.controller;

import com.example.userdetailstest.entity.User;
import com.example.userdetailstest.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // Set up your UserController to use the mocked UserService
        // Example: UserController userController = new UserController(userService);
        UserController userController = new UserController();
    }

    @Test
    public void testLoginUser() throws Exception {
        // Mock a POST request to create a user
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"username\": \"JB2122\", \"password\": \"adasdsa\"}"))
                .andExpect(status().isOk());
    }
    @Test
    public void testCreateUser() throws Exception {
        // Mock a POST request to create a user
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"username\": \"JB\", \"last_name\": \"B\", \"email\": \"JB@gmail1.com\", , \"mobile_number\": \"9878578752\", , \"status\": \"true\", , \"password\": \"adasdsa\"}"))
                .andExpect(status().isOk());
    }
    @Test
    public void testGetAllUsers() throws Exception {
        // Mock a list of users that you expect to be returned by the service
        List<User> mockUsers = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setLast_name("Doe");
        mockUsers.add(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setLast_name("Smith");
        mockUsers.add(user2);

        // Configure the UserService mock to return the mockUsers when getAllUsers is called
        when(userService.getAllUsers()).thenReturn(mockUsers);

        // Perform a GET request to retrieve all users
        ResultActions result = mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        result.andExpect(status().isOk());

        // Verify that the JSON response is an array and contains the expected user properties
        result.andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].username").value("user1"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].username").value("user2"))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].lastName").value("Smith"));
    }
    @Test
    public void testGetUserById() throws Exception {
        // Mock a user that you expect to be returned by the service
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setUsername("user1");
        mockUser.setLast_name("Doe");

        // Configure the UserService mock to return the mockUser when getUserById is called
        when(userService.getUserById(1L)).thenReturn(mockUser);

        // Perform a GET request to retrieve the user by ID
        ResultActions result = mockMvc.perform(get("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        result.andExpect(status().isOk());

        // Verify that the JSON response contains the expected user properties
        result.andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("user1"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }
    @Test
    public void testDeleteUserById() throws Exception {
        // Configure the UserService mock to return true when deleteUserById is called
        when(userService.deleteUser(1L)).thenReturn(true);

        // Perform a DELETE request to delete the user by ID
        ResultActions result = mockMvc.perform(delete("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is NO_CONTENT (204) indicating a successful deletion
        result.andExpect(status().isNoContent());
    }
    @Test
    public void testUpdateUserById() throws Exception {
        // Create a mock user with updated data
        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setUsername("updatedUser");
        updatedUser.setLast_name("User");

        // Serialize the updatedUser object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String updatedUserJson = objectMapper.writeValueAsString(updatedUser);

        // Configure the UserService mock to return the updated user when updateUserById is called
        when(userService.updateUser(1L, updatedUser)).thenReturn(updatedUser);

        // Perform a PUT request to update the user by ID
        ResultActions result = mockMvc.perform(put("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedUserJson));

        // Verify that the response status is OK (200)
        result.andExpect(status().isOk());
    }
}
