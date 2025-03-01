import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '@services/auth-service.service';
import { UserInfoService } from '@services/user-info.service';
import { UserInfo } from '@models/user-info.model';

@Component({
  selector: 'app-homepage',
  imports: [FormsModule],
  templateUrl: './homepage.component.html',
  standalone: true,
})
export class HomepageComponent implements OnInit {
  username: string | null = null;
  userInfo: UserInfo | null = null;
  showerror: boolean = false;
  healthBar : Number | null = null;

  constructor(
    private authService: AuthService,
    private router: Router,
    private userInfoService: UserInfoService
  ) {}

  ngOnInit(): void {
    this.username = this.authService.getUserName();
    if (this.username) {
      this.userInfoService.getUserInfo(this.username).subscribe(info => {
        this.userInfo = info;
        this.healthBar = 100 - info.diseases.length * 20;
      });
    }
  }

  onSicknessQuestionnaire() {
    this.router.navigate(['/sicknessQuestionnaire']);
  }

  onLogout(): void {
    this.authService.logout();
    this.router.navigate(['']);
  }
}
