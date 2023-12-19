package com.kamran.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kamran.pma.dto.ChartData;
import com.kamran.pma.dto.TimeChartData;
import com.kamran.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel="apiprojects", path="apiprojects")
public interface ProjectRepository extends CrudRepository<Project, Long> {
  
	@Override
	public List<Project> findAll();

	
	@Query(nativeQuery=true, value="SELECT stage AS label, COUNT(*) AS \"value\" " +
			"FROM project " +
			"GROUP BY stage")
			public List<ChartData> getProjectStatus();
        
        @Query(nativeQuery=true, value="SELECT name as projectName, start_date as startDate, end_date as endDate "
        		+ "FROM project")
        public List<TimeChartData> getTimeDate(); 


	
}