package com.project.demo.order;

import com.project.demo.order.data.CustomerOrder;
import com.project.demo.order.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private CustomerOrderService orderService;


    @PostMapping("/create-order")
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        return orderService.createOrder(order);
    }

    @GetMapping()
    public CustomerOrder getById(@RequestParam Long orderId) {
        return orderService.getOrderById(orderId);
    }
}