import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

// Import standalone components
import { UserDetailsComponent } from './components/user-details/user-details.component';

// Import required Angular modules
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,  // ✅ Added FormsModule for form handling
    HttpClientModule, // ✅ Added HttpClientModule for API calls
    UserDetailsComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {}
