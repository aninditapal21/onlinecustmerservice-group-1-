import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindDepartmentComponent } from './find-department.component';

describe('FindDepartmentComponent', () => {
  let component: FindDepartmentComponent;
  let fixture: ComponentFixture<FindDepartmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindDepartmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindDepartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
