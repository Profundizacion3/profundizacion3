import { TestBed, inject } from '@angular/core/testing';

import { AreaConocimientoService } from './area-conocimiento.service';

describe('AreaConocimientoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AreaConocimientoService]
    });
  });

  it('should be created', inject([AreaConocimientoService], (service: AreaConocimientoService) => {
    expect(service).toBeTruthy();
  }));
});
