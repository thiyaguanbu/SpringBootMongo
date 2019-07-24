package com.perfm.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.perfm.services.model.User;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String>{

}
