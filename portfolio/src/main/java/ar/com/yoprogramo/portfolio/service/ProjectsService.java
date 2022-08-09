package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.Projects;
import ar.com.yoprogramo.portfolio.repository.ProjectsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService implements IProjectsService{
    
    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public List<Projects> getProjects() {
        List<Projects> projectsList = projectsRepository.findAll();
        return projectsList;
    }

    @Override
    public void saveProjects(Projects projects) {
        projectsRepository.save(projects);
    }

    @Override
    public void deleteProjects(Long id) {
        projectsRepository.deleteById(id);
    }

    @Override
    public Projects findProjects(Long id) {
        Projects projects = projectsRepository.findById(id).orElse(null);
        return projects;
    }
    
}
