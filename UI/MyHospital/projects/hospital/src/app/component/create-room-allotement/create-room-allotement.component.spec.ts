import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRoomAllotementComponent } from './create-room-allotement.component';

describe('CreateRoomAllotementComponent', () => {
  let component: CreateRoomAllotementComponent;
  let fixture: ComponentFixture<CreateRoomAllotementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateRoomAllotementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRoomAllotementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
