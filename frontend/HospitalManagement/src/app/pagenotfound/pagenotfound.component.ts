import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pagenotfound',
  templateUrl: './pagenotfound.component.html',
  styleUrls: ['./pagenotfound.component.css']
})
export class PagenotfoundComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onClick(){
    if(sessionStorage.getItem('username') === "admin")
    {
      this.router.navigate(['admin']);
    }
    else if(sessionStorage.getItem('username') === "reception")
    {
      this.router.navigate(['reception']);
    }
    else
    {
      this.router.navigate(['index']);
    }   
  }

}
