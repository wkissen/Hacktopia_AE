package be.ae.hackatonae.service;

import be.ae.hackatonae.controller.dto.DiseaseDTO;
import be.ae.hackatonae.domain.Disease;
import be.ae.hackatonae.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {
    private DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public List<Disease> getDisease(DiseaseDTO diseaseDTO) {
        return diseaseRepository.findBySymptomsInAndFever(diseaseDTO.getSymptoms(), diseaseDTO.getFever());
    }
}