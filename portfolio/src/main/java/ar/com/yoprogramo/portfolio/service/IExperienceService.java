package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.Experience;
import java.util.List;

public interface IExperienceService {
    
    public List<Experience> getExperiences();
    
    public void saveExperience(Experience experience);
    
    public void deleteExperience(Long id);
    
    public Experience findExperience(Long id);
    
}
