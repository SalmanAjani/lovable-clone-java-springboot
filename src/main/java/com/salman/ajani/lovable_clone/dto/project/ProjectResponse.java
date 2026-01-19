package com.salman.ajani.lovable_clone.dto.project;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
//        UserProfileResponse owner
) {
}
