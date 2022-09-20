import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Admin } from './admin';
import { AdminService } from './admin.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private adminService: AdminService) { }
  string: any;
  admin: Admin = new Admin();
  public check: number = 0;
  public array: string[] = [];


  

  authenticate(username, password) {
    this.admin.password = password;
    this.admin.username = username;
    this.adminService.checkAdmin(this.admin).subscribe(data => {
      this.string = data;
      if(this.string === "Right Password")
      {
        sessionStorage.setItem('username', username);
      }
    });
    if (sessionStorage.getItem('username')===username) {
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