
package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.dto.ExperienceDTO;
import ar.com.yoprogramo.portfolio.dto.Mensaje;
import ar.com.yoprogramo.portfolio.model.Experience;
import ar.com.yoprogramo.portfolio.service.IExperienceService;
import java.time.Year;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/experience")
public class ExperienceController {
    
    @Autowired
    private IExperienceService experienceInterface;
    
    @GetMapping ("/get")
    /*
    public List<Experience> getExperiences() {
        return experienceInterface.getExperiences();
    } */
    
    public ResponseEntity<List<Experience>> getExperiences(){
        List<Experience> list = experienceInterface.getExperiences();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping ("/create")
    /*
    public String createExperience(@RequestBody Experience experience) {
        experienceInterface.saveExperience(experience);
        return "Experiencia creada correctamente";
    } */
    
    public ResponseEntity<?> create(@RequestBody ExperienceDTO experienceDTO){
        Experience experience = new Experience(experienceDTO.getJob(), experienceDTO.getInstitution(), experienceDTO.getDescription(), experienceDTO.getStarted(), experienceDTO.getFinished(), experienceDTO.getLogoExp(), experienceDTO.getContinues());
        experienceInterface.saveExperience(experience);
        return new ResponseEntity(new Mensaje("Experiencia creada correctamente"), HttpStatus.OK);    
    }

    @DeleteMapping ("/delete/{id}")
    /*
    public String deleteExperience (@PathVariable Long id) {   
        experienceInterface.deleteExperience(id);
        return "Experiencia eliminada correctamente";
    } */
    
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        experienceInterface.deleteExperience(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada correctamente"), HttpStatus.OK);
    }

    @PutMapping ("/edit/{id}")
    /*
    public Experience editExperience (@PathVariable Long id,
                                      @RequestParam ("job") String newJob,
                                      @RequestParam ("institution") String newInstitution,
                                      @RequestParam ("description") String newDescription,
                                      @RequestParam ("started") Year newStarted,
                                      @RequestParam ("finished") Year newFinished,
                                      @RequestParam ("logoExp") String newLogoExp,
                                      @RequestParam ("continues") Boolean newContinues) {       
        Experience experience = experienceInterface.findExperience(id);
        experience.setJob(newJob);
        experience.setInstitution(newInstitution);
        experience.setDescription(newDescription);
        experience.setStarted(newStarted);
        experience.setFinished(newFinished);
        experience.setLogoExp(newLogoExp);
        experience.setContinues(newContinues);
        experienceInterface.saveExperience(experience);
        return experience;
    } */
    
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ExperienceDTO experienceDTO){
        Experience experience = experienceInterface.findExperience(id);
        experience.setJob(experienceDTO.getJob());
        experience.setInstitution(experienceDTO.getInstitution());
        experience.setDescription(experienceDTO.getDescription());
        experience.setStarted(experienceDTO.getStarted());
        experience.setFinished(experienceDTO.getFinished());
        experience.setLogoExp(experienceDTO.getLogoExp());
        experience.setContinues(experienceDTO.getContinues());
        experienceInterface.saveExperience(experience);
        return new ResponseEntity(new Mensaje("Información sobre experiencia actualizada"), HttpStatus.OK);
    } 
}
