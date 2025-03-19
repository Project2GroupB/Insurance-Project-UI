import { Component } from '@angular/core';
import { NavigationEnd, NavigationError, NavigationStart, Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { ViewUserPolicyComponent } from './view-user-policy/view-user-policy.component';
import { Event } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ViewAllUserComponent } from './view-all-user/view-all-user.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,ViewUserPolicyComponent, HttpClientModule, ViewAllUserComponent, RouterLink,RouterLinkActive],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'User-Policy-UI';

  constructor(private router: Router) {
    this.router.events.subscribe((event: Event) => {
      if (event instanceof NavigationStart) {
        console.log('Navigation started to:', event.url);
      } else if (event instanceof NavigationEnd) {
        console.log('Navigation ended to:', event.url);
      } else if (event instanceof NavigationError) {
        console.error('Navigation error:', event.error);
      }
    });
  }

  logClick(event: MouseEvent): void {
    console.log('RouterLink clicked!', event);
  }
}
