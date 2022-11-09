import { Component, Inject, OnInit, Optional } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DoctorScheduleServiceService } from '../../service/doctor-schedule-service.service';
import { Doctorschedule } from '../../entity/doctorschedule';
import { Appointment } from '../../entity/appointment';
import { AppointmentService } from '../../service/appointment.service';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.scss']
})
export class ScheduleComponent implements OnInit {
  // selectedDate = new FormControl();
  // selectedTime = new FormControl();
  // date=new Date();
  // patientName="shlok";
  // description = "Schedule"
  description="Schedule"
  scheduleList: Doctorschedule[] = [];
  myMap = new Map();
  myMap2 = new Map();
  schedule: Appointment=new Appointment();
  constructor(private router: Router, private dialogRef: MatDialogRef<ScheduleComponent>,
    private doctorScheduleService: DoctorScheduleServiceService,
    private appointmentService: AppointmentService,
    @Inject(MAT_DIALOG_DATA) public data: any) {
    }

  ngOnInit(): void {
    console.log('------------------'+this.data.doctor_id);
    console.log('------------------'+this.data.patient_id);

    this.viewData();


    }
    setSch(item: any, value: any) {
    this.schedule.time = value;
    this.schedule.date = item.key;
    this.schedule.doctor.id =this.data.doctor_id;
    this.schedule.patient.id =this.data.patient_id;

   // this.appointmentService.saveAppointment(this.schedule).subscribe(data => { });
    }

  onSave() {
    console.log(this.appointmentService);
    //this.appointmentService.saveAppointment(this.schedule).subscribe(data => { });
    console.log("schedule ",this.schedule)
    this.dialogRef.close();
    this.router.navigate(['/appointment-list']);
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

   this.doctorScheduleService.getScheduleList(this.data.doctor_id).subscribe((data: any) => {
     console.log("------view d 1")
     this.scheduleList = data;
     return;
     console.log("_-------------22")
   });

   }
  doctorList()
  {
    console.log(this.scheduleList.length)
    var i = 0;

    for (var j = 0; j < this.scheduleList.length; j = i) {

      this.myMap.set(this.scheduleList[j].date, []);
      var str = this.scheduleList[j].date;
      for (; i<this.scheduleList.length; i++) {

        if (this.scheduleList[i].date === str) {
          this.myMap.get(this.scheduleList[j].date).push(this.scheduleList[i].time);
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
