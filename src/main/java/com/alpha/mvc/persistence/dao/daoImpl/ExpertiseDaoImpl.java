package com.alpha.mvc.persistence.dao.daoImpl;

import com.alpha.mvc.persistence.dao.ExpertiseDao;
import com.alpha.mvc.persistence.domain.Expertise;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ExpertiseDaoImpl implements ExpertiseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Expertise> getAllExpertise() {
        return (List<Expertise>) sessionFactory.getCurrentSession().createCriteria(Expertise.class).list();
    }

    @Override
    public void update(Expertise expertise) {
        sessionFactory.getCurrentSession().update(expertise);
    }

    @Override
    public Integer save(Expertise expertise) {
        return (Integer)sessionFactory.getCurrentSession().save(expertise);
    }

    @Override
    public Integer getLastExpertiseNumber(Date date) {
        return (Integer)sessionFactory.getCurrentSession().createCriteria(Expertise.class)
                .setProjection(Projections.max("number"))
                .add(Restrictions.sqlRestriction("YEAR(start_date) = YEAR(?)", date, StandardBasicTypes.DATE))
                .uniqueResult();
    }

    @Override
    public void deleteByNumberAndStartDate(int number, Date startDate) {
        Expertise expertise = (Expertise)sessionFactory.getCurrentSession()
                .createCriteria(Expertise.class)
                .add(Restrictions.eq("number", number))
                .add(Restrictions.sqlRestriction("start_date = ?", startDate, StandardBasicTypes.DATE))
                .uniqueResult();
        sessionFactory.getCurrentSession().delete(expertise);
    }

    @Override
    public Expertise loadByNumberAndStartDate(int number, Date startDate) {
        return (Expertise)sessionFactory.getCurrentSession().createCriteria(Expertise.class)
                .add(Restrictions.eq("number", number))
                .add(Restrictions.sqlRestriction("start_date = ?", startDate, StandardBasicTypes.DATE))
                .uniqueResult();
    }

    @Override
    public List<Expertise> getExpertiseByLikeParametr(String searchString) {
        Criterion searchCriterion = null;
        if(searchString.matches("\\d+")){
            searchCriterion = Restrictions.eq("number", Integer.parseInt(searchString));
        } else {
            searchCriterion = Restrictions.like("organization", searchString, MatchMode.ANYWHERE);
        }

        return (List<Expertise>)sessionFactory.getCurrentSession().createCriteria(Expertise.class)
                .add(searchCriterion)
                .list();
    }

}
