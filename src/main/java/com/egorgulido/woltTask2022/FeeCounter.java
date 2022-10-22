package com.egorgulido.woltTask2022;

import com.egorgulido.woltTask2022.order.Order;
import com.egorgulido.woltTask2022.order.OrderController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeeCounter {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    public int countFeeByDistance(int distance) {
        int fee = 100;
        int counter = 0;

        while (distance > 0) {
            distance = distance - 500;
            counter++;
        }

        fee *= counter;

        return fee;
    }

    public void countFeeByTime(DeliveryFee fee, Order order) {
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
