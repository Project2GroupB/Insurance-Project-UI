import { Component, OnInit } from '@angular/core';
import { UserPolicyServiceService } from '../user-policy-service.service';
import { User } from '../user';
import { Policy } from '../policy';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ActivatedRoute, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-view-user-policy',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule,RouterLink,RouterLinkActive,RouterOutlet],
  providers: [UserPolicyServiceService],
  templateUrl: './view-user-policy.component.html',
  styleUrl: './view-user-policy.component.css'
})

export class ViewUserPolicyComponent implements OnInit {
  user: User | null = null; // Allow null for initialization
  policy: Policy[] | null = null; // Handle policy as an array
  errorMessage: string = ''; // Error messages for user feedback
  details="hidden";
  searchBar=""

  constructor(private userPolicyService: UserPolicyServiceService,
              private routes: ActivatedRoute) {}

    ngOnInit(): void {
      const userId = this.routes.snapshot.paramMap.get('id');
      if(userId){
        this.getUserPolicyById(userId);
        this.searchBar="disabled"
      }
    }

  getUserPolicyById(id: string): void {
    console.log('User ID entered: ' + id);
    const userId = Number(id);
    if (!id || isNaN(userId) || userId < 0) {
      console.error('Invalid User ID');
      this.errorMessage = 'Invalid User ID. Please enter a valid number.';
      return;
    }

    this.userPolicyService.getUserPolicyDetails(userId).subscribe(
      (response) => {
        this.user = response; // `response` is User object with a `policy` array
        console.log("user is" + this.user)
        this.policy = response.policy; // Access policy array
        this.errorMessage = ''; // Clear any previous error
        this.details=''
        console.log("deat is" + this.details)
      },
      (error) => {
        console.error('Error fetching user details:', error);
        this.user = null;
        this.policy = null; // Reset policy on error
        this.details=''
        this.errorMessage = 'Failed to fetch user or policy details. Please try again.';
      }
    );
  }
}
