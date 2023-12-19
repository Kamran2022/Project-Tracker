package com.kamran.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamran.pma.dao.EmployeeRepository;
import com.kamran.pma.dao.ProjectRepository;
import com.kamran.pma.dto.TimeChartData;
import com.kamran.pma.entities.Employee;
import com.kamran.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {


	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> project = proRepo.findAll();
		model.addAttribute("projects", project);
		return "projects/list-projects";
				}
	
	
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employee = empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employee);
		
		return "projects/new-project";
	}
	
	
	
	
	@PostMapping("/save")
	public String createProject(Project project,  Model model) {
		//this should handle saving to the database
		proRepo.save(project);
		
	 
		//use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
	
	@GetMapping("/timelines")
	public String displayProjectTimelines(Model model) throws JsonProcessingException {
		
		List<TimeChartData> timelineData = proRepo.getTimeDate();
		
		ObjectMapper objectMapper = new ObjectMapper();
			String jsonTimlineString =	objectMapper.writeValueAsString(timelineData);
		
		System.out.println("-----project timeline------");
		System.out.println(jsonTimlineString);
		
		model.addAttribute("projectTimeList", jsonTimlineString);
		
		return "projects/project-timelines";
		
	}
	
}
