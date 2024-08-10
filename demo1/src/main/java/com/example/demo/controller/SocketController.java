package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import com.example.demo.model.Message;

@Controller
public class SocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message-simple-string")
    @SendTo("/chatroom/public")
    public Message receivePublicSimpleString(String message) {
        Message messageToReturn = new Message();
        messageToReturn.setMessageContent(message);

        System.out.println("Simple string received: " + message);
        return messageToReturn;
    }

    @MessageMapping("/message-simple-direct-response")
    public Message receivePublicSimpleStringDirectResponse(String message) {
        Message messageToReturn = new Message();
        messageToReturn.setMessageContent(message);

        System.out.println("Simple string received: " + message);
        return messageToReturn;
    }

    @SubscribeMapping("/faketopic")
    public Message fakeTopic() {
        Message message = new Message();
        message.setMessageContent("This is a fake topic message");
        return message;
    }


}
