package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.Education;
import java.util.List;

public interface IEducationService {
    
    public List<Education> getEducations();
    
    public void saveEducation(Education education);
    
    public void deleteEducation(Long id);
    
    public Education findEducation(Long id);
    
}
