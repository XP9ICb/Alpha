package com.alpha.mvc.persistence.domain;

import com.alpha.mvc.services.servicesImpl.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expertise")
public class Expertise {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "number")
    private int number;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "organization")
    private String organization;

    @Column(name = "crime_number")
    private String crimeNumber;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCrimeNumber() {
        return crimeNumber;
    }

    public void setCrimeNumber(String crimeNumber) {
        this.crimeNumber = crimeNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
