import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { PatientDetails } from '../../entity/patient-details';
import { PatientService } from '../../service/patient.service';
import { PatientDashboardComponent } from '../patient-dashboard/patient-dashboard.component';

const validRequired=Validators.required;

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.scss']
})

export class CreatepatientComponent implements OnInit {
  durationInSeconds: number=3;
  description="Patient Form";
  patientData: PatientDetails = new PatientDetails;
  genders: any[] = [ {value: 'Male'}, {value: 'Female'} ];

  constructor(private router:Router,private patientService:PatientService,
    private dialogRef:MatDialogRef<CreatepatientComponent>,private _snackBar:MatSnackBar) {}

    ngOnInit(): void {
    }

    openSnackBar() { this._snackBar.open("Patient Added successfully","", {
      duration: this.durationInSeconds * 1000, horizontalPosition: 'right',
      verticalPosition: 'top', panelClass: ['blue-snackbar'] });
    }

    patientForm:FormGroup = new FormGroup({
      FieldFirstName: new FormControl('',[validRequired]),
      FieldLastName: new FormControl('',[validRequired]),
      FieldAge: new FormControl('',[validRequired]),
      FieldMobileNumber: new FormControl('',[validRequired]),
      FieldCity: new FormControl('',[validRequired]),
      FieldGender: new FormControl('',[validRequired]),
      FieldAddress:new FormControl('',[validRequired]),
      FieldEM: new FormControl('',[validRequired]), FieldEmail: new
      FormControl('',[validRequired])
    });

    onFormSubmit(){
      // this.selectedData.clusterName =
      // this.AddCreateForm.get('FieldClusterName').value;
      this.patientData.first_name=this.patientForm.get('FieldFirstName')!.value
      this.patientData.last_name=this.patientForm.get('FieldLastName')!.value
      this.patientData.age=this.patientForm.get('FieldAge')!.value
      this.patientData.mobile_number=this.patientForm.get('FieldMobileNumber')!.value
      this.patientData.city=this.patientForm.get('FieldCity')!.value
      this.patientData.gender=this.patientForm.get('FieldGender')!.value
      this.patientData.address = this.patientForm.get('FieldAddress')!.value
      this.patientData.emergencyContactNumber = this.patientForm.get('FieldEM')!.value
      this.patientData.email=this.patientForm.get('FieldEmail')!.value
      this.patientService.CreatePatient(this.patientData).subscribe(data=>{
        this.onClose();
        this.openSnackBar();
        this.patientService.filter('register');
      },(error)=> {
        console.log("error.message"+error);
        console.log("error.message"+error.error.message);
        this._snackBar.open(error.error.message,"ok", {
          duration: this.durationInSeconds * 1000,
          horizontalPosition: 'right',
          verticalPosition: 'top',
          panelClass: ['red-snackbar']
        });
      });
    }

    onClose(){
      this.dialogRef.close();
      this.patientForm.reset();
      this.router.navigate(['/patientdashboard']);
    }

  }
