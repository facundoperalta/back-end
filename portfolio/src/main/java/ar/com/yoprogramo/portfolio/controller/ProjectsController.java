package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.dto.Mensaje;
import ar.com.yoprogramo.portfolio.dto.ProjectsDTO;
import ar.com.yoprogramo.portfolio.model.Projects;
import ar.com.yoprogramo.portfolio.service.IProjectsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontend-arprog.web.app")
@RequestMapping("/api/projects")
public class ProjectsController {
    
    @Autowired
    private IProjectsService projectsInterface;
    
    @GetMapping ("/get")
    /*
    public List<Projects> getProjects() {
        return projectsInterface.getProjects();
    } */
    
    public ResponseEntity<List<Projects>> getProjects(){
        List<Projects> list = projectsInterface.getProjects();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/create")
    /*
    public String createProjects(@RequestBody Projects projects) {
        projectsInterface.saveProjects(projects);
        return "Proyecto creado correctamente";
    } */
    
    public ResponseEntity<?> create(@RequestBody ProjectsDTO projectsDTO){
        Projects projects = new Projects(projectsDTO.getProject(), projectsDTO.getDescription(), projectsDTO.getAddress(), projectsDTO.getProjectImage());
        projectsInterface.saveProjects(projects);
        return new ResponseEntity(new Mensaje("Proyecto creado correctamente"), HttpStatus.OK);    
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    /*
    public String deleteProjects (@PathVariable Long id) {
        projectsInterface.deleteProjects(id);
        return "Proyecto eliminado correctamente";
    } */
    
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        projectsInterface.deleteProjects(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/edit/{id}")
    /*
    public Projects editProjects (@PathVariable Long id,
                                  @RequestParam ("project") String newProject,
                                  @RequestParam ("description") String newDescription,
                                  @RequestParam ("address") String newAdress,
                                  @RequestParam ("projectImage") String newProjectImage) {
        Projects projects = projectsInterface.findProjects(id);  
        projects.setProject(newProject);
        projects.setDescription(newDescription);
        projects.setAddress(newAdress);
        projects.setProjectImage(newProjectImage);
        projectsInterface.saveProjects(projects);
        return projects;
    } */
    
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ProjectsDTO projectsDTO){
        Projects projects = projectsInterface.findProjects(id);  
        projects.setProject(projectsDTO.getProject());
        projects.setDescription(projectsDTO.getDescription());
        projects.setAddress(projectsDTO.getAddress());
        projects.setProjectImage(projectsDTO.getProjectImage());

        projectsInterface.saveProjects(projects);
        return new ResponseEntity(new Mensaje("Proyecto actualizado correctamente"), HttpStatus.OK);
    }    
}
