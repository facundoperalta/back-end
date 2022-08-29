package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.dto.EducationDTO;
import ar.com.yoprogramo.portfolio.dto.Mensaje;
import ar.com.yoprogramo.portfolio.model.Education;
import ar.com.yoprogramo.portfolio.service.IEducationService;
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
@RequestMapping("/api/education")
public class EducationController {
    
    @Autowired
    private IEducationService educationInterface;
    
    @GetMapping ("/get")
    /*
    public List<Education> getEducations() {
        return educationInterface.getEducations();
    }*/
    
    public ResponseEntity<List<Education>> getEducations(){
        List<Education> list = educationInterface.getEducations();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/create")
    /*
    public String createEducation(@RequestBody Education education) {
        educationInterface.saveEducation(education);
        return "Educación creada correctamente";
    } */
    
    public ResponseEntity<?> create(@RequestBody EducationDTO educationDTO){
        Education education = new Education(educationDTO.getDegree(), educationDTO.getYear(), educationDTO.getInstitution(), educationDTO.getFinished(), educationDTO.getLogoEdu());
        educationInterface.saveEducation(education);
        return new ResponseEntity(new Mensaje("Educación creada correctamente"), HttpStatus.OK);    
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    /*
    public String deleteEducation (@PathVariable Long id) {       
        educationInterface.deleteEducation(id);
        return "Educación fue eliminada correctamente";
    } */
    
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        educationInterface.deleteEducation(id);
        return new ResponseEntity(new Mensaje("Educación eliminada correctamente"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/edit/{id}")
    /*
    public Education editEducation (@PathVariable Long id,
                                    @RequestParam ("degree") String newDegree,
                                    @RequestParam ("year") Year newYear,
                                    @RequestParam ("institution") String newInstitution,
                                    @RequestParam ("finished") Boolean newFinished,
                                    @RequestParam ("logoEdu") String newLogoEdu) {       
        Education education = educationInterface.findEducation(id);
        education.setDegree(newDegree);
        education.setYear(newYear);
        education.setInstitution(newInstitution);
        education.setFinished(newFinished);
        education.setLogoEdu(newLogoEdu);
        educationInterface.saveEducation(education);
        return education;
    } */
    
     public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody EducationDTO educationDTO){
        Education education = educationInterface.findEducation(id);
        education.setDegree(educationDTO.getDegree());
        education.setYear(educationDTO.getYear());
        education.setInstitution(educationDTO.getInstitution());
        education.setFinished(educationDTO.getFinished());
        education.setLogoEdu(educationDTO.getLogoEdu());
        educationInterface.saveEducation(education);
        return new ResponseEntity(new Mensaje("Información sobre Educación actualizada"), HttpStatus.OK);
    }
}
