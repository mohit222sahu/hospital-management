import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Appointment } from '../../entity/appointment';
import { AppointmentService } from '../../service/appointment.service';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.scss']
})
export class AppointmentListComponent implements OnInit {

  rowData!: Appointment[];
  columnDefs: any;
  frameworkComponents:any;
   gridApi:any;
   gridColumnApi:any;

  paginationPageSize:any;
   paginationNumberFormatter:any;



  constructor(private router:Router,
    private appointmentService:AppointmentService)
     { 
       
      this.paginationPageSize = 8;

     
        this.appointmentService.listen().subscribe((m:any)=>{
          console.log(m);
          this.getappointment();
           });
  
     this.columnDefs=[
      

      
  
      // ,valueGetter: this.docValueGetter
      // {
      //   headerName: 'Doctor Name',
      //   valueGetter: 'data.firstName + " " + data.lastName',
      //   valueSetter: `var nameSplit = newValue.split(" ");
      //        var newFirstName = nameSplit[0];
      //        var newLastName = nameSplit[1];
      //        if (data.firstName !== newFirstName || data.lastName !== newLastName) {  
      //           data.firstName = newFirstName;  
      //           data.lastName = newLastName;  
      //           return true;
      //       } else {  
      //           return false;
      //       }`,
      // },

      // valueGetter: this.patValueGetter
      { headerName: 'Doctor Name', width: 320,valueGetter:this.docValueGetter},
      {headerName: 'Patient Name' ,width: 320,valueGetter: this.patValueGetter},
  
      { headerName: 'Appointment Date',field: "date" ,width: 310},
     
      { headerName: 'Appointment Time',field: "time" ,width: 310}
      
      ];
      
      this.frameworkComponents = {
        
      };
  
  }

  onGridReady(params:any) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
  }



  getappointment(){
    this.appointmentService.getAppointmentList().subscribe(data =>{
    console.log("appoint_list",data);
      //console.log("data  type is",typeof(data));
      //console.log("dlist  type is",typeof(this.doctorList));
      
      this.rowData=data;
      
     // console.log("dlist is",this.doctorList);
    }) ;
  }

  

  navigateMenu(tag:any){
    if(tag === 'doctor'){
         this.router.navigate(['/doctordashboard']);
        }
      if(tag === 'patient'){
          this.router.navigate(['/patientdashboard']);
         }
         if(tag === 'createdoctor'){
          this.router.navigate(['/createdoctor']);
         }
         if(tag === 'roomAllotement'){
          this.router.navigate(['/roomAllotement']);
         }
         if(tag === 'appointment-list'){
          this.router.navigate(['/appointment-list']);
         }
  }

 

   

  docValueGetter(params:any) {
    // console.log(params.data.lastName);
   var firstchar=params.data.doctor.firstName.slice(0,1).toUpperCase();
    var lastchar=params.data.doctor.lastName.slice(0,1).toUpperCase();
    //console.log("doc",firstchar+lastchar)
     return firstchar+params.data.doctor.firstName.slice(1) +"   "+lastchar+params.data.doctor.lastName.slice(1);
     
   }

   patValueGetter(params:any) {
    // console.log(params.data.lastName);
    //if(!params.value) return 'ERROR';
    var firstchar=params.data.patient.first_name.slice(0,1).toUpperCase();
    var lastchar=params.data.patient.last_name.slice(0,1).toUpperCase();
     return firstchar+params.data.patient.first_name.slice(1) +"   "+lastchar+params.data.patient.last_name.slice(1);
     
   }


   ngOnInit(): void {
    this.getappointment();
   this.appointmentService.filter("grid)reloed");
    console.log("ngonit called");
 }

}
