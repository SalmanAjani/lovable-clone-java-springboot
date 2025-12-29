package com.salman.ajani.lovable_clone.dto.member;

import com.salman.ajani.lovable_clone.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
