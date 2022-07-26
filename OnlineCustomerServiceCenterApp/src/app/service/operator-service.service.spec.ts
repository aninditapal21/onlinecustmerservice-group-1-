import { TestBed } from '@angular/core/testing';

import { OperatorServiceService } from './operator-service.service';

describe('OperatorServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OperatorServiceService = TestBed.get(OperatorServiceService);
    expect(service).toBeTruthy();
  });
});
