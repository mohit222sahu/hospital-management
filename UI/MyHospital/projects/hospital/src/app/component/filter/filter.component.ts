import { Component, Input, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { EventEmitterService } from '../../service/event-emitter.service';
import { PatientService } from '../../service/patient.service';
import { DoctorDashboardComponent } from '../doctor-dashboard/doctor-dashboard.component';
import { PatientDashboardComponent } from '../patient-dashboard/patient-dashboard.component';

interface FilterTypes{
  types:string;
  value:string;
}

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.scss']
})
export class FilterComponent implements OnInit {

  filterData!:string;
  city!:string;
  contact!:string;
  selectedFilterType!:string;

  @Input() filterpojo: any = {

    type:'',
    fdata:''

  }


  filterTypes: FilterTypes[] = [
    {value: 'name', types: 'Name'},
    {value: 'attendeeDoctor', types: 'Attendee Doctor'},
    // {value: 'admissionDate', types: 'Admission Date'}
    {value: 'city', types: 'City'},
    {value: 'gender', types: 'Gender'}
  ];

  constructor(private router: Router,
    private dialogRef:MatDialogRef<FilterComponent>,
    private patientService:PatientService,
    private eventEmitterService: EventEmitterService
  ) {
  }

  ngOnInit(): void {
  }

  back(){
    console.log("back");
    this.dialogRef.close();
    this.router.navigate(['/patientdashboard']);

  }


  filter(){
    //this.router.navigate(['/patientdashboard',{filterdata:this.name}]);
    this.filterpojo.type=this.selectedFilterType;
    this.filterpojo.fdata= this.filterData;
    //console.log("filpojo",this.filterpojo)
    this.eventEmitterService.onFilterComponentButtonClick(this.filterpojo);
    this.dialogRef.close();

  }


}
