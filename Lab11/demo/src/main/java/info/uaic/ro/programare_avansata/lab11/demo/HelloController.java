package info.uaic.ro.programare_avansata.lab11.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Greetings from Spring Boot!";
    }
}
