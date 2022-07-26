import { TestBed } from '@angular/core/testing';

import { DepartmentserviceService } from './departmentservice.service';

describe('DepartmentserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DepartmentserviceService = TestBed.get(DepartmentserviceService);
    expect(service).toBeTruthy();
  });
});
