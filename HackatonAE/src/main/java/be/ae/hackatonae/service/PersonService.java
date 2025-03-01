package be.ae.hackatonae.service;

import be.ae.hackatonae.domain.Person;
import be.ae.hackatonae.repository.PersonRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public void createpeople(){
        List<Person> people = List.of(
                new Person("Sami", 65.0, 21, 177.0),
                new Person("Wesley", 105.3, 37, 160.0),
                new Person("Sander", 82.7, 80, 180.0),
                new Person("Rune", 104.2, 23, 173)
        );
        personRepository.saveAll(people);
    }

    public Person getPersonByName(String name){
        return personRepository.findPersonByName(name);
    }

    public void removeDiseaseFromPerson(String name, Long diseaseId) {
        Person person = personRepository.findPersonByName(name);
        person.getDiseases().removeIf(disease -> disease.getId().equals(diseaseId));
        personRepository.save(person);
    }

    public void removeMedicineFromPerson(String name, Long medicineId) {
        Person person = personRepository.findPersonByName(name);
        person.getMedicines().removeIf(medicine -> medicine.getId() == medicineId);
        personRepository.save(person);
    }
}
