package com.project.demo.option.services;

import com.project.demo.option.data.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class optionService {

    @Autowired
    private optionRepo optionRepo;

    public Option createUpdateOption(Option option){
        return optionRepo.save(option);
    }
    public Iterable<Option> getAllOptions(){
        return optionRepo.findAll();
    }
}
