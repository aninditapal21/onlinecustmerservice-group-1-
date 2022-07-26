import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindIssueComponent } from './find-issue.component';

describe('FindIssueComponent', () => {
  let component: FindIssueComponent;
  let fixture: ComponentFixture<FindIssueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindIssueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindIssueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
