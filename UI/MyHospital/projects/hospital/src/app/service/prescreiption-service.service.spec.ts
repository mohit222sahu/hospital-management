import { TestBed } from '@angular/core/testing';

import { PrescreiptionServiceService } from './prescreiption-service.service';

describe('PrescreiptionServiceService', () => {
  let service: PrescreiptionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrescreiptionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
