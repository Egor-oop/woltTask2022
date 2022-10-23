package com.egorgulido.woltTask2022;

import com.egorgulido.woltTask2022.order.Order;
import com.egorgulido.woltTask2022.order.OrderController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeeCounter {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    public void countFee(DeliveryFee fee, Order order) {
        countFeeByCartValue(fee, order.getCartValue());
        countFeeByNumberOfItems(fee, order.getNumberOfItems());
        countFeeByDistance(fee, order.getDeliveryDistance());
        countFeeByTime(fee, order);

        if (order.getCartValue() >= 10000) {
            fee.setDeliveryFee(0);
        }
        if (fee.getDeliveryFee() > 1500) {
            fee.setDeliveryFee(1500);
        }
    }

    private void countFeeByCartValue(DeliveryFee fee, int cartValue) {
        /*
            Add difference between a cart value and 10 euro,
            if the cart value is less than 10 euro
         */

        if (cartValue < 100) {
            fee.addToFee(100 - cartValue);
        }
    }

    private void countFeeByNumberOfItems(DeliveryFee fee, int numberOfItems) {
        /*
            Add 50 cents supercharge to the delivery fee
            by every cart item after first 4 items
         */

        if (numberOfItems >= 5) {
            fee.addToFee((numberOfItems - 4) * 50);
        }
    }

    private void countFeeByDistance(DeliveryFee fee, int distance) {
        /*
            Add 1 euro to the delivery fee every 500 meters

            Default value of distance supercharge is
            100 cents (1 euro)
         */

        int supercharge = 100;
        int counter = 0;

        while (distance > 0) {
            distance = distance - 500;
            counter++;
        }

        supercharge *= counter;
        fee.addToFee(supercharge);
    }

    private void countFeeByTime(DeliveryFee fee, Order order) {
        /*
            Add 1.1x supercharge to the delivery fee
            during Friday rush at 3-7 PM
         */

        int orderHour = order.getTime().getHour();
        String orderDayOfTheWeek = order.getTime().getDayOfWeek().toString();

        if (orderDayOfTheWeek.equals("FRIDAY")) {
            if (orderHour >= 15 && orderHour <= 19) {
                int supercharge = (int) (fee.getDeliveryFee() * 0.1);
                fee.addToFee(supercharge);
            }
        }
    }
}
