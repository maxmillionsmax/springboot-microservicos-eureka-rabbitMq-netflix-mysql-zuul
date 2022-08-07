package com.br.myfood.cadastro.entity;

import com.br.myfood.cadastro.dto.RestaurantDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String password;

    public static Restaurant create(RestaurantDto restaurantDto){
        return new ModelMapper().map(restaurantDto, Restaurant.class);
    }
}
