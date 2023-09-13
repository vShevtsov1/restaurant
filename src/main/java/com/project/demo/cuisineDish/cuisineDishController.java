package com.project.demo.cuisineDish;



import com.project.demo.cuisineDish.data.DTO.CuisineDishStatus;
import com.project.demo.cuisineDish.service.cuisineDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuisine-dish")
public class cuisineDishController {

    @Autowired
    private cuisineDishService cuisineDishService;

    @PostMapping("/add-dish-to-cuisine")
    public CuisineDishStatus addDishToCuisine(
            @RequestParam("cuisineId") Long cuisineId,
            @RequestParam("dishId") Long dishId) {
        return cuisineDishService.addDishToCuisine(cuisineId, dishId);
    }
}
