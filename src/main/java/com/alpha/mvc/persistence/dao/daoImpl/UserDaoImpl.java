package com.alpha.mvc.persistence.dao.daoImpl;

import com.alpha.mvc.persistence.dao.UserDao;
import com.alpha.mvc.persistence.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int id) {
        return (User) sessionFactory.getCurrentSession().load(User.class, id);
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void saveNewUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
    }

    @Override
    public List<User> getUsersList(int first, int maxResult) {
        return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setFirstResult(first).setMaxResults(maxResult).list();
    }

    @Override
    public void deleteUserByLogin(String login) {
        User user = (User)sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
        sessionFactory.getCurrentSession().delete(user);
    }
}
