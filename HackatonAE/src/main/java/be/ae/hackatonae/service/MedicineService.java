package be.ae.hackatonae.service;

import be.ae.hackatonae.domain.Medicine;
import be.ae.hackatonae.domain.Person;
import be.ae.hackatonae.repository.MedicineRepository;
import be.ae.hackatonae.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MedicineService {
    private MedicineRepository medicineRepository;
    private PersonRepository personRepository;

    public MedicineService(MedicineRepository medicineRepository, PersonRepository personRepository) {
        this.medicineRepository = medicineRepository;
        this.personRepository = personRepository;
    }

    public Medicine getMedicine(String treatment) {
        List<Medicine> medicineList = medicineRepository.findMedicineByTreatment(treatment);


        Collections.shuffle(medicineList);

        return medicineList.get(0);
    }

    public void giveMedicineToPerson(String name, Long medicineId) {
        Person person = personRepository.findPersonByName(name);
        Optional<Medicine> medicine = medicineRepository.findById(medicineId);

        if(person.getMedicines().contains(medicine.get())) {
            return;
        }

        person.getMedicines().add(medicine.get());
        personRepository.save(person);
    }

    public List<Medicine> getAllMedicines(String name) {
        Person person = personRepository.findPersonByName(name);
        return person.getMedicines();
    }
}