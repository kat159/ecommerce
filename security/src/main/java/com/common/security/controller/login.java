package com.common.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("security/login")
public class login {
    @PostMapping("account")
    public Map<String, String> login() {
        Map<String, String> res = new HashMap<>();
        res.put("status", "ok");
        res.put("currentAuthority", "admin"); // admin / user / guest
        return res;
    }

    @PostMapping("outLogin")
    public Map<String, String> logout() {
        Map<String, String> res = new HashMap<>();
        res.put("success", "true");

        Map<String, String> data = new HashMap<>();


        return res;
    }
}
