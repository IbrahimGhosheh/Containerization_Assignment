package com.assignment.AnalyticsService.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnalyticsController {
    RestTemplate restTemplate = new RestTemplate();
    AnalyticsRepository analyticsRepository;

    public AnalyticsController(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    @RequestMapping("analytics")
    public ResponseEntity<ArrayList<Integer>> getAnalytics(){
        ArrayList<Integer> ages = (ArrayList<Integer>) restTemplate.getForObject
                ("http://sql-service:8082/getAllAges", List.class);

        ArrayList<Integer> analyzed = Analytics.analyze(ages);
        Data d1 = new Data("max",analyzed.get(0));
        Data d2 = new Data("min",analyzed.get(1));
        Data d3 = new Data("avg",analyzed.get(2));

        analyticsRepository.save(d1);
        analyticsRepository.save(d2);
        analyticsRepository.save(d3);
        return new ResponseEntity<>(Analytics.analyze(ages), HttpStatus.OK);
    }
}
