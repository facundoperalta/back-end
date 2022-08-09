
package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.Person;
import java.util.List;

public interface IPersonService {
    
    public List<Person> getPersons();
    
    public void savePerson(Person person);
    
    public void deletePerson(Long id);
    
    public Person findPerson(Long id);
}
