import { Component, HostListener } from '@angular/core';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'MediPlus';
  constructor(private registerService: RegisterService) {}
  @HostListener('window:beforeunload', ['$event'])
  onBeforeUnload(event: any): void {
    this.registerService.logout();
  }
}
