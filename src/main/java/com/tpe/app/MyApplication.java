package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Spring ile uygulama gelistirmek harika");

        //config classini okumak gerekiyor
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        //config clasindaki component scani ile tum componentleri tarayacak.
        // Her componentdan bir tane bean olusturacak.Contextte hazirda bekletecek.
        //Bean istedigimizde icrisindeki gereli bagimliliklari olusturup bize sunacak.


        MessageService service = context.getBean(MailService.class);//mailservice objesi olusacak
        service.sendMessage(message);

        //newleme yapmadik spring containerdan rica ettik bize hazir getirdi.IOC
        //IOC inversion of control->kontrolun terse cevrilmesi yani springe birakilmasi

        MessageService service1 = context.getBean(SmsService.class);
        service1.sendMessage(message);
        //getbean(MessageService.class) interface yazarsak ne olur?
        //MessageService intefaceini implement eden bir tane ise onu verir.Birden fazla ise exception verir.
        //bu durumda hangisini istedigimizi bildirebiliriz.
        // Bunun icin secegimiz classi cagirmak icin o classin component icine name yazmali ve bu namei getbeane eklemeliyiz.
        MessageService service2 = context.getBean("smsservice", MessageService.class);
        service2.sendMessage(message);

        MessageService service3=context.getBean(MailService.class);//mailservice ve DbRepo newlenmeden geldi.
        service3.sendMessage(message);
        service3.saveMessage(message);
        //enjekte edilecek obje sayisi birden fazla ise qualifier ile isim verilip belirtilmelidir.(camelcase)


        //Random random=new Random();// bizim icin spring olustursun
        Random random=context.getBean(Random.class);//Random.class AppConf icinde @Bean altinda yer alan bir method
        System.out.println(random.nextInt(100));

       //contexte 1 tane obje olusur.Tst edelim 2 farkli olusturdum ayni mi bunlar?

        MessageService service4=context.getBean(MailService.class);
        MessageService service5=context.getBean(MailService.class);
      //Spring beanleri scope default:singleton
        //singleton:tm uygulama icinde sadece tek bir bean olusur
//prototype:her obje istendiginde yeni bir bean olusturulur/Clasta @Scope icine prototype yazilir.

        if (service4==service5){
            System.out.println("ayni referansli objeler");
            System.out.println(service4);
            System.out.println(service5);
        } else  {
            System.out.println("farkli referansli");
            System.out.println(service4);
            System.out.println(service5);
        }

        context.close();//contextden artik obje isteyemeyeiz.getbean hata verir.
        //cunku contex container icerisinde ve kapatildiginda beanler de sonlandirilir.





    }
}
