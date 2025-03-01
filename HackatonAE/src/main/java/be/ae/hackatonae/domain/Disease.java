package be.ae.hackatonae.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String diseaseName;
    private String type;
    private String heartRate;
    private String breathRate;
    private String bloodPressure;
    private String fever;
    private int incubationTime;
    private int periodOfIllness;
    private String duration;
    private String infectious;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> symptoms;

    // Default constructor
    public Disease() {
    }

    // Parameterized constructor
    public Disease(Long id, String diseaseName, String type, String heartRate, String breathRate, String bloodPressure,
                   String fever, int incubationTime, int periodOfIllness, String duration, String infectious, List<String> symptoms) {
        this.id = id;
        this.diseaseName = diseaseName;
        this.type = type;
        this.heartRate = heartRate;
        this.breathRate = breathRate;
        this.bloodPressure = bloodPressure;
        this.fever = fever;
        this.incubationTime = incubationTime;
        this.periodOfIllness = periodOfIllness;
        this.duration = duration;
        this.infectious = infectious;
        this.symptoms = symptoms;
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getBreathRate() {
        return breathRate;
    }

    public void setBreathRate(String breathRate) {
        this.breathRate = breathRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    public int getIncubationTime() {
        return incubationTime;
    }

    public void setIncubationTime(int incubationTime) {
        this.incubationTime = incubationTime;
    }

    public int getPeriodOfIllness() {
        return periodOfIllness;
    }

    public void setPeriodOfIllness(int periodOfIllness) {
        this.periodOfIllness = periodOfIllness;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getInfectious() {
        return infectious;
    }

    public void setInfectious(String infectious) {
        this.infectious = infectious;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    // Optionally, you can override toString(), equals(), hashCode() methods if necessary
}
