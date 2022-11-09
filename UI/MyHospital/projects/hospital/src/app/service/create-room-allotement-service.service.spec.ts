import { TestBed } from '@angular/core/testing';

import { CreateRoomAllotementServiceService } from './create-room-allotement-service.service';

describe('CreateRoomAllotementServiceService', () => {
  let service: CreateRoomAllotementServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateRoomAllotementServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
