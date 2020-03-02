package com.example.demo.Repositories;

import com.example.demo.Models.Staff;
import com.example.demo.Models.StaffUser;
import com.example.demo.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StaffUserRepository extends CrudRepository<StaffUser, Long> {
    public List<User> findAllByStaff(Staff staff);
}
