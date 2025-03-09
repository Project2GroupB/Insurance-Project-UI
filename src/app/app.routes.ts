import { Routes } from '@angular/router';
import { UserDetailsComponent } from './components/user-details/user-details.component'; // ✅ FIXED IMPORT

export const appRoutes: Routes = [
  { path: 'user-details', component: UserDetailsComponent }, // ✅ FIXED COMPONENT NAME
  { path: '', redirectTo: '/user-details', pathMatch: 'full' } // ✅ Default route
];
