import { Component, OnInit } from '@angular/core';
import { RoomComponent } from '../room/room.component';
import { RoomAllotement } from '../../entity/room-allotement';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctorschedule } from '../../entity/doctorschedule';
import { DoctorScheduleServiceService } from '../../service/doctor-schedule-service.service';
import { DoctorDetails } from '../../entity/doctor-details';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DatePipe } from '@angular/common';
import { elementGettingCreated } from 'ag-grid-community/dist/lib/widgets/component';
@Component({
  selector: 'app-doctor-schedule',
  templateUrl: './doctor-schedule.component.html',
  styleUrls: ['./doctor-schedule.component.css']
})
export class DoctorScheduleComponent implements OnInit {

  pipe = new DatePipe('en-US');
  doctorSchedules: Doctorschedule[]=[];

  title = 'Hospital Management System';
  minDate = new Date();
  maxDate = new Date(2021, 8, 10);
  master_checked: boolean = false;
  master_indeterminate: boolean = false;
  checkbox_list1 :any= [];
  slotList10:any= [];
  slotList12:any = [];
  slotList2 :any= [];
  slotList4 :any= [];
  slotList6 :any= [];
  slotList8 :any= [];
  tempList:any = [];
  docSchedule : Doctorschedule[] = [];
  //roomAllotement: RoomAllotement;
  tempList2: any = [];
  list :any= [];
  date!: Date ;
  flag: number = 0;
  constructor(private router: Router,
    private route: ActivatedRoute,
    private doctorScheduleService: DoctorScheduleServiceService,
    private snackBar: MatSnackBar,
  ) {

    this.doctorScheduleService.listen().subscribe((m:any)=>{
      console.log(m);
      this.router.navigate(['/doctor-schedule']);
       });

    this.checkbox_list1 = [
      {
        name: "10:00 am - 12:00 pm",
        id:10,
        disabled: false,
        checked: false,
        labelPosition: "after"
      }, {
        name: "12:00 pm - 2:00 pm",
        id:12,
        disabled: false,
        checked: false,
        labelPosition: "after"
      }, {
        name: "2:00 pm - 4:00 pm",
        id:2,
        disabled: false,
        checked: false,
        labelPosition: "after"
      }, {
        name: "4:00 pm - 6:00 pm",
        id:4,
        disabled: false,
        checked: false,
        labelPosition: "after"
      }, {
        name: "6:00 pm - 8:00 pm",
        id: 6,
        disabled: false,
        checked: false,
        labelPosition: "after"
      }, {
        name: "8:00 pm - 10:00 pm",
        id:8,
        disabled: false,
        checked: false,
        labelPosition: "after"
      },
    ]

    this.slotList10 = [
      {
        slot: "10:00 am - 10:30 am"
      },  {
        slot: "10:30 am - 11:00 am"
      },
      {
        slot: "11:00 am - 11:30 am"
      },  {
        slot: "11:30 am - 12:00 pm"
      }
    ]
    this.slotList12 = [
      {
        slot: "12:00 pm - 12:30 pm"
      }, {
        slot: "12:30 pm - 1:00 pm"
      },
      {
        slot: "1:00 pm - 1:30 pm"
      },  {
        slot: "1:30 pm - 2:00 pm"
      }
    ]
    this.slotList2 = [
      {
        slot: "2:00 pm - 2:30 pm"
      }, {
        slot: "2:30 pm - 3:00 pm"
      },
      {
        slot: "3:00 pm - 3:30 pm"
      },  {
        slot: "3:30 pm - 4:00 pm"
      }
    ]

    this.slotList4 = [
      {
        slot: "4:00 pm - 4:30 pm"
      }, {
        slot: "4:30 pm - 5:00 pm"
      },
      {
        slot: "5:00 pm - 5:30 pm"
      },  {
        slot: "5:30 pm - 6:00 pm"
      }]
    this.slotList6 = [
      {
        slot: "6:00 pm - 6:30 pm"
      }, {
        slot: "6:30 pm - 7:00 pm"
      },
      {
        slot: "7:00 pm - 7:30 pm"
      },  {
        slot: "7:30 pm - 8:00 pm"
      }
    ]
    this.slotList8 = [
      {
        slot: "8:00 pm - 8:30 pm"
      }, {
        slot: "8:30 pm - 9:00 pm"
      },
      {
        slot: "9:00 pm - 9:30 pm"
      },  {
        slot: "9:30 pm - 10:00 pm"
      }
    ]

  }

