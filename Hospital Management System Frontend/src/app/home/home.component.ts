import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RegisterService } from '../register.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  toastr = inject(ToastrService);
  constructor(
    private router: Router,
    private registerService: RegisterService
  ) {}
  logout() {
    console.log('log out successfullyy');
    localStorage.clear();
    this.router.navigate(['/login']);
    this.toastr.success('Logout Successfully', 'Successfull');
  }
}
