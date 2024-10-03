package com.project.mobileStore.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private List<Mobile> mobiles;

    public Cart() {
        this.mobiles = new ArrayList<>();
    }

    /*public void addMobile(Mobile mobile) {
        mobiles.add(mobile);
    }*/

    public void removeMobile(Mobile mobile) {
        mobiles.remove(mobile);
    }

    public double getTotalPrice() {
        return mobiles.stream().mapToDouble(Mobile::getPrice).sum();
    }

    public double confirmPurchase() {
        double total = getTotalPrice();
        mobiles.clear(); // Clear the cart after confirming purchase
        return total; // Return the total amount
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
