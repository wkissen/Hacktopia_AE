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
        Long medicineId = medicineService.getMedicine(Treatment).getId();
        medicineService.giveMedicineToPerson(name, medicineId);
        return ResponseEntity.ok().build();
    }

//
//    @PostMapping("/{name}/{medicineId}")
//    public ResponseEntity<?> giveMedicineToPerson(@PathVariable String name, @PathVariable Long medicineId) {
//        medicineService.giveMedicineToPerson(name, medicineId);
//        return ResponseEntity.ok().build();
//    }
}
