package com.alpha.mvc.services;

import com.alpha.mvc.persistence.domain.Profile;
import com.alpha.mvc.persistence.domain.Role;
import com.alpha.mvc.persistence.domain.User;
import com.alpha.mvc.persistence.dto.NewUserDto;
import com.alpha.mvc.persistence.dto.UserDto;

import java.util.List;

public interface UserService {
    public User getUser(String login);
    public String encodePassword(String password);
    public void saveNewUser(NewUserDto newUserDto);
    public List<User> getUsersList(int first, int maxResult);
    public void deleteUserByLogin(String login);
    public void updateUser(User user);
    public Role getRoleByName(String role);
    public Profile getProfile(int id);
    public void updateProfile(Profile profile);
}
