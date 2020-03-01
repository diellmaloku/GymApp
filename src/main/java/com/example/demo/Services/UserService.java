package com.example.demo.Services;

import com.example.demo.Models.Staff;
import com.example.demo.Models.User;
import com.example.demo.Repositories.StaffRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto.UserStaffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Staff> optionalStaff = staffRepository.findById(staffId);

        if(optionalStaff.isPresent()){
            Staff staff = optionalStaff.get();
            staff.setRegisteredUsers(user);
            userRepository.save(user);
            staffRepository.save(staff);

            return  user;
        }
        else{
            throw new RuntimeException("Staff with id " + staffId + " does not exist");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id)    {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())   {
            return optionalUser.get();
        }
        else {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
    }

}