  dfirstName = this.route.snapshot.paramMap.get('firstName');
  dId = Number(this.route.snapshot.paramMap.get('id'));
  dlastName = this.route.snapshot.paramMap.get('lastName');
  ngOnInit(): void {


  }

  openSnackBar2() {
    this.snackBar.open("Schedule for selected date is already created","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['red-snackbar']
    });
  }

  openSnackBar3() {
    this.snackBar.open("Date field can not be empty","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['red-snackbar']
    });
  }
  openSnackBar4() {
    this.snackBar.open("Select atleast one slot for selected date","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['red-snackbar']
    });
  }
  openSnackBar5() {
    this.snackBar.open("Date and Slots can not be empty","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['red-snackbar']
    });
  }
  list_change(item: any) {

   // console.log('****************'+item);
//    if (item.checked) this.list.push(item)

    console.log(this.list);
   // this.finalSlots(this.tempList2);
  }





  valueChange(event: any) {
    this.flag = 0;
    this.date = event.value;
    var s=this.pipe.transform(event.value, 'yyyy-MM-dd');
    //this.date = new Date(String(this.pipe.transform(event.value, 'yyyy-MM-dd')));

    console.log("s"+s);

    this.doctorScheduleService.getScheduleList(this.dId).subscribe((data) => {
      this.docSchedule = data;

      for (let i = 0; i < this.docSchedule.length; i++) {
        console.log("**********" + this.docSchedule[i].date)
        console.log(event.value)
        if (String(this.docSchedule[i].date) == s) {
          this.openSnackBar2();
          this.flag = 1;
          break;
        }
      }
    });
  }
  onSave() {
    if (this.flag == 1) {

      this.openSnackBar2();
      return;
    }

    this.checkbox_list1.forEach((element: { checked: any; }) => {
      if (element.checked) this.list.push(element);
    });
    if (this.date == null && this.list.length == 0) {
      this.openSnackBar5();
      return;
    }
    if (this.date == null) {
      this.openSnackBar3();
      return;
    }

    if (this.list.length == 0) {
      this.openSnackBar4();
      return
    }
    console.log(this.list);
    // if (this.list.length == 0) {
    //   alert("select schedule")
    //   return;
    // }
     console.log(this.date+"lllllllllllllllllllllllllllllll");
  //  this.finalSlots(this.tempList2);
    for (let i = 0; i < this.list.length; i++) {
      if (this.list[i].id == 10) {
        this.tempList = this.slotList10;
      }
      if (this.list[i].id == 12) {
        this.tempList = this.slotList12;
      }
      if (this.list[i].id == 2) {
        this.tempList = this.slotList2;
      }
      if (this.list[i].id == 4) {
        this.tempList = this.slotList4;
      }
      if (this.list[i].id == 6) {
        this.tempList = this.slotList6;
      }
      if (this.list[i].id == 8) {
        this.tempList = this.slotList8;
      }
      for (let j = 0; j < 4; j++) {
        const dSchedule = new Doctorschedule();
        dSchedule.time = this.tempList[j].slot;

        dSchedule.date = this.date;
        //this.date = new Date();
        console.log(this.date);
        dSchedule.doctor.id = this.dId;;
        console.log("doctor ki id---------------------------------------");
        console.log(dSchedule.doctor.id);
        // dSchedule.doctor.doctorId = "DOC11";
        this.doctorSchedules.push(dSchedule);
      }
    }

    console.log(this.doctorSchedules);
    this.doctorScheduleService.addSchedule(this.doctorSchedules).subscribe(() => { });
    this.openSnackBar();
    this.router.navigate(['/doctordashboard'])

  }
  cancel() {
    this.router.navigate(['/doctordashboard'])

  }


  openSnackBar() {
    this.snackBar.open("Schedule Added successfully","", {
      duration: 3 * 1000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['blue-snackbar']
    });
  }

  back() {
    this.router.navigate(['/doctordashboard']);
   }

}
