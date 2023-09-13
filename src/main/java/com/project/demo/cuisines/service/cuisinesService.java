package com.project.demo.cuisines.service;

import com.project.demo.cuisines.data.Cuisine;
import com.project.demo.option.data.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cuisinesService {

    @Autowired
    private cuisinesRepo cuisinesRepo;

    public Cuisine createUpdateCuisines(Cuisine cuisine){
        return cuisinesRepo.save(cuisine);
    }

    public Iterable<Cuisine> getAllCuisine(){
        return cuisinesRepo.findAll();
    }
    public Cuisine findById(Long id){
        return cuisinesRepo.findById(id).get();
    }
}
