import { DoctorDetails } from "./doctor-details";

export class Doctorschedule {

  scheduleId: number=0;
  doctor: DoctorDetails = {
    id:0,
    doctorId: "",
    firstName: "",
    lastName: "",
    age: 0,
    contactNumber: "",
    email: "",
    address: "",
    specialization: "",
    qualification: "",
    fee: 0
  };
  date: Date=new Date;
  time: string = '';
  patientName: string = '';

}
