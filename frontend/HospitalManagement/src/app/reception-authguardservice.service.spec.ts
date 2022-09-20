import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { ReceptionAuthguardserviceService } from './reception-authguardservice.service';

describe('ReceptionAuthguardserviceService', () => {
  let service: ReceptionAuthguardserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule]
    });
    service = TestBed.inject(ReceptionAuthguardserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
