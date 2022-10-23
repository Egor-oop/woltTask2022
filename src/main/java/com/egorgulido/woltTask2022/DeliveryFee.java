package com.egorgulido.woltTask2022;

public class DeliveryFee {

    public int deliveryFee;

    public DeliveryFee(int fee) {
        this.deliveryFee = fee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void addToFee(int fee) {
        setDeliveryFee(getDeliveryFee() + fee);
    }

    @Override
    public String toString() {
        return "DeliveryFee{" +
                "deliveryFee=" + deliveryFee +
                '}';
    }
}
