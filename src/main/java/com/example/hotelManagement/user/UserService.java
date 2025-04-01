package com.example.hotelManagement.user;

import java.util.List;

public interface UserService {
    void createUser(Users users);
    List<Users> getAllUsers();
    void deleteUser(Long id);

    void updateUser(Users users);
}
