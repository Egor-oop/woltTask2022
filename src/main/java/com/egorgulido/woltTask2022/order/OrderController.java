package com.egorgulido.woltTask2022.order;

import com.egorgulido.woltTask2022.FeeCounter;
import com.egorgulido.woltTask2022.DeliveryFee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @PostMapping
    public DeliveryFee CountFee(@RequestBody Order order) {
        log.info("" + order);

        // Init a fee and a feeCounter
        DeliveryFee fee = new DeliveryFee(0);
        FeeCounter countFee = new FeeCounter();

        // Counting the delivery fee
        countFee.countFee(fee, order);

        return fee;
    }
}
