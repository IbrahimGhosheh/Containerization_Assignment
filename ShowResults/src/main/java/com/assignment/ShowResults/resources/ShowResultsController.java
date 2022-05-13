package com.assignment.ShowResults.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/login")
public class ShowResultsController {
    RestTemplate restTemplate = new RestTemplate();
    ResultsRepository resultsRepository;

    public ShowResultsController(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    @GetMapping("/now")
    public ModelAndView authenticate(@ModelAttribute("ID") int id , @ModelAttribute("password") int pass){

        String response = restTemplate.getForObject("http://authentication-service:8081/authenticate?ID="+
                id+"&password="+pass,String.class);
        ModelAndView modelAndView = new ModelAndView();
        if(response.equals("ok")){
           ArrayList<Data> data = (ArrayList<Data>) resultsRepository.findAll();
            modelAndView.setViewName("ShowData");
            modelAndView.addObject(data.get(0).getName(),data.get(0).getValue());
            modelAndView.addObject(data.get(1).getName(),data.get(1).getValue());
            modelAndView.addObject(data.get(2).getName(),data.get(2).getValue());
            return modelAndView;
        }
        modelAndView.setViewName("LoginFailed");
        return modelAndView;
    }
}