import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatepatientComponent } from './create-patient.component';

describe('CreatePatientComponent', () => {
  let component: CreatepatientComponent;
  let fixture: ComponentFixture<CreatepatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatepatientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatepatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
