import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '@services/auth-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-homepage',
  imports: [FormsModule],
  templateUrl: './homepage.component.html',
})
export class HomepageComponent implements OnInit {
  role: string | null = null;
  username: string | null = null;
  showerror: boolean = false;
  comments: Comment[] = [];
  searchParams = {
    content: '',
    author: '',
    fromDate: '',
    toDate: '',
  };
  newComments: { [postId: string]: string } = {};

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.username = this.authService.getUserName();
    if (this.role === 'hoofdredacteur') {
      this.showerror = true;
    }
  }
  CreatePostRedirect(): void {
    this.router.navigate(['/posts']);
  }

  onLogout(): void {
    this.authService.logout();
    this.router.navigate(['']);
  }

  GoToPostConcepts(): void {
    this.router.navigate(['/concepts']);
  }

  GoToPostWaitingApprovals(): void {
    this.router.navigate(['/waitingapproval']);
  }

  GoToNotifications(): void {
    this.router.navigate(['/notifications']);
  }
}