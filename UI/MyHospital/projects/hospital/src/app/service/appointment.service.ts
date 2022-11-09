import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Appointment } from '../entity/appointment';
import { PatientDetails } from '../entity/patient-details';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private http:HttpClient) { }
  private baseURL ="http://localhost:9091/appointment";
  private getURL ="http://localhost:9091/appointment/getByDoctorId";


  private _listners =new Subject<any>();
  listen():Observable<any>{
    return this._listners.asObservable();
  }
  filter(filterBy:string){
    this._listners.next(filterBy);
  }

  saveAppointment(appointment:any): Observable<any[]>{ 
    return this.http.post<any[]>(`${this.baseURL}`+'/addschedule',appointment);
  }

  getAppointmentList(): Observable<Appointment[]>{ 
    return this.http.get<Appointment[]>(`${this.baseURL}`+'/get');
  }
  getByDoctorId(id:number): Observable <Appointment[]> {
    return this.http.get<Appointment[]>(`${this.getURL}` + `/${id}`)
  }
  getByPatientId(id:any):Observable<Appointment[]>{
    return this.http.get<Appointment[]>(`${this.baseURL}`+'/getByPatientId'+`/${id}`);
  }

  getPatientListFilterByDoctorName(docName:string):Observable<PatientDetails[]>{
    return this.http.get<PatientDetails[]>(`${this.baseURL}`+'/filterByAttendeeDoctor'+`/${docName}`);

  }
}
