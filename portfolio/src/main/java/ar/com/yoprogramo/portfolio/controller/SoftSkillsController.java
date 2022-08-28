package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.dto.Mensaje;
import ar.com.yoprogramo.portfolio.dto.SoftSkillsDTO;
import ar.com.yoprogramo.portfolio.model.SoftSkills;
import ar.com.yoprogramo.portfolio.service.ISoftSkillsService;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/softskills")
public class SoftSkillsController {
    
    @Autowired
    private ISoftSkillsService softSkillsInterface;
    
    @GetMapping ("/get")
    /*
    public List<SoftSkills> getSoftSkills() {
        return softSkillsInterface.getSoftSkills();
    } */
    public ResponseEntity<List<SoftSkills>> getSoftSkills(){
        List<SoftSkills> list = softSkillsInterface.getSoftSkills();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/create")
    /*
    public String createSoftSkills(@RequestBody SoftSkills softSkills) {
        softSkillsInterface.saveSoftSkills(softSkills);
        return "Habilidad creada correctamente";
    } */
    
    public ResponseEntity<?> create(@RequestBody SoftSkillsDTO softSkillsDTO){
        SoftSkills softSkills = new SoftSkills(softSkillsDTO.getSoftSkill(), softSkillsDTO.getMastery());
        softSkillsInterface.saveSoftSkills(softSkills);
        return new ResponseEntity(new Mensaje("Habilidad Dura creada correctamente"), HttpStatus.OK);    
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    /*
    public String deleteSoftSkills (@PathVariable Long id) {
        softSkillsInterface.deleteSoftSkills(id);
        return "Habilidad eliminada correctamente";
    } */
    
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        softSkillsInterface.deleteSoftSkills(id);
        return new ResponseEntity(new Mensaje("Habilidad Blanda eliminada correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/edit/{id}")
    /*
    public SoftSkills editSoftSkills (@PathVariable Long id,
                                      @RequestParam ("softSkill") String newSoftSkill,
                                      @RequestParam ("mastery") int newMastery) {       
        SoftSkills softSkills = softSkillsInterface.findSoftSkills(id);
        softSkills.setSoftSkill(newSoftSkill);
        softSkills.setMastery(newMastery);
        softSkillsInterface.saveSoftSkills(softSkills);
        return softSkills;
    } */
    
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody SoftSkillsDTO softSkillsDTO){
        SoftSkills softSkills = softSkillsInterface.findSoftSkills(id);
        softSkills.setSoftSkill(softSkillsDTO.getSoftSkill());
        softSkills.setMastery(softSkillsDTO.getMastery());

        softSkillsInterface.saveSoftSkills(softSkills);
        return new ResponseEntity(new Mensaje("Habilidad Blanda actualizada correctamente"), HttpStatus.OK);
    }
}
