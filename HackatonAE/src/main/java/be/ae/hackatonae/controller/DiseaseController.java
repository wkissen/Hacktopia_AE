package be.ae.hackatonae.controller;

import be.ae.hackatonae.controller.dto.DiseaseDTO;
import be.ae.hackatonae.domain.Disease;
import be.ae.hackatonae.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseController {
    private DiseaseService diseaseService;

    @Autowired
    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @GetMapping()
    public ResponseEntity<?> getDisease(@RequestBody DiseaseDTO diseaseDTO) {
        Disease disease = diseaseService.getDisease(diseaseDTO);
        return ResponseEntity.ok(disease);
    }

    @PostMapping("/{name}/{id}")
    public ResponseEntity<?> personHasDisease(@PathVariable String name, @PathVariable long id) {
        diseaseService.personHasDisease(name, id);
        return ResponseEntity.ok().build();
    }
}
