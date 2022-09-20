import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { ReceptionAuthenticationService } from '../reception-authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authentocationService: AuthenticationService, private receptionAuthenticationService: ReceptionAuthenticationService,
    private router: Router) { }

  ngOnInit(): void {
    this.authentocationService.logout();
    this.receptionAuthenticationService.logout();
    this.router.navigate(['/index']);
  }

}
