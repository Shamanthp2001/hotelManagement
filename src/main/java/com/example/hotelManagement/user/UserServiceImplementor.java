package com.example.hotelManagement.user;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImplementor implements UserService{
    Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/mydatabase2","myuser","secret");

    @Autowired
    UserRepository userRepository;

    public UserServiceImplementor() throws SQLException {
    }

    @Override
    public void createUser(Users users) {
        userRepository.save(users);
        userRepository.flush();

    }


    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Users users) {
        Users users1= userRepository.getReferenceById(users.getId());
        users1.setFirstName(users.getFirstName());
        users1.setLastName(users.getLastName());
        users1.setEmail(users.getEmail());
        userRepository.save(users1);
    }
}
