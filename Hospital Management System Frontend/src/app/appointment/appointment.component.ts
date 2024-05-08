import { Component, inject } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrl: './appointment.component.css',
})
export class AppointmentComponent {
  appointments: Appointment[] = [];
  index: any;
  errorMessage: string;
  constructor(private appointmntService: AppointmentService) {}
  toastr = inject(ToastrService);

  ngOnInit(): void {
    this.getAllAppointment();
  }
  getAllAppointment() {
    this.appointmntService.getAllAppointments().subscribe((data) => {
      console.log(data);
      this.appointments = data;
    });
  }
  deleteAppointment(id: number) {
    this.appointmntService.deleteAppointment(id).subscribe(
      (data) => {
        console.log(data);
        this.toastr.success('Appointment Deleted Successfully', 'SuccessFull');
        this.getAllAppointment();
      },
      (error) => {
        this.errorMessage = error.error.errorMessage;
        this.toastr.error('Error While Deleting Appointment', 'Error');
      }
    );
  }
}
