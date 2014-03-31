package com.alpha.mvc.persistence.dao;

import com.alpha.mvc.persistence.domain.Expertise;
import com.alpha.mvc.persistence.domain.User;

import java.util.List;

public interface UserDao {
    public User getUser(int id);
    public void saveNewUser(User user);
    public User getUserByLogin(String login);
    public List<User> getUsersList(int first, int maxResult);
    public void deleteUserByLogin(String login);
    public void save(User user);
}
