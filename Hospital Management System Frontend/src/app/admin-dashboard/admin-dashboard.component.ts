import { Component, inject } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RegisterService } from '../register.service';
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css',
})
export class AdminDashboardComponent {
  toastr = inject(ToastrService);
  constructor(
    private router: Router,
    private patientService: PatientService,
    private registerService: RegisterService
  ) {}
  patients: Patient[] = [];
  getPatient() {
    this.patientService.getPatientList().subscribe((data) => {
      console.log(data);
      this.patients = data;
    });
  }
  deletePatient(id: number) {
    this.patientService.deletePatient(id).subscribe(
      (data) => {
        this.getPatient();
      },
      (error) => {
        alert('An Error Occured while deleting Patient!!');
      }
    );
  }
  navigateTo() {
    this.router.navigate(['/admin']);
  }
  logOut() {
    console.log('log out successfullyy');
    localStorage.clear();
    this.router.navigate(['/login']);
    this.toastr.success('Logout Successfully', 'Successfull');
  }
}
