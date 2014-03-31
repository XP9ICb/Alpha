package com.alpha.mvc.services.servicesImpl;

import com.alpha.mvc.persistence.dao.ProfileDao;
import com.alpha.mvc.persistence.dao.RoleDao;
import com.alpha.mvc.persistence.dao.UserDao;
import com.alpha.mvc.persistence.domain.Profile;
import com.alpha.mvc.persistence.domain.Role;
import com.alpha.mvc.persistence.domain.User;
import com.alpha.mvc.persistence.dto.NewUserDto;
import com.alpha.mvc.persistence.dto.UserDto;
import com.alpha.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private Md5PasswordEncoder md5PasswordEncoder;

    @Override
    @Transactional
    public User getUser(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public String encodePassword(String password) {
        return md5PasswordEncoder.encodePassword(password, null);
    }

    @Override
    @Transactional
    public void saveNewUser(NewUserDto newUserDto) {
        User user = new User();
        Profile profile = new Profile();
        user.setLogin(newUserDto.getLogin());
        user.setPassword(encodePassword(newUserDto.getPassword()));
        user.setRole(roleDao.getRoleByName(newUserDto.getRole()));
        profile.setName(newUserDto.getName());
        profile.setSecondName(newUserDto.getSecondName());
        profile.setMidleName(newUserDto.getMidleName());
        profile.setCertificateNumber(newUserDto.getCertificateNumber());
        user.setProfile(profile);
        userDao.saveNewUser(user);
    }

    @Override
    @Transactional
    public List<User> getUsersList(int first, int maxResult) {
        return userDao.getUsersList(first, maxResult);
    }

    @Override
    @Transactional
    public void deleteUserByLogin(String login) {
        userDao.deleteUserByLogin(login);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public Role getRoleByName(String role) {
        return roleDao.getRoleByName(role);
    }

    @Override
    @Transactional
    public Profile getProfile(int id) {
        return profileDao.getProfile(id);
    }

    @Override
    @Transactional
    public void updateProfile(Profile profile) {
        profileDao.update(profile);
    }

}
