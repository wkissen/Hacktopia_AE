import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicinepageComponent } from './medicinepage.component';

describe('MedicinepageComponent', () => {
  let component: MedicinepageComponent;
  let fixture: ComponentFixture<MedicinepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MedicinepageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedicinepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
