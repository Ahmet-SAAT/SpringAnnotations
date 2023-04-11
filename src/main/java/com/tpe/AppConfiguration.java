package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration//bu classda configuration yapilacak
@ComponentScan("com.tpe")//com.tpe packagedeki componentlari tara,"com.tpe" yazmassa
// default da yani bu clasım hangi package icindeyse onu verır.Burada  "com.tpe"dir
public class AppConfiguration {

@Bean//random clasindan bir tane bean olusturuyor
    public Random random(){
    return new Random();
};


}



//neden resource altinda yapmadik .Cunku xml bazli degil kod bazli