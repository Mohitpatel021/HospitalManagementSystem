import { Component, inject } from '@angular/core';
import { SaveMedicine } from '../save-medicine';
import { Router } from '@angular/router';
import { AppointmentService } from '../appointment.service';
import { Toast, ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrl: './medicine.component.css',
})
export class MedicineComponent {
  toastr = inject(ToastrService);
  constructor(
    private router: Router,
    private appointment: AppointmentService
  ) {}
  medicines: SaveMedicine[] = [];
  errorMessage: string;
  searchParameter: string;

  deleteMedicine(id: number) {
    this.appointment.deleteMedicine(id).subscribe(
      (data) => {
        this.toastr.success('Medicine Deleted Successfull', 'Successfull');
        this.router.navigate(['/medicine']);
        this.getMedicine();
      },
      (error) => {
        this.errorMessage = error.error.errorMessage;
        this.toastr.error('Error While Deleting', 'Error');
      }
    );
  }
  ngOnInit() {
    this.getMedicine();
  }
  getMedicine() {
    this.appointment.getAllMedicine(this.searchParameter).subscribe(
      (data) => {
        this.medicines = data;
      },
      (error) => {
        this.errorMessage = error.error.errorMessage;
        this.toastr.error(this.errorMessage, 'Error');
      }
    );
  }
}
