import { R3TargetBinder } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from '../../entity/appointment';
import { PatientDetails } from '../../entity/patient-details';
import { PrescriptionDetails } from '../../entity/prescription-details';
import { AppointmentService } from '../../service/appointment.service';
import { PatientService } from '../../service/patient.service';
//import { PatientDashboardComponent } from '../patient-dashboard/patient-dashboard.component';


@Component({
  selector: 'app-patient-view',
  templateUrl: './patient-view.component.html',
  styleUrls: ['./patient-view.component.scss']
})
export class PatientViewComponent implements OnInit {
  patientData!: PatientDetails[]
  apointmentData!: any
  roomData!:any
  roomNumber:any
  roomDate:any

  dLastName:any
  dFirstName:any
  dtime:any
  ddate:any
dischargeDate:any
  prescriptionData:PrescriptionDetails[]=[];
  ptype:any
  pschedule:any
  ptypes:any







  constructor(private route: ActivatedRoute, private patientService: PatientService, private appintmetsService: AppointmentService,
    private router: Router) {




  }

  id = (this.route.snapshot.paramMap.get('id'));
  first_name = this.route.snapshot.paramMap.get('first_name');
  last_name = this.route.snapshot.paramMap.get('last_name');
  age = this.route.snapshot.paramMap.get('age');
  city = this.route.snapshot.paramMap.get('city');
  mobile_number = this.route.snapshot.paramMap.get('mobile_number');
  gender = this.route.snapshot.paramMap.get('gender');

  ngOnInit(): void {
    this.getRoom();
     this.getData();
    this.viewData();
  this.getPrescription();
    console.log(this.first_name);
  }



  viewData() {
    this.patientService.getPatientList().subscribe((data: any) => {
      this.patientData = data;
    })
  }
  back() {
    this.router.navigate(['/patientdashboard']);
  }


  getRoom(){
    this.patientService.getRoomAllotement(this.id).subscribe((data:any) =>{
    this.roomData=data;
       this.roomDate = this.roomData.bookedDate;
      this.roomNumber = this.roomData.room.roomNo;
      this.dischargeDate = this.roomData.dischargeDate;

    });

  }
  getData() {
    this.appintmetsService.getByPatientId(this.id).subscribe((data: any) => {
      this.apointmentData = data;


      this.dFirstName=this.apointmentData.doctor.firstName;
      this.dLastName=this.apointmentData.doctor.lastName;
      this.dtime = this.apointmentData.time;
      this.ddate= this.apointmentData.date;

    })




  }

  getPrescription(){
    this.patientService.getPrescription(this.id).subscribe((data:any)=>{
      console.log("prc dayta",data)
      this.prescriptionData = data;
  //     this.ptype = this.prescriptionDadta.prescription_type;
  // this.ptypes = this.prescriptionDadta.types;
  //  this.pschedule = this.prescriptionDadta.schedule

   console.log(this.prescriptionData)


    })
  }


 ;

}
