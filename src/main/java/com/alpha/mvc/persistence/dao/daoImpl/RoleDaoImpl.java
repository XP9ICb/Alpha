package com.alpha.mvc.persistence.dao.daoImpl;

import com.alpha.mvc.persistence.dao.RoleDao;
import com.alpha.mvc.persistence.domain.Role;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRole(int id) {
        return (Role) sessionFactory.getCurrentSession().load(Role.class, id);
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) sessionFactory.getCurrentSession().createCriteria(Role.class).add(Restrictions.eq("role", name)).uniqueResult();
    }
}
