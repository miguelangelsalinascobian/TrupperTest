package com.H2DB.test4.controller;

import com.H2DB.test4.jwt.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@Autowired
	private JwtUtil jwtUtil;

    @PostMapping("/login/{username}")
    public String login(@PathVariable String username) {
        return jwtUtil.generateToken(username);
    }
}
