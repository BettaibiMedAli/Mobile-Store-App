package com.project.mobileStore.services;

import com.project.mobileStore.models.Cart;
import com.project.mobileStore.models.Mobile;

public interface CartService {
    Cart getCart();
    void addMobileToCart(Mobile mobile);
    void removeMobileFromCart(Long mobileId);
    double calculateTotal();
    void confirmPurchase();

}
