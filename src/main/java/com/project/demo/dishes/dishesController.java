package com.project.demo.dishes;

import com.project.demo.dishes.data.dishes;
import com.project.demo.dishes.service.dishesService;
import com.project.demo.option.data.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dishes")
public class dishesController {

    @Autowired
    private dishesService dishesService;

    @PostMapping("/create")
    public ResponseEntity<dishes> createUpdateDish(@RequestBody dishes dishes){
        dishes createdDishes = dishesService.createUpdateDish(dishes);
        if(createdDishes!=null){
            return ResponseEntity.ok(createdDishes);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<dishes>> getAllDishes(){
        return ResponseEntity.ok(dishesService.getAllDishes());
    }
}
