import { TestBed } from '@angular/core/testing';
import { MockProvider } from 'ng-mocks';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        AppComponent,
      ],
      providers: [
        MockProvider(HttpClient, { get: () => of({}) } as any),
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
});
