package springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    String home(){
        return "Hello";
    }

    @RequestMapping("/test")
    String home1(){
        return "Hello1";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
