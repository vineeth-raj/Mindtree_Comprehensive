import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { DoctorService } from './doctor.service';



describe('DoctorService', () => {
  let service: DoctorService;

  beforeEach(() => {
    TestBed.configureTestingModule({
        imports: [HttpClientModule]
    });
    service = TestBed.inject(DoctorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});