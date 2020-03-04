package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/{staffId}")
    public ResponseEntity<User> createUser(@RequestBody User user, @PathVariable Long staffId)   {
        userService.createUser(user, staffId);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)   {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/{staffId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long staffId)   {
        userService.updateUser(user, staffId);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> list = userService.getAllUsers();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)  {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }
}
