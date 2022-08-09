package com.br.myfood.cadastro.controller;

import com.br.myfood.cadastro.dto.RestaurantDto;
import com.br.myfood.cadastro.entity.Restaurant;
import com.br.myfood.cadastro.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RequestMapping("/restaurant")
@RestController
public class RestaurantController {


    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertRestaurant(@RequestBody RestaurantDto restaurantDto) {

        try {
            return ResponseEntity.ok(restaurantService.insertRestaurant(Restaurant.create(restaurantDto)));
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(e);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantDto restaurantDto){

        Restaurant restaurant = Restaurant.create(restaurantDto);
        restaurant.setId(id);

        Restaurant updateRestaurant = restaurantService.updateRestaurant(restaurant);

        return Objects.nonNull(updateRestaurant) ?
               ResponseEntity.ok(updateRestaurant) :
               ResponseEntity.notFound().build();

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable("id") Long id){
        return restaurantService.deleteRestaurant(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){

        Optional<Restaurant> restaurant = restaurantService.findById(id);
        return restaurant.isPresent()?
                ResponseEntity.ok(restaurant.get()):
                ResponseEntity.notFound().build();

    }
}

