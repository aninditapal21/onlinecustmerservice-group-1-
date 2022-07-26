import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntimationMailComponent } from './intimation-mail.component';

describe('IntimationMailComponent', () => {
  let component: IntimationMailComponent;
  let fixture: ComponentFixture<IntimationMailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntimationMailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntimationMailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
