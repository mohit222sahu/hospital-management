import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorScheduleServiceService } from '../../service/doctor-schedule-service.service';
import { Doctorschedule } from '../../entity/doctorschedule';
import { Appointment } from '../../entity/appointment';
import { AppointmentService } from '../../service/appointment.service';

@Component({
  selector: 'app-doctor-view',
  templateUrl: './doctor-view.component.html',
  styleUrls: ['./doctor-view.component.scss']
})
export class DoctorViewComponent implements OnInit {
  scheduleList:Doctorschedule[] =[];

  constructor(private route: ActivatedRoute,
    private doctorScheduleService: DoctorScheduleServiceService,
    private router: Router,
    private appointment:AppointmentService) { }

    id = Number(this.route.snapshot.paramMap.get('id'));
    doctorId =String(this.route.snapshot.paramMap.get('doctorId'));
    firstName= this.route.snapshot.paramMap.get('firstName');
    lastName= this.route.snapshot.paramMap.get('lastName');
    age= this.route.snapshot.paramMap.get('age');
    email= this.route.snapshot.paramMap.get('email');
    contactNumber= this.route.snapshot.paramMap.get('contact');
    specialization= this.route.snapshot.paramMap.get('specialization');
    qualification = this.route.snapshot.paramMap.get('qualification');
    fee= this.route.snapshot.paramMap.get('fee');
    address= this.route.snapshot.paramMap.get('address');

    ngOnInit(): void {
      this.viewData();
    }

    viewData() {
        this.doctorScheduleService.getScheduleList(this.id).subscribe((data: any) => {
        this.scheduleList = data;
        console.log(this.doctorId);
      })
    }

    back() {
      this.router.navigate(['/doctordashboard']);
    }
  }
