// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';
// @Injectable({
//   providedIn: 'root',
// })
// export class ParameterService {
 
  
// }

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ParameterService {
  private baseUrl = 'http://localhost:8080/quotes'; 

  constructor(private http: HttpClient) {}

  getParametersForFeature(featureName: string): Observable<any[]> {
    const url = `${this.baseUrl}/parameters/${featureName}`;
    return this.http.get<any[]>(url);
  }
}
