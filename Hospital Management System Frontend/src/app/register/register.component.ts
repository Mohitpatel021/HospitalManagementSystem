import { Component, Inject, inject } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonRegisterRequest } from '../common-register-request';
import { RegisterService } from '../register.service';

import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  commonRegisterRequest: CommonRegisterRequest = new CommonRegisterRequest();
  errorMessage: string;
  message: String;
  agree: boolean;
  constructor(
    private registerService: RegisterService,
    private router: Router
  ) {}
  toastr = inject(ToastrService);
  registerDoctor(registerForm: NgForm) {
    console.log(this.commonRegisterRequest);
    this.registerService.registerUser(this.commonRegisterRequest).subscribe(
      (response) => {
        console.log('done');
        this.router.navigate(['/login']);
        this.toastr.success('Registration successful', 'Successful');
      },
      (error) => {
        this.errorMessage = error.error.message;
        this.toastr.error(this.errorMessage, 'Error');
      }
    );
  }
}
