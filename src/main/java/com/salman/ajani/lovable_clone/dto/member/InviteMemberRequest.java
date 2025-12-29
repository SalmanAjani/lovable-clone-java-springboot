package com.salman.ajani.lovable_clone.dto.member;

import com.salman.ajani.lovable_clone.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
