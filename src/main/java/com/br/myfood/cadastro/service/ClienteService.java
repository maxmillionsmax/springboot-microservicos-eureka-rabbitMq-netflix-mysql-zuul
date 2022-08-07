package com.br.myfood.cadastro.service;

import com.br.myfood.cadastro.dto.ClienteDto;
import com.br.myfood.cadastro.entity.Client;
import com.br.myfood.cadastro.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClienteService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client inserClient(Client client){
        return clientRepository.save(client);
    }

    public Client updateClient(Client client){

        Optional<Client> newclient = clientRepository.findById(client.getId());

        if (newclient.isPresent()){
            return clientRepository.save(client);
        }else {
            return null;
        }
    }

    public boolean deleteClient(Long id){
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()){
            clientRepository.delete(client.get());
            return true;
        }else {
            return false;
        }
    }
    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }
}
