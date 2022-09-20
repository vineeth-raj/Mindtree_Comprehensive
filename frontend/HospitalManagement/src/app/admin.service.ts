import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {


  private baseURL = "http://localhost:9000/admin/";

  constructor(private httpClient: HttpClient) { }

  addAdmin(admin: Admin): Observable<Admin>{
    return this.httpClient.post<Admin>(`${this.baseURL}`, admin);
  }

  checkAdmin(admin: Admin){
    return this.httpClient.post(`${this.baseURL}${"check-admin"}`, admin, {responseType: "text"});
  }
}
