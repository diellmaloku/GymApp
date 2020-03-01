package com.example.demo.dto;

public class UserStaffDTO

{
    String firstName;
    String lastName;
    String staffName;

    public UserStaffDTO(String firstName, String lastName, String staffName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffName = staffName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
