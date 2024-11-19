package com.obaid.RestAPI.Service;

import com.obaid.RestAPI.Entity.User;
import com.obaid.RestAPI.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }


    public User addUser(User user) { return userRepository.save(user); }

    public String deleteUserById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Delete success";
        } else {
            return "User with ID " + id + " does not exist";
        }
    }

    public List<User> addUsers(List<User> users) { return userRepository.saveAll(users); }
}
