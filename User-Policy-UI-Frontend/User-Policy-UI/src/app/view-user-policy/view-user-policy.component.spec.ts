import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUserPolicyComponent } from './view-user-policy.component';

describe('ViewUserPolicyComponent', () => {
  let component: ViewUserPolicyComponent;
  let fixture: ComponentFixture<ViewUserPolicyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewUserPolicyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewUserPolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
