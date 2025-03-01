package be.ae.hackatonae.service;

import be.ae.hackatonae.controller.dto.DiseaseDTO;
import be.ae.hackatonae.domain.Disease;
import be.ae.hackatonae.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DiseaseService {
    private DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public Disease getDisease(DiseaseDTO diseaseDTO) {
        List<Disease> diseases = diseaseRepository.findBySymptomsInAndFever(diseaseDTO.getSymptoms(), diseaseDTO.getFever());

        Random random = new Random();
        int randomIndex = random.nextInt(diseases.size());

        return diseases.get(randomIndex);
    }
}