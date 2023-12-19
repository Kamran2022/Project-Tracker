package com.kamran.pma.entities;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	 @SequenceGenerator(name="employee_seq", sequenceName = "employee_seq", allocationSize = 1)
	private long employeeId;
	

	@NotBlank(message=" *first name required")
	@Size(min=2, max=20)
	private String firstName;
	
	@NotBlank(message=" *last name required")
	@Size(min=2, max=20)
	private String lastName;
	
	@NotBlank(message=" *valid email required")
	@Email
	private String email;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST},
	                       fetch = FetchType.LAZY)
	@JoinTable(name="project_employee", 
    joinColumns= @JoinColumn(name="employee_id"),
      inverseJoinColumns = @JoinColumn(name= "project_id"))
	private List<Project> theProjects;
	
	
	
	public Employee() {
		
	}
	
	
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
	
	


	public List<Project> getProjects() {
		return theProjects;
	}



	public void setProjects(List<Project> theProjects) {
		this.theProjects = theProjects;
	}



	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
	
	

