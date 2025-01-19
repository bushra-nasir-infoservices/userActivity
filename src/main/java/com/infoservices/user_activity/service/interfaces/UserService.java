package com.infoservices.user_activity.service.interfaces;

import com.infoservices.user_activity.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();
    public User getUserById(int userId);
    public User createUser(User user);
    public User updateUser(int userId,User user);
    public void deleteUser(int userId);
}
