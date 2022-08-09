package ar.com.yoprogramo.portfolio.repository;

import ar.com.yoprogramo.portfolio.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    
}
