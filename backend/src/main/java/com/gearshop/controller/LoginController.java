package com.gearshop.controller;

import com.gearshop.entity.User;
import com.gearshop.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final SecurityService securityService;

    @Autowired
    public LoginController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public String login(@Validated @RequestBody User user) throws BadCredentialsException {
        securityService.doLogin(user.getEmail(), user.getPassword());
        return "authentication";
    }

}
