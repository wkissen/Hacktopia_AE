package be.ae.hackatonae.service;

import be.ae.hackatonae.controller.dto.DiseaseDTO;
import be.ae.hackatonae.domain.Disease;
import be.ae.hackatonae.domain.Person;
import be.ae.hackatonae.repository.DiseaseRepository;
import be.ae.hackatonae.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DiseaseService {
    private DiseaseRepository diseaseRepository;
    private PersonRepository personRepository;

    public DiseaseService(DiseaseRepository diseaseRepository, PersonRepository personRepository) {
        this.diseaseRepository = diseaseRepository;
        this.personRepository = personRepository;
    }

    public Disease getDisease(DiseaseDTO diseaseDTO) {
        System.out.println(diseaseDTO.getSymptoms());
        System.out.println(diseaseDTO.getFever());
        List<Disease> diseases = diseaseRepository.findBySymptomsInAndFever(diseaseDTO.getSymptoms(), diseaseDTO.getFever());

        Random random = new Random();
        int randomIndex = random.nextInt(diseases.size());

        return diseases.get(randomIndex);
    }

    public void personHasDisease(String name, Long diseaseId) {
        Disease disease = diseaseRepository.findById(diseaseId).orElseThrow();

        Person person = personRepository.findPersonByName(name);

        person.getDiseases().add(disease);

        personRepository.save(person);
    }

    public List<Disease> getAllDiseases() {
        return diseaseRepository.findAll();
    }
}