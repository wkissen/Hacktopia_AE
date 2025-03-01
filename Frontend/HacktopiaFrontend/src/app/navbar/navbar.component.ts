import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  standalone: true,
  imports: [
    RouterLink
  ],
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {}
