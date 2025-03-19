import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserPolicyServiceService {

  private baseURL:string="http://localhost:8181/api/users/"

  constructor(private httpClient:HttpClient) { }

  getUserPolicyDetails(userId: number): Observable<User> {
    console.log("user id is " + userId);
    const url = `${this.baseURL}getUser/${userId}`;
    return this.httpClient.get<User>(url); // Only 'User' since policy is within User
}

getAllUsers(): Observable<User[]>{
  const url = `${this.baseURL}getAllUsers`;
  console.log(" data is" + this.httpClient.get<User>(url));
  return this.httpClient.get<User[]>(url);
}
}
