import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '@services/auth-service.service';

@Component({
  selector: 'app-homepage',
  imports: [FormsModule],
  templateUrl: './homepage.component.html',
  standalone: true,
})
export class HomepageComponent implements OnInit {
  username: string | null = null;
  showerror: boolean = false;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.username = this.authService.getUserName();
  }

  onSicknessQuestionnaire() {
    this.router.navigate(['/sicknessQuestionnaire']);
  }

  onLogout(): void {
    this.authService.logout();
    this.router.navigate(['']);
  }

}
