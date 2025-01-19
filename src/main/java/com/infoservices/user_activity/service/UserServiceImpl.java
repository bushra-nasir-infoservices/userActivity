package com.infoservices.user_activity.service;

import com.infoservices.user_activity.entity.User;
import com.infoservices.user_activity.repository.UserRepository;
import com.infoservices.user_activity.service.interfaces.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Error finding article!"));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int userId, User user) {
        User existingUser = getUserById(userId);
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setGender(user.getGender());
        existingUser.setAge(user.getAge());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(int userId) {
        User userToDelete = getUserById(userId);
        userRepository.delete(userToDelete);
    }
}
