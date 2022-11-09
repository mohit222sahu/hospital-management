import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DoctorDetails } from '../../entity/doctor-details';
import { DoctorService } from '../../service/doctor.service';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DoctorDashboardComponent } from '../doctor-dashboard/doctor-dashboard.component';



const validRequired=Validators.required;
@Component({
  selector: 'app-create-doctor',
  templateUrl: './create-doctor.component.html',
  styleUrls: ['./create-doctor.component.scss']
})
export class CreateDoctorComponent implements OnInit {
  durationInSeconds: number=4;
  description="Doctor Details";
  doctorData : DoctorDetails = new DoctorDetails;

  constructor(private router:Router,private doctorService:DoctorService,
    private dialogRef:MatDialogRef<CreateDoctorComponent>,private _snackBar: MatSnackBar) { }

    ngOnInit(): void {
    }

    openSnackBar() {
      this._snackBar.open("Doctor Added successfully","", {
        duration: this.durationInSeconds * 1000,
        horizontalPosition: 'right',
        verticalPosition: 'top',
        panelClass: ['blue-snackbar']
      });
    }

    navigateMenu(tag:any){
      if(tag === 'doctor'){
        this.router.navigate(['/doctordashboard']);
      }
      if(tag === 'patient'){
        this.router.navigate(['/patientdashboard']);
      }
    }

    doctorForm:FormGroup = new FormGroup({
      FieldFirstName: new FormControl('',[validRequired]),
      FieldAge: new FormControl('',[validRequired]),
      FieldLastName: new FormControl('',[validRequired]),
      FieldContactNumber: new FormControl('',[validRequired]),
      FieldEmail: new FormControl('test@gmail.com',[validRequired,Validators.email]),
      FieldAddress: new FormControl('',[validRequired]),
      FieldSpecialization: new FormControl('',[validRequired]),
      FieldQualification: new FormControl('MBBS',[validRequired]),
      FieldFee: new FormControl('',[validRequired]),
      // fee: new FormControl('',[validRequired])
    });

    specializations: any[] = [
      {value: 'Immunologist'},
      {value: 'Anesthesiologist'},
      {value: 'Cardiologist'},
      {value: 'Dermatologist'},
      {value: 'Physician'},
    ];

    onFormSubmit(){
      console.log("inside onFormSubmit = "+this.doctorForm.status);
      if(this.doctorForm.status == 'VALID'){
        this.doctorData.firstName=this.doctorForm.get('FieldFirstName')!.value
        this.doctorData.lastName=this.doctorForm.get('FieldLastName')!.value
        this.doctorData.age=this.doctorForm.get('FieldAge')!.value
        this.doctorData.contactNumber=this.doctorForm.get('FieldContactNumber')!.value
        this.doctorData.email=this.doctorForm.get('FieldEmail')!.value
        this.doctorData.address=this.doctorForm.get('FieldAddress')!.value
        this.doctorData.qualification=this.doctorForm.get('FieldQualification')!.value
        this.doctorData.specialization=this.doctorForm.get('FieldSpecialization')!.value
        this.doctorData.fee=this.doctorForm.get('FieldFee')!.value
        //console.log(this.doctorData);
        this.doctorService.CreateDoctor(this.doctorData).subscribe( (data)=> {
          this.onClose();
          this.openSnackBar();
          this.doctorService.filter('register');
        },(error)=> {
          console.log("error.message"+error);
          console.log("error.message"+error.error.message);
          this._snackBar.open(error.error.message,"", {
            duration: this.durationInSeconds * 1000,
            horizontalPosition: 'right',
            verticalPosition: 'top',
            panelClass: ['red-snackbar']
          });
        });
      }
      else{
        this._snackBar.open("Please fill mandatory details","", {
          duration: this.durationInSeconds * 1000,
          horizontalPosition: 'right',
          verticalPosition: 'top',
          panelClass: ['red-snackbar']
        });
      }
    }

    onClose(){
      this.dialogRef.close();
      this.doctorForm.reset();
      this.router.navigate(['/doctordashboard']);
    }

    isFieldValid(field: string) {
      return !this.doctorForm.get(field)?.valid && this.doctorForm.get(field)?.touched;
    }

  }
