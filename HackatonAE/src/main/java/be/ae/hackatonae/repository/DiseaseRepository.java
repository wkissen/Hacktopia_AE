package be.ae.hackatonae.repository;

import be.ae.hackatonae.domain.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    List<Disease> findBySymptomsInAndFever(List<String> symptoms, String fever);

    Disease findDiseaseByDiseaseName(String diseaseName);
}
