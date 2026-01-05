package com.salman.ajani.lovable_clone.service.impl;

import com.salman.ajani.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.salman.ajani.lovable_clone.dto.subscription.UsageTodayResponse;
import com.salman.ajani.lovable_clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId) {
        return null;
    }
}
