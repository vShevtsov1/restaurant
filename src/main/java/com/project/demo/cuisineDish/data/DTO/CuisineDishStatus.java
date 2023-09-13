package com.project.demo.cuisineDish.data.DTO;

import com.project.demo.cuisineDish.data.CuisineDish;
import com.project.demo.cuisineDish.data.help.status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuisineDishStatus {

    private String message;
    private status status;
    private CuisineDish cuisineDish;
}
