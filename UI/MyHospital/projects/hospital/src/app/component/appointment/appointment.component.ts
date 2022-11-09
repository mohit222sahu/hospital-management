import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { DoctorService } from '../../service/doctor.service';
import { CreateDoctorComponent } from '../create-doctor/create-doctor.component';
import { ScheduleComponent } from '../schedule/schedule.component';
import {startWith} from 'rxjs/operators';
import {map} from 'rxjs/operators';
import { ViewChild } from '@angular/core';
import { DoctorDetails } from '../../entity/doctor-details';
import { PatientDetails } from '../../entity/patient-details';
import { PatientService } from '../../service/patient.service';
import { AppointmentService } from '../../service/appointment.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Doctorschedule } from '../../entity/doctorschedule';
import { Appointment } from '../../entity/appointment';
import { DoctorScheduleServiceService } from '../../service/doctor-schedule-service.service';



const validRequired=Validators.required;

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.scss']
})
export class AppointmentComponent implements OnInit {

  showDate:any;
  showTime:any;

  scheduleList: Doctorschedule[] = [];
  myMap = new Map();
  myMap2 = new Map();
  schedule: Appointment=new Appointment();
  doctorList!:DoctorDetails[];
  docNameList!:string[];
  patient!:PatientDetails;
  Doctor="";
 //schedule!:ScheduleComponent;
  durationInSeconds: number=3;
//    FieldDoctorName=new FormControl("");
//    FieldPatientName=new FormControl("");






  constructor( private router:Router,
    private dialog:MatDialog,
    private doctorService:DoctorService,
    private appointmentService:AppointmentService,
    private _snackBar: MatSnackBar,
    private doctorScheduleService: DoctorScheduleServiceService,

    ) {
     this.patient=this.router.getCurrentNavigation()?.extras.state?.patient;

     this.appointForm.get("FieldPatientName")?.setValue(this.patient.first_name+" "+this.patient.last_name)

    this.appointData.patient_id = this.patient.id;

  }




    openSnackBar() {
      this._snackBar.open("Appointment Comfirmed","", {
        duration: this.durationInSeconds * 1000,
        horizontalPosition: 'right',
        verticalPosition: 'top',
        panelClass: ['blue-snackbar']
      });
    }


        appointForm:FormGroup = new FormGroup({

          FieldDoctorName: new FormControl('',[validRequired]),
          FieldPatientName: new FormControl('',[validRequired]),
          // FieldPatientName: new FormControl(this.patient.first_name+" "+this.patient.last_name,[validRequired]),
      });






      stateChangeDoctor($event:any){

        this.getDoctors();
        this.appointData.doctor_id = $event.value;
      //  console.log("doc id",this.appointData.doctor_id)
        //this.viewData();

        this.doctorScheduleService.getScheduleList(this.appointData.doctor_id).subscribe((data: any) => {
         // console.log("------view d 1")
          this.scheduleList = data;
      //    console.log("doc schedule in method",this.scheduleList)

        console.log(this.scheduleList.length)
        var i = 0;

         for (var j = 0; j < this.scheduleList.length; j = i) {

         this.myMap.set(this.scheduleList[j].date, []);
         var str = this.scheduleList[j].date;
         for (; i<this.scheduleList.length; i++) {

           if (this.scheduleList[i].date === str) {
             if(this.scheduleList[i].patientName=='')
             this.myMap.get(this.scheduleList[j].date).push(this.scheduleList[i]);
           }
           else {

              break;
          }
          }


        if (i == this.scheduleList.length) break;
         }
     //   console.log("my map",this.myMap)

        });


        //this.doctorLists();




      }






    navigateMenu(tag:any){
      if(tag === 'patient'){
           this.router.navigate(['/patientdashboard']);
          }

    }



 getDoctors(){
  this.doctorService.getDoctorList().subscribe(data =>{
    //console.log("docs are",data);
    this.doctorList=data;
  // console.log("dlist is",this.doctorList);
  }) ;
}


// openSchedule(){
//   this.router.navigate(['/schedule']);
// }

// onSchedule(){
//   const  dialogConfig=new MatDialogConfig();
//   dialogConfig.disableClose=true;
//   dialogConfig.autoFocus=true;
//   dialogConfig.height='75%';
//   dialogConfig.width='90%';
//   dialogConfig.data = this.appointData;
//  const dialogref= this.dialog.open(ScheduleComponent,dialogConfig);

//   dialogref.afterClosed().subscribe(result =>{
//     //console.log("result is ",result.data);
//     this.appointData.time=result.data.time;
//    this.appointData.date=result.data.date;

//   });}

appointData:any={

  patient_id: 0,
doctor_id:0

}

  description:string ="Appointment";

  ngOnInit(): void {

    this.getDoctors();


  }

//   onFormSubmit(){

//     let doc=this.appointForm.get("FieldDoctorName")!.value;
// //console.log(doc);

// this.doctorList.forEach((val) =>{
//   if(val.firstName===doc)
//   this.appointData.doctor=val;
// });





// // this.appointData.patientId=this.FieldPatientName.value;
// //    this.appointData.doctorId=this.FieldDoctorName.value;

//     console.log(this.appointData);

//     this.appointmentService.saveAppointment(this.appointData).subscribe((data)=>{
//       this.openSnackBar();
//      });

//   }





//schudle code





  setSch(item: any, value: any) {
    this.schedule.myId = value.scheduleId;
      this.schedule.time = value.time;
  this.schedule.date = item.key;
  this.schedule.doctor.id =this.appointData.doctor_id;
  this.schedule.patient.id =this.appointData.patient_id;

  this.showDate=item.key;
  this.showTime=value.time;
 // this.appointmentService.saveAppointment(this.schedule).subscribe(data => { });
  }

onSave() {
  //console.log(this.appointmentService);
this.appointmentService.saveAppointment(this.schedule).subscribe(data => { });
 //console.log(this.schedule);
 this.openSnackBar();
  this.router.navigate(['/patientdashboard']);
}

// scheduleData:any={
//   date:'',
//   time:''
// }

//   getScheduleDetails(){
//      this.scheduleData.date=this.selectedDate.value;
//      this.scheduleData.time=this.selectedTime.value;
//     // console.log(this.scheduleData)
//     // return this.scheduleData;

//     this.dialogRef.close({data: this.scheduleData});
//  }

viewData() {
 // console.log("in vwiew data",this.appointData.doctor_id)
 this.doctorScheduleService.getScheduleList(this.appointData.doctor_id).subscribe((data: any) => {
   console.log("------view d 1")
   this.scheduleList = data;
   return;
 });

 }
doctorLists()
{
     console.log(this.scheduleList.length)
   var i = 0;

    for (var j = 0; j < this.scheduleList.length; j = i) {

    this.myMap.set(this.scheduleList[j].date, []);
    var str = this.scheduleList[j].date;
    for (; i<this.scheduleList.length; i++) {

      if (this.scheduleList[i].date === str) {
        this.myMap.get(this.scheduleList[j].date).push(this.scheduleList[i]);
      }
      else {

         break;
     }
     }


   if (i == this.scheduleList.length) break;
    }
   console.log(this.myMap)
  }

}
