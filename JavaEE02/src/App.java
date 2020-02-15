import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
        WhiteMage goodie=(WhiteMage)context.getBean("strongWMage");
        BlackMage badie=(BlackMage)context.getBean("strongBMage");
        goodie.intro();
        badie.intro();
        goodie.autcast();
        badie.autcast();
    }
}
