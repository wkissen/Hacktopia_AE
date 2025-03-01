import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth-service.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { Medicine } from '@models/medicine.model';

@Component({
  selector: 'app-medicinepage',
  imports: [FormsModule],
  templateUrl: './medicinepage.component.html',
  styleUrl: './medicinepage.component.css'
})
export class MedicinepageComponent implements OnInit {
toggleDay(arg0: string,_t16: string) {
throw new Error('Method not implemented.');
}

  medicineList: Medicine[] = [];
  selectedDays: { [key: string]: string[] } = {};
  

  constructor(private router: Router, private http: HttpClient, private authService: AuthService) {}

  ngOnInit(): void {
    this.getUserMedicine().subscribe(data => {
      this.medicineList = data;
    });
  }

  getUserMedicine(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>('http://localhost:8080/api/medicine/'+ this.authService.getUserName());
  }

  onSubmit() {
    console.log('Selected Days:', this.selectedDays);
    // You can send this.selectedDays to your backend if needed
  }
}
