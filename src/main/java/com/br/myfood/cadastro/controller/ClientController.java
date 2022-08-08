package com.br.myfood.cadastro.controller;

import com.br.myfood.cadastro.dto.ClientDto;
import com.br.myfood.cadastro.entity.Client;
import com.br.myfood.cadastro.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RequestMapping("/client")
@RestController
public class ClientController {


    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody ClientDto clientDto) {

        try {
            return ResponseEntity.ok(clientService.insertClient(Client.create(clientDto)));
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(e);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientDto){

        Client client = Client.create(clientDto);
        client.setId(id);

        Client updateClient = clientService.updateClient(client);

        return Objects.nonNull(updateClient) ?
               ResponseEntity.ok(updateClient) :
               ResponseEntity.notFound().build();

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id){
        return clientService.deleteClient(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){

        Optional<Client> client = clientService.findById(id);
        return client.isPresent()?
                ResponseEntity.ok(client.get()):
                ResponseEntity.notFound().build();

    }
}

