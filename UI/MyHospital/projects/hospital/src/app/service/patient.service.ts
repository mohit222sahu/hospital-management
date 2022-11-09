import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Observable } from 'rxjs';
import { PatientDetails } from '../entity/patient-details';

@Injectable({
  providedIn: 'root'
})

export class PatientService {
  private baseURL ="http://localhost:9091/patient";
  private baseUrl1="http://localhost:9091/roomAllotement"
  private baseUrl2 ="http://localhost:9091/prescription"

  constructor(private http:HttpClient) {}

  private _listners =new Subject<any>();

  listen():Observable<any>{
    return this._listners.asObservable();
  }

  filter(filterBy:string){
    this._listners.next(filterBy);
  }

  getPatientList(): Observable<PatientDetails[]>{
    return this.http.get<PatientDetails[]>(`${this.baseURL}`+'/patientList');
  }

  CreatePatient(patient:PatientDetails):Observable<object>{
    return this.http.post<PatientDetails>(`${this.baseURL}`+'/addPatient',patient);
  }

  UpdatePatient(patient:PatientDetails):Observable<object>{
    return this.http.post<PatientDetails>(`${this.baseURL}`+'/addPatient',patient);
  }

  removePatient(id: number):Observable <object> {
    // console.log("sending delete");
    return this.http.get<any>(`${this.baseURL}`+'/deletePatient'+`/${id}`);
    //return this.http.post<any>(`${this.baseURL}`+'/deletePatient'+`/`,id);
  }

  getRoomAllotement(id:any):Observable<object>{
    return this.http.get<any>(`${this.baseUrl1}`+'/findByPatientId'+`/${id}`)
  }

  getPrescription(id:any):Observable<object>{
    return this.http.get<any[]>(`${this.baseUrl2}`+'/getByPatientId'+`/${id}`)
  }

  getPatientListFilter(name:string): Observable<PatientDetails[]>{
    return this.http.get<PatientDetails[]>(`${this.baseURL}`+'/filterByName'+`/${name}`);
  }

  getPatientListFilterByCity(city: any) {
    return this.http.get<PatientDetails[]>(`${this.baseURL}`+'/filterByName'+`/${city}`);
  }

  getPatientListFilterByContact(contact: any) {
    return this.http.get<PatientDetails[]>(`${this.baseURL}`+'/filterByName'+`/${contact}`);
  }

}
