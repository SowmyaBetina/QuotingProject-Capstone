import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LocationService {
  private baseUrl = 'http://localhost:8080/quotes';

  constructor(private http: HttpClient) {}

  getLocationDetails(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/location`);
  }
  addLocation(location: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/addlocation`, location);
  }
}
