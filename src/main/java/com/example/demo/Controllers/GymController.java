package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GymController {

    @GetMapping("/test")
    public static String firstController()  {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("kosova", "prishtina");
        hashMap.put("shqiperia", "tirana");

        return hashMap.get("kosova");
    }
}
