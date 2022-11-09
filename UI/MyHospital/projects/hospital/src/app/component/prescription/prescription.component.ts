import { variable } from '@angular/compiler/src/output/output_ast';
import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { MatSnackBar } from '@angular/material/snack-bar';
import { DoctorDetails } from '../../entity/doctor-details';
import { PatientDetails } from '../../entity/patient-details';
import { PrescriptionService } from '../../service/prescreiption-service.service';
import { PrescriptionDetails } from '../../entity/prescription-details';
import { AppointmentService } from '../../service/appointment.service';


interface Type {
  name: string;
  sound: string[];
}

interface Food {
  value: string,
  viewValue: string,
  // firstDropDownChange(val: any):string;
}


interface Name {

  sound: string;
}

interface Schedule {
  name: string;
  sound: string;
}

const validRequired = Validators.required;
@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',

  styleUrls: ['./prescription.component.scss']
})
export class PrescriptionComponent implements OnInit {
  description = "Add Prescription";

  // selectedState = "";
  // selectedCity = "";
  // cities = [];

  // dropdownList = [

  //   { value: "andhra pradesh", viewValue: "Andhra Pradesh", cities: ["Vishakapatnam", "Vijaywada", "Guntur"] },
  //   { value: "karnataka", viewValue: "Karnataka", cities: ["Mysore", "Banglore", "Manglore"] }
  // ];

  // onSelect(selectedList : any) {

  //   selectedList = this.dropdownList.find(list => list.value == this.selectedState);
  //   this.cities = selectedList.cities;

  // }


  loanProductForm: any;
  router: any;

  durationInSeconds: number = 4;
  constructor(private dialog: MatDialog,
    private dialogRef: MatDialogRef<PrescriptionComponent>,
    private prescriptionService: PrescriptionService,
     private _snackBar: MatSnackBar,
     @Inject(MAT_DIALOG_DATA) public data: any,
     private appointService:AppointmentService) {
    this.name = 'Angular2'
  }

  ngOnInit(): void {

  }
prescriptionList:PrescriptionDetails[]=[];
  prescriptionForm: FormGroup = new FormGroup({
    FieldPrescriptionType: new FormControl('', [validRequired]),
    FieldTypes: new FormControl('', [validRequired]),
    FieldSchedule: new FormControl('', [validRequired]),

    // fee: new FormControl('',[validRequired])
  });

  @Input() prescriptionData: any = {

    doctor:DoctorDetails,
    patient:PatientDetails,
    prescription_type: '',
    types: '',
    schedule: '',

  }


  onFormSubmit() {
    // this.selectedData.clusterName = this.AddCreateForm.get('FieldClusterName').value;

    this.appointService.getAppointmentList().subscribe(appointdata => {

      appointdata.forEach(appointment =>{

        if(appointment.patient.id===this.data.id){

        this.prescriptionData.doctor=appointment.doctor;
        // console.log(appointment.doctor)
        // console.log(" predoc11",this.prescriptionData.doctor);


        // console.log(" predoc",this.prescriptionData.doctor);
        this.prescriptionData.prescription_type = this.prescriptionForm.get('FieldPrescriptionType')!.value
        this.prescriptionData.types = this.prescriptionForm.get('FieldTypes')!.value
        this.prescriptionData.schedule = this.prescriptionForm.get('FieldSchedule')!.value
        this.prescriptionData.patient=this.data
     //console.log(this.data)
     console.log("no of pr",this.prescriptionData);


     this.prescriptionService.CreatePrescription(this.prescriptionData).subscribe((data) => {
      this.onClose();
      console.log("h1");
      this.openSnackBar();
      console.log("h2");
    }, (error) => {
      //console.log("error.message"+error);
      //console.log("error.message"+error.error.message);
      this._snackBar.open(error.error.message, "", {
        duration: this.durationInSeconds * 1000,
        horizontalPosition: 'right',
        verticalPosition: 'top',
        panelClass: ['blue-snackbar']
      });
    });

        }
      })
     })


    // this.prescriptionService.CreatePrescription(this.prescriptionData).subscribe((data) => {
    //   this.onClose();
    //   console.log("h1");
    //   this.openSnackBar();
    //   console.log("h2");
    // }, (error) => {
    //   //console.log("error.message"+error);
    //   //console.log("error.message"+error.error.message);
    //   this._snackBar.open(error.error.message, "", {
    //     duration: this.durationInSeconds * 1000,
    //     horizontalPosition: 'right',
    //     verticalPosition: 'top',
    //     panelClass: ['red-snackbar']
    //   });
    // });
    //this.openSnackBar();


    //this.docdash.getDoctors();
  }

  onClose() {
    this.dialogRef.close();

  }

  openSnackBar() {
    console.log("h3");
    this._snackBar.open("Prescription Added successfully", "", {
      duration: this.durationInSeconds * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['blue-snackbar']
    });
  }



  close() {
    this.dialogRef.close();
  }
  save() {

  }
  addRow() {

  }







  typeControl = new FormControl('', Validators.required);
  nameControl = new FormControl('', Validators.required);
  scheduleControl = new FormControl('', Validators.required);

  selectFormControl = new FormControl('', Validators.required);
  types: Type[] = [
    { name: 'Test', sound: ['CT-SCAN', 'X-Ray'] },
    { name: 'Medicine', sound: ['Paracetamol', 'Flexon'] },

  ];
  names: Name[] = [

    { sound: 'Flexon!' }, { sound: 'Flex!' }

  ];
  schedules: Schedule[] = [
    { name: '1pm', sound: 'Woof!' },
    { name: '2pm', sound: 'Meow!' },

  ];
  public prescription: any[] = [{

    prescription_type: '',
    types: '',
    schedule: ''

  }];
  profiles = [
    { id: 'dev', name: 'Developer' },
    { id: 'man', name: 'Manager' },
    { id: 'dir', name: 'Director' }
  ];
  selectedProfile = this.profiles[1];


  selectedGame = "Football";
  addPrescription() {
    this.prescription.push({
      id: this.profiles.length + 1,
      prescription_type: [],
      types: [],
      schedule: []

    });
    //console.log(this.prescription);
  }






  logvalue() { }
  removeAddress(i: number) {
    this.prescription.splice(i, 1);
  }


  name: string;

  public _values1 = ["steak-0", "pizza-1", "3"];
  public _values2 = [""];


  prescriptions: any[] = [
    {value: 'Test'},
    {value: 'Medicine'}
    ];


}
