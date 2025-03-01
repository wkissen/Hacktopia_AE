import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

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

  onSubmit() {
    console.log('Form submitted:', this.symptoms);
  }
}
