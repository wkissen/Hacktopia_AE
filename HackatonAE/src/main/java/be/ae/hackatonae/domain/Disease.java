package be.ae.hackatonae.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String diseaseName;
    private String type;
    private String heart_Rate;
    private String breath_Rate;
    private String blood_Pressure;
    private String fever;
    private int incubation_time;
    private int period_of_illness;
    private String duration;
    private String Infectious;
}
