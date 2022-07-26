import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerviewissueComponent } from './customerviewissue.component';

describe('CustomerviewissueComponent', () => {
  let component: CustomerviewissueComponent;
  let fixture: ComponentFixture<CustomerviewissueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerviewissueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerviewissueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
