import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {  Observable } from 'rxjs';
import { PrescriptionDetails } from '../entity/prescription-details';
@Injectable({
  providedIn: 'root'
})
export class PrescriptionService {
  private baseURL = "http://localhost:9091/prescription";
  constructor(private http:HttpClient) { }

  CreatePrescription(prescription:PrescriptionDetails):Observable<object>{
    return this.http.post<PrescriptionDetails>(`${this.baseURL}`+'/addPrescription',prescription);
  }

  getprescription():Observable<any>{
    return this.http.get<any>(`${this.baseURL}`+'/getAll')
  }



}
