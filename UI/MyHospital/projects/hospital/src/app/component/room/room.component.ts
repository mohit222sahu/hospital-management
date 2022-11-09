import { Component, OnInit } from '@angular/core';
import { Room } from '../../entity/Room';
import { ActivatedRoute, Router } from '@angular/router';
import { RoomServiceService } from '../../service/room-service.service';
@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  rooms: Room[]=[];


  constructor(private roomService: RoomServiceService,
    private router: Router,
  private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.getRooms();
  }
  getRooms() {
    this.roomService.getRoomsList().subscribe((data:any) => {
      this.rooms = data;
      console.log(data);
    })
  }
  booked(room: Room) {

   this.router.navigate(['/createRoomAllotement',{ roomNo:room.roomNo,room_type:room.room_type,price:room.price,patientId:this.route.snapshot.paramMap.get('patientId'),first_name:this.route.snapshot.paramMap.get('first_name'),last_name:this.route.snapshot.paramMap.get('last_name')}])
    room.is_booked= true;
  }
  back() {
    this.router.navigate(['/patientdashboard']);
   }
}
