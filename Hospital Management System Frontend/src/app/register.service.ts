import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { CommonRegisterRequest } from './common-register-request';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  toastr = inject(ToastrService);
  constructor(private router: Router, private http: HttpClient) {}

  private baseUrl = 'http://localhost:8080/auth';
  registerUser(commonRegisterRequest: CommonRegisterRequest): Observable<any> {
    return this.http.post(`${this.baseUrl}/save-user`, commonRegisterRequest);
  }
  loginUser(loginRequest: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, loginRequest);
  }
  logout() {
    console.log('log out successfullyy');
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
