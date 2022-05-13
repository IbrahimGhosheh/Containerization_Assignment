package com.assignment.AnalyticsService.resources;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnalyticsRepository extends MongoRepository<Data, String> {

}


