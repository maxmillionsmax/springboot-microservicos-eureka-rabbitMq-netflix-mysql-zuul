package com.br.myfood.cadastro.service;

import com.br.myfood.cadastro.dto.ClientOrderDto;
import com.br.myfood.cadastro.dto.LoginDto;
import com.br.myfood.cadastro.entity.Client;
import com.br.myfood.cadastro.message.ClientSendMessage;
import com.br.myfood.cadastro.message.LoginSendMessage;
import com.br.myfood.cadastro.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientSendMessage clientSendMessage;
    private final LoginSendMessage loginSendMessage;


    @Autowired
    public ClientService(ClientRepository clientRepository, ClientSendMessage clientSendMessage, LoginSendMessage loginSendMessage) {
        this.clientRepository = clientRepository;
        this.clientSendMessage = clientSendMessage;
        this.loginSendMessage = loginSendMessage;
    }

    public Client insertClient(Client client){
        Client newClient =  clientRepository.save(client);
        clientSendMessage.sendMessage(new ClientOrderDto(newClient.getId()));
        loginSendMessage.sendMessage(new LoginDto(newClient.getEmail(), newClient.getPassword()));
        return newClient;
    }

    public Client updateClient(Client client){

        Optional<Client> newClient = clientRepository.findById(client.getId());

        if (newClient.isPresent()){
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
