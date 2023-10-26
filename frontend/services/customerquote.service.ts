import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CustomerQuoteService {
  private baseUrl = 'http://localhost:8080'; 

  constructor(private http: HttpClient) {}

  getCustomerQuotes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/quotes/select`);
  }
}
