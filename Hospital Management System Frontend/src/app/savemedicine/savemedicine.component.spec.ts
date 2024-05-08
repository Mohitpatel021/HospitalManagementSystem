import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavemedicineComponent } from './savemedicine.component';

describe('SavemedicineComponent', () => {
  let component: SavemedicineComponent;
  let fixture: ComponentFixture<SavemedicineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SavemedicineComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SavemedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
