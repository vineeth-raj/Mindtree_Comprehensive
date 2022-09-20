import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-view-doctor',
  templateUrl: './view-doctor.component.html',
  styleUrls: ['./view-doctor.component.css']
})
export class ViewDoctorComponent implements OnInit {

  constructor(private doctorService: DoctorService, private router:Router, public loginService: AuthenticationService) { }
  doctor: Doctor = new Doctor();
  doctors: Doctor[];
  str: string;
  name: string;
  isLoggedIn = false;

  ngOnInit(): void {
    this.name = "Select Doctor";
    this.doctorService.getDoctorsList().subscribe(data => {
      this.doctors = data;
    })
  }

  onSelect(event){
    this.name = event.target.value;
    var found = 0;
    for(var i=0; i<this.doctors.length; i++)
    {
      if(this.doctors[i].name == this.name)
      {
        this.doctor = this.doctors[i];
        found = 1;
      }
    }
    if(found==0)
    {
      this.doctor = new Doctor();
    }
  }
}
