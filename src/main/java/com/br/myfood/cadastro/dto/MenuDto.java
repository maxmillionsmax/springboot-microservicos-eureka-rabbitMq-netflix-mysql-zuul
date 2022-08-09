package com.br.myfood.cadastro.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

    private String name;
    private Double price;
    private Long restaurant;
}

