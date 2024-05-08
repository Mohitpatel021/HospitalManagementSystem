import { Component, inject } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrl: './create-appointment.component.css',
})
export class CreateAppointmentComponent {
  appointment: Appointment = new Appointment();
  constructor(
    private appointmentService: AppointmentService,
    private router: Router
  ) {}
  toastr = inject(ToastrService);
  saveAppointment() {
    this.appointmentService
      .createAppointment(this.appointment)
      .subscribe((data) => {
        console.log(this.appointment);

        this.toastr.success('Appoinment created Successfully', 'Successfull');
        this.router.navigate(['/home']);
      });
  }
  onSubmit() {
    alert('Are your sure? ');
    this.saveAppointment();
  }

  resetForm() {
    this.appointment = new Appointment();
  }
}
