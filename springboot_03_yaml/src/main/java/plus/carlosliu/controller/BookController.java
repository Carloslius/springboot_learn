package plus.carlosliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.carlosliu.MyDateSource;

// Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${city}")
    private String city1;
    @Value("${server.port}")
    private int port1;
    @Value("${users[1].name}")
    private String name1;
    @Value("${tempDir}")
    private String tempDir1;
    @Value("${tempDir2}")
    private String tempDir2;

    @Autowired
    private Environment environment;

    @Autowired
    private MyDateSource dateSource;

    @GetMapping
    public String getById(){
        System.out.println("springboot is running...yaml");
        System.out.println("city1====>>" + city1);
        System.out.println("port1====>>" + port1);
        System.out.println("name1====>>" + name1);
        System.out.println("tempDir1====>>" + tempDir1);
        System.out.println("tempDir2====>>" + tempDir2);
        System.out.println("-------------------------------");
        System.out.println(environment.getProperty("users[0].name"));
        System.out.println(environment.getProperty("tempDir2"));
        System.out.println("-------------------------------");
        System.out.println(dateSource);
        return "springboot is running...yaml";
    }
}
