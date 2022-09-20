import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { ReceptionService } from './reception.service';

describe('ReceptionService', () => {
  let service: ReceptionService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule]
    });
    service = TestBed.inject(ReceptionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
