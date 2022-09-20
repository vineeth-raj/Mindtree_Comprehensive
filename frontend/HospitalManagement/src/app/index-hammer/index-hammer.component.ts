import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { AuthenticationService } from '../authentication.service';
import { ReceptionAuthenticationService } from '../reception-authentication.service';



@Component({
  selector: 'app-index-hammer',
  templateUrl: './index-hammer.component.html',
  styleUrls: ['./index-hammer.component.css']
})
export class IndexHammerComponent implements OnInit {


  username = 'admin';
  password = '';
  reception_username = 'reception';
  reception_password = '';
  invalidLogin = false;
  

  constructor(private router: Router, private modalService: NgbModal, private loginService: AuthenticationService, private recloginService: ReceptionAuthenticationService) { }

  ngOnInit(): void {
  }

  checkLogin() {
    if (this.loginService.authenticate(this.username, this.password)
    ) {
      this.router.navigate(['/admin']);
      this.invalidLogin = false;
    } else
      this.invalidLogin = true;
  }

  checkReceptionLogin() {
    if (this.recloginService.authenticate(this.reception_username, this.reception_password)
    ) {
      this.router.navigate(['/reception']);
      this.invalidLogin = false;
    } else
      this.invalidLogin = true;
  }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.checkLogin();
    });
  }

  receptionOpen(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.checkReceptionLogin();
    });
  }

}
