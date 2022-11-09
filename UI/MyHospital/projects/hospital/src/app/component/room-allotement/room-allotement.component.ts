import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MatDialog,MatDialogConfig } from '@angular/material/dialog';
import { AgGridEvent, ICellRendererParams } from 'ag-grid-community';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AppointmentService } from '../../service/appointment.service';
import { RoomAllotement } from '../../entity/room-allotement';
import { RoomAllotementServiceService } from '../../service/room-allotement-service.service';


@Component({
  selector: 'app-room-allotement',
  templateUrl: './room-allotement.component.html',
  styleUrls: ['./room-allotement.component.css']
})
export class RoomAllotementComponent implements OnInit {


  roomAllotement: RoomAllotement[] | undefined;
  constructor(private roomAllotementService: RoomAllotementServiceService,
    private router: Router,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private allotementService:AppointmentService) {
      this.allotementService.listen().subscribe((m:any)=>{
        console.log(m);
        this.getRoomAllotementList();
         });

   }

  ngOnInit(): void {
    this.getRoomAllotementList();
    this.allotementService.filter("get_rooms");
     }


  getRoomAllotementList() {
    this.roomAllotementService.getRoomAllotement().subscribe((data: RoomAllotement[] | undefined) => {
      this.roomAllotement = data;
      console.log(data);
    })

  }
  navigateMenu(tag: any) {
    if (tag === 'doctor') {
      this.router.navigate(['/doctordashboard']);
    }
    if (tag === 'patient') {
      this.router.navigate(['/patientdashboard']);
    }

    if (tag === 'roomAllotement') {
      this.router.navigate(['/roomAllotement']);
    }
    if(tag === 'appointment-list'){
      this.router.navigate(['/appointment-list']);
     }
  }
  delete(roomAllotement: RoomAllotement) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {
        message: 'Are you sure want to Delete Patient Record?',
        buttonText: {
          ok: 'Yes',
          cancel: 'No'
        }
      }
    });
    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
       // console.log(this.params.data);
       this.roomAllotementService.delete(roomAllotement).subscribe((data: any) => { });

        this.openSnackBar2();
  }
    });


  }
  discharge(roomAllotement: RoomAllotement) {

  const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
    data: {
      message: 'Are you sure want to Discharge Patient?',
      buttonText: {
        ok: 'Yes',
        cancel: 'No'
      }
    }
  });
  dialogRef.afterClosed().subscribe((confirmed: boolean) => {
    if (confirmed) {
     // console.log(this.params.data);
      this.roomAllotementService.discharge(roomAllotement).subscribe();
      this.openSnackBar();
}
  });
  }
  openSnackBar() {
    this.snackBar.open("Patient Discharged successfully","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['blue-snackbar']
    });
  }
  openSnackBar2() {
    this.snackBar.open("Patient Record Deleted successfully","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['red-snackbar']
    });
  }


}
