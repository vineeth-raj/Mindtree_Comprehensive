import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { AdminCardsComponent } from './admin-cards/admin-cards.component';
import { AuthguardService } from './authguard.service';
import { IndexHammerComponent } from './index-hammer/index-hammer.component';
import { LogoutComponent } from './logout/logout.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ReceptionAddpatientComponent } from './reception-addpatient/reception-addpatient.component';
import { ReceptionAuthguardserviceService } from './reception-authguardservice.service';
import { ReceptionCardsComponent } from './reception-cards/reception-cards.component';
import { ReceptionViewpatientComponent } from './reception-viewpatient/reception-viewpatient.component';
import { ViewDoctorComponent } from './view-doctor/view-doctor.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';

const routes: Routes = [
  {path:"add-doctor", component:AddDoctorComponent, canActivate:[AuthguardService]},
  {path:"add-patient", component:AddPatientComponent, canActivate:[AuthguardService]},
  {path:"view-doctor", component:ViewDoctorComponent, canActivate:[AuthguardService]},
  {path:"view-patient", component:ViewPatientComponent, canActivate:[AuthguardService]},
  {path:"add-patient-reception", component:ReceptionAddpatientComponent, canActivate:[ReceptionAuthguardserviceService]},
  {path:"view-patient-reception", component:ReceptionViewpatientComponent, canActivate:[ReceptionAuthguardserviceService]},
  {path: 'logout', component: LogoutComponent, canActivate:[AuthguardService]},
  {path: "index", component:IndexHammerComponent},
  {path: "admin", component:AdminCardsComponent, canActivate:[AuthguardService]},
  {path: "reception", component:ReceptionCardsComponent, canActivate:[ReceptionAuthguardserviceService]},
  {path:"", redirectTo:"index", pathMatch:'full'},
  {path:"**", pathMatch:'full', component:PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
