package com.project.demo.dishes.service;

import com.project.demo.dishes.data.dishes;
import com.project.demo.option.data.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dishesService {

    @Autowired
    private dishesRepo dishesRepo;

    public dishes createUpdateDish(dishes dishes){
        return dishesRepo.save(dishes);
    }
    public Iterable<dishes> getAllDishes(){
        return dishesRepo.findAll();
    }

    public dishes findById(Long id){
        return dishesRepo.findById(id).get();
    }
}
