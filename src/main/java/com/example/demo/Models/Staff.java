package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staffId;

    private String firstName;
    private String lastName;
    private Date bornDate;
    private int identification;
    private String password;

    protected Staff() {}

    public Staff(String firstName, String lastName, Date bornDate, int identification, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.identification = identification;
        this.password = password;
    }

    public Staff(Long staffId, String firstName, String lastName, Date bornDate, int identification, String password) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.identification = identification;
        this.password = password;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getStaffId() {
        return staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public int getIdentification() {
        return identification;
    }

    public String getPassword() {
        return password;
    }
}