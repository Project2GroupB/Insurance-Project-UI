import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Policy } from '../policy';
import { UserPolicyServiceService } from '../user-policy-service.service';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { ViewUserPolicyComponent } from '../view-user-policy/view-user-policy.component';

@Component({
  selector: 'app-view-all-user',
  imports: [CommonModule,HttpClientModule, FormsModule,RouterOutlet
  , RouterLink,RouterLinkActive,ViewUserPolicyComponent],
  providers: [UserPolicyServiceService],
  templateUrl: './view-all-user.component.html',
  styleUrl: './view-all-user.component.css'
})
export class ViewAllUserComponent implements OnInit{

  users: User [] | null = [] ; // Allow null for initialization
  policy: Policy[] | null = []; // Handle policy as an array
  errorMessage:String=''

    constructor(private userService: UserPolicyServiceService){}

  ngOnInit(){
    console.log("into inti")
    this.getAllUser()
  }

  getAllUser(){
      this.userService.getAllUsers().subscribe(
        (response: User[]) => {
          this.users = response,
          console.log("users is" + this.users)
          // this.policy=response.policy
          this.errorMessage = ''
        },
      (error) =>{
        console.error('Error fetching users details:', error);
        this.users=null,
        this.policy = null,
        this.errorMessage="Failed to get users"
      }
    )
  };

  logClick(event: MouseEvent): void {
    console.log('RouterLink clicked!', event);
  }
}
