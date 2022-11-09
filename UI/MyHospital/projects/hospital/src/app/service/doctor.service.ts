import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {  Observable,Subject } from 'rxjs';
import { CreateDoctorComponent } from '../component/create-doctor/create-doctor.component';
import { DoctorDetails } from '../entity/doctor-details';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private baseURL ="http://localhost:9091/doctor";
  constructor(private http:HttpClient) { }

  private _listners =new Subject<any>();

  listen():Observable<any>{
    console.log("inside listen doctor service ")
    return this._listners.asObservable();
  }

  filter(filterBy:string){
    console.log("inside filter doctor service "+filterBy )
    this._listners.next(filterBy);
  }

  getDoctorList(): Observable<DoctorDetails[]>{
    return this.http.get<DoctorDetails[]>(`${this.baseURL}`+'/getAll');
  }

  CreateDoctor(doctor: DoctorDetails): Observable<object>{
    return this.http.post<DoctorDetails>(`${this.baseURL}`+'/addDoctor',doctor);
  }

  UpdateDoctor(doctor: DoctorDetails): Observable<object>{
    return this.http.post<DoctorDetails>(`${this.baseURL}`+'/updateDoctor',doctor);
  }

  removeDoctor(id: number): Observable<object> {
    return this.http.get<any>(`${this.baseURL}`+'/deleteDoctor'+`/${id}`);
  }

}
