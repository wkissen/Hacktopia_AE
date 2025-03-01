import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth-service.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { Medicine } from '@models/medicine.model';
import {Disease} from '@models/user-info.model';
import { UserInfoService } from '@services/user-info.service';
import { UserInfo } from '@models/user-info.model';

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
  diseaseList: Disease[] = [];
  selectedDays: { [key: string]: string[] } = {};
  

  constructor(private router: Router, private http: HttpClient, private authService: AuthService) {}

  ngOnInit(): void {
    this.getUserMedicine().subscribe(data => {
      this.medicineList = data;
    });
    
    this.getDiseases().subscribe(data => {
      this.diseaseList = data;
    });
  }

  getUserMedicine(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>('http://localhost:8080/api/medicine/'+ this.authService.getUserName());
  }

  getDiseases(): Observable<Disease[]> {
    return this.http.get<Disease[]>(`http://localhost:8080/api/person/disease` + this.authService.getUserName());
  }

  onSubmit() {
    this.http.get<UserInfo>(`http://localhost:8080/api/person/` + this.authService.getUserName())
      .subscribe(testuser => {
        if (testuser.diseases && testuser.diseases.length > 0) {
          this.http.delete('http://localhost:8080/api/person/disease/' + this.authService.getUserName() + '/' + testuser.diseases[0].id, { responseType: 'text' })
            .subscribe(response => {
              console.log('Disease deleted successfully:', response);
              this.router.navigate(['/homepage']); // Navigate after deletion
            }, error => {
              console.error('Error deleting disease:', error);
            });
        } else {
          console.log('No diseases found for the user.');
        }
      });
  }  
}
