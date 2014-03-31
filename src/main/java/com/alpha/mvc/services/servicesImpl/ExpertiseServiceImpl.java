package com.alpha.mvc.services.servicesImpl;

import com.alpha.mvc.persistence.dao.ExpertiseDao;
import com.alpha.mvc.persistence.dao.UserDao;
import com.alpha.mvc.persistence.domain.Expertise;
import com.alpha.mvc.persistence.domain.User;
import com.alpha.mvc.persistence.dto.ChangeExpertDto;
import com.alpha.mvc.persistence.dto.FinishExpertiseDto;
import com.alpha.mvc.persistence.dto.NewExpertiseDto;
import com.alpha.mvc.services.ExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ExpertiseServiceImpl implements ExpertiseService {

    @Autowired
    private ExpertiseDao expertiseDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<Expertise> getAllExpertises() {
        return expertiseDao.getAllExpertise();
    }

    @Override
    @Transactional
    public void update(Expertise expertise) {
        expertiseDao.update(expertise);
    }

    @Override
    @Transactional
    public Integer save(NewExpertiseDto newExpertiseDto) {
        Expertise expertise = new Expertise();
        expertise.setStartDate(newExpertiseDto.getStartdate());
        expertise.setOrganization(newExpertiseDto.getOrganization());
        expertise.setCrimeNumber(newExpertiseDto.getCrimenumber());
        Integer currentNumber = expertiseDao.getLastExpertiseNumber(newExpertiseDto.getStartdate());
        if (currentNumber != null) {
            currentNumber += 1;
        } else {
            currentNumber = 1;
        }
        expertise.setNumber(currentNumber);
        expertiseDao.save(expertise);
        return currentNumber;
    }

    @Override
    @Transactional
    public void deleteByNumberAndStartDate(int number, Date startDate) {
        expertiseDao.deleteByNumberAndStartDate(number, startDate);
    }

    @Override
    @Transactional
    public void changeExpert(ChangeExpertDto changeExpertDto) {
        Expertise expertise = expertiseDao.loadByNumberAndStartDate(changeExpertDto.getNumber(), changeExpertDto.getStartDate());
        User user = userDao.getUserByLogin(changeExpertDto.getUserLogin());
        expertise.setUser(user);
        expertiseDao.update(expertise);
    }

    @Override
    @Transactional
    public List<Expertise> getExpertiseByLikeParametr(String searchString) {
        return expertiseDao.getExpertiseByLikeParametr(searchString);
    }

    @Override
    @Transactional
    public void finishExpertise(FinishExpertiseDto finishExpertiseDto) {
        Expertise expertise = expertiseDao.loadByNumberAndStartDate(finishExpertiseDto.getNumber(), finishExpertiseDto.getStartDate());
        expertise.setEndDate(finishExpertiseDto.getEndDate());
    }
}
