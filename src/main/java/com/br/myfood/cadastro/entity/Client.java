package com.br.myfood.cadastro.entity;

import com.br.myfood.cadastro.dto.ClienteDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String password;

    public static Client create(ClienteDto clienteDto){
        return new ModelMapper().map(clienteDto, Client.class);
    }
}
