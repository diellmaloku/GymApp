package com.example.demo.Services;

import com.example.demo.Models.Staff;
import com.example.demo.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
