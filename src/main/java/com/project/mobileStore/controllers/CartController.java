package com.project.mobileStore.controllers;

import com.project.mobileStore.models.Cart;
import com.project.mobileStore.models.Mobile;
import com.project.mobileStore.services.CartService;
import com.project.mobileStore.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CartController {

    private CartService cartService;
    private MobileService mobileService;

    @Autowired
    public CartController(CartService cartService, MobileService mobileService) {
        this.cartService = cartService;
        this.mobileService = mobileService;
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        Cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        model.addAttribute("total", cartService.calculateTotal());
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addMobileToCart(@RequestParam Long mobileId) {
        Optional<Mobile> optionalMobile = mobileService.getMobileById(mobileId); // Find mobile by ID
        if (optionalMobile.isPresent()) {
            Mobile mobile = optionalMobile.get();
            cartService.addMobileToCart(mobile);
        }
        return "redirect:/Homepage";
    }

    @PostMapping("/cart/remove")
    public String removeMobileFromCart(@RequestParam Long mobileId) {
        cartService.removeMobileFromCart(mobileId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/confirm")
    public String confirmPurchase() {
        cartService.confirmPurchase();
        return "redirect:/Homepage";
    }
}