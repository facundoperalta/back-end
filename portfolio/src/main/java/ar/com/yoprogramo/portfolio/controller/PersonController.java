
package ar.com.yoprogramo.portfolio.controller;

import ar.com.yoprogramo.portfolio.dto.Mensaje;
import ar.com.yoprogramo.portfolio.dto.PersonDTO;
import ar.com.yoprogramo.portfolio.model.Person;
import ar.com.yoprogramo.portfolio.service.IPersonService;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/api/person")
public class PersonController {
    
    @Autowired
    private IPersonService personInterface;
    
    @GetMapping ("/get")
    /*         
    public List<Person> getPersons() {
        return personInterface.getPersons();
    } */
    
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> list = personInterface.getPersons();
        return new ResponseEntity(list, HttpStatus.OK);
    }
      
    @PostMapping ("/create")
    /*
    public String createPerson(@RequestBody Person person) {
        personInterface.savePerson(person);
        return "La persona fue creada correctamente";
    } */
    
    public ResponseEntity<?> create(@RequestBody PersonDTO personDTO){
        Person person = new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getBirthDate(), personDTO.getPlace(), personDTO.getOccupation(), personDTO.getProfileImage(), personDTO.getAbout());
        personInterface.savePerson(person);
        return new ResponseEntity(new Mensaje("La persona fue creada correctamente"), HttpStatus.OK);    
    }
    
    @DeleteMapping ("/delete/{id}")
    /*
    public String deletePerson (@PathVariable Long id) {
        personInterface.deletePerson(id);
        return "La persona fue eliminada correctamente";
    } */
    
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        personInterface.deletePerson(id);
        return new ResponseEntity(new Mensaje("Persona eliminada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("/edit/{id}")
    /*
    public Person editPerson (@PathVariable Long id,
                              @RequestParam ("firstName") String newFirstName,
                              @RequestParam ("lastName") String newLastName,
                              @RequestParam ("birthDate") Date newBirthDate,
                              @RequestParam ("place") String newPlace,
                              @RequestParam ("occupation") String newOccupation,
                              @RequestParam ("profileImage") String newProfileImage,
                              @RequestParam ("about") String newAbout) {
        
        Person person = personInterface.findPerson(id);
        person.setFirstName(newFirstName);
        person.setLastName(newLastName);
        person.setBirthDate(newBirthDate);
        person.setPlace(newPlace);
        person.setOccupation(newOccupation);
        person.setProfileImage(newProfileImage);
        person.setAbout(newAbout);     
        personInterface.savePerson(person);
        return person;
    } */
    
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody PersonDTO personDTO){
        Person person = personInterface.findPerson(id);
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setBirthDate(personDTO.getBirthDate());
        person.setPlace(personDTO.getPlace());
        person.setOccupation(personDTO.getOccupation());
        person.setProfileImage(personDTO.getProfileImage());
        person.setAbout(personDTO.getAbout());
        personInterface.savePerson(person);
        return new ResponseEntity(new Mensaje("Perfil de usuario actualizado"), HttpStatus.OK);
    } 
   
    @GetMapping ("/get/{id}")
    /*
    public Person findPerson(@PathVariable("id") Long id) {
        Person person = personInterface.findPerson(id);
        return person;
    } */
    
    public ResponseEntity<Person> getById(@PathVariable("id") long id){
        Person person = personInterface.findPerson(id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

}
