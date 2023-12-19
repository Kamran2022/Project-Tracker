package com.kamran.pma.entities;

import java.sql.Date;
import java.util.ArrayList;

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
import jakarta.validation.constraints.NotNull;

@Entity
public class Project {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
	 @SequenceGenerator(name="project_seq", sequenceName = "project_seq", allocationSize = 1)
	private long projectId;
	
	private String name;
	private String stage;  //NOT STARTED, COMPLETED, INPROGRESS
	private String description;
	
	 @NotNull(message = "*Provide a starting date")
	private Date startDate;
	 @NotNull(message = "*Provide an ending date")
	private Date endDate;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST},
            fetch = FetchType.LAZY)
	@JoinTable(name="project_employee", 
	           joinColumns= @JoinColumn(name="project_id"),
	             inverseJoinColumns = @JoinColumn(name= "employee_id"))
	private List<Employee> employees;
	
	
	
	
	public Project() {
		
	}
	
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	
	
	public List<Employee> getEmployees() {
		return employees;
	}




	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
	

	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
    public String getDescription() {
		return description;
	}
    public void setDescription(String description) {
		this.description = description;
	}
    
  //Convenience Method
  	public void addEmployee(Employee emp) {
  		if(employees == null) {
  			employees = new ArrayList<>();
  			
  		}
  		employees.add(emp);
  	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
		
		
	
	
}
