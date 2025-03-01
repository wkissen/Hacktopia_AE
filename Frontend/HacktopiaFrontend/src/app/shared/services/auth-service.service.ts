import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '@models/user.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private currentUser: User | null = null;
  private readonly STORAGE_KEY = 'currentUserRole';

  // Hardcoded lijst van gebruikers
  private readonly users: User[] = [
    new User('wesley', 'PXLstudent'),
    new User('sander', 'PXLstudent'),
    new User('sami', 'PXLstudent'),
    new User('rune', 'PXLstudent'),
  ];

  constructor(private router: Router) {
    if (typeof window !== 'undefined' && window.localStorage) {
      const savedUser = localStorage.getItem(this.STORAGE_KEY);
      if (savedUser) {
        this.currentUser = JSON.parse(savedUser) as User;
      }
    }
  }

  login(userName: string, password: string): boolean {
    // Controleer of de gebruiker bestaat in de hardcoded lijst
    const user = this.users.find(
      (u) => u.username === userName && u.password === password
    );

    if (user) {
      this.currentUser = user;
      localStorage.setItem(this.STORAGE_KEY, JSON.stringify(this.currentUser)); // Sla op in localStorage
      this.router.navigate(['/homepage']);
      return true; 
    } else {
      return false;
    }
  }

  logout(): void {
    this.currentUser = null;
    localStorage.removeItem(this.STORAGE_KEY); // Verwijder uit localStorage
    this.router.navigate(['']);
  }

  getRole(): string | null {
    return this.currentUser?.password || null;
  }

  isLoggedIn(): boolean {
    return this.currentUser !== null;
  }

  getUserName(): string | null {
    return this.currentUser?.username || null;
  }
}
