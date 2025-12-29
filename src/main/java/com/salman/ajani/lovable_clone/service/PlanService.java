package com.salman.ajani.lovable_clone.service;

import com.salman.ajani.lovable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
