package com.project.demo.cuisineDish.service;

import com.project.demo.cuisineDish.data.CuisineDish;
import org.springframework.data.repository.CrudRepository;

public interface cuisineDishRepo extends CrudRepository<CuisineDish,Long> {
}
