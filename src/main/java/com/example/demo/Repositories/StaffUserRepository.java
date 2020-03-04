package com.example.demo.Repositories;

import com.example.demo.Models.Staff;
import com.example.demo.Models.StaffUser;
import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffUserRepository extends JpaRepository<StaffUser, Long> {

    @Query("select u from Users u inner join StaffUser su on u.userId = su.user.id inner join Staff s on s.staffId = su.staff.id where s.staffId = :staff_id")
    List<User> findAllUsersByStaff(@Param(value = "staff_id") Long staff_id);

}
