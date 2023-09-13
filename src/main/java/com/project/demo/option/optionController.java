package com.project.demo.option;

import com.project.demo.option.data.Option;
import com.project.demo.option.services.optionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class optionController {

    @Autowired
    private optionService optionService;

    @PostMapping("/create")
    public ResponseEntity<Option> createNewOption(@RequestBody Option option){
        Option createdOption = optionService.createUpdateOption(option);
        if(createdOption!=null){
            return ResponseEntity.ok(createdOption);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Option>> getAllOptions(){
        return ResponseEntity.ok(optionService.getAllOptions());
    }
}
