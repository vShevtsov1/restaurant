package com.project.demo.cuisineDish.data;

import com.project.demo.cuisines.data.Cuisine;
import com.project.demo.dishes.data.dishes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CuisineDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private dishes dish;

    public CuisineDish(Cuisine cuisine, dishes dish) {
        this.cuisine = cuisine;
        this.dish = dish;
    }
}
