package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.Experience;
import ar.com.yoprogramo.portfolio.repository.ExperienceRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService implements IExperienceService{
    
    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<Experience> getExperiences() {
        List<Experience> experienceList = experienceRepository.findAll();
        return experienceList;
        
    }

    @Override
    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        return experience;
    }
    
}
