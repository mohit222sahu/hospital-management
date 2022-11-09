import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { PatientDetails } from '../../entity/patient-details';
import { Autowired, GridOptions, ICellRendererParams } from 'ag-grid-community';
import { PatientService } from '../../service/patient.service';
import { CreatepatientComponent } from '../create-patient/create-patient.component';
import { PatientButtenRendererComponent } from '../patient-butten-renderer/patient-butten-renderer.component';
import { PrescriptionComponent } from '../prescription/prescription.component';
import { EditPatientComponent } from '../edit-patient/edit-patient.component';
//import { FilterComponent } from 'ag-grid-community/dist/lib/components/framework/componentTypes';
import { FilterComponent } from '../filter/filter.component';
import { EventEmitterService } from '../../service/event-emitter.service';
import { AppointmentService } from '../../service/appointment.service';
import { switchMap } from 'rxjs/operators';
@Component({
  selector: 'app-patient-dashboard',
  templateUrl: './patient-dashboard.component.html',
  styleUrls: ['./patient-dashboard.component.scss']
})

export class PatientDashboardComponent implements OnInit {
  rowData!: PatientDetails[];
  paginationPageSize:any;
  paginationNumberFormatter:any;
  columnDefs: any;
  gridApi:any;
  gridColumnApi:any;
  filterAgreementNumber = '';
  gridOptions!: GridOptions;
  refreshpatGrid=new BehaviorSubject<boolean>(true);
  frameworkComponents: any;

  constructor(
    private patientService: PatientService,
    private appointmentService:AppointmentService,
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MatDialog,
    private eventEmitterService: EventEmitterService
  ) {
    this.patientService.listen().subscribe((m:any)=>{
      console.log("m=>", m.type);
      this.getPatients();
      if(m.type==="name"){
        this.patientService.getPatientListFilter(m.fdata).subscribe(data =>{
          console.log("filtepatname=",data)
          this.rowData=data;
          console.log("rowdatapatfilter=",this.rowData)
        })
      }
      if(m.type==="city"){
        this.patientService.getPatientListFilterByCity(m.fdata).subscribe(data =>{
          console.log("filtecityname=",data)
          this.rowData=data;
          console.log("rowdatacityfilter=",this.rowData)
        })
      }
      if(m.type==="gender"){
        this.patientService.getPatientListFilterByContact(m.fdata).subscribe(data =>{
          console.log("filtegender=",data)
          this.rowData=data;
          console.log("rowdatagender=",this.rowData)
        })
      }
      // this.getFilterDataByName(m);
    });
    this.appointmentService.listen().subscribe((m:any)=>{
      console.log("m=>",m);
      this.appointmentService.getPatientListFilterByDoctorName(m).subscribe(data =>{
        console.log("filtedocname=",data)
        //this.appointmentService.filter("doc-filter")
        this.rowData=data;
        console.log("rowdataDocfilter=",this.rowData)
      })
    });
    this.paginationPageSize = 10;
    this.columnDefs = [
      { headerName: 'First Name', field: "first_name", width: 200, filter: true, sortable: true, },
      { headerName: 'Last  Name', field: "last_name", width: 200,  filter: true },
      { headerName: 'Gender', field: "gender", width: 200, filter: true },
      { headerName: 'Age', field: "age", width: 150, filter: true },
      { headerName: 'City', field: "city", width: 300, filter: true },
      { headerName: 'Contact', field: "mobile_number", width:250, filter: true },
      { headerName: 'Actions', field: 'action', width:200,
      cellRenderer: 'patientButtenRenderer', filter: true},
    ];
    this.frameworkComponents = {
      patientButtenRenderer: PatientButtenRendererComponent
    };
  }

  private getPatients() {
    console.log("getPatients called")
    this.patientService.getPatientList().subscribe(data => {
      this.rowData=data;
    });
  }

  getFilterDataByName(name: any){
    this.patientService.filter(name)
  }

  getFilterDataByDoctorName(docName: string){
    this.appointmentService.filter(docName);
  }

  getFilterDataByCity(city: any){
    this.patientService.filter(city);
  }

  getFilterDataByGender(gender: any){
    this.patientService.filter(gender);
  }

  onBtnClick() {
    console.log("hello");
  }

  onGridReady(params:any) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
  }

  ngOnInit(): void {
    console.log("initiate patient-dashboard")
    this.getPatients();

    if (this.eventEmitterService.subsVar==undefined) {
      this.eventEmitterService.subsVar = this.eventEmitterService.
      invokeFirstComponentFunction.subscribe((filterData:any) => {
        console.log("filter data=",filterData);
        if(filterData.type==="name"){
          this.getFilterDataByName(filterData);}
          if(filterData.type==="attendeeDoctor")
          this.getFilterDataByDoctorName(filterData.fdata);
          if(filterData.type==="city")
          this.getFilterDataByCity(filterData);
          if(filterData.type==="gender")
          this.getFilterDataByGender(filterData);

        });
      }
    }

    public agGridConfig: any = {

    }

    refreshGrid() {
      this.getPatients();
    }

    openDialog() {
      const dialogConfig = new MatDialogConfig();
      dialogConfig.disableClose = true;
      dialogConfig.autoFocus = true;
      dialogConfig.height = '70%';
      dialogConfig.width = '70%';
      this.dialog.open(PrescriptionComponent, dialogConfig);
    }

    onEdit() {
      const dialogConfig = new MatDialogConfig();
      dialogConfig.disableClose = true;
      dialogConfig.autoFocus = true;
      dialogConfig.height = '110%';
      dialogConfig.width = '80%';
      this.dialog.open(EditPatientComponent, dialogConfig);
      // this.refreshGrid();
    }

    OnDelete(id: any) {
      this.patientService.removePatient(id).subscribe(data => { });
      //this.refreshGrid();
      // window.location.reload();
    }

    filter(){
      const dialogConfig = new MatDialogConfig();
      dialogConfig.disableClose = true;
      dialogConfig.autoFocus = true;
      dialogConfig.height = '50%';
      dialogConfig.width = '50%';
      this.dialog.open(FilterComponent, dialogConfig);
    }

  }
