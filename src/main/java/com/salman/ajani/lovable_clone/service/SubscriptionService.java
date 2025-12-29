package com.salman.ajani.lovable_clone.service;

import com.salman.ajani.lovable_clone.dto.subscription.CheckoutRequest;
import com.salman.ajani.lovable_clone.dto.subscription.CheckoutResponse;
import com.salman.ajani.lovable_clone.dto.subscription.PortalResponse;
import com.salman.ajani.lovable_clone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
