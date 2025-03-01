package be.ae.hackatonae.service;

import be.ae.hackatonae.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {
    private DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }


}