
package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.model.Experience;
import ar.com.yoprogramo.portfolio.service.IExperienceService;
import java.time.Year;
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
@RequestMapping("/api/experience")
public class ExperienceController {
    
    @Autowired
    private IExperienceService experienceInterface;
    
    @GetMapping ("/get")
    public List<Experience> getExperiences() {

        return experienceInterface.getExperiences();
    }

    @PostMapping ("/create")
    public String createExperience(@RequestBody Experience experience) {
    
        experienceInterface.saveExperience(experience);
        return "Experience creada correctamente";
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteExperience (@PathVariable Long Id) {
    
        experienceInterface.deleteExperience(Id);
        return "Experience eliminada correctamente";
    }


    @PutMapping ("/edit/{id}")
    public Experience editExperience (@PathVariable Long id,
                                      @RequestParam ("job") String newJob,
                                      @RequestParam ("institution") String newInstitution,
                                      @RequestParam ("description") String newDescription,
                                      @RequestParam ("started") Year newStarted,
                                      @RequestParam ("finished") Year newFinished,
                                      @RequestParam ("logoExp") String newlogoExp,
                                      @RequestParam ("continues") Boolean newContinues) {
        
        Experience experience = experienceInterface.findExperience(id);
        
        experience.setJob(newJob);
        experience.setInstitution(newInstitution);
        experience.setDescription(newDescription);
        experience.setStarted(newStarted);
        experience.setFinished(newFinished);
        experience.setLogoExp(newlogoExp);
        experience.setContinues(newContinues);
        
        experienceInterface.saveExperience(experience);
        return experience;
    }

    
}
