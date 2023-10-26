import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerquoteComponent } from './customerquote.component';

describe('CustomerquoteComponent', () => {
  let component: CustomerquoteComponent;
  let fixture: ComponentFixture<CustomerquoteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomerquoteComponent]
    });
    fixture = TestBed.createComponent(CustomerquoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
