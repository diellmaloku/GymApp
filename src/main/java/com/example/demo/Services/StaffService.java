package com.example.demo.Services;

import com.example.demo.Models.Staff;
import com.example.demo.Models.User;
import com.example.demo.Repositories.StaffRepository;
import com.example.demo.dto.UserStaffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository)    {
        this.staffRepository = staffRepository;
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

    public Set<User> getUsersByStaffId(Long id)  {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent())  {
//            Staff staff = optionalStaff.get();
//            Set<User> userSet = staff.getRegisteredUsers();
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
