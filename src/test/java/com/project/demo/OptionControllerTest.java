package com.project.demo;

import com.project.demo.option.data.Option;
import com.project.demo.option.optionController;
import com.project.demo.option.services.optionService;
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

@WebMvcTest(optionController.class)
@SpringJUnitConfig
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OptionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private optionService optionService;

    @Test
    @Order(1)
    public void createOptionTest() throws Exception {
        Option sampleOption = new Option();
        sampleOption.setId(1L);
        sampleOption.setName("Sample Option");
        sampleOption.setPrice(5.0);

        when(optionService.createUpdateOption(Mockito.any(Option.class))).thenReturn(sampleOption);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/options/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Sample Option\",\"price\":5.0}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sample Option"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(5.0));
    }

    @Test
    @Order(2)
    public void testGetAllOptions() throws Exception {
        Option sampleOption = new Option();
        sampleOption.setId(1L);
        sampleOption.setName("Sample Option");
        sampleOption.setPrice(5.0);

        List<Option> optionsList = new ArrayList<>();
        optionsList.add(sampleOption);

        when(optionService.getAllOptions()).thenReturn(optionsList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/options")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Sample Option"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(5.0));
    }
}
