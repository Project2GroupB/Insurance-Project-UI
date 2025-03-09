import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-details', // ✅ Ensure this matches usage in HTML
  standalone: true,  // ✅ Ensure it's standalone
  imports: [CommonModule, FormsModule],  // ✅ Required modules
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent {  // ✅ Ensure this matches `app.component.ts`
  userId!: number;
  user: any = null;
  claims: any[] = [];
  errorMessage: string = '';

  constructor(private http: HttpClient) {}

  getUserDetails() {
    if (!this.userId) {
      this.errorMessage = "Please enter a valid User ID.";
      return;
    }

    const apiUrl = `http://localhost:8181/api/users/${this.userId}`;
    
    this.http.get<any>(apiUrl).subscribe({
      next: (data) => {
        this.user = {
          id: data.id,
          name: data.name,
          email: data.email,
          phone: data.phone,
          address: data.address
        };
        this.claims = data.claims || [];
        this.errorMessage = '';
      },
      error: () => {
        this.errorMessage = "User not found. Please enter a valid User ID.";
        this.user = null;
        this.claims = [];
      }
    });
  }
}
