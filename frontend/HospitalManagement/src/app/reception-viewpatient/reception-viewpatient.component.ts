import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { ReceptionAuthenticationService } from '../reception-authentication.service';

@Component({
  selector: 'app-reception-viewpatient',
  templateUrl: './reception-viewpatient.component.html',
  styleUrls: ['./reception-viewpatient.component.css']
})
export class ReceptionViewpatientComponent implements OnInit {

  patient: Patient;
  id: number;
  str: string;
  isLoggedIn = false;
  constructor(private patientService: PatientService, private router: Router, public loginService: ReceptionAuthenticationService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.patientService.getPatientByID(this.id).subscribe(
      data => {
        this.patient = data;
      },
      () => {
        this.router.navigateByUrl("error-page");
      }
    )
  }
}

