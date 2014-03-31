package com.alpha.mvc;

import com.alpha.mvc.persistence.dto.ChangeExpertDto;
import com.alpha.mvc.persistence.dto.FinishExpertiseDto;
import com.alpha.mvc.persistence.dto.NewExpertiseDto;
import com.alpha.mvc.services.ExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

@Controller
public class ExpertiseController {

    @Autowired
    private ExpertiseService expertiseService;

    @RequestMapping("/new-expertise.htm")
    @ResponseBody String createNewExpertise(@RequestBody NewExpertiseDto newExpertiseDto){
        return expertiseService.save(newExpertiseDto).toString();
    }

    @RequestMapping("/delete-expertise.htm")
    @ResponseBody String deleteExpertise(@RequestBody ChangeExpertDto changeExpertDto){
        expertiseService.deleteByNumberAndStartDate(changeExpertDto.getNumber(), changeExpertDto.getStartDate());
        return "{\"success\":\"true\"}";
    }

    @RequestMapping("/change-expert.htm")
    @ResponseBody String changeExpert(@RequestBody ChangeExpertDto changeExpertDto){
        expertiseService.changeExpert(changeExpertDto);
        return "{\"success\":\"true\"}";
    }

    @RequestMapping("/finish-experise.htm")
    @ResponseBody void finishExpertise(@RequestBody FinishExpertiseDto finishExpertiseDto) throws ParseException {
        expertiseService.finishExpertise(finishExpertiseDto);
    }
}

