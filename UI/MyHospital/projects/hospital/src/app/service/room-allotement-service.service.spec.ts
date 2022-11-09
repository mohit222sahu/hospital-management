import { TestBed } from '@angular/core/testing';

import { RoomAllotementServiceService } from './room-allotement-service.service';

describe('RoomAllotementServiceService', () => {
  let service: RoomAllotementServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoomAllotementServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
