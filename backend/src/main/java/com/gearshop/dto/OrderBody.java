package com.gearshop.dto;

import com.gearshop.entity.CartItem;

import java.io.Serializable;

public class OrderBody implements Serializable {

    private CartItem[] cartItems;

    private String phone;

    public CartItem[] getCartItems() {
        return cartItems;
    }

    public void setCartItems(CartItem[] cartItems) {
        this.cartItems = cartItems;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
