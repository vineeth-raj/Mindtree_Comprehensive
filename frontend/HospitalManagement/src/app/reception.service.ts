import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reception } from './reception';

@Injectable({
  providedIn: 'root'
})
export class ReceptionService {

  private baseURL = "http://localhost:9000/reception/";

  constructor(private httpClient: HttpClient) { }

  addReception(Reception: Reception): Observable<Reception>{
    return this.httpClient.post<Reception>(`${this.baseURL}`, Reception);
  }

  checkReception(Reception: Reception){
    return this.httpClient.post(`${this.baseURL}${"check-reception"}`, Reception, {responseType: "text"});
  }
}
