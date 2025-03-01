import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { MedicinepageComponent } from './medicinepage/medicinepage.component';
import {RoleGuard} from './role.guard';
import {QuestionPageComponent} from '@components/question-page/question-page.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'homepage', component: HomepageComponent},
  { path: 'sicknessQuestionnaire', component: QuestionPageComponent},
  { path: 'medicine', component: MedicinepageComponent}
];
