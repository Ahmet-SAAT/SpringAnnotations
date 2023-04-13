package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//bu classtan springin obje uretmesini istiyoruz
@Scope("prototype") //scope degisire objeler farkli olur
public class MailService implements MessageService {
    @PostConstruct//classtan obje uretildikten hemen sonra bu method cagrilir
    public void init(){
        System.out.println("mailservice objesi olusturuluyor");
    }

    @PreDestroy//obje oldurulmesinden hemen once bu metod gelir
    public void destroy(){
        System.out.println("mailservice objesi sonlandirildi");
    }

    //  FIELD INJECTION

   /* @Autowired//reponun objesini bu classa enjekte ediyor.(DI)
    //yani mailservice objesi olustugu anda repoda buna enjekte edilmis olacak
    @Qualifier("fileRepository")//hangisini enjekte edecegimizi soyledik
    private Repo repo;*/
//private degeri nasil setter olmadan kullandik.String bunu reflection ile sagladi

    //SETTER INJEKTION

  /*  private Repo repo;
    @Autowired//fieldi enjekte et ama ederken seti kullan
    @Qualifier("fileRepository")
    public void setRepo(Repo repo) {
        this.repo = repo;
    }
*/

    //CONSTRUCTOR ENJECTION
    //burada fark olarak @qualifier parametre olarak verilmeli
    private Repo repo;
    @Autowired//classin birtane consu varsa cons enjekstionda autowired anat zorunlu degildir.
    public MailService(@Qualifier("fileRepository")Repo repo) {
        this.repo = repo;
    }



    /*
    once hangi injection tercih edilmelidir
    -constuctor injection oncelikle tercih edilmelidir.
    -cunku paametre ile obje olusur ve  setter yoksa daha sonra degisemeyecegi icin guvenlidir.
    -parametrede enjete edilen acikca goruleceginden okunabilirdir.
    -ayrica test etme asamasi daha kolay olacak.
    -Ama field ve setter injektionda kullanilabilir.

     */




    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim.Mesajiniz gonderildi.Mesajiniz = "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //reponun methodu icin objesine ihtiyac var
        repo.save(message);
    }
}
