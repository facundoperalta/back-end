package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.model.Education;
import ar.com.yoprogramo.portfolio.service.IEducationService;
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
@RequestMapping("/api/education")
public class EducationController {
    
    @Autowired
    private IEducationService educationInterface;
    
    @GetMapping ("/get")
    public List<Education> getEducations() {

        return educationInterface.getEducations();
    }

    @PostMapping ("/create")
    public String createEducation(@RequestBody Education education) {
        
        educationInterface.saveEducation(education);
        return "Educación creada correctamente";
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteEducation (@PathVariable Long Id) {
        
        educationInterface.deleteEducation(Id);
        return "Educación fue eliminada correctamente";
    }


    @PutMapping ("/edit/{id}")
    public Education editEducation (@PathVariable Long Id,
                                    @RequestParam ("degree") String newDegree,
                                    @RequestParam ("year") Year newYear,
                                    @RequestParam ("institution") String newInstitution,
                                    @RequestParam ("finished") Boolean newFinished,
                                    @RequestParam ("logoEdu") String newLogoEdu) {
        
        Education education = educationInterface.findEducation(Id);
        
        education.setDegree(newDegree);
        education.setYear(newYear);
        education.setInstitution(newInstitution);
        education.setFinished(newFinished);
        education.setLogoEdu(newLogoEdu);
        
        educationInterface.saveEducation(education);
        
        return education;
    }

    
}
