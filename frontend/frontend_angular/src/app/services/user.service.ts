// src/app/services/user.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';



@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080';
  private http = inject(HttpClient);
  private baseUrl = `${this.apiUrl}/user`;

  createUser(user: any) {
    return this.http.post(`${this.baseUrl}/create/`, user);
  }
}
