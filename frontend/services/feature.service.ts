import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FeatureService {
  private apiUrl = 'http://localhost:8080/quotes'; 
  private baseUrl = 'http://localhost:8080/quotes'; 
  constructor(private http: HttpClient) {}

  getFeaturesForProduct(productName: string | null) {
    
    const url = `${this.apiUrl}/features/${productName}`;
    return this.http.get<any[]>(url);
  }

  getProductDetails(productName: string): Observable<any> {
    const url = `${this.baseUrl}/features/${productName}`; 
    return this.http.get(url);
  }
}
