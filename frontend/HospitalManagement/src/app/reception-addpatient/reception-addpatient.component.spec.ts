import { DatePipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

import { ReceptionAddpatientComponent } from './reception-addpatient.component';

describe('ReceptionAddpatientComponent', () => {
  let component: ReceptionAddpatientComponent;
  let fixture: ComponentFixture<ReceptionAddpatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceptionAddpatientComponent ],
      imports:[HttpClientModule, BsDatepickerModule, FormsModule],
      providers: [DatePipe]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReceptionAddpatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
