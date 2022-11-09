import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { observable, Observable } from 'rxjs';
import { Admin } from '../entity/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseURL ="http://localhost:9091/authenticate";

  constructor(private http:HttpClient) { }


  check(admin:Admin){
      return this.http.post<Admin>(`${this.baseURL}`+'/login', admin);
  }

  getAdmin(): Observable<Admin>{
    return this.http.get<Admin>(`${this.baseURL}`+'/getuser');
  }
}
