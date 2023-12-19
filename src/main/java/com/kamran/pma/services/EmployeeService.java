package com.kamran.pma.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.kamran.pma.dao.EmployeeRepository;

public class EmployeeService {

	
	//field Injection
    //@Autowired
	StaffRepository empRepo;
	
	//constructor Injection
	public EmployeeService(StaffRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}
	
	//setter Injection
	//@Autowired
	//public void setEmpRespo(EmployeeRepository empRepo) {
		//this.empRepo = empRepo;
	//}
}
