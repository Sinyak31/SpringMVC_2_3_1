package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);
    List<User> getUserList();
    void removeUser(long id);
    User getUserFindById(long id);
    void updateUser(User user);
}
