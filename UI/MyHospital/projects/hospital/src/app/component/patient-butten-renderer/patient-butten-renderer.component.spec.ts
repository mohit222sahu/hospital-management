import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientButtenRendererComponent } from './patient-butten-renderer.component';

describe('PatientButtenRendererComponent', () => {
  let component: PatientButtenRendererComponent;
  let fixture: ComponentFixture<PatientButtenRendererComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientButtenRendererComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientButtenRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
