package com.project.demo.order.services;

import com.project.demo.order.data.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface CustomerOrderRepo extends CrudRepository<CustomerOrder,Long> {
}
