import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import axios from 'axios';
import { DiseaseCardComponent } from '../disease-card/disease-card.component';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-question-page',
  templateUrl: './question-page.component.html',
  styleUrls: ['./question-page.component.css'],
  standalone: true,
  imports: [FormsModule, DiseaseCardComponent, NgIf]
})
export class QuestionPageComponent {
  symptoms = {
    sleepy: false,
    shortnessOfBreath: false,
    diarrhea: false,
    fatigue: false,
    muscleAches: false,
    coughing: false
  };

  fever: boolean = false; // Added fever property
  disease: any; // Added disease property

  constructor(private router: Router) {}

  async onSubmit() {
    const sendSymptomList: string[] = [];
    for (const [key, value] of Object.entries(this.symptoms)) {
      if (value) {
        sendSymptomList.push(key);
      }
    }

    const data = {
      symptoms: sendSymptomList,
      fever: this.fever ? 'yes' : 'no' // Convert boolean to "yes" or "no"
    };

    try {
      const response = await axios.post('http://localhost:8079/api/disease', data);
      this.disease = response.data; // Store the response in the disease property
      console.log('Response:', response.data); // Log the response to verify
    } catch (error) {
      console.error('Error:', error);
    }
  }

  ToHomePage(): void {
    this.router.navigate(['/homepage']);
  }
}
