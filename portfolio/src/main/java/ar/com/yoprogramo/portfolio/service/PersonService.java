package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.Person;
import ar.com.yoprogramo.portfolio.repository.PersonRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService implements IPersonService{
   
    
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getPersons() {
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return person;        
    }
    

    
}
