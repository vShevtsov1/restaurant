package com.project.demo;

import com.project.demo.cuisines.CuisinesController;
import com.project.demo.cuisines.data.Cuisine;
import com.project.demo.cuisines.service.cuisinesService;
import org.junit.jupiter.api.*;
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

@WebMvcTest(CuisinesController.class)
@SpringJUnitConfig
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CuisinesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private cuisinesService cuisinesService;

    @Test
    @Order(1)
    public void createCuisineTest() throws Exception {
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
    @Order(2)
    public void testGetAllCuisines() throws Exception {
        Cuisine sampleCuisine = new Cuisine();
        sampleCuisine.setId(1L);
        sampleCuisine.setName("Sample Cuisine");

        List<Cuisine> cuisinesList = new ArrayList<>();
        cuisinesList.add(sampleCuisine);

        when(cuisinesService.getAllCuisine()).thenReturn(cuisinesList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/cuisines")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Sample Cuisine"));
    }
}
