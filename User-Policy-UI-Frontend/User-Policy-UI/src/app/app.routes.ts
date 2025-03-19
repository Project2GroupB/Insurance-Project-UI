import { Routes } from '@angular/router';
import { ViewUserPolicyComponent } from './view-user-policy/view-user-policy.component';

import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { AppComponent } from './app.component';
import { ViewAllUserComponent } from './view-all-user/view-all-user.component';


export const routes: Routes = [
  { path: 'viewuserpolicy', component: ViewUserPolicyComponent },
 // { path: '', redirectTo: 'viewuserpolicy', pathMatch: 'full' }, // Redirect to 'viewuserpolicy'
  { path: 'viewallusers', component: ViewAllUserComponent},
  {path: 'viewuser/:id', component: ViewUserPolicyComponent}
];


// Bootstrap your application with the router
bootstrapApplication(AppComponent, {
  providers: [provideRouter(routes)] // Pass the routes array here
}).catch(err => console.error(err));
