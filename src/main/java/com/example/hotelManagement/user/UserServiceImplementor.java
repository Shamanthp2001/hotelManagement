package com.example.hotelManagement.user;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImplementor implements UserService{
    Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/mydatabase2","myuser","secret");

    @Autowired
    UserRepository userRepository;

    public UserServiceImplementor() throws SQLException {
    }

    @Override
    @Transactional
    public void createUser(Users users) {
        try {
            userRepository.save(users);
            userRepository.flush();
        }
       catch (OptimisticLockingFailureException e){
           Logger.getLogger("Concurrency conflict: --OptimisticLockingFailureException-- "+e.getMessage());
           throw new OptimisticLockingFailureException("OptimisticLockingFailureException concurrency conflict: --OptimisticLockingFailureException-- "+e.getMessage());
       }


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
