import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceptionViewpatientComponent } from './reception-viewpatient.component';

describe('ReceptionViewpatientComponent', () => {
  let component: ReceptionViewpatientComponent;
  let fixture: ComponentFixture<ReceptionViewpatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceptionViewpatientComponent ],
      imports: [HttpClientModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReceptionViewpatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
