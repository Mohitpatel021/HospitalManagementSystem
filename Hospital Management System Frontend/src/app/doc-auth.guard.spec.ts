import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { docAuthGuard } from './doc-auth.guard';

describe('docAuthGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => docAuthGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
