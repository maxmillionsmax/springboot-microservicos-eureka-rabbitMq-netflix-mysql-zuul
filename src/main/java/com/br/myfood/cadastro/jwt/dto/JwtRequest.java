package com.br.myfood.cadastro.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class JwtRequest {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;


}