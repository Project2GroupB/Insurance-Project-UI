import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root' // This ensures the service is available globally
})
export class UserService {

  private baseUrl = 'http://localhost:8181/api'; // Base API URL

  constructor(private http: HttpClient) {}

  // Fetch user details by userId
  getUserById(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/users/${userId}`);
  }

  // Fetch all claims
  getAllClaims(): Observable<any> {
    return this.http.get(`${this.baseUrl}/claims`);
  }
}
