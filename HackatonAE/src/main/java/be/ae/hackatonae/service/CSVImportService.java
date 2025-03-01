package be.ae.hackatonae.service;

import be.ae.hackatonae.domain.Disease;
import be.ae.hackatonae.domain.Medicine;
import be.ae.hackatonae.repository.DiseaseRepository;
import be.ae.hackatonae.repository.MedicineRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CSVImportService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public void importCSV() {
        // Import disease data
        importDiseaseCSV("src/main/resources/dataset_disease.csv");

        // Import medicine data
        importMedicineCSV("src/main/resources/dataset_medicines.csv");
    }

    // Method to import and process disease data
    private void importDiseaseCSV(String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             InputStreamReader reader = new InputStreamReader(inputStream);
             CSVReader csvReader = new CSVReader(reader)) {

            if (inputStream == null) {
                System.out.println("File not found: " + fileName);
                return;
            }

            List<String[]> records = csvReader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty: " + fileName);
                return;
            }

            String[] headers = records.get(0); // Read header row
            records.remove(0); // Remove header row

            // Process each disease record
            for (String[] row : records) {
                try {
                    Disease disease = new Disease();
                    disease.setDiseaseName(row[0]); // Name
                    disease.setFever(row[1]); // Fever
                    disease.setHeartRate(row[2]); // Heart Rate
                    disease.setBreathRate(row[3]); // Breath Rate
                    disease.setBloodPressure(row[4]); // Blood Pressure
                    disease.setSymptoms(List.of(row[5].split("\\s*,\\s*"))); // Symptoms (splitting by comma)
                    disease.setType(row[6]); // Type
                    disease.setIncubationTime(Integer.parseInt(row[7])); // Incubation Time
                    disease.setPeriodOfIllness(Integer.parseInt(row[8])); // Period of Illness
                    disease.setDuration(row[9]); // Duration
                    disease.setInfectious(row[10]); // Infectious

                    diseaseRepository.save(disease);
                } catch (Exception e) {
                    System.out.println("Error processing disease row: " + String.join(",", row));
                    e.printStackTrace();
                }
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    // Method to import and process medicine data
    private void importMedicineCSV(String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             InputStreamReader reader = new InputStreamReader(inputStream);
             CSVReader csvReader = new CSVReader(reader)) {

            if (inputStream == null) {
                System.out.println("File not found: " + fileName);
                return;
            }

            List<String[]> records = csvReader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty: " + fileName);
                return;
            }

            String[] headers = records.get(0); // Read header row
            records.remove(0); // Remove header row

            // Process each medicine record
            for (String[] row : records) {
                try {
                    Medicine medicine = new Medicine();
                    medicine.setName(row[0]); // Name
                    medicine.setType(row[1]); // Type
                    medicine.setDaysOfTreatment(Integer.parseInt(row[2])); // Days of Treatment
                    medicine.setDosage(Double.parseDouble(row[3])); // Dosage
                    medicine.setTreatment(row[4]); // Treatment

                    medicineRepository.save(medicine);
                } catch (Exception e) {
                    System.out.println("Error processing medicine row: " + String.join(",", row));
                    e.printStackTrace();
                }
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
