package com.alpha.mvc.persistence.dto;

import com.alpha.mvc.services.servicesImpl.CustomDateDeserializer;
import com.alpha.mvc.services.servicesImpl.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

public class NewExpertiseDto {

    private Date startdate;
    private String organization;
    private String crimenumber;

    public Date getStartdate() {
        return startdate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCrimenumber() {
        return crimenumber;
    }

    public void setCrimenumber(String crimenumber) {
        this.crimenumber = crimenumber;
    }
}
