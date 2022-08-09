
package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.model.Person;
import ar.com.yoprogramo.portfolio.service.IPersonService;
import java.util.Date;
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
@RequestMapping("/api/person")
public class PersonController {
    
    @Autowired
    private IPersonService personInterface;
    
    @GetMapping ("/get")
    public List<Person> getPersons() {
        
        return personInterface.getPersons();
    }
    
    @PostMapping ("/create")
    public String createPerson(@RequestBody Person person) {
    
    personInterface.savePerson(person);
    
    return "La persona fue creada correctamente";
    }
    
    @DeleteMapping ("/delete/{id}")
    public String deletePerson (@PathVariable Long Id) {
        personInterface.deletePerson(Id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping ("/edit/{id}")
    public Person editPerson (@PathVariable Long Id,
                              @RequestParam ("firstName") String newFirstName,
                              @RequestParam ("lastName") String newLastName,
                              @RequestParam ("birthDate") Date newBirthDate,
                              @RequestParam ("place") String newPlace,
                              @RequestParam ("occupation") String newOccupation,
                              @RequestParam ("profileImage") String newProfileImage,
                              @RequestParam ("about") String newAbout) {
        
        Person person = personInterface.findPerson(Id);
        
        person.setFirstName(newFirstName);
        person.setLastName(newLastName);
        person.setBirthDate(newBirthDate);
        person.setPlace(newPlace);
        person.setOccupation(newOccupation);
        person.setProfileImage(newProfileImage);
        person.setAbout(newAbout);
             
        personInterface.savePerson(person);
        
        return person;
        
    } 
            
            
    
}
