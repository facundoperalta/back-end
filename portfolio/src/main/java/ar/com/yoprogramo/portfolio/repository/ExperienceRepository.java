package ar.com.yoprogramo.portfolio.repository;

import ar.com.yoprogramo.portfolio.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    
}
