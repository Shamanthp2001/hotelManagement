package com.example.hotelManagement.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping
    public String createUser(@RequestBody Users users) {
//        Users users =modelMapper.map(userDto, Users.class);
        userService.createUser(users);
        return "User created";
    }
    @GetMapping
    public List<Users> getUser() {
        return userService.getAllUsers();
    }
    @DeleteMapping
    public String deleteUser(@RequestBody Long userId) {
        userService.deleteUser(userId);
        return "User deleted of id= "+ userId.toString();
    }
    @PutMapping
    public String updateUser(@RequestBody Users users) {
        userService.updateUser(users);
        return "User updated";
    }
}
