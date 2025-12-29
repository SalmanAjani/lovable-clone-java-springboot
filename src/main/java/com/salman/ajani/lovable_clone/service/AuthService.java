package com.salman.ajani.lovable_clone.service;

import com.salman.ajani.lovable_clone.dto.auth.AuthResponse;
import com.salman.ajani.lovable_clone.dto.auth.LoginRequest;
import com.salman.ajani.lovable_clone.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
