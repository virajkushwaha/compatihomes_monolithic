import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register-user.component.html',
  styleUrl: './register-user.component.css'
})
export class RegisterUserComponent {

  http = inject(HttpClient);
  router = inject(Router);

  // Main form object
  registerUser: any = {
    name: '',
    email: '',
    role: '',
    offerings: '',
    preferences: ''
  };

  saveUser() {
    this.http.post('http://localhost:8080/api/users', this.registerUser).subscribe((res: any) => {
      console.log('User Registered:', res);
      this.router.navigate(['https://compatihomes.wegic.app/']); // Navigate to home or dashboard
    });
  }

  homePage() {
    this.router.navigate(['https://compatihomes.wegic.app/']);
  }
}
