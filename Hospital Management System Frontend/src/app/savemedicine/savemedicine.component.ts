import { Component, inject } from '@angular/core';
import { SaveMedicine } from '../save-medicine';
import { ToastrService } from 'ngx-toastr';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-savemedicine',
  templateUrl: './savemedicine.component.html',
  styleUrl: './savemedicine.component.css',
})
export class SavemedicineComponent {
  saveMedicine: SaveMedicine = new SaveMedicine();
  toastr = inject(ToastrService);
  errorMessage = '';
  constructor(
    private appointmentService: AppointmentService,
    private router: Router
  ) {}

  onSubmit() {
    this.appointmentService.saveMedicine(this.saveMedicine).subscribe(
      (data) => {
        console.log('medicine saving');
        this.toastr.success('Medicine Save Successfully', 'Success');
        this.router.navigate(['/medicine']);
      },
      (error) => {
        this.errorMessage = error.error.Message;
        this.toastr.error(this.errorMessage, 'Error');
      }
    );
  }

  
  resetForm() {
    this.saveMedicine = new SaveMedicine();
  }
}
