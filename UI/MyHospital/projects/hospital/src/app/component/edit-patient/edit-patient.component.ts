import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../../service/patient.service';
import { PatientDashboardComponent } from '../patient-dashboard/patient-dashboard.component';

const validRequired=Validators.required;

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.scss']
})
export class EditPatientComponent implements OnInit {
 id:any=this.data.id;

  description="Edit Patient";
  durationInSeconds: number=4;
 
  constructor(private patientService:PatientService,
    private dialogRef:MatDialogRef<EditPatientComponent>,
    private router:Router,
    private route:ActivatedRoute,
    private _snackBar:MatSnackBar ,
    @Inject(MAT_DIALOG_DATA) public data: any
    ) { }

    
    openSnackBar() {

      this._snackBar.open("Patient update successfully","", {
        duration: this.durationInSeconds * 1000,
        horizontalPosition: 'right',
        verticalPosition: 'top',
        panelClass: ['blue-snackbar']
      });
     
    }
  ngOnInit(): void {
    
    
  }

 editPatientForm:FormGroup = new FormGroup({
    FieldFirstName: new FormControl(this.data.first_name,[validRequired]),
    FieldLastName: new FormControl(this.data.last_name,[validRequired]),
    FieldAge: new FormControl(this.data.age,[validRequired]),
    FieldMobileNumber: new FormControl(this.data.mobile_number,[validRequired]),
    FieldCity: new FormControl(this.data.city,[validRequired]),
    FieldGender: new FormControl(this.data.gender,[validRequired]),
    FieldAddress:new FormControl(this.data.address,[validRequired]),
    FieldEmail:new FormControl(this.data.email,[validRequired]),
    FieldEmergencyContactNumber : new FormControl(this.data.emergencyContactNumber,[validRequired])

});
genders: any[] = [
  {value: 'Male'},
  {value: 'Female'}
  ];
@Input()patientData:any ={
  
    first_name:'',
    last_name:'',
    age:'',
    mobile_number:'',
    city:'',
    gender:'',
    address:'',
    email:'',
    emergencyContactNumber:'',

 }

onFormSubmit(){
this.patientData.first_name=this.editPatientForm.get('FieldFirstName')!.value
this.patientData.last_name=this.editPatientForm.get('FieldLastName')!.value
this.patientData.age=this.editPatientForm.get('FieldAge')!.value
this.patientData.mobile_number=this.editPatientForm.get('FieldMobileNumber')!.value
this.patientData.city=this.editPatientForm.get('FieldCity')!.value
this.patientData.gender=this.editPatientForm.get('FieldGender')!.value
this.patientData.email=this.editPatientForm.get('FieldEmail')!.value
this.patientData.address=this.editPatientForm.get('FieldAddress')!.value
this.patientData.emergencyContactNumber=this.editPatientForm.get('FieldEmergencyContactNumber')!.value

this.patientData.id = this.id;
this.patientService.UpdatePatient(this.patientData).subscribe((data)=>{
  this.onClose(); 

  this.openSnackBar();

   this.patientService.filter('register');

  //this.patientService.filter('update');


  
});
  // window.location.reload();
}

onClose(){
  this.dialogRef.close();
  this.editPatientForm.reset();
  this.router.navigate(['/patientdashboard']);
}


}
