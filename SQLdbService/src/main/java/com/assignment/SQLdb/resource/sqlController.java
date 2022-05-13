package com.assignment.SQLdb.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;

@Controller
public class sqlController {
    DBModel db = new DBModel();
    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("getAge")
    public ResponseEntity<String> getAge(@ModelAttribute("age") int age){
        db.storeAge(age);
        restTemplate.getForObject("http://analytics-service:8083/analytics",String.class);
        return new ResponseEntity<>("done", HttpStatus.OK);

    }
    @RequestMapping("getAllAges")
    public ResponseEntity<ArrayList<Integer>> getAllAges(){
        ArrayList<Integer> ages = db.getAges();
        return new ResponseEntity<>(ages,HttpStatus.OK);

    }
}
