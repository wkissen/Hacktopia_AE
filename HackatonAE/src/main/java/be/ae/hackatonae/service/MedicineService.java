package be.ae.hackatonae.service;

import be.ae.hackatonae.domain.Medicine;
import be.ae.hackatonae.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class MedicineService {
    private MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getMedicine(String treatment) {
        List<Medicine> medicineList = medicineRepository.findMedicineByTreatment(treatment);

        if (medicineList.size() <= 3) {
            return medicineList;
        }

        Collections.shuffle(medicineList);

        Random random = new Random();
        int randomIndex = random.nextInt(1, 6);

        return medicineList.subList(0, randomIndex);
    }
}