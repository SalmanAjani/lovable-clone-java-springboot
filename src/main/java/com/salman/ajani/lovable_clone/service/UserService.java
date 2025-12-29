package com.salman.ajani.lovable_clone.service;

import com.salman.ajani.lovable_clone.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
