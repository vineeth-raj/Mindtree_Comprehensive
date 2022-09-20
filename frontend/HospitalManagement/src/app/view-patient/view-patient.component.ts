import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrls: ['./view-patient.component.css']
})
export class ViewPatientComponent implements OnInit {

  patient: Patient;
  id: number;
  str: string;
  isLoggedIn = false;
  constructor(private patientService: PatientService, private router: Router, public loginService: AuthenticationService) { }

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
