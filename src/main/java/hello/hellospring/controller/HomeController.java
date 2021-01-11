package hello.hellospring.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //우선순위 컨트롤러 확인후 index.html을 찾는다.
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
