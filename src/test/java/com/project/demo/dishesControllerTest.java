package com.project.demo;

import com.project.demo.dishes.data.dishes;
import com.project.demo.dishes.dishesController;
import com.project.demo.dishes.service.dishesService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@WebMvcTest(dishesController.class)
@SpringJUnitConfig
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class dishesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private dishesService dishesService;

    @Test
    @Order(1)
    public void createDishTest() throws Exception {
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
    }

    @Test
    @Order(2)
    public void testGetAllDishes() throws Exception {
        dishes sampleDish = new dishes();
        sampleDish.setId(1L);
        sampleDish.setName("Sample Dish");
        sampleDish.setPrice(10.0);
        sampleDish.setDescription("A delicious sample dish");

        List<dishes> dishesList = new ArrayList<>();
        dishesList.add(sampleDish);

        when(dishesService.getAllDishes()).thenReturn(dishesList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dishes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Sample Dish"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(10.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("A delicious sample dish"));
    }
}
