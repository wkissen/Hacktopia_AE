package be.ae.hackatonae.controller;

import be.ae.hackatonae.domain.Person;
import be.ae.hackatonae.service.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        try {
            // Create a new person
            personService.createPerson(person);
            return ResponseEntity.ok("Person created successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create person: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getPerson() {
        try {
            // Get the person by id
            List<Person> persons = personService.getAllPersons();
            return ResponseEntity.ok(persons);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to get person: " + e.getMessage());
        }
    }

    @PostMapping("/createpeople")
    public ResponseEntity<?> createPeople() {
        try {
            // Create people
            personService.createpeople();
            return ResponseEntity.ok("People created successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create people: " + e.getMessage());
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonByName(@PathVariable String name) {
        try {
            // Get the person by name
            Person person = personService.getPersonByName(name);
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to get person: " + e.getMessage());
        }
    }
}
