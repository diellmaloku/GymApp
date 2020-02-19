package com.example.demo.Services;

import com.example.demo.Models.Staff;
import com.example.demo.Models.User;
import com.example.demo.Repositories.StaffRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final StaffRepository staffRepository;

    @Autowired
    public UserService(UserRepository userRepository, StaffRepository staffRepository) {
        this.userRepository = userRepository;
        this.staffRepository = staffRepository;
    }

    public User createUser(User user, Long staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        Set<User> newUser = new HashSet<>();
        newUser.add(user);
        staff.get().setLikedCourses(newUser);
        staffRepository.save(staff.get());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
