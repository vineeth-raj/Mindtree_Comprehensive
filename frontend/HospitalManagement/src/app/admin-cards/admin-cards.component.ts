import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-admin-cards',
  templateUrl: './admin-cards.component.html',
  styleUrls: ['./admin-cards.component.css']
})
export class AdminCardsComponent implements OnInit {

  constructor(private router: Router, public loginService: AuthenticationService) { }

  ngOnInit(): void {
  }

  addDoctor(){
    this.router.navigate(['add-doctor']);
  }

  viewDoctor(){
    this.router.navigate(['view-doctor']);
  }

  addPatient(){
    this.router.navigate(['add-patient']);
  }

  viewPatient(){
    this.router.navigate(['view-patient']);
  }

}
