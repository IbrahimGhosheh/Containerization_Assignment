package com.example.enterdata.resources;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/login")
public class EnterDataController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/now")
    public String authenticate(@ModelAttribute("ID") int id ,@ModelAttribute("password") int pass, Model model){

        String response = restTemplate.getForObject("http://authentication-service:8081/authenticate?ID="+id+"&password="+pass,String.class);

        if(response.equals("ok")){
            return "GetData";
        }

        return "LoginFailed";
    }
    @GetMapping("/data")
    public String sendData(@ModelAttribute("age") int age){

        restTemplate.getForObject("http://sql-service:8082/getAge?age="+age,String.class);
        return "GetData";
    }
}
