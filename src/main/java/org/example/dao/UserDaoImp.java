package org.example.dao;

import org.example.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository

public class UserDaoImp implements UserDao{
  @Autowired
    private EntityManager entityManager;
    @Override
    public void svaUser(User user) {
entityManager.persist(user);
    }
}
