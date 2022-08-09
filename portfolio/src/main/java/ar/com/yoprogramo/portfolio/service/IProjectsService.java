package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.Projects;
import java.util.List;

public interface IProjectsService {
    
    public List<Projects> getProjects();
    
    public void saveProjects(Projects projects);
    
    public void deleteProjects(Long id);
    
    public Projects findProjects(Long id);
    
}
