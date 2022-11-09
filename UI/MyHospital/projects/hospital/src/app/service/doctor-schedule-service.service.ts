import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doctorschedule } from '../entity/doctorschedule';
import { Observable, Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class DoctorScheduleServiceService {
  private baseURL = "http://localhost:9091/doctorSchedule/addSchedule";
 private getUrl="http://localhost:9091/doctorSchedule/getAll";

 private _listners =new Subject<any>();
 listen():Observable<any>{
   return this._listners.asObservable();
 }
 filter(filterBy:string){
   this._listners.next(filterBy);
 }

  constructor(private httpClient: HttpClient) {

  }
  addSchedule(doctorSchedules:Doctorschedule[]) {
    return this.httpClient.post(`${this.baseURL}`, doctorSchedules);
  }
  getScheduleList(id:number) {
    return this.httpClient.get<Doctorschedule[]>(`${this.getUrl}` + `/${id}`);
  }
}
