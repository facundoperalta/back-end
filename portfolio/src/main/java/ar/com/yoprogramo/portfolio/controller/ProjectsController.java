package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.model.Projects;
import ar.com.yoprogramo.portfolio.service.IProjectsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectsController {
    
    @Autowired
    private IProjectsService projectsInterface;
    
    @GetMapping ("/get")
    public List<Projects> getProjects() {
        return projectsInterface.getProjects();
    }

    @PostMapping ("/create")
    public String createProjects(@RequestBody Projects projects) {
        projectsInterface.saveProjects(projects);
        return "Proyecto creado correctamente";
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteProjects (@PathVariable Long id) {
        projectsInterface.deleteProjects(id);
        return "Proyecto eliminado correctamente";
    }


    @PutMapping ("/edit/{id}")
    public Projects editProjects (@PathVariable Long id,
                                  @RequestParam ("project") String newProject,
                                  @RequestParam ("description") String newDescription,
                                  @RequestParam ("address") String newAdress,
                                  @RequestParam ("projectImage") String newImage) {
        
        Projects projects = projectsInterface.findProjects(id);
        
        projects.setProject(newProject);
        projects.setDescription(newDescription);
        projects.setAddress(newAdress);
        projects.setProjectImage(newImage);
        
        projectsInterface.saveProjects(projects);
        return projects;
    }
    
}
