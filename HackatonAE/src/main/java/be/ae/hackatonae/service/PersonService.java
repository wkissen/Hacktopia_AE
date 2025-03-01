package be.ae.hackatonae.service;

import be.ae.hackatonae.domain.Person;
import be.ae.hackatonae.repository.PersonRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void createPerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }
}
