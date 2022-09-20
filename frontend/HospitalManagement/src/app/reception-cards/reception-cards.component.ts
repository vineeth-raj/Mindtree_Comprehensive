import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReceptionAuthenticationService } from '../reception-authentication.service';

@Component({
  selector: 'app-reception-cards',
  templateUrl: './reception-cards.component.html',
  styleUrls: ['./reception-cards.component.css']
})
export class ReceptionCardsComponent implements OnInit {

  constructor(private router: Router, public loginService: ReceptionAuthenticationService) { }

  ngOnInit(): void {
  }

  addPatient(){
    this.router.navigate(['add-patient-reception']);
  }

  viewPatient(){
    this.router.navigate(['view-patient-reception']);
  }
}
