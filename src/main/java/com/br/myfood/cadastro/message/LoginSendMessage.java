package com.br.myfood.cadastro.message;

import com.br.myfood.cadastro.dto.ClientOrderDto;
import com.br.myfood.cadastro.dto.LoginDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginSendMessage {

    @Value("${cadastro.rabbitmq.exchange}")
    private String exchange;
    @Value("${cadastro.login.rabbitmq.routingkey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public LoginSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(LoginDto loginDto){
        System.out.println(loginDto);
        System.out.println(exchange);
        System.out.println(routingKey);
        rabbitTemplate.convertAndSend(exchange,routingKey,loginDto);
    }
}
