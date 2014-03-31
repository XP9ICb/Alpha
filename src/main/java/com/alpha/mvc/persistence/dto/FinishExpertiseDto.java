package com.alpha.mvc.persistence.dto;

import com.alpha.mvc.services.servicesImpl.CustomDateDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.Date;

public class FinishExpertiseDto {
    private int number;
    private Date startDate;
    private Date endDate;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
