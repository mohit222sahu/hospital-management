import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RoomAllotement } from '../entity/room-allotement';
import { Observable } from 'rxjs';
import { Room } from '../entity/Room';
@Injectable({
  providedIn: 'root'
})
export class RoomAllotementServiceService {
private baseURL="http://localhost:9091/roomAllotement/getAll";
private url="http://localhost:9091/roomAllotement/delete";
private addUrl="http://localhost:9091/roomAllotement/update";

  constructor(private httpClient: HttpClient) { }
  getRoomAllotement(): Observable<RoomAllotement[]>
  {
    return this.httpClient.get<RoomAllotement[]>(`${this.baseURL}`);
  }
  delete(roomAllotement: RoomAllotement) {
    return this.httpClient.post(`${this.url}`,roomAllotement);
  }
  discharge(roomAllotement: RoomAllotement) {

      roomAllotement.dischargeDate = String(new Date()).substring(0,16);

    return this.httpClient.post<any>(`${this.addUrl}`, roomAllotement);
  }
}
