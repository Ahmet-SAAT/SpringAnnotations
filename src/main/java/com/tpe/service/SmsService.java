package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;


@Component("smsservice")//kendimiz component isim verebiliriz
public class SmsService implements MessageService{

    @PostConstruct//classtan obje uretildikten hemen sonra bu method cagrilir
    public void init(){
        System.out.println("smsservice objesi olusturuluyor");
    }

    @PreDestroy//obje oldurulmesinden hemen once bu metod gelir
    public void destroy(){
        System.out.println("smsservice objesi sonlandirildi");
    }

    @Autowired
   private Random random;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir sms servisiyim.Mesajiniz gonderildi.Mesajiniz = "+message.getMessage());
        System.out.println("random sayi : "+random.nextInt(100));
    }

    @Override
    public void saveMessage(Message message) {
        System.out.println("Ben bir sms servisiyim.Mesajiniz kaydedildi.Mesajiniz = "+message.getMessage());

    }

    //degiskenlelerin degerlerini uygulamamizin disindan vermek istersek
    @Value("${app.email}")
    private String email;
    @Value("${app.phone}")//bilgiler resources altindaki application.properties dosyasinda key value seklinde
    private String phone;

    public  void printContact(){
 /*       System.out.println("email: email@gmail.com");
        System.out.println("phone number : 0123548756");*/
        System.out.println("email: "+email+"----"+"phone: "+phone);
    }

    @Autowired
private Properties properties;
    public void printProperties(){
        System.out.println("contact email: "+properties.getProperty("mymail"));
        System.out.println("Java Home "+properties.getProperty("JAVA_HOME"));
    }




}
