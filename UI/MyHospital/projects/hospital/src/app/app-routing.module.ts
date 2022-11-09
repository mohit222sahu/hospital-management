import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FilterComponent } from './component/filter/filter.component';
import { AppointmentListComponent } from './component/appointment-list/appointment-list.component';
import { AppointmentComponent } from './component/appointment/appointment.component';
import { CreateDoctorComponent } from './component/create-doctor/create-doctor.component';
import { CreatepatientComponent } from './component/create-patient/create-patient.component';
import { DoctorDashboardComponent } from './component/doctor-dashboard/doctor-dashboard.component';
import { EditDoctorComponent } from './component/edit-doctor/edit-doctor.component';
import { LoginComponent } from './component/login/login.component';
import { PatientDashboardComponent } from './component/patient-dashboard/patient-dashboard.component';
import { PatientViewComponent } from './component/patient-view/patient-view.component';
import { PrescriptionComponent } from './component/prescription/prescription.component';
import { ScheduleComponent } from './component/schedule/schedule.component';
import { CreateRoomAllotementComponent } from './component/create-room-allotement/create-room-allotement.component';
import { DoctorScheduleComponent } from './component/doctor-schedule/doctor-schedule.component';
import { DoctorViewComponent } from './component/doctor-view/doctor-view.component';
import { RoomAllotementComponent } from './component/room-allotement/room-allotement.component';
import { RoomComponent } from './component/room/room.component';

const routes: Routes = [
  { path:"login",
  component:LoginComponent
},
{
  path:"doctordashboard",
  component:DoctorDashboardComponent
},
{
  path:"patientdashboard",
  component:PatientDashboardComponent
},
{
  path:"createdoctor",
  component:CreateDoctorComponent
},
{
  path:"createpatient",
  component:CreatepatientComponent
}
,
{
  path:"schedule",
  component:ScheduleComponent
}
,
{
  path:"editdoctor",
  component:EditDoctorComponent
}
,
{
  path:"appointment",
  component:AppointmentComponent
},
{
  path:"prescription",
  component:PrescriptionComponent
},
{
  path:"doctor-schedule",
  component:DoctorScheduleComponent
},
{
  path:"roomAllotement",
  component:RoomAllotementComponent
},
{
  path:"room",
  component:RoomComponent
},
{
  path:"createRoomAllotement",
  component:CreateRoomAllotementComponent
},
{
  path:"doctorView",
  component:DoctorViewComponent
},
{
  path:"patientView",
  component:PatientViewComponent
},
{
  path:"appointment-list",
  component:AppointmentListComponent
},
{
  path:"filter",
  component:FilterComponent
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
