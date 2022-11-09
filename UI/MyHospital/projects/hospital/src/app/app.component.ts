import { Component,OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog,MatDialogConfig } from '@angular/material/dialog';
import { CreateDoctorComponent } from './component/create-doctor/create-doctor.component';
import { CreatepatientComponent } from './component/create-patient/create-patient.component';
import { TokenStorageService } from './service/token-storage.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Hospital';
  selectedTab: any = 'Doctor';

  constructor(
    private router:Router,
    private route:ActivatedRoute,
    private dialog:MatDialog,
    private tokenStorage: TokenStorageService) {}

    ngOnInit(){
      console.log("ngOnInit initiate AppComponent");
      this.router.navigate(['/doctordashboard']);
    }

    redirectTologin(){
    //  console.log("ngOnInit initiate AppComponent");
      this.tokenStorage.signOut();
      this.router.navigate(['/login']);
    }

    onCreate(){
      const  dialogConfig=new MatDialogConfig();
      dialogConfig.disableClose=true;
      dialogConfig.autoFocus=true;
      if(this.selectedTab=='Doctor')
      this.dialog.open(CreateDoctorComponent,dialogConfig);
      if(this.selectedTab=='Patient')
      this.dialog.open(CreatepatientComponent,dialogConfig)
    }

    refreshGrid(){
      //    this.getDoctors();
    }
    navigateMenu(tag:any){
      this.selectedTab=tag;
      console.log('selectedTab = '+this.selectedTab);
      if(tag === 'Doctor'){
        this.router.navigate(['/doctordashboard']);
      }
      if(tag === 'Patient'){
        this.router.navigate(['/patientdashboard']);
      }
      if(tag === 'createdoctor'){
        this.router.navigate(['/createdoctor']);
      }
      if(tag === 'Room Allotment'){
        this.router.navigate(['/roomAllotement']);
      }
      if(tag === 'Appointment'){
        this.router.navigate(['/appointment-list']);
      }
    }

  }
