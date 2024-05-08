import { Inject, inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
export const authGuard: CanActivateFn = (route, state) => {
  let router = inject(Router);
  const toastr = inject(ToastrService);
  if (
    localStorage.getItem('token') &&
    localStorage.getItem('isUserLoggedIn') === 'true'
  ) {
    return true;
  } 
  else {
    router.navigate(['/login']);
    toastr.error('Please Login First ', 'Error');
    return false;
  }
};
