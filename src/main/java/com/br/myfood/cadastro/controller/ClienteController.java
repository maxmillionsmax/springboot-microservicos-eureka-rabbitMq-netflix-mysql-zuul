package com.br.myfood.cadastro.controller;

import com.br.myfood.cadastro.dto.ClienteDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client")
@RestController
public class ClienteController {

    @PostMapping("/insert")
    public String insertClient(ClienteDto clienteDto){



        return "OK";
    }

}

