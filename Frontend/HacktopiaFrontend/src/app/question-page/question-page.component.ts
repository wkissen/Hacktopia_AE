import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import axios from 'axios';
import { NgIf } from '@angular/common';
import { AuthService } from '../shared/services/auth-service.service';
import { DiseaseCardPopupComponent } from '@components/disease-card-popup/disease-card-popup.component';

@Component({
  selector: 'app-question-page',
  templateUrl: './question-page.component.html',
  styleUrls: ['./question-page.component.css'],
  standalone: true,
  imports: [FormsModule, DiseaseCardPopupComponent, NgIf]
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

  fever: boolean = false; 
  disease: any; 
  medicine: any;

  constructor(private router: Router, private  authService: AuthService ) {}

  ngOnInit(): void {
    this.disease = null; 
  }
  async onSubmit() {
    const sendSymptomList: string[] = [];
    for (const [key, value] of Object.entries(this.symptoms)) {
      if (value) {
        sendSymptomList.push(key);
      }
    }

    const data = {
      symptoms: sendSymptomList,
      fever: this.fever ? 'yes' : 'no' 
    };

    try {
      const response = await axios.post('http://localhost:8080/api/disease', data);
      this.disease = response.data; 
      await axios.post('http://localhost:8080/api/disease/' + this.authService.getUserName() + '/' + this.disease.id , data);
      //this.medicine = await axios.post('http://localhost:8080/api/medicine/' + this.authService.getUserName() + '/' + this.disease.type , data);
      console.log('Response:', response.data); 
      console.log('disease', this.disease);
    } catch (error) {
      console.error('Error:', error);
    }
  }

  ToHomePage(): void {
    this.router.navigate(['/homepage']);
  }
}
