import { DoctorDetails } from "./doctor-details";
import { PatientDetails } from "./patient-details";

export class Appointment {




	scheduleId!:number;
	
	patient:PatientDetails=new PatientDetails();
	
	 doctor:DoctorDetails=new DoctorDetails();
	
	date!:string;
    time!:string;
	myId!: number;
}
