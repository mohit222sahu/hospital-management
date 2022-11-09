import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomAllotementComponent } from './room-allotement.component';

describe('RoomAllotementComponent', () => {
  let component: RoomAllotementComponent;
  let fixture: ComponentFixture<RoomAllotementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoomAllotementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomAllotementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
