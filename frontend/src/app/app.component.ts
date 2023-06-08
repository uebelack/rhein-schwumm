import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RheinTemperature } from './rhein-temperature';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  rheinTemperature?: RheinTemperature;

  error?: string;

  constructor(private httpClient: HttpClient) {
    httpClient.get('/api/rhein-temperature')
      .subscribe((data) => {
        this.rheinTemperature = data as RheinTemperature;
      }, (error) => {
        this.error = error.error.error;
      });
  }
}
