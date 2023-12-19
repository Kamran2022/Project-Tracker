package com.kamran.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamran.pma.dao.EmployeeRepository;
import com.kamran.pma.dao.ProjectRepository;
import com.kamran.pma.dto.ChartData;
import com.kamran.pma.dto.EmployeeProject;
import com.kamran.pma.entities.Employee;
import com.kamran.pma.entities.Project;

@Controller
public class HomeController {

	@Value("${version}")
	private String var;
	
	
	@Autowired
	ProjectRepository proRepo;

	@Autowired
	EmployeeRepository EmpRepo;
	


	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {

		
		model.addAttribute("versionNumber", var);
		
		Map<String, Object> map = new HashMap<>();

		
		
		//  querying the database for projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("MyProjects", projects);
		
		  List<ChartData> projectData = proRepo.getProjectStatus();
		  
		  //convert projectData object into a Json structure for use in JavaScript
		 ObjectMapper objectMapper = new ObjectMapper(); 
		
		 String jsonString = objectMapper.writeValueAsString(projectData);
		 //[["NOTSTARTED", 1], ["INPROGERESS", 2], ["COMPLETED", 1]]
		
		 model.addAttribute("projectStatusCnt", jsonString);
		

		//  querying the database for employees
		List<EmployeeProject> employeesProjectsCnt = EmpRepo.employeeProject();
		model.addAttribute("employeesListProjectCnt", employeesProjectsCnt);

		return "main/home";

	}

}
