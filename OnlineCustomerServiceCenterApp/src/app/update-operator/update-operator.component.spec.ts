import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateOperatorComponent } from './update-operator.component';

describe('UpdateOperatorComponent', () => {
  let component: UpdateOperatorComponent;
  let fixture: ComponentFixture<UpdateOperatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateOperatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateOperatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
