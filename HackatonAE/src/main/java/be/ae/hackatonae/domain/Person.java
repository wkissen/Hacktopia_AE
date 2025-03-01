package be.ae.hackatonae.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double weight;
    private int age;
    private double height;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Medicine> medicines;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Disease> diseases;

    // Default constructor
    public Person() {
    }

    // Parameterized constructor
    public Person(String name, double weight, int age, double height) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.medicines = new ArrayList<>();
        this.diseases = new ArrayList<>();
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}
