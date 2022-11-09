import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AgRendererComponent } from 'ag-grid-angular';
import { ICellRendererParams } from 'ag-grid-community';
import { DoctorDetails } from '../../entity/doctor-details';
import { DoctorService } from '../../service/doctor.service';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { DoctorDashboardComponent } from '../doctor-dashboard/doctor-dashboard.component';
import { EditDoctorComponent } from '../edit-doctor/edit-doctor.component';

@Component({
  selector: 'app-button-renderer',
  templateUrl: './button-renderer.component.html',
  styleUrls: ['./button-renderer.component.scss']
})
export class ButtonRendererComponent implements AgRendererComponent {

  private label!: string;
  private params: any;
  doctor_id!:any;

  constructor(private doctorDash: DoctorDashboardComponent,
    private doctorService:DoctorService,
    private router:Router,
    private dialog:MatDialog,
    private _snackBar: MatSnackBar){}

    refresh(params: ICellRendererParams): boolean {
      throw new Error('Method not implemented.');
    }

    openSnackBar() {
      this._snackBar.open("Doctor Deleted successfully","", {
        duration: 3 * 1000,
        horizontalPosition: 'right',
        verticalPosition: 'top',
        panelClass: ['red-snackbar']
      });
    }

    agInit(params: any): void {
      this.params=params;
      this.label = this.params.label || null;
    }

    onDelete($event: any) {
      if (this.params.onClick instanceof Function) {
        const params = {
          event: $event,
          rowData: this.params.node.data
        }
        this.params.onClick(params);
      }

      const dialogRef = this.dialog.open(ConfirmationDialogComponent,{
        data:{
          message: 'Are you sure want to delete?',
          buttonText: {
            ok: 'Yes',
            cancel: 'No'
          }
        }
      });

      dialogRef.afterClosed().subscribe((confirmed: boolean) => {
        if (confirmed) {
          console.log(this.params.data);
          this.doctorDash.OnDelete(this.params.data.id);
          this.openSnackBar();
        }
      });
    }

    onEdit($event: any){
      if (this.params.onClick instanceof Function) {
        const params = {
          event: $event,
          rowData: this.params.node.data
        }
        this.params.onClick(params);
      }
      //console.log(this.params.data);
      const  dialogConfig=new MatDialogConfig();
      dialogConfig.disableClose=true;
      dialogConfig.autoFocus=true;
      //  dialogConfig.height='85%';
      //  dialogConfig.width='54%';
      dialogConfig.data=this.params.data;
      console.log("edit k aneder");
      console.log(dialogConfig.data);
      this.dialog.open(EditDoctorComponent,dialogConfig);
    }

    onView($event:any) {
      if (this.params.onClick instanceof Function) {
        const params = {
          event: $event,
          rowData: this.params.node.data
        }
      }
      console.log(this.params.data);
      this.router.navigate(['/doctorView', { id:this.params.data.id,doctorId:this.params.data.doctorId,firstName:this.params.data.firstName,lastName:this.params.data.lastName,age:this.params.data.age,specialization:this.params.data.specialization,qualification:this.params.data.qualification,fee:this.params.data.fee,contact:this.params.data.contactNumber,email:this.params.data.email,address:this.params.data.address}]);
    }

    navigateMenu($event: any) {
      this.router.navigate(['/doctor-schedule',
      { id: this.params.data.id, firstName: this.params.data.firstName, lastName:this.params.data.lastName}]);
      console.log(this.params.data);
    }
  }
