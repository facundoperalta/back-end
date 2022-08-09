package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.model.SoftSkills;
import ar.com.yoprogramo.portfolio.service.ISoftSkillsService;
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
@RequestMapping("/api/softskills")
public class SoftSkillsController {
    
    @Autowired
    private ISoftSkillsService softSkillsInterface;
    
    @GetMapping ("/get")
    public List<SoftSkills> getSoftSkills() {
        return softSkillsInterface.getSoftSkills();
    }

    @PostMapping ("/create")
    public String createSoftSkills(@RequestBody SoftSkills softSkills) {
        softSkillsInterface.saveSoftSkills(softSkills);
        return "Habilidad creada correctamente";
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteSoftSkills (@PathVariable Long id) {
        softSkillsInterface.deleteSoftSkills(id);
        return "Habilidad eliminada correctamente";
    }

    @PutMapping ("/edit/{id}")
    public SoftSkills editSoftSkills (@PathVariable Long id,
                                      @RequestParam ("softSkill") String newSoftSkill,
                                      @RequestParam ("mastery") int newMastery) {
        
        SoftSkills softSkills = softSkillsInterface.findSoftSkills(id);
        
        softSkills.setSoftSkill(newSoftSkill);
        softSkills.setMastery(newMastery);
        
        softSkillsInterface.saveSoftSkills(softSkills);
        return softSkills;
    
    }    
}
