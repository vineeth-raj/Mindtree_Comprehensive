import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { ReceptionAuthenticationService } from './reception-authentication.service';

describe('ReceptionAuthenticationService', () => {
  let service: ReceptionAuthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule]
    });
    service = TestBed.inject(ReceptionAuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
