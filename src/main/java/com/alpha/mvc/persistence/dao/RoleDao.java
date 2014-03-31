package com.alpha.mvc.persistence.dao;

import com.alpha.mvc.persistence.domain.Role;

public interface RoleDao {
    public Role getRole(int id);
    public Role getRoleByName(String name);
}
