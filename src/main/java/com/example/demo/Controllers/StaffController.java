package com.example.demo.Controllers;

import com.example.demo.Models.Staff;
import com.example.demo.Services.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {

    private StaffService staffService;

    public StaffController(StaffService staffService)   {
        this.staffService = staffService;
    }

    @PostMapping("/staff")
    public ResponseEntity<Staff> createStaff(Staff staff)   {
        staffService.createStaff(staff);
        return ResponseEntity.ok().body(staff);
    }

    @DeleteMapping("/staff/delete/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id)  {
        staffService.deleteStaff(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/staff/get")
    public ResponseEntity<Iterable<Staff>> getAllStaff()    {
        Iterable<Staff> list = staffService.getAllStaff();
        return ResponseEntity.ok().body(list);
    }
}
