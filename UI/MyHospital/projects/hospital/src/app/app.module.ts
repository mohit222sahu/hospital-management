import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';
import { AgGridModule } from 'ag-grid-angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { MatSliderModule } from '@angular/material/slider';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ErrorStateMatcher, MatNativeDateModule, MatOptionModule, ShowOnDirtyErrorStateMatcher } from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker'
//import {MatNativeDateModule,MatDatepickerModule,MatIconModule,MatButtonModule,MatCheckboxModule, MatToolbarModule, MatCardModule,MatFormFieldModule,MatInputModule,MatRadioModule,MatListModule,} from  '@angular/material/core';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule, MatTextareaAutosize} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {MatRadioModule} from '@angular/material/radio';
import { DoctorDashboardComponent } from './component/doctor-dashboard/doctor-dashboard.component';
import {MatMenuModule} from '@angular/material/menu';
import { PatientDashboardComponent } from './component/patient-dashboard/patient-dashboard.component';
import { CreateDoctorComponent } from './component/create-doctor/create-doctor.component';
import {MatDialogModule,MatDialogRef} from '@angular/material/dialog';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { ScheduleComponent } from './component/schedule/schedule.component';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import { CreatepatientComponent } from './component/create-patient/create-patient.component';
 import { PrescriptionComponent } from './component/prescription/prescription.component';
import {MatSelectModule} from '@angular/material/select';
import { ButtonRendererComponent } from './component/doctor-button-renderer/button-renderer.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { EditDoctorComponent } from './component/edit-doctor/edit-doctor.component';
import { AppointmentComponent } from './component/appointment/appointment.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { PatientButtenRendererComponent } from './component/patient-butten-renderer/patient-butten-renderer.component';
import { EditPatientComponent } from './component/edit-patient/edit-patient.component';
import { ConfirmationDialogComponent } from './component/confirmation-dialog/confirmation-dialog.component';
import { DoctorScheduleComponent } from './component/doctor-schedule/doctor-schedule.component';
import { RoomAllotementComponent } from './component/room-allotement/room-allotement.component';
import { RoomComponent } from './component/room/room.component';
import { CreateRoomAllotementComponent } from './component/create-room-allotement/create-room-allotement.component';
import { DoctorViewComponent } from './component/doctor-view/doctor-view.component';
import { AppointmentListComponent } from './component/appointment-list/appointment-list.component';
 import { PatientViewComponent } from './component/patient-view/patient-view.component';
import { FilterComponent } from './component/filter/filter.component';
import { EventEmitterService } from './service/event-emitter.service';
import { BasicAuthHtppInterceptorService } from './service/basic-httpInterceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DoctorDashboardComponent,
    PatientDashboardComponent,
    CreateDoctorComponent,
    ScheduleComponent,
    CreatepatientComponent,
    PatientViewComponent,
    PrescriptionComponent,
    ButtonRendererComponent, EditDoctorComponent, AppointmentComponent, PatientButtenRendererComponent, EditPatientComponent, ConfirmationDialogComponent, DoctorScheduleComponent, RoomAllotementComponent, RoomComponent, CreateRoomAllotementComponent, DoctorViewComponent, AppointmentListComponent, FilterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatSliderModule,
    BrowserAnimationsModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatIconModule,
    MatButtonModule,
    MatCheckboxModule,
     MatToolbarModule,
     MatCardModule,
     MatFormFieldModule,
     MatInputModule,
     MatListModule,
    MatRadioModule,
    MatMenuModule,
    ReactiveFormsModule,
    MatOptionModule,
    MatFormFieldModule,
    MatDialogModule,
    MatSnackBarModule,
    MatButtonToggleModule,
    MatTooltipModule,
    MatAutocompleteModule,
    AgGridModule.withComponents([ButtonRendererComponent]),
    MatSelectModule,
  ],
  providers: [EventEmitterService,{ provide: HTTP_INTERCEPTORS, useClass: BasicAuthHtppInterceptorService, multi: true }],
  bootstrap: [AppComponent],
  entryComponents:[
  [CreateDoctorComponent],
  [PrescriptionComponent],
  [EditDoctorComponent],
  [ScheduleComponent],
  [FilterComponent]
]
})
export class AppModule { }
