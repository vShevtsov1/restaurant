package com.project.demo.cuisineDish.service;

import com.project.demo.cuisineDish.data.CuisineDish;
import com.project.demo.cuisineDish.data.DTO.CuisineDishStatus;
import com.project.demo.cuisineDish.data.help.status;
import com.project.demo.cuisines.data.Cuisine;
import com.project.demo.cuisines.service.cuisinesService;
import com.project.demo.dishes.data.dishes;
import com.project.demo.dishes.service.dishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cuisineDishService {

    @Autowired
    private cuisineDishRepo cuisineDishRepo;

    @Autowired
    private cuisinesService cuisinesService;

    @Autowired
    private dishesService dishesService;

    public CuisineDishStatus addDishToCuisine(Long cuisineId, Long dishId){
        CuisineDishStatus cuisineDishStatus = new CuisineDishStatus();
        Cuisine cuisine = cuisinesService.findById(cuisineId);
        if(cuisine == null){
            cuisineDishStatus.setStatus(status.NOT_FOUND);
            cuisineDishStatus.setMessage("Cannot find cuisine by id");
            return cuisineDishStatus;
        }
        dishes dishes = dishesService.findById(dishId);
        if(dishes == null){
            cuisineDishStatus.setStatus(status.NOT_FOUND);
            cuisineDishStatus.setMessage("Cannot find dishes by id");
            return cuisineDishStatus;
        }
        CuisineDish  cuisineDish = new CuisineDish(cuisine,dishes);
        cuisineDishRepo.save(cuisineDish);
        cuisineDishStatus.setStatus(status.OK);
        cuisineDishStatus.setMessage("Successfully added dish to cuisine");
        cuisineDishStatus.setCuisineDish(cuisineDish);
        return cuisineDishStatus;
    }
}
