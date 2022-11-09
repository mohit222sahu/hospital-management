import { coerceStringArray } from '@angular/cdk/coercion';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AgRendererComponent } from 'ag-grid-angular';
import { ICellRendererParams } from 'ag-grid-community';

import { Appointment } from '../../entity/appointment';
import { PatientDetails } from '../../entity/patient-details';
import { PrescriptionService } from '../../service/prescreiption-service.service';
import { RoomAllotementServiceService } from '../../service/room-allotement-service.service';
import { Room } from '../../entity/Room';
import { AppointmentService } from '../../service/appointment.service';
import { PatientService } from '../../service/patient.service';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { EditPatientComponent } from '../edit-patient/edit-patient.component';
import { PatientDashboardComponent } from '../patient-dashboard/patient-dashboard.component';
import { PrescriptionComponent } from '../prescription/prescription.component';

@Component({
  selector: 'app-patient-butten-renderer',
  templateUrl: './patient-butten-renderer.component.html',
  styleUrls: ['./patient-butten-renderer.component.scss']
})



export class PatientButtenRendererComponent implements AgRendererComponent {
  constructor(private patientDash:PatientDashboardComponent,
    private router:Router,
    private dialog:MatDialog,
    private snackBar: MatSnackBar,
    private patientService:PatientService,
    private appointService:AppointmentService,
    private roomAllotmentService:RoomAllotementServiceService,
    private prescriptionService:PrescriptionService){
      //console.log("pat button render");



// this.patientService.getPatientList().subscribe(patientdata => {
//   //this.patientList=data;
//   this.appointService.getAppointmentList().subscribe(appointdata => {
//    // this.appointmentList=data;


//    // console.log("patient",patientdata);
//    // console.log("appoint",appointdata);

//     appointdata.forEach(appointment =>{
//       patientdata.forEach(patient => {

//         if(patient.id===appointment.patient.id){
//           console.log("pat",patient.id);
//           console.log("app",appointment.patient.id);
//           this.done=true;
//           console.log("done",this.done);
//         }

//       });
//     })

//    });


// })

  }


     appointDone:boolean=true;
     roomAllotmentDone:boolean=true;
     prescriptionDone:boolean=false;
    label: any;
    private params: any;
    mobile_number!: any;
    patientList!:any[];
    appointmentList!:any[];
    roomList!:any[];

    refresh(params: ICellRendererParams): boolean {

      throw new Error('Method not implemented.');

    }


   cellValue!: string

   agInit(params: any): void {
   //console.log("aginit");
   this.params=params;
   this.label = this.params.label || null;

  // console.log(params.data)

   this.appointService.getAppointmentList().subscribe(appointdata => {

    appointdata.forEach(appointment =>{

      if(appointment.patient.id===params.data.id){

      //console.log("pat",params.data.id,"   ap",appointment.patient.id);

        this.appointDone=false;
        this.prescriptionDone=true;
      }
    })
   })



   this.roomAllotmentService.getRoomAllotement().subscribe(roomData => {

    roomData.forEach(room =>{

      if(room.patient.id===params.data.id){

    //  console.log("room  ","pat",params.data.id,"  room ",room.patient.id);

        this.roomAllotmentDone=false;
      }
    })
   })

   this.prescriptionService.getprescription().subscribe(prescriptionData =>{
    prescriptionData.forEach((pricreption: { doctor: { id: any; }; }) => {
      if(pricreption.doctor.id===params.data.id)
      {}

   })


     })
    }

  onClick($event: any) {
    if (this.params.onClick instanceof Function) {
      const params = {
        event: $event,
        rowData: this.params.node.data
      }
      this.params.onClick(params);

    }
    console.log(this.params.data.id);
    const dialogRef = this.dialog.open(ConfirmationDialogComponent,{
      data:{
        message: 'Are you sure want to delete?',
        buttonText: {
          ok: 'Yes',
          cancel: 'No'
        }
      }
    });
    this.patientDash.OnDelete(this.params.data.id);


    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        console.log(this.params.data);
        this.patientDash.OnDelete(this.params.data.doctorId);
        this.openSnackBar();
}
    });

  }
  openSnackBar() {
    this.snackBar.open("patient Deleted successfully","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['blue-snackbar']
    });
    window.location.reload();
  }
  onEdit($event: any){
    if (this.params.onClick instanceof Function) {

      const params = {
        event: $event,
        rowData: this.params.node.data
      }
      this.params.onClick(params);

    }
    const  dialogConfig=new MatDialogConfig();
    dialogConfig.disableClose=true;
    dialogConfig.autoFocus=true;
    dialogConfig.height='90%';
    dialogConfig.width='65%';
    dialogConfig.data=this.params.data;

    this.dialog.open(EditPatientComponent,dialogConfig);

  }



  onPrescription($event: any){
    if (this.params.onClick instanceof Function) {

      const params = {
        event: $event,
        rowData: this.params.node.data
      }
      this.params.onClick(params);

    }
    const  dialogConfig=new MatDialogConfig();
    dialogConfig.disableClose=true;
    dialogConfig.autoFocus=true;
    dialogConfig.height='95%';
    dialogConfig.width='70%';
    dialogConfig.data=this.params.data;

    this.dialog.open(PrescriptionComponent,dialogConfig);

  }
  onView($event:any) {
    if (this.params.onClick instanceof Function) {

      const params = {
        event: $event,
        rowData: this.params.node.data
      }

    }
    console.log("patient ki id in view "+this.params.data.id);
    this.router.navigate(['/patientView', { id:this.params.data.id,first_name:this.params.data.first_name,last_name:this.params.data.last_name,age:this.params.data.age,mobile_number:this.params.data.mobile_number,address:this.params.data.city,gender:this.params.data.gender}]);
  }


  buttonClicked() {
    alert(`${this.cellValue} medals won!`);
  }

  getValueToDisplay(params: ICellRendererParams) {
    return params.valueFormatted ? params.valueFormatted : params.value;
  }

  navigateMenu(tag:string){
    if(tag === 'doctor'){
         this.router.navigate(['/patientdashboard']);
        }
        if(tag === 'appointment'){
          this.router.navigate(['/appointment'],{state:{patient:this.params.data}});
         }

      if(tag === 'patient'){
          this.router.navigate(['/patientdashboard']);
         }
         if(tag === 'createdoctor'){
          this.router.navigate(['/patientdashboard']);
         }
         if(tag=='createpatient'){
           this.router.navigate(['/patientdashboard'])
         }


  }
  roomAllote($event: any) {
    if (this.params.onClick instanceof Function) {

      const params = {
        event: $event,
        rowData: this.params.node.data
      }
    }
    console.log(this.params.data.id);
    this.router.navigate(['/room', { patientId: this.params.data.id,first_name:this.params.data.first_name,last_name:this.params.data.last_name }]);
   }
}
