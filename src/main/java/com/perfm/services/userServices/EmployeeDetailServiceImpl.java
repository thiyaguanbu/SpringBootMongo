package com.perfm.services.userServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.perfm.services.model.EmployeeDetail;
import com.perfm.services.repository.EmployeeDetailRepository;

public class EmployeeDetailServiceImpl implements EmployeeDetailService {

	@Autowired
	EmployeeDetailRepository employeeRepo;
	
	@Override
	public List<EmployeeDetail> getAllEmployeeDetails() {
		List<EmployeeDetail> employeeList = employeeRepo.findAll();
		return employeeList;
	}

	
}
