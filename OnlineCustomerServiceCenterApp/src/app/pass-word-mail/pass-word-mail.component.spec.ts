import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PassWordMailComponent } from './pass-word-mail.component';

describe('PassWordMailComponent', () => {
  let component: PassWordMailComponent;
  let fixture: ComponentFixture<PassWordMailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PassWordMailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PassWordMailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
