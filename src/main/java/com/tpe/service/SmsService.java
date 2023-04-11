package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component("smsservice")//kendimiz component isim verebiliriz
public class SmsService implements MessageService{
    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir sms servisiyim.Mesajiniz gonderildi.Mesajiniz = "+message.getMessage());

    }

    @Override
    public void saveMessage(Message message) {
        System.out.println("Ben bir sms servisiyim.Mesajiniz kaydedildi.Mesajiniz = "+message.getMessage());

    }
}
