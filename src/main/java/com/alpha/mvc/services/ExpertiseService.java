package com.alpha.mvc.services;

import com.alpha.mvc.persistence.domain.Expertise;
import com.alpha.mvc.persistence.dto.ChangeExpertDto;
import com.alpha.mvc.persistence.dto.FinishExpertiseDto;
import com.alpha.mvc.persistence.dto.NewExpertiseDto;

import java.util.Date;
import java.util.List;

public interface ExpertiseService {
    public List<Expertise> getAllExpertises();
    public void update(Expertise expertise);
    public Integer save(NewExpertiseDto newExpertiseDto);
    public void deleteByNumberAndStartDate(int number, Date startDate);
    public void changeExpert(ChangeExpertDto changeExpertDto);
    public List<Expertise> getExpertiseByLikeParametr(String searchString);
    public void finishExpertise(FinishExpertiseDto finishExpertiseDto);
}
