import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { CreateRoomAllotementServiceService } from '../../service/create-room-allotement-service.service';
import { RoomAllotement } from '../../entity/room-allotement';

@Component({
  selector: 'app-create-room-allotement',
  templateUrl: './create-room-allotement.component.html',
  styleUrls: ['./create-room-allotement.component.scss']
})
export class CreateRoomAllotementComponent implements OnInit {
  roomAllotement: RoomAllotement = new RoomAllotement;
  // bookDate: string = '';
  // dischargeDate: string = '';
  minDate = new Date();
  maxDate = new Date(2021,12,10);
  constructor(private route: ActivatedRoute,
    private createRoomAllotementService: CreateRoomAllotementServiceService,
    private router: Router,
  private snackbar:MatSnackBar) { }
  roomNo = this.route.snapshot.paramMap.get('roomNo');
  patientId = this.route.snapshot.paramMap.get('patientId');
  room_type = this.route.snapshot.paramMap.get('room_type');
  price = this.route.snapshot.paramMap.get('price');
  first_name = this.route.snapshot.paramMap.get('first_name');
  last_name=this.route.snapshot.paramMap.get('last_name');
  ngOnInit(): void {
  }
  addRoomAllotement() {
    this.roomAllotement.patient.id = Number(this.patientId);
    this.roomAllotement.room.roomNo = Number(this.roomNo);
    this.roomAllotement.room.is_booked = true;
    this.roomAllotement.room.price = Number(this.price);
    console.log(this.price)
    console.log(this.room_type)
    this.roomAllotement.room.room_type = String(this.room_type);
    this.createRoomAllotementService.createAllotement(this.roomAllotement).subscribe((data:any) => { });
    this.openSnackBar();
    this.router.navigate(['/patientdashboard']);
  }
  dateChange($event:any) {
    this.roomAllotement.bookedDate = String($event.value).substring(0,16);
  }
  openSnackBar() {
    this.snackbar.open("Room Allocated successfully","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['blue-snackbar']
    });
  }
  cancel() {
    this.router.navigate(['/patientdashboard']);
  }
  back() {
    this.router.navigate(['/room']);
   }
}
