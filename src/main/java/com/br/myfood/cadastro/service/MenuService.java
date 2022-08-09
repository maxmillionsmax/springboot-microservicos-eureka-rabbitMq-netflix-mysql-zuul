package com.br.myfood.cadastro.service;

import com.br.myfood.cadastro.dto.MenuDto;
import com.br.myfood.cadastro.entity.Menu;
import com.br.myfood.cadastro.entity.Restaurant;
import com.br.myfood.cadastro.repository.MenuRepository;
import com.br.myfood.cadastro.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Menu insertMenu(MenuDto menuDto){

        Optional<Restaurant> restaurant = restaurantRepository.findById(menuDto.getRestaurant());
        if (restaurant.isPresent()){
            Menu menu = Menu.create(menuDto);
            menu.setRestaurant(restaurant.get());
            return menuRepository.save(menu);
        }else {
            return null;
        }

    }

    public Menu updateMenu(Menu menu){

        Optional<Menu> newMenu = menuRepository.findById(menu.getId());

        if (newMenu.isPresent()){
            return menuRepository.save(menu);
        }else {
            return null;
        }
    }

    public boolean deleteMenu(Long id){
        Optional<Menu> menu = menuRepository.findById(id);

        if (menu.isPresent()){
            menuRepository.delete(menu.get());
            return true;
        }else {
            return false;
        }
    }
    public Optional<Menu> findById(Long id){
        return menuRepository.findById(id);
    }
}
