package be.ae.hackatonae.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;
    private int daysOfTreatment;
    private double dosage;
    private String treatment;

    // Default constructor
    public Medicine() {
    }

    // Parameterized constructor
    public Medicine(long id, String name, String type, int daysOfTreatment, double dosage, String treatment) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.daysOfTreatment = daysOfTreatment;
        this.dosage = dosage;
        this.treatment = treatment;
    }

    // Getter and Setter methods
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDaysOfTreatment() {
        return daysOfTreatment;
    }

    public void setDaysOfTreatment(int daysOfTreatment) {
        this.daysOfTreatment = daysOfTreatment;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    // Optionally, you can override toString(), equals(), hashCode() methods if necessary
}
