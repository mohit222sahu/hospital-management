import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RoomAllotement } from '../entity/room-allotement';
import { Observable, Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CreateRoomAllotementServiceService {

  private _listners =new Subject<any>();
  listen():Observable<any>{
    return this._listners.asObservable();
  }
  filter(filterBy:string){
    this._listners.next(filterBy);
  }

  constructor(private http: HttpClient) { }
  private url = "http://localhost:9091/roomAllotement/addRoomAllotement";

  createAllotement(roomAllotement:RoomAllotement) {
   return this.http.post<any>(`${this.url}`, roomAllotement);
  }
}
