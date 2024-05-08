import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root',
})
export class PatientService {
  constructor(private Http: HttpClient) {}
  private baseUrl = 'http://localhost:8080';
  getPatientList(): Observable<Patient[]> {
    return this.Http.get<Patient[]>(`${this.baseUrl}/all-patient`);
  }

  deletePatient(id: number): Observable<Object> {
    return this.Http.delete<Object>(`${this.baseUrl}/delete-patient/${id}`);
  }
}
