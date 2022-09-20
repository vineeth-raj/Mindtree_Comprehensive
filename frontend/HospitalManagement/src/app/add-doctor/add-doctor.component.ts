import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { AuthenticationService } from '../authentication.service';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor: Doctor = new Doctor();
  fields: any = [];
  strs: string = '';
  isLoggedIn = false;
  constructor(private auth: AuthService, private doctorService: DoctorService, private router: Router, public loginService: AuthenticationService) { }

  ngOnInit(): void {
    this.fields = this.auth.fields();
    this.doctor.specfields = "Select Fields";
  }

  onSubmit(){
    this.doctorService.addDoctor(this.doctor).subscribe(
      (data) => {
        //console.log(data);
        this.router.navigate(['/view-doctor']);
      }
    )
  }
}
