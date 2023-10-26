import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PriceService {
  private calculatePriceUrl = 'http://localhost:8080/quotes/calculatePrice';

  constructor(private http: HttpClient) {}

  calculatePrice(productName: string, quantity: number) {
    const params = new HttpParams()
      .set('productName', productName)
      .set('quantity', quantity.toString());

    return this.http.get<number>(this.calculatePriceUrl, { params });
  }
}
