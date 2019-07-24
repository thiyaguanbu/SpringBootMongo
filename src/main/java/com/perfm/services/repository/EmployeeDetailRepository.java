package com.perfm.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.perfm.services.model.EmployeeDetail;

@Repository
public interface EmployeeDetailRepository extends MongoRepository<EmployeeDetail, String> {

}
