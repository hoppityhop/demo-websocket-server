package com.example.demo.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data


public class Message {

    private String senderName;
    private String receiverName;

    private String messageContent;

    private Date date;

}
