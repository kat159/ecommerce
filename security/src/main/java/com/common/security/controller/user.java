package com.common.security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("security/user")
public class user {
    @GetMapping("page")
    public Map<String, String> page(@RequestParam String token) {
        
        return new HashMap<>();
    }


}
