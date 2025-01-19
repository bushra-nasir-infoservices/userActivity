package com.infoservices.user_activity.controller;

import com.infoservices.user_activity.dto.UserDTO;
import com.infoservices.user_activity.entity.User;
import com.infoservices.user_activity.service.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private UserService userService;

    private final ModelMapper modelMapper;

    public UserController(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers.stream().map(user -> modelMapper.map(user,UserDTO.class)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(modelMapper.map(user,UserDTO.class));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> addUser(UserDTO userDTO) {
        User userRequest = modelMapper.map(userDTO, User.class);
        return ResponseEntity.ok(modelMapper.map(userService.createUser(userRequest),UserDTO.class));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") int userId, UserDTO userDTO) {
        User userRequest = modelMapper.map(userDTO,User.class);
        return ResponseEntity.ok(modelMapper.map(userService.updateUser(userId,userRequest),UserDTO.class));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully!");
    }

}
