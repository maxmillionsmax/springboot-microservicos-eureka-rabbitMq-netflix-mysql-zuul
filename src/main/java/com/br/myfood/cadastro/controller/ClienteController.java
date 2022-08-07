package com.br.myfood.cadastro.controller;

import com.br.myfood.cadastro.dto.ClienteDto;
import com.br.myfood.cadastro.entity.Client;
import com.br.myfood.cadastro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequestMapping("/client")
@RestController
public class ClienteController {


    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody ClienteDto clienteDto) {

        try {
            return ResponseEntity.ok(clienteService.inserClient(Client.create(clienteDto)));
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(e);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody ClienteDto clienteDto){

        Client client = Client.create(clienteDto);
        client.setId(id);

        Client updateClient = clienteService.updateClient(client);

        return Objects.nonNull(updateClient) ?
               ResponseEntity.ok(updateClient) :
               ResponseEntity.notFound().build();

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id){
        return clienteService.deleteClient(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}

