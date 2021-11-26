package plus.carlosliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import plus.carlosliu.controller.BookController;

@SpringBootApplication
public class Springboot0101QuickstartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot0101QuickstartApplication.class, args);
        BookController bean = run.getBean(BookController.class);
        System.out.println("bean=======>>" + bean);
        User user = run.getBean(User.class);
        System.out.println("user=======>>" + user);
    }

}
