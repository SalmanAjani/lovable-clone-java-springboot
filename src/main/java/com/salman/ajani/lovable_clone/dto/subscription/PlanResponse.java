package com.salman.ajani.lovable_clone.dto.subscription;

public record PlanResponse(
        Long id,
        String name,
        String price,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Boolean unlimitedAi
) {
}
