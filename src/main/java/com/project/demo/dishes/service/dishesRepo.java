package com.project.demo.dishes.service;

import com.project.demo.dishes.data.dishes;
import org.springframework.data.repository.CrudRepository;

public interface dishesRepo extends CrudRepository<dishes,Long> {
}
