package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration//bu classda configuration yapilacak
@ComponentScan("com.tpe")//com.tpe packagedeki componentlari tara,"com.tpe" yazmassa
@PropertySource("classpath:application.properties")//proportiesdeki verileri okumasi icin kaydettik
// default da yani bu clasım hangi package icindeyse onu verır.Burada  "com.tpe"dir
public class AppConfiguration {

    @Autowired
    private Environment environment;
    //application.properties dosyasi icindeki bilgilere ulasmak icin
    // springin environment isimli interfacei kullanilir


@Bean//random clasindan bir tane bean olusturuyor
    public Random random(){
    return new Random();
};


    //value ile yaptigimizi properties clasi ile de yapabilriz.Yani degiskenleri bir dosyadan da okuyabilir
@Bean
public Properties properties(){
    Properties properties=new Properties();
    properties.put("mymail",environment.getProperty("app.email"));
    //application.properties dosyasi icindeki bilgilere ulasmak icin
    // springin environment isimli interfacei kullanilir
    //proporties ayrica uygulamanin calistigi tum ortam degiskenlerine ulasmak icin kullanilabilir.
    properties.put("myjavahome",environment.getProperty("JAVA_HOME"));
return properties;
}



}

//obje olusturmak icin bean enjekte etmek icin autowired


//neden resource altinda yapmadik .Cunku xml bazli degil kod bazli