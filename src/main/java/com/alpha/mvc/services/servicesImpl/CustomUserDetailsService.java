package com.alpha.mvc.services.servicesImpl;

import com.alpha.mvc.persistence.dao.UserDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.alpha.mvc.persistence.domain.User domainUser = userDao.getUserByLogin(login);
        return new User(
                domainUser.getLogin(),
                domainUser.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities(domainUser.getRole().getRole())
        );
    }

    public Collection<GrantedAuthority> getAuthorities(String role) {
        return getGrantedAuthorities(getRoles(role));
    }

    public List<String> getRoles(String role) {

        List<String> roles = new ArrayList<String>();

        if (role.equals("user")) {
            roles.add("ROLE_USER");
        } else if (role.equals("admin")) {
            roles.add("ROLE_ADMIN");
        } else if (role.equals("moderator")) {
            roles.add("ROLE_MODERATOR");
        }
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
