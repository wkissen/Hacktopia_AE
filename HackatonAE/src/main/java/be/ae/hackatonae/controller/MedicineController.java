package be.ae.hackatonae.controller;

import be.ae.hackatonae.domain.Medicine;
import be.ae.hackatonae.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
    private MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @RequestMapping("/{Treatment}")
    public ResponseEntity<?> getMedicine(@PathVariable String Treatment) {
        List<Medicine> medicine = medicineService.getMedicine(Treatment);
        return ResponseEntity.ok(medicine);
    }
}
