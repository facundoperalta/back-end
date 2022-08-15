package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.dto.HardSkillsDTO;
import ar.com.yoprogramo.portfolio.dto.Mensaje;
import ar.com.yoprogramo.portfolio.model.HardSkills;
import ar.com.yoprogramo.portfolio.service.IHardSkillsService;
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
@RequestMapping("/api/hardskills")
public class HardSkillsController {
    
    @Autowired
    private IHardSkillsService hardSkillsInterface;
    
    @GetMapping ("/get")
    /*
    public List<HardSkills> getHardSkills() {
        return hardSkillsInterface.getHardSkills();
    } */
    
    public ResponseEntity<List<HardSkills>> getHardSkills(){
        List<HardSkills> list = hardSkillsInterface.getHardSkills();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping ("/create")
    /*
    public String createHardSkills(@RequestBody HardSkills hardSkills) {
        hardSkillsInterface.saveHardSkills(hardSkills);
        return "Habilidad creada correctamente";
    } */
    
    public ResponseEntity<?> create(@RequestBody HardSkillsDTO hardSkillsDTO){
        HardSkills hardSkills = new HardSkills(hardSkillsDTO.getHardSkill(), hardSkillsDTO.getTechnology(), hardSkillsDTO.getMastery());
        hardSkillsInterface.saveHardSkills(hardSkills);
        return new ResponseEntity(new Mensaje("Habilidad Dura creada correctamente"), HttpStatus.OK);    
    }
    
    @DeleteMapping ("/delete/{id}")
    /*
    public String deleteHardSkills (@PathVariable Long id) {
        hardSkillsInterface.deleteHardSkills(id);
        return "Habilidad eliminada correctamente";
    } */
    
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        hardSkillsInterface.deleteHardSkills(id);
        return new ResponseEntity(new Mensaje("Habilidad Dura eliminada correctamente"), HttpStatus.OK);
    }



    @PutMapping ("/edit/{id}")
    /*
    public HardSkills editHardSkills (@PathVariable Long id,
                                      @RequestParam ("hardSkill") String newHardSkill,
                                      @RequestParam ("technology") String newTechnology,
                                      @RequestParam ("mastery") int newMastery) {
        HardSkills hardSkills = hardSkillsInterface.findHardSkills(id);
        hardSkills.setHardSkill(newHardSkill);
        hardSkills.setTechnology(newTechnology);
        hardSkills.setMastery(newMastery);
        hardSkillsInterface.saveHardSkills(hardSkills);
        return hardSkills;
    } */
    
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody HardSkillsDTO hardSkillsDTO){
        HardSkills hardSkills = hardSkillsInterface.findHardSkills(id);
        hardSkills.setHardSkill(hardSkillsDTO.getHardSkill());
        hardSkills.setTechnology(hardSkillsDTO.getTechnology());
        hardSkills.setMastery(hardSkillsDTO.getMastery());

        hardSkillsInterface.saveHardSkills(hardSkills);
        return new ResponseEntity(new Mensaje("Habilidad Dura actualizada correctamente"), HttpStatus.OK);
    }  
}
