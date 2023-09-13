package com.project.demo.cuisines;

import com.project.demo.cuisines.data.Cuisine;
import com.project.demo.cuisines.service.cuisinesService;
import com.project.demo.option.data.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuisines")
public class CuisinesController {

    @Autowired
    private cuisinesService cuisinesService;

    @PostMapping("/create")
    public ResponseEntity<Cuisine> createNewCuisine(@RequestBody Cuisine cuisines){
        Cuisine createdCuisine = cuisinesService.createUpdateCuisines(cuisines);
        if(createdCuisine!=null){
            return ResponseEntity.ok(createdCuisine);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Cuisine>> getAllOptions(){
        return ResponseEntity.ok(cuisinesService.getAllCuisine());
    }
}
