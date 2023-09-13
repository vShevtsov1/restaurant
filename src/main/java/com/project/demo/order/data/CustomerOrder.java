package com.project.demo.order.data;

import com.project.demo.cuisines.data.Cuisine;

import com.project.demo.option.data.Option;
import com.project.demo.dishes.data.dishes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "order_dishes",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "dishes_id")
    )
    private List<dishes> dishes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "order_options",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<Option> options = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "order_cuisines",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "cuisine_id")
    )
    private List<Cuisine> cuisines = new ArrayList<>();
}
