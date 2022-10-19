package com.egorgulido.woltTask2022.order;

import java.time.LocalDateTime;

public class Order {

    private int cartValue;
    private int deliveryDistance;
    private int numberOfItems;
    private LocalDateTime time;

    public Order(int cartValue, int deliveryDistance, int numberOfItems, LocalDateTime time) {
        this.cartValue = cartValue;
        this.deliveryDistance = deliveryDistance;
        this.numberOfItems = numberOfItems;
        this.time = time;
    }

    public void setCartValue(int cartValue) {
        this.cartValue = cartValue;
    }

    public void setDeliveryDistance(int deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCartValue() {
        return cartValue;
    }

    public int getDeliveryDistance() {
        return deliveryDistance;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cartValue=" + cartValue +
                ", deliveryDistance=" + deliveryDistance +
                ", numberOfItems=" + numberOfItems +
                ", time=" + time +
                '}';
    }
}
