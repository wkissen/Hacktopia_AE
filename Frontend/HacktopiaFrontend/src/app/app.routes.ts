import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import {RoleGuard} from './role.guard';

export const routes: Routes = [
  { path: '', component: LoginComponent },
];
