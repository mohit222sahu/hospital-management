import { TestBed } from '@angular/core/testing';

import { DoctorScheduleServiceService } from './doctor-schedule-service.service';

describe('DoctorScheduleServiceService', () => {
  let service: DoctorScheduleServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoctorScheduleServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
