package com.alpha.mvc.services.servicesImpl;

import com.alpha.mvc.persistence.dao.RoleDao;
import com.alpha.mvc.persistence.domain.Role;
import com.alpha.mvc.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }
}
