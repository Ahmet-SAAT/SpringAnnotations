package com.tpe.repository;

import com.tpe.domain.Message;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class FileRepository implements Repo{
    @Override
    public void save(Message message) {
        System.out.println("Mesajiniz dosya`ya kaydediliyor.Mesajiniz = "+message.getMessage() );

    }
}
