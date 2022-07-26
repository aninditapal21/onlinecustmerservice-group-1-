import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindCustmerComponent } from './find-custmer.component';

describe('FindCustmerComponent', () => {
  let component: FindCustmerComponent;
  let fixture: ComponentFixture<FindCustmerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindCustmerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindCustmerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
