package com.salman.ajani.lovable_clone.service;

import com.salman.ajani.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.salman.ajani.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId);
}
