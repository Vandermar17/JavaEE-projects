package starter;

import library.SimpleS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class MyStarterClient {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MyStarterClient.class, args);

        SimpleS mySimpleC = applicationContext.getBean(SimpleS.class);
        mySimpleC.puts();

        SimpleS mySimple = (SimpleS) applicationContext.getBean("SimpleS");
        mySimple.puts();
    }
}
