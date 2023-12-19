package com.kamran.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kamran.pma.dto.EmployeeProject;
import com.kamran.pma.entities.Employee;

@RepositoryRestResource(collectionResourceRel="apiemployees", path="apiemployees")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount "
			+ "FROM employee e left join project_employee pe on pe.employee_id = e.employee_id "
			+ "GROUP By e.first_name, e.last_name ORDER BY 3 Desc" )
	public List<EmployeeProject> employeeProject();

	
	
}

