import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreguntasAreaComponent } from './preguntas-area.component';

describe('PreguntasAreaComponent', () => {
  let component: PreguntasAreaComponent;
  let fixture: ComponentFixture<PreguntasAreaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreguntasAreaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreguntasAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
