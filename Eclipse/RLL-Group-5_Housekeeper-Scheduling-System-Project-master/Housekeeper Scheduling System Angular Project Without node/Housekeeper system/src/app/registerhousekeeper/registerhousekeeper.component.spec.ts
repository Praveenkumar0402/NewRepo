import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterhousekeeperComponent } from './registerhousekeeper.component';

describe('RegisterhousekeeperComponent', () => {
  let component: RegisterhousekeeperComponent;
  let fixture: ComponentFixture<RegisterhousekeeperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterhousekeeperComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterhousekeeperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
