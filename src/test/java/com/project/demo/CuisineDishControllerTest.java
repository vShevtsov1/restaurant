package com.project.demo;

import com.project.demo.cuisineDish.cuisineDishController;
import com.project.demo.cuisineDish.data.DTO.CuisineDishStatus;
import com.project.demo.cuisineDish.service.cuisineDishService;
import com.project.demo.cuisines.CuisinesController;
import com.project.demo.cuisines.data.Cuisine;
import com.project.demo.cuisines.service.cuisinesService;
import com.project.demo.dishes.data.dishes;
import com.project.demo.dishes.dishesController;
import com.project.demo.dishes.service.dishesService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.mockito.Mockito;
import com.project.demo.cuisineDish.data.help.status;

import static org.mockito.Mockito.when;

@WebMvcTest({dishesController.class,CuisinesController.class,cuisineDishController.class})
@SpringJUnitConfig
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CuisineDishControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private dishesService dishesService;
    @MockBean
    private cuisinesService cuisinesService;
    @MockBean
    private cuisineDishService cuisineDishService;

    @Test
    @Order(1)
    public void createCuisineAndDishTest() throws Exception {
        dishes sampleDish = new dishes();
        sampleDish.setId(1L);
        sampleDish.setName("Sample Dish");
        sampleDish.setPrice(10.0);
        sampleDish.setDescription("A delicious sample dish");

        when(dishesService.createUpdateDish(Mockito.any(dishes.class))).thenReturn(sampleDish);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/dishes/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Sample Dish\",\"price\":10.0,\"description\":\"A delicious sample dish\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sample Dish"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(10.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("A delicious sample dish"));

        Cuisine sampleCuisine = new Cuisine();
        sampleCuisine.setId(1L);
        sampleCuisine.setName("Sample Cuisine");

        when(cuisinesService.createUpdateCuisines(Mockito.any(Cuisine.class))).thenReturn(sampleCuisine);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/cuisines/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Sample Cuisine\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sample Cuisine"));
    }

    @Test
    public void testAddDishToCuisine() throws Exception {
        Long cuisineId = 1L;
        Long dishId = 1L;



        mockMvc.perform(MockMvcRequestBuilders
                        .post("/cuisine-dish/add-dish-to-cuisine")
                        .param("cuisineId", cuisineId.toString())
                        .param("dishId", dishId.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(status.OK));

    }
}
