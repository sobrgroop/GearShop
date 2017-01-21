package com.gearshop.service;

import org.springframework.security.authentication.BadCredentialsException;

public interface SecurityService {

    void doLogin(String email, String password) throws BadCredentialsException;
}
