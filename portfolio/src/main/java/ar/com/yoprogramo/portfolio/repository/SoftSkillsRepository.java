package ar.com.yoprogramo.portfolio.repository;

import ar.com.yoprogramo.portfolio.model.SoftSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillsRepository extends JpaRepository<SoftSkills, Long> {
    
}
