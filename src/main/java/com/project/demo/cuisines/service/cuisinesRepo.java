package com.project.demo.cuisines.service;

import com.project.demo.cuisines.data.Cuisine;
import org.springframework.data.repository.CrudRepository;

public interface cuisinesRepo extends CrudRepository<Cuisine,Long> {
}
