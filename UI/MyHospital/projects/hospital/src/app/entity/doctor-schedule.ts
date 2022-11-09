import { DoctorDetails } from "./doctor-details";

export class DoctorSchedule {
  scheduleId!: number;
  doctor!: DoctorDetails;
  time!: string;
  date!: Date;

}
