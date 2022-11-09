import { DoctorDetails } from "./doctor-details";
import { PatientDetails } from "./patient-details";

export class PrescriptionDetails {
    // prescriptionId! : string;
    // patient_id! : string;
    prescription_type! : string;
    types! : string;
    schedule! : string;
    doctor!:DoctorDetails;
    patient!:PatientDetails

    }
