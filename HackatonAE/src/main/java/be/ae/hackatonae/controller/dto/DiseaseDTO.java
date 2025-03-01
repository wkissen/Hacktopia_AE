package be.ae.hackatonae.controller.dto;

import java.util.List;


public class DiseaseDTO{
    private List<String> symptoms;
    private String fever;

    // Getters and setters
    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }
}
