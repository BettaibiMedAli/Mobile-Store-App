package com.project.mobileStore.services;

import com.project.mobileStore.models.Cart;
import com.project.mobileStore.models.Mobile;
import com.project.mobileStore.repositories.CartRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepo cartRepo;
    private Cart currentCart;

    @Autowired
    public CartServiceImpl(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
        this.currentCart = new Cart();
    }

    @Override
    public Cart getCart() {
        return currentCart;
    }

    @Override
    public void addMobileToCart(Mobile mobile) {
        currentCart.getItems().add(mobile);
    }

    @Override
    public void removeMobileFromCart(Long mobileId) {
        currentCart.getItems().removeIf(mobile -> mobile.getId().equals(mobileId));
    }

    @Override
    public double calculateTotal() {
        return currentCart.getItems().stream()
                .mapToDouble(Mobile::getPrice)
                .sum();
    }

    @Override
    public void confirmPurchase() {
        double total = calculateTotal();
        // Logic to add total to incomes goes here
        // Reset the cart after confirming purchase
        currentCart.getItems().clear();
    }
}
