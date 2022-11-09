import { Room } from "./Room";
import {  PatientDetails} from "./patient-details"
export class RoomAllotement {
  roomAllotementId!: number;
  room: Room = new Room;
  patient: PatientDetails = new PatientDetails;
  bookedDate!: string;
  dischargeDate!: string;

}
