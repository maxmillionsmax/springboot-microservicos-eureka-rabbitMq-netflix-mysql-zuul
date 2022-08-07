package com.br.myfood.cadastro.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private String name;
    private String email;
    private String password;
}
