package com.assignment.ShowResults.resources;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultsRepository extends MongoRepository<Data, String> {

}
