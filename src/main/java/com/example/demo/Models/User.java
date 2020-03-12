package com.example.demo.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String firstName;
    private String lastName;
    private int identification;
    private Date bornDate;
    private Date startDate;
    private Date endDate;

    @ManyToMany
    @JoinTable(
            name = "staff_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<Staff> staff;

    protected User()    {}

    // Constructor without userId. Used to add a new user
    public User(String firstName, String lastName, int identification, Date bornDate, Date startDate, Date endDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.bornDate = bornDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Constructor with userId. Used for updating
    public User(Long userId, String firstName, String lastName, int identification, Date bornDate, Date startDate, Date endDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.bornDate = bornDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getIdentification() {
        return identification;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
