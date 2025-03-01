package be.ae.hackatonae.service;

import be.ae.hackatonae.domain.Disease;
import be.ae.hackatonae.domain.Medicine;
import be.ae.hackatonae.repository.DiseaseRepository;
import be.ae.hackatonae.repository.MedicineRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class CSVImportService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public void importCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            String[] headers = records.get(0); // Read the header row
            records.remove(0); // Remove header row from processing

            if (headers[0].equalsIgnoreCase("Disease")) {
                processDiseaseData(records);
            } else if (headers[0].equalsIgnoreCase("Name")) {
                processMedicineData(records);
            } else {
                System.out.println("Unknown dataset format!");
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private void processDiseaseData(List<String[]> records) {
        for (String[] row : records) {
            try {
                Disease disease = new Disease();
                disease.setDiseaseName(row[0]); // Name
                disease.setFever(row[1]); // Fever (keep it as String)
                disease.setHeartRate(row[2]); // Heart Rate
                disease.setBreathRate(row[3]); // Breath Rate
                disease.setBloodPressure(row[4]); // Blood Pressure
                disease.setSymptoms(List.of(row[5].split("\\s*,\\s*"))); // Fixes symptom parsing
                disease.setType(row[6]); // Type
                disease.setIncubationTime(Integer.parseInt(row[7])); // Incubation Time
                disease.setPeriodOfIllness(Integer.parseInt(row[8])); // Period of Illness
                disease.setDuration(row[9]); // Duration
                disease.setInfectious(row[10]); // Infectious (keep as String)

                diseaseRepository.save(disease);
            } catch (Exception e) {
                System.out.println("Error processing disease row: " + String.join(",", row));
                e.printStackTrace();
            }
        }
    }


    private void processMedicineData(List<String[]> records) {
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
    }

}
