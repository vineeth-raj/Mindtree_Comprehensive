import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatTableModule} from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatCardModule} from '@angular/material/card';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { DatePipe } from '@angular/common';
import { NgbCarouselModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
//import { MatIconModule} from '@angular/material/icon';

import * as CanvasJSAngularChart from '../assets/canvasjs.angular.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { ViewDoctorComponent } from './view-doctor/view-doctor.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { LogoutComponent } from './logout/logout.component';
import { ReceptionAddpatientComponent } from './reception-addpatient/reception-addpatient.component';
import { ReceptionViewpatientComponent } from './reception-viewpatient/reception-viewpatient.component';
import { IndexHammerComponent } from './index-hammer/index-hammer.component';
import { NgImageSliderModule } from 'ng-image-slider';
import { AdminCardsComponent } from './admin-cards/admin-cards.component';
import { ReceptionCardsComponent } from './reception-cards/reception-cards.component';
var CanvasJSChart = CanvasJSAngularChart.CanvasJSChart;



@NgModule({
  declarations: [
    AppComponent,
    CanvasJSChart,
    AddDoctorComponent,
    AddPatientComponent,
    ViewDoctorComponent,
    ViewPatientComponent,
    PagenotfoundComponent,
    LogoutComponent,
    ReceptionAddpatientComponent,
    ReceptionViewpatientComponent,
    IndexHammerComponent,
    AdminCardsComponent,
    ReceptionCardsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    BsDatepickerModule.forRoot(),
    DatePipe,
    NgbModule,
    MatIconModule,
    MatInputModule,
    FormsModule,
    MatFormFieldModule,
    MatTableModule,
    MatSelectModule,
    MatPaginatorModule,
    MatSortModule,
    MatButtonModule,
    MatDialogModule,
    MatTooltipModule,
    MatProgressSpinnerModule,
    MatDatepickerModule,
    MatCardModule,
    NgImageSliderModule,
    NgbCarouselModule 
  ],
  providers: [DatePipe, HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
