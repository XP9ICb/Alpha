package com.alpha.mvc.persistence.dto;

import com.alpha.mvc.services.servicesImpl.CustomDateDeserializer;
import com.alpha.mvc.services.servicesImpl.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

public class ChangeExpertDto {
    private String userLogin;
    private int number;
    private Date startDate;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
