package be.ae.hackatonae.controller;

import be.ae.hackatonae.domain.Medicine;
import be.ae.hackatonae.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin("localhost:4200")
public class MedicineController {
    private MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/{name}/{Treatment}")
    public ResponseEntity<?> giveMedicineToPerson(@PathVariable String Treatment, @PathVariable String name) {
        Medicine medicine = medicineService.getMedicine(Treatment);
        medicineService.giveMedicineToPerson(name, medicine.getId());
        return ResponseEntity.ok(medicine);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMedicines(@PathVariable String name) {
        try {
            List<Medicine> medicines = medicineService.getAllMedicines(name);
            return ResponseEntity.ok(medicines);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to get medicines: " + e.getMessage());
        }
    }
}
