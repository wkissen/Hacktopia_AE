import { AuthService } from '@services/auth-service.service';
import { FormsModule } from '@angular/forms';
import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NavbarComponent
  ]
})
export class LoginComponent {
  userName: string = '';
  password: string = '';
  errorMessage: string = '';
  showerror: boolean = false;

  constructor(private authService: AuthService) {}

  onLogin(): void {
    if (this.userName && this.password) {
      if (!this.authService.login(this.userName, this.password)) {
        this.showerror = true;
        this.errorMessage = 'Invalid username or password.';
        return;
      }
      this.errorMessage = '';
    } else {
      this.showerror = true;
      this.errorMessage = 'Please enter both username and password.';
    }
  }
}
