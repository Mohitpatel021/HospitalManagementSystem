import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';
import { SaveMedicine } from './save-medicine';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  constructor(private http: HttpClient) {}
  private baseUrl = 'http://localhost:8080';

  //for getting all the appointment
  getAllAppointments(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.baseUrl}/all-appointment`, {
      headers: this.header,
    });
  }

  //For creating an appointment
  createAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(
      `${this.baseUrl}/save-appointment`,
      appointment,
      { headers: this.header }
    );
  }
  //for deleting an appointment
  deleteAppointment(id: number): Observable<Object> {
    return this.http.delete<object>(
      `${this.baseUrl}/delete-appointment/${id}`,
      { headers: this.header }
    );
  }

  header = new HttpHeaders().set(
    'Authorization',
    `Bearer ` + localStorage.getItem('token')
  );
  saveMedicine(saveMedicine: SaveMedicine): Observable<SaveMedicine> {
    return this.http.post<SaveMedicine>(
      `${this.baseUrl}/save-medicine`,
      saveMedicine,
      { headers: this.header }
    );
  }
  getAllMedicine(searchParameter): Observable<SaveMedicine[]> {
    return this.http.get<SaveMedicine[]>(`${this.baseUrl}/all-medicine`, {
      headers: this.header,
    });
  }
  deleteMedicine(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/delete-medicine/${id}`, {
      headers: this.header,
    });
  }
}
