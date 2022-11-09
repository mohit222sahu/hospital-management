import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorService } from '../../service/doctor.service';
import { DoctorDetails } from '../../entity/doctor-details';

const validRequired=Validators.required;

@Component({
  selector: 'app-edit-doctor',
  templateUrl: './edit-doctor.component.html',
  styleUrls: ['./edit-doctor.component.scss']
})
export class EditDoctorComponent implements OnInit {
  docid:string=this.data.doctorId;
  description="Edit Doctor";
  durationInSeconds: number=4;
  doctorData: DoctorDetails = new DoctorDetails;

  constructor(private doctorService:DoctorService,
    private dialogRef:MatDialogRef<EditDoctorComponent>,
    private router:Router,
    private route:ActivatedRoute,
    private _snackBar:MatSnackBar ,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  openSnackBar() {
    this._snackBar.open("Doctor update successfully","", {
      duration: this.durationInSeconds * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['blue-snackbar']
    });
  }

  ngOnInit(): void {
  }

  editDoctorForm:FormGroup = new FormGroup({
    FieldFirstName: new FormControl(this.data.firstName,[validRequired]),
    FieldDoctorId: new FormControl(this.data.doctorId,[validRequired]),
    FieldId: new FormControl(this.data.id,[validRequired]),
    FieldAge: new FormControl(this.data.age, [validRequired]),
    FieldLastName: new FormControl(this.data.lastName,[validRequired]),
    FieldContactNumber: new FormControl(this.data.contactNumber,[validRequired]),
    FieldEmail: new FormControl(this.data.email,[validRequired]),
    FieldAddress: new FormControl(this.data.address,[validRequired]),
    FieldSpecialization: new FormControl(this.data.specialization,[validRequired]),
    FieldQualification: new FormControl(this.data.qualification,[validRequired]),
    FieldFee: new FormControl(this.data.fee,[validRequired]),
  });
  //selectedSpecialization=this.data.specialization.value;

  specializations: any[] = [
    {value: 'Immunologist'},
    {value: 'Anesthesiologist'},
    {value: 'Cardiologist'},
    {value: 'Dermatologist'},
    {value: 'Physician'},
  ];

  onFormSubmit(){
    this.doctorData.id=this.editDoctorForm.get('FieldId')!.value
    this.doctorData.firstName = this.editDoctorForm.get('FieldFirstName')!.value
    this.doctorData.lastName=this.editDoctorForm.get('FieldLastName')!.value
    this.doctorData.doctorId=this.editDoctorForm.get('FieldDoctorId')!.value
    this.doctorData.age=this.editDoctorForm.get('FieldAge')!.value
    this.doctorData.contactNumber=this.editDoctorForm.get('FieldContactNumber')!.value
    this.doctorData.email=this.editDoctorForm.get('FieldEmail')!.value
    this.doctorData.address=this.editDoctorForm.get('FieldAddress')!.value
    this.doctorData.qualification=this.editDoctorForm.get('FieldQualification')!.value
    this.doctorData.specialization=this.editDoctorForm.get('FieldSpecialization')!.value
    this.doctorData.fee=this.editDoctorForm.get('FieldFee')!.value
    console.log(this.doctorData.id);
    this.doctorService.UpdateDoctor(this.doctorData).subscribe((data)=>{
      console.log(data);
      this.onClose();
      this.openSnackBar();
      this.doctorService.filter('update');
    });
  }

  onClose(){
    this.dialogRef.close();
    this.editDoctorForm.reset();
    this.router.navigate(['/doctordashboard']);
  }
}
