import { DatePipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Patientwithfile } from '../patientwithfile';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  patient: Patient = new Patient();
  patientFile: Patientwithfile = new Patientwithfile();
  date: Date;
  str: string;
  maxDate: Date = new Date();
  doctors: Doctor[];
  doctorforpatient: Doctor = new Doctor();
  public userFile:any = File;
  isLoggedIn = false;
  constructor(public datePipe: DatePipe, private doctorService: DoctorService, private patientService: PatientService, private router: Router, public loginService: AuthenticationService) { }

  ngOnInit(): void {
//    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    this.patient.visiteddoctorname = "Select Doctor"
    this.doctorService.getDoctorsList().subscribe(data => {
      this.doctors = data;
    })
  }

  onSelectFile(event){
    const file = event.target.files[0];
    this.userFile = file;
  }

  onSubmit(){
    //console.log(this.isLoggedIn);
    //console.log(this.patient);
    this.patient.dateofvisit = this.datePipe.transform(this.date, "dd-MM-yyyy");
    var x: number = +this.patient.visiteddoctorname;
    this.patient.doctorid = x;
    for(var y=0; y<this.doctors.length; y++)
    {
      if(this.doctors[y].id==x)
      {
        this.patient.visiteddoctorname = this.doctors[y].name;
        this.doctorforpatient = this.doctors[y];
        break;
      }
    }
    this.doctorforpatient.noofpatientsattended += 1;
    //console.log(this.doctorforpatient);
    this.doctorService.updateDoctor(x, this.doctorforpatient).subscribe(data => {
      console.log(data);
    })
    //console.log(this.userFile);
    const formData = new FormData();
    formData.append("file", this.userFile);
    formData.append("patient", JSON.stringify(this.patient));
    this.patientService.addPatient(formData).subscribe(data => {
      //console.log(data);
      this.router.navigate(['/add-doctor'])
    })
  }

}
