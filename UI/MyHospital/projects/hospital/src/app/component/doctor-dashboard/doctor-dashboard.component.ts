import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { DoctorDetails } from '../../entity/doctor-details';
import { DoctorService } from '../../service/doctor.service';
import { MatDialog,MatDialogConfig } from '@angular/material/dialog';
import { CreateDoctorComponent } from '../create-doctor/create-doctor.component';
import { AgGridEvent, ICellRendererParams } from 'ag-grid-community';
import { ButtonRendererComponent } from '../doctor-button-renderer/button-renderer.component';
import { EditDoctorComponent } from '../edit-doctor/edit-doctor.component';

@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  styleUrls: ['./doctor-dashboard.component.scss']
})

export class DoctorDashboardComponent implements OnInit {
  //doctorList!:DoctorDetails[];
  // private columnDefs;
  rowData!: DoctorDetails[];
  columnDefs: any;
  frameworkComponents:any;
  gridApi:any;
  gridColumnApi:any;
  paginationPageSize:any;
  paginationNumberFormatter:any;
  // private autoGroupColumnDef;

  constructor(
    private doctorService:DoctorService,
    private router:Router,
    private route:ActivatedRoute,
    private dialog:MatDialog,) {
      this.paginationPageSize = 10;
      this.doctorService.listen().subscribe((m:any)=>{
        console.log(m);
        this.getDoctors();
      });

      this.columnDefs=[
        { headerName: 'Name', width: 300,valueGetter: this.abValueGetter,},
        { headerName: 'Specialization', field: "specialization" ,width: 250},
        { headerName: 'Email-Id',field: "email" ,width: 300},
        { headerName: 'Contact No.',field: "contactNumber" ,width: 250},
        { headerName: 'Fee',field: "fee" ,width: 200},
        { headerName: 'Actions',field: 'action',width:150,
        cellRenderer: 'buttonRenderer'}
    ];
    this.frameworkComponents = {
      buttonRenderer:ButtonRendererComponent
    };
  }

  onGridReady(params:any) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
  }

  getDoctors(){
    this.doctorService.getDoctorList().subscribe(data =>{
      console.log("data is",data);
      this.rowData=data;
    }) ;
  }

  refreshGrid(){
    this.getDoctors();
  }

  abValueGetter(params:any) {
    // console.log(params.data.lastName);
    var firstchar=params.data.firstName.slice(0,1).toUpperCase();
    var lastchar=params.data.lastName.slice(0,1).toUpperCase();
    return firstchar+params.data.firstName.slice(1) +"   "+lastchar+params.data.lastName.slice(1);

  }

  ngOnInit(): void {
    console.log("initate doctor dashboard");
    this.getDoctors();
  }

  public agGridConfig:any={
  }

  OnDelete(id:number){
    this.doctorService.removeDoctor(id).subscribe((data)=>{
    this.doctorService.filter('delete');
    });
    window.location.reload();
  }

}
