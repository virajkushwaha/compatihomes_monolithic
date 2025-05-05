import { Routes } from '@angular/router';
import { RegisterUserComponent } from './features/register-user/register-user.component';

export const routes: Routes = [
  { path: 'register', component: RegisterUserComponent },
  { path: '', redirectTo: 'register', pathMatch: 'full' }
];
