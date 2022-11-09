import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from '../entity/Room';
@Injectable({
  providedIn: 'root'
})
export class RoomServiceService {
private baseURL="http://localhost:9091/room/getAll";
  constructor(private httpClient: HttpClient) { }
  getRoomsList(): Observable<Room[]> {
    return this.httpClient.get<Room[]>(`${this.baseURL}`);
  }
}
