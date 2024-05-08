import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginRequest = {
    username: '',
    password: '',
  };
  errorMessage: string = '';
  isUserLoggedIn: boolean = false;
  isDoctorLoggedIn: boolean = false;
  constructor(
    private router: Router,
    private registerService: RegisterService
  ) {}
  toastr = inject(ToastrService);
  loginUser() {
    this.registerService.loginUser(this.loginRequest).subscribe(
      (response) => {
        console.log(response);
        localStorage.setItem('token', response.token);
        localStorage.setItem('role', response.role);
        localStorage.setItem('username', response.username);
        localStorage.setItem('tokenType', response.tokenType);

        if (response.role === 'USER') {
          this.router.navigate(['/home']);
          this.toastr.success('User Login SuccessFully', 'Successfull');
          localStorage.setItem('isUserLoggedIn', 'true');
        } else {
          this.router.navigate(['/admin']);
          localStorage.setItem('isDoctorLoggedIn', 'true');
          this.toastr.success('Doctor Login SuccessFully', 'Successfull');
        }
      },
      (error) => {
        this.errorMessage = error.error.message;
        this.toastr.error(this.errorMessage, 'Error');
      }
    );
  }
}
