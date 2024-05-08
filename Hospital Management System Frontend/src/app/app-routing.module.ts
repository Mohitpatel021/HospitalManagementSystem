import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';

import { AppointmentComponent } from './appointment/appointment.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { MedicineComponent } from './medicine/medicine.component';
import { SavemedicineComponent } from './savemedicine/savemedicine.component';
import { authGuard } from './auth.guard';
import { docAuthGuard } from './doc-auth.guard';

const routes: Routes = [
  {
    path: '',
    component: UserDashboardComponent,
    pathMatch: 'full',
  },
  {
    path: 'medicine',
    component: MedicineComponent,
    canActivate: [docAuthGuard],
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'admin',
    component: AdminDashboardComponent,
    canActivate: [docAuthGuard],
  },
  {
    path: 'create-appointment',
    component: CreateAppointmentComponent,
    canActivate: [authGuard],
  },
  {
    path: 'appointmentlist',
    component: AppointmentComponent,
    canActivate: [docAuthGuard],
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'save-medicine',
    component: SavemedicineComponent,
    canActivate: [docAuthGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
