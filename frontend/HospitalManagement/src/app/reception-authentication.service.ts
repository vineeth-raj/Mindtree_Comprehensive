import { Injectable } from '@angular/core';
import { Reception } from './reception';
import { ReceptionService } from './reception.service';

@Injectable({
  providedIn: 'root'
})
export class ReceptionAuthenticationService {

  constructor(private receptionService: ReceptionService) { }
  string: any;
  reception: Reception = new Reception();

  authenticate(username, password) {
    this.reception.password = password;
    this.reception.username = username;
    this.receptionService.checkReception(this.reception).subscribe(data => {
      this.string = data;
      console.log(this.string);
      if(this.string.localeCompare("Right Password")==0)
      {
        sessionStorage.setItem('username', username);
      }
    })
    if (sessionStorage.getItem('username')?.localeCompare(username)==0) {
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('username')
  }
  
}
