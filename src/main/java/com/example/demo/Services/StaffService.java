package com.example.demo.Services;

import com.example.demo.Models.Staff;
import com.example.demo.Models.User;
import com.example.demo.Repositories.StaffRepository;
import com.example.demo.Repositories.StaffUserRepository;
import com.example.demo.dto.UserStaffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final StaffUserRepository staffUserRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository, StaffUserRepository staffUserRepository)    {
        this.staffRepository = staffRepository;
        this.staffUserRepository = staffUserRepository;
    }

    public Staff createStaff(Staff staff)   {
        return staffRepository.save(staff);
    }

    public void deleteStaff(Long id)    {
        staffRepository.deleteById(id);
    }

    public Iterable<Staff> getAllStaff()    {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id)  {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent()) {
            return optionalStaff.get();
        }
        else {
            throw new RuntimeException("Staff with id " + id + " does not exist");
        }
    }

    public List<User> getUsersByStaffId(Long id)  {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        List<User> userList = new LinkedList<>();
        if (optionalStaff.isPresent())  {
            staffUserRepository.findAllUsersByStaff_staffId(id);
            return null;
        }
        else {
            throw new RuntimeException("Staff with id " + id + "does not exist");
        }
    }

    public UserStaffDTO getUserStaffDto(Long sId, Long uId) {
        Optional<Staff> optionalStaff = staffRepository.findById(sId);
        if (optionalStaff.isPresent())  {
//            for (User user : optionalStaff.get().getRegisteredUsers())  {
//                if (user.getUserId() == uId)    {
//                    UserStaffDTO userStaffDTO = new UserStaffDTO(user.getFirstName(), user.getLastName(), optionalStaff.get().getFirstName());
//                    return userStaffDTO;
//                }
//            }
        }
        else {
            throw new RuntimeException("Staff with id " + sId + "does not exist");
        }
        return null;
    }
}
