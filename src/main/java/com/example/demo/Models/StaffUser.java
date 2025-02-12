package com.example.demo.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "StaffUser")
@Table(name = "staff_users")
public class StaffUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(updatable = false)
    private Date createdAt;

    protected StaffUser()   {}

    // Used on create
    public StaffUser(Staff staff, User user, Date createdAt) {
        this.staff = staff;
        this.user = user;
        this.createdAt = createdAt;
    }

    // Used on update
    public StaffUser(Long id, Staff staff, User user, Date createdAt) {
        this.staff = staff;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
}
