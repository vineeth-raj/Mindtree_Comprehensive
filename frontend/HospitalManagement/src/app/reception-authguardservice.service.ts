import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { ReceptionAuthenticationService } from './reception-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class ReceptionAuthguardserviceService {

  constructor(private recService: ReceptionAuthenticationService, private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.recService.isUserLoggedIn())
      return true;

    this.router.navigate(['index']);
    return false;

  }
}
