package com.kamran.pma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kamran.pma.entities.Project;


@SpringBootTest
@RunWith(SpringRunner.class)

	      public class ProjectRepositoryIntegrationTest {

	@Autowired
	ProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSave_thenSuccess() {
		
		Project myProject = new Project("Paint the office", "INPROGRESS", "The office needs new painting");
		proRepo.save(myProject);
		
		assertEquals(5, proRepo.findAll().size());
	}
	
	
}
