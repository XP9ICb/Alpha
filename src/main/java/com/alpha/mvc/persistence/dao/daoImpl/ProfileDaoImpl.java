package com.alpha.mvc.persistence.dao.daoImpl;

import com.alpha.mvc.persistence.dao.ProfileDao;
import com.alpha.mvc.persistence.domain.Profile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDaoImpl implements ProfileDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Profile getProfile(int id) {
        return (Profile)sessionFactory.getCurrentSession().load(Profile.class, id);
    }

    @Override
    public void update(Profile profile) {
        sessionFactory.getCurrentSession().update(profile);
    }
}
