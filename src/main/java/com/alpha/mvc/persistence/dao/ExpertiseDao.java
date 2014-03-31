package com.alpha.mvc.persistence.dao;

import com.alpha.mvc.persistence.domain.Expertise;

import java.util.Date;
import java.util.List;

public interface ExpertiseDao {
    public List<Expertise> getAllExpertise();
    public void update(Expertise expertise);
    public Integer save(Expertise expertise);
    public Integer getLastExpertiseNumber(Date date);
    public void deleteByNumberAndStartDate(int number, Date startDate);
    public Expertise loadByNumberAndStartDate(int number, Date startDate);
    public List<Expertise> getExpertiseByLikeParametr(String searchString);
}
