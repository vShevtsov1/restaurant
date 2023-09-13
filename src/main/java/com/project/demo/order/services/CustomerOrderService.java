package com.project.demo.order.services;

import com.project.demo.order.data.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepo customerOrderRepo;

    public CustomerOrder createOrder(CustomerOrder customerOrder){
        return customerOrderRepo.save(customerOrder);
    }

    public CustomerOrder getOrderById(Long id){
        return customerOrderRepo.findById(id).get();
    }
}
