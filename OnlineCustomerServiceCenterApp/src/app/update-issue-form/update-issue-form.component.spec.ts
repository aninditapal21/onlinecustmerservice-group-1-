import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateIssueFormComponent } from './update-issue-form.component';

describe('UpdateIssueFormComponent', () => {
  let component: UpdateIssueFormComponent;
  let fixture: ComponentFixture<UpdateIssueFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateIssueFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateIssueFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
