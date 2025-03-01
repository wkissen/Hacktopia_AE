import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import axios from 'axios';

@Component({
  selector: 'app-question-page',
  templateUrl: './question-page.component.html',
  styleUrls: ['./question-page.component.css'],
  standalone: true,
  imports: [FormsModule]
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
      console.log('Response:', response.data);
    } catch (error) {
      console.error('Error:', error);
    }
  }
}
