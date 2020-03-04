package com.example.demo.Controllers;

import com.example.demo.Models.Staff;
import com.example.demo.Models.User;
import com.example.demo.Services.StaffService;
import com.example.demo.dto.UserStaffDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @DeleteMapping("/staff/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id)  {
        staffService.deleteStaff(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/staff")
    public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff)  {
        staffService.updateStaff(staff);
        return ResponseEntity.ok().body(staff);
    }

    @GetMapping("/staff")
    public ResponseEntity<Iterable<Staff>> getAllStaff()    {
        Iterable<Staff> list = staffService.getAllStaff();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id)  {
        Staff staff = staffService.getStaffById(id);
        return ResponseEntity.ok().body(staff);
    }

    @GetMapping("/staff/{id}/users")
    public ResponseEntity<List<User>> getUsersByStaffId(@PathVariable Long id)    {
        List<User> userSet = staffService.getUsersByStaffId(id);
        return ResponseEntity.ok().body(userSet);
    }

    @GetMapping("/staff/{sId}/user/{uId}/userdto")
    public ResponseEntity<UserStaffDTO> getUserDto(@PathVariable Long sId, @PathVariable Long uId)  {
        UserStaffDTO userStaffDTO = staffService.getUserStaffDto(sId, uId);
        return ResponseEntity.ok().body(userStaffDTO);
    }
}
