package be.ae.hackatonae.repository;

import be.ae.hackatonae.domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findMedicineByTreatment(String treatment);
}
