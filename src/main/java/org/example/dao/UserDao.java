package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public interface UserDao {

    void svaUser(User user);
}
