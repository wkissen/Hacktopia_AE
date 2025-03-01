import { Component } from '@angular/core';
import { AuthService } from '../shared/services/auth-service.service';
import { Router } from '@angular/router';
import axios from 'axios';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Medicine } from '@models/medicine.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-medicinepage',
  imports: [FormsModule],
  templateUrl: './medicinepage.component.html',
  styleUrl: './medicinepage.component.css'
})
export class MedicinepageComponent {


  constructor(private router: Router,private http: HttpClient ,private  authService: AuthService ) {}


  // async onSubmit() {
  //   try {
  //     const response = await axios.delete('http://localhost:8080/api/disease', data);
  //     this.disease = response.data; 
  //     await axios.post('http://localhost:8080/api/disease/' + this.authService.getUserName() + '/' + this.disease.id , data);
  //     //this.medicine = await axios.post('http://localhost:8080/api/medicine/' + this.authService.getUserName() + '/' + this.disease.type , data);
  //     console.log('Response:', response.data); 
  //     console.log('disease', this.disease);
  //   } catch (error) {
  //     console.error('Error:', error);
  //   }
  // }

  getUserMedicine(name: string): Observable<Medicine[]> {
    return this.http.get<Medicine[]>(`http://localhost:8080/api/person/${name}`);
  }
}
