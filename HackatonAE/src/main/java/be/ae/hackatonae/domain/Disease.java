package be.ae.hackatonae.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
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

    @ElementCollection
    private List<String> symptoms;

    public Disease() {

    }
}