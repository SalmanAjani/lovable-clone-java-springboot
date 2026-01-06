package com.salman.ajani.lovable_clone.dto.member;

import com.salman.ajani.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role
) {
}
