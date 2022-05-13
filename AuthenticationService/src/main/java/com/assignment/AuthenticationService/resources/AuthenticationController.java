package com.assignment.AuthenticationService.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @GetMapping("authenticate")
    public ResponseEntity<String> Authenticate(@ModelAttribute("ID") int id , @ModelAttribute("password") int pass){
        if(id == 123 && pass == 123) {
            return new ResponseEntity<>("ok", HttpStatus.OK);}
        return  new ResponseEntity<>("no", HttpStatus.OK);

    }
}
