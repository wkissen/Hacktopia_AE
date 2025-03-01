package be.ae.hackatonae.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String weight;
    private int age;
    private String height;
    @ManyToMany
    private List<Medicine> medicines;
    @ManyToMany
    private List<Disease> diseases;
}
