import { TestBed } from '@angular/core/testing';

import { CustomerIssueService } from './customer-issue.service';

describe('CustomerIssueService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerIssueService = TestBed.get(CustomerIssueService);
    expect(service).toBeTruthy();
  });
});
